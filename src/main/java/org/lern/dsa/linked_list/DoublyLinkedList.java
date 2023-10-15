package org.lern.dsa.linked_list;

import static java.util.Objects.isNull;

import java.util.Optional;

public class DoublyLinkedList<E> {
    private int size = 0;
    private Node<E> head;
    private Node<E> tail;

    public int getSize() {
        return this.size;
    }

    static class Node<T> {
        Node<T> previous;
        T data;
        Node<T> next;

        private Node(T data) {
            this.data = data;
        }

        static <T> Node<T> of(T data) {
            return new Node<>(data);
        }

        @Override
        public String toString() {
            return " | " + this.data.toString() + (isNull(next) ? "" : next.toString());
        }

    }

    public void addFirst(E data) {
        var newNode = Node.of(data);
        size++;
        if (head == null) {
            this.head = newNode;
            this.tail = this.head;
            return;
        }
        newNode.next = this.head;
        this.head.previous = newNode;
        this.head = newNode;
    }

    public void addLast(E data) {
        if (this.tail == null) {
            addFirst(data);
            return;
        }
        var newNode = Node.of(data);
        this.tail.next = newNode;
        newNode.previous = this.tail;
        this.tail = newNode;
        size++;
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    public boolean contains(E data) {
        var temp = this.head;
        while (temp != null) {
            if (temp.data.equals(data))
                return true;
            temp = temp.next;
        }
        return false;
    }

    public Optional<E> get(int index) {
        if (this.isEmpty() || index >= size)
            return Optional.empty();
        var temp = this.head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return Optional.of(temp.data);
    }

    public void insert(E data, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        var temp = this.head;
        while (index - 1 > 0) {
            temp = temp.next;
            index--;
        }
        var newNode = Node.of(data);
        newNode.next = temp.next;
        newNode.previous = temp;
        temp.next = newNode;
        size++;
    }

    public DoublyLinkedList<E> reversed() {
        var reversed = new DoublyLinkedList<E>();
        var temp = this.head;
        while (temp != null) {
            reversed.addFirst(temp.data);
            temp = temp.next;
        }
        return reversed;
    }

    public Optional<E> removeFirst() {
        if (head == null)
            return Optional.empty();
        var removedData = head.data;
        this.head = head.next;
        if (this.head == null)
            this.tail = null;
        size--;
        return Optional.of(removedData);
    }

    public Optional<E> removeLast() {
        if (this.isEmpty())
            return Optional.empty();
        var removedData = tail.data;
        this.tail = tail.previous;
        if (this.tail == null)
            this.head = null;
        else
            this.tail.next = null;
        size--;
        return Optional.of(removedData);
    }

    public String toString() {
        if (isNull(head))
            return "| |";
        return this.head.toString() + " | ";
    }

}
