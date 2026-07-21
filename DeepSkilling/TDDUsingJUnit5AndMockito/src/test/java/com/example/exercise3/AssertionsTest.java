package com.example.exercise3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AssertionsTest {

    @Test
    void testDifferentAssertions() {

        assertEquals(5, 2 + 3);

        assertTrue(10 > 5);

        assertFalse(5 > 10);

        String value = null;
        assertNull(value);

        Object object = new Object();
        assertNotNull(object);
    }
}