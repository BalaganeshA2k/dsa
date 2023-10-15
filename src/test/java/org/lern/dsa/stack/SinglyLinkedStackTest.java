package org.lern.dsa.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SinglyLinkedStackTest {
    @Test
    void testIsEmpty() {
        var stack = new SinglyLinkedStack<Integer>();
        assertThat(stack.isEmpty()).isTrue();
        stack.push(1);
        assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    void testPeek() {
        var stack = new SinglyLinkedStack<Integer>();
        assertThat(stack.peek()).isEmpty();
        stack.push(1);
        assertThat(stack.peek()).hasValue(1);
        stack.push(2);
        assertThat(stack.peek()).hasValue(2);

    }

    @Test
    void testPop() {
        var stack = new SinglyLinkedStack<Integer>();
        assertThat(stack.pop()).isEmpty();
        stack.push(1);
        assertThat(stack.pop()).hasValue(1);
        assertThat(stack.isEmpty()).isTrue();
        assertThat(stack.getSize()).isZero();

        stack.push(1);
        stack.push(2);
        assertThat(stack.pop()).hasValue(2);
        assertThat(stack.isEmpty()).isFalse();
        assertThat(stack.getSize()).isOne();

    }

    @Test
    void testPush() {
        var stack = new SinglyLinkedStack<Integer>();
        stack.push(1);
        assertThat(stack.getSize()).isOne();
        assertThat(stack.head).isNotNull();
        assertThat(stack.head.getData()).isOne();
        stack.push(2);
        assertThat(stack.getSize()).isEqualTo(2);
        assertThat(stack.head.getData()).isEqualTo(2);
    }
}
