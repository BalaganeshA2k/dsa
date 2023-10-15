package org.lern.dsa.linked_list;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

    @Test
    void toStringTest() {
        var linkedList = new SinglyLinkedList<Integer>();
        assertThat(linkedList).hasToString("| |");
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        assertThat(linkedList).hasToString(" | 2 | 1 | ");
    }

    @Test
    void addFirst_should_append_values_to_the_begining() {
        var linkedList = new SinglyLinkedList<Integer>();
        linkedList.addFirst(0);
        assertThat(linkedList.toString()).isEqualToIgnoringWhitespace("| 0 |");
        linkedList.addFirst(1);
        assertThat(linkedList.toString()).isEqualToIgnoringWhitespace("| 1 | 0 |");
    }

    @Test
    void isEmpty_should_return_true_when_empty() {
        var linkedList = new SinglyLinkedList<Integer>();
        assertTrue(linkedList.isEmpty());
    }

    @Test
    void isEmpty_should_return_false_when_list_has_values() {
        var linkedList = new SinglyLinkedList<Integer>();
        linkedList.addFirst(1);
        assertThat(linkedList.isEmpty()).isFalse();
    }

    @Test
    void contains_should_return_true_when_list_has_target_value() {
        var linkedList = new SinglyLinkedList<Integer>();
        linkedList.addFirst(1);
        assertThat(linkedList.contains(2)).isFalse();
    }

    @Test
    void contains_should_return_false_when_list_does_not_have_target_value() {
        var linkedList = new SinglyLinkedList<Integer>();
        assertThat(linkedList.contains(1)).isFalse();
        linkedList.addFirst(2);
        assertThat(linkedList.contains(1)).isFalse();
    }

    @Test
    void removeFirst_should_return_removed_first_element_when_list_is_not_empty() {
        var linkedList = new SinglyLinkedList<Integer>();
        linkedList.addFirst(1);
        assertThat(linkedList.removeFirst()).hasValue(1);
        assertThat(linkedList.contains(1)).isFalse();
        assertThat(linkedList.isEmpty()).isTrue();
    }

    @Test
    void removeFirst_should_return_empty_optional_when_list_is_empty() {
        var linkedList = new SinglyLinkedList<Integer>();
        assertThat(linkedList.removeFirst()).isEmpty();
    }

    @Test
    void removeFirst_should_always_return_first_element() {
        var removeOrder = new int[] { 4, 3, 2, 1 };
        var linkedList = Stream.of(1, 2, 3, 4).collect(SinglyLinkedList<Integer>::new, SinglyLinkedList::addFirst,
                SinglyLinkedList::addAllFirst);
        Arrays.stream(removeOrder).forEach(value -> assertThat(linkedList.removeFirst()).hasValue(value));
    }

    @Test
    void remove_should_return_empty_when_index_is_out_of_bounds() {
        var linkedList = new SinglyLinkedList<>();
        assertThat(linkedList.remove(0)).isEmpty();
        linkedList.addFirst(1);
        assertThat(linkedList.remove(3)).isEmpty();
    }

    @Test
    void remove_should_return_optionalOf_removed_element() {
        var linkedList = Stream.of(3, 2, 1, 0).collect(SinglyLinkedList<Integer>::new, SinglyLinkedList::addFirst,
                SinglyLinkedList::addAllFirst);
        assertThat(linkedList.remove(3)).hasValue(3);
        assertThat(linkedList.remove(0)).hasValue(0);
        assertThat(linkedList.contains(3)).isFalse();
        assertThat(linkedList.contains(0)).isFalse();
    }

    @Test
    void indexOf_should_return_empty_optional_when_list_is_empty() {
        var linkedList = new SinglyLinkedList<>();
        assertThat(linkedList.indexOf(1)).isEmpty();
    }

    @Test
    void indexOf_should_return_the_index_when_value_is_present() {
        var linkedList = Stream.of(1, 2, 3, 4).collect(SinglyLinkedList<Integer>::new, SinglyLinkedList::addFirst,
                SinglyLinkedList::addAllFirst);
        assertThat(linkedList.indexOf(4)).hasValue(0);
        assertThat(linkedList.indexOf(3)).hasValue(1);
        assertThat(linkedList.indexOf(2)).hasValue(2);
        assertThat(linkedList.indexOf(1)).hasValue(3);
    }

    @Test
    void get_should_return_the_value_at_index_when_present() {
        var emptyList = new SinglyLinkedList<Integer>();
        assertThat(emptyList.get(0)).isEmpty();
        var linkedList = Stream.of(1, 2, 3, 4).collect(SinglyLinkedList<Integer>::new,
                SinglyLinkedList::addFirst,
                SinglyLinkedList::addAllFirst);
        assertThat(linkedList.get(0)).hasValue(4);
        assertThat(linkedList.get(1)).hasValue(3);
        assertThat(linkedList.get(2)).hasValue(2);
        assertThat(linkedList.get(3)).hasValue(1);
        assertThat(linkedList.get(4)).isEmpty();
    }

    @Test
    void removeLast_should_return_the_last_value() {
        var emptyList = new SinglyLinkedList<Integer>();
        assertDoesNotThrow(emptyList::removeLast);
        var linkedList = Stream.of(1, 2, 3, 4).collect(SinglyLinkedList<Integer>::new,
                SinglyLinkedList::addFirst,
                SinglyLinkedList::addAllFirst);
        linkedList.removeLast();
        assertThat(linkedList.contains(1)).isFalse();
        assertThat(linkedList.toString()).isEqualToIgnoringWhitespace("|4|3|2|");
    }

    @Test
    void addLast_should_add_data_to_last() {
        var linkedList = Stream.of(1, 2, 3, 4).collect(SinglyLinkedList<Integer>::new,
                SinglyLinkedList::addFirst,
                SinglyLinkedList::addAllFirst);
        linkedList.addLast(5);
        assertThat(linkedList.toString()).isEqualToIgnoringWhitespace("|4|3|2|1|5|");
    }

    @Test
    void insert_should_insert_values_at_specified_index() {
        var linkedList = Stream.of(1, 2, 3, 4).collect(SinglyLinkedList<Integer>::new,
                SinglyLinkedList::addFirst,
                SinglyLinkedList::addAllFirst);
        linkedList.insert(5, 0);
        assertThat(linkedList.get(0)).hasValue(5);
        assertThat(linkedList.toString()).isEqualToIgnoringWhitespace("|5|4|3|2|1|");
        linkedList.insert(6, 2);
        assertThat(linkedList.get(2)).hasValue(6);
        assertThat(linkedList.toString()).isEqualToIgnoringWhitespace("|5|4|6|3|2|1|");
        linkedList.insert(7, 5);
        assertThat(linkedList.toString()).isEqualToIgnoringWhitespace("|5|4|6|3|2|7|1|");
        assertThat(linkedList.get(5)).hasValue(7);
    }
}