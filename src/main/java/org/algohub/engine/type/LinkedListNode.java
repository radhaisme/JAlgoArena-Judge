package org.algohub.engine.type;

public class LinkedListNode<E> {
    public E value;
    public LinkedListNode<E> next;

    public LinkedListNode() {
        value = null;
        next = null;
    }

    public LinkedListNode(final E value) {
        this.value = value;
        this.next = null;
    }

    public LinkedListNode(final E value, final LinkedListNode<E> next) {
        this.value = value;
        this.next = next;
    }

    public void add(final E value) {
        if (this.value == null) {
            this.value = value;
            return;
        }

        LinkedListNode<E> tail = this;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new LinkedListNode<>(value);
    }

    public boolean isNull() {
        return this.value == null;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinkedListNode)) {
            return false;
        }

        final LinkedListNode other = (LinkedListNode) obj;

        LinkedListNode p = this;
        LinkedListNode q = other;
        while (p != null && q != null && p.value != null) {
            if (!p.value.equals(q.value)) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return p == null && q == null;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        for (LinkedListNode<E> p = this; p != null; p = p.next) {
            hashCode = 31 * hashCode + (value == null ? 0 : value.hashCode());
        }

        return hashCode;
    }

    @Override
    public String toString() {
        if (value == null) {
            return "[]";
        }

        final StringBuilder linkedListAsString = new StringBuilder();
        linkedListAsString.append('[').append(value);

        for (LinkedListNode<E> p = next; p != null; p = p.next) {
            linkedListAsString.append(", ").append(p.value);
        }

        linkedListAsString.append(']');

        return linkedListAsString.toString();
    }
}
