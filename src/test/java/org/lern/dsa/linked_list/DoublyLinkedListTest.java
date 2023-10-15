package org.lern.dsa.linked_list;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {
    @Test
    void testAddFirst() {
        var linkedList = new DoublyLinkedList<Integer>();
        assertThat(linkedList.isEmpty()).isTrue();
        linkedList.addFirst(1);
        assertThat(linkedList.isEmpty()).isFalse();
        assertThat(linkedList.getSize()).isOne();
        linkedList.addFirst(2);
        assertThat(linkedList.isEmpty()).isFalse();
        assertThat(linkedList.getSize()).isEqualTo(2);
        assertThat(linkedList.contains(1)).isTrue();
        assertThat(linkedList.contains(2)).isTrue();
    }

    @Test
    void testAddLast() {
        var linkedList = new DoublyLinkedList<Integer>();
        assertThat(linkedList.isEmpty()).isTrue();
        linkedList.addLast(1);
        assertThat(linkedList.isEmpty()).isFalse();
        assertThat(linkedList.getSize()).isEqualTo(1);
        linkedList.addLast(2);
        assertThat(linkedList.isEmpty()).isFalse();
        assertThat(linkedList.getSize()).isEqualTo(2);
        assertThat(linkedList.contains(1)).isTrue();
        assertThat(linkedList.contains(2)).isTrue();
    }

    @Test
    void testContains() {
        var linkedList = new DoublyLinkedList<Integer>();
        assertThat(linkedList.isEmpty()).isTrue();
        linkedList.addFirst(1);
        assertThat(linkedList.contains(1)).isTrue();
        linkedList.addLast(2);
        assertThat(linkedList.contains(2)).isTrue();

    }

    @Test
    void testGet() {
        var linkedList = new DoublyLinkedList<Integer>();
        linkedList.addFirst(4);
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addFirst(0);
        Stream.of(0, 1, 2, 3, 4)
                .forEach(indexValue -> assertThat(linkedList.get(indexValue)).hasValue(indexValue));

    }

    @Test
    void testInsert() {
        var linkedList = new DoublyLinkedList<Integer>();
        linkedList.insert(4, 0);
        assertThat(linkedList.toString()).isEqualToIgnoringWhitespace("|4|");
        assertThat(linkedList.getSize()).isOne();
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addFirst(0);
        assertThat(linkedList.toString()).isEqualToIgnoringWhitespace("|0|1|2|3|4|");
        linkedList.insert(6, linkedList.getSize());
        assertThat(linkedList.toString()).isEqualToIgnoringWhitespace("|0|1|2|3|4|6|");
        assertThat(linkedList.getSize()).isEqualTo(6);
        linkedList.insert(5, linkedList.getSize() - 1);
        assertThat(linkedList.toString()).isEqualToIgnoringWhitespace("|0|1|2|3|4|5|6|");
    }

    @Test
    void testIsEmpty() {
        var linkedList = new DoublyLinkedList<Integer>();
        assertThat(linkedList.isEmpty()).isTrue();
        linkedList.addFirst(1);
        assertThat(linkedList.isEmpty()).isFalse();
    }

    @Test
    void testRemoveFirst() {
        var linkedList = new DoublyLinkedList<Integer>();
        assertThat(linkedList.removeFirst()).isEmpty();
        linkedList.addFirst(3);
        assertThat(linkedList.removeFirst()).hasValue(3);
        assertThat(linkedList.isEmpty()).isTrue();
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        assertThat(linkedList.removeFirst()).hasValue(1);
        assertThat(linkedList.toString()).isEqualToIgnoringWhitespace("|2|3|");
        assertThat(linkedList.getSize()).isEqualTo(2);
    }

    @Test
    void testRemoveLast() {
        var linkedList = new DoublyLinkedList<Integer>();
        assertThat(linkedList.removeLast()).isEmpty();
        linkedList.addFirst(3);
        assertThat(linkedList.removeLast()).hasValue(3);
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addFirst(0);
        assertThat(linkedList.removeLast()).hasValue(3);
        assertThat(linkedList.toString()).isEqualToIgnoringWhitespace("|0|1|2|");
        assertThat(linkedList.getSize()).isEqualTo(3);

    }

    @Test
    void testReverse() {
        var linkedList = new DoublyLinkedList<Integer>();
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addFirst(0);
        var reversed = linkedList.reversed();
        assertThat(linkedList.toString()).isEqualToIgnoringWhitespace("|0|1|2|3|");
        assertThat(reversed.toString()).isEqualToIgnoringWhitespace("|3|2|1|0|");
    }

    @Test
    void testToString() {
        var linkedList = new DoublyLinkedList<Integer>();
        assertThat(linkedList.toString()).isEqualTo("| |");
        linkedList.addFirst(1);
        linkedList.addFirst(0);
        assertThat(linkedList.toString()).isEqualTo(" | 0 | 1 | ");
        linkedList.addLast(2);
        linkedList.addLast(3);
        assertThat(linkedList.toString()).isEqualTo(" | 0 | 1 | 2 | 3 | ");
    }
}
