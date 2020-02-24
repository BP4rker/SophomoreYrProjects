package com.company;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class Assignment1Test {
    @Test
    void test() {
        assertTrue(Assignment1.stackPermutation(new int[]{1, 2, 5, 4, 3}));
        assertFalse(Assignment1.stackPermutation(new int[] {1,2,5,3,4 }));
        assertTrue(Assignment1.stackPermutation(new int[] {2,1,3,4,6,5 }));
        assertTrue(Assignment1.stackPermutation(new int[] {2,1,4,6,5,3 }));
        assertFalse(Assignment1.stackPermutation(new int[] {2,1,6,3,4,5 }));
        assertTrue(Assignment1.stackPermutation(new int[] {}));
    }
}

