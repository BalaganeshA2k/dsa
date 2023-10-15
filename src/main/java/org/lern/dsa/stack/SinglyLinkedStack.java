package org.lern.dsa.stack;

import java.util.Optional;

public class SinglyLinkedStack<E> {
    int size = 0;
    Node<E> head;

    public void push(E data) {
        var newNode = Node.of(data);
        if (isEmpty()) {
            this.head = newNode;
            size++;
            return;
        }
        newNode.next = this.head;
        this.head = newNode;
        size++;
    }

    public Optional<E> pop() {
        if (head == null)
            return Optional.empty();
        var poppedData = head.getData();
        this.head = head.next;
        size--;
        return Optional.of(poppedData);
    }

    public Optional<E> peek() {
        if (head == null)
            return Optional.empty();
        return Optional.of(head.getData());
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return this.size;
    }

    static class Node<T> {
        private T data;
        private Node<T> next;

        private Node(T data) {
            this.data = data;
        }

        static <T> Node<T> of(T data) {
            return new Node<>(data);
        }

        T getData() {
            return data;
        }

        void setData(T data) {
            this.data = data;
        }

        Node<T> getNext() {
            return next;
        }

        void setNext(Node<T> next) {
            this.next = next;
        }
    }

}
