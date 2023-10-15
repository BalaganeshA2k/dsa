package org.lern.dsa.linked_list;

import static java.util.Objects.isNull;

import java.util.Optional;

public class SinglyLinkedList<E> {

    private Node<E> head;

    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        private Node(T data) {
            this.data = data;
        }

        public void insertAfter(T data) {
            var newNode = Node.of(data);
            newNode.next = this.next;
            this.next = newNode;
        }

        @Override
        public String toString() {
            return " | " + this.data.toString() + (isNull(next) ? "" : next.toString());
        }

        static <T> Node<T> of(T data) {
            return new Node<>(data);
        }

    }

    public void addFirst(E data) {
        var node = Node.of(data);
        node.next = head;
        head = node;
        this.size++;
    }

    public void addAllFirst(SinglyLinkedList<E> linkedList) {
        if (linkedList.isEmpty())
            return;
        var temp = linkedList.head;
        while (temp != null) {
            addFirst(temp.data);
            temp = temp.next;
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public Optional<Integer> indexOf(E data) {
        if (head == null)
            return Optional.empty();
        var temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data.equals(data))
                return Optional.of(index);
            temp = temp.next;
            index++;
        }
        return Optional.empty();
    }

    public boolean contains(E e) {
        var temp = head;
        while (temp != null) {
            if (temp.data.equals(e))
                return true;
            temp = temp.next;
        }
        return false;
    }

    public Optional<E> get(int index) {
        if (isEmpty() || index >= size)
            return Optional.empty();
        return Optional.of(getNode(index).data);
    }

    private Node<E> getNode(int index) {
        var temp = head;
        while (index != 0) {
            temp = temp.next;
            index--;
        }
        return temp;
    }

    public void insert(E data, int index) {
        if (index > size)
            throw new IndexOutOfBoundsException(index);
        if (index == size) {
            addLast(data);
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        getNode(index - 1).insertAfter(data);
        size++;
    }

    public void addLast(E data) {
        if (this.isEmpty()) {
            addFirst(data);
        }

        var temp = head;
        for (int i = 0; i < size - 1; i++) {
            temp = temp.next;
        }
        temp.next = Node.of(data);
        size++;
    }

    public void removeLast() {
        if (this.isEmpty())
            return;
        var temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    public Optional<E> removeFirst() {
        if (isEmpty())
            return Optional.empty();
        var removedData = Optional.of(head.data);
        head = head.next;
        this.size--;
        return removedData;
    }

    public Optional<E> remove(int index) {
        if (index >= size)
            return Optional.empty();
        if (index == 0)
            return removeFirst();
        var temp = head;
        index--;
        while (index != 0) {
            temp = temp.next;
            index--;
        }
        var dataToBeRemoved = Optional.of(temp.next.data);
        temp.next = temp.next.next;
        size--;
        return dataToBeRemoved;
    }

    @Override
    public String toString() {
        if (isNull(head))
            return "| |";
        return this.head.toString() + " | ";
    }

}
