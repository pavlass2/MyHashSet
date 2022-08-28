package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MyHashSetTest {
    String PERSON_NAME = "James Gosling";
    String EVIL_PERSON_NAME = "Anders Hejlsberg";
    MyHashSet myHashSet;
    @BeforeEach
    void setup() {
        myHashSet =  new MyHashSet(89);
    }

    @Test
    void isEmpty() {
        Assertions.assertTrue(myHashSet.isEmpty());

        myHashSet.add(PERSON_NAME);
        myHashSet.add(EVIL_PERSON_NAME);
        myHashSet.clear();

        Assertions.assertTrue(myHashSet.isEmpty());
    }

    @Test
    void contains() {
        myHashSet.add(PERSON_NAME);
        Assertions.assertTrue(myHashSet.contains(PERSON_NAME));
        Assertions.assertFalse(myHashSet.contains(EVIL_PERSON_NAME));
    }

    @Test
    void add() {
        Assertions.assertTrue(myHashSet.add(PERSON_NAME));
        Assertions.assertFalse(myHashSet.add(PERSON_NAME));
        Assertions.assertTrue(myHashSet.add(EVIL_PERSON_NAME));
        Assertions.assertFalse(myHashSet.add(EVIL_PERSON_NAME));
    }

    @Test
    void remove() {
        Assertions.assertFalse(myHashSet.contains(PERSON_NAME));
        Assertions.assertFalse(myHashSet.contains(EVIL_PERSON_NAME));

        myHashSet.add(PERSON_NAME);
        myHashSet.add(EVIL_PERSON_NAME);

        Assertions.assertTrue(myHashSet.contains(PERSON_NAME));
        Assertions.assertTrue(myHashSet.contains(EVIL_PERSON_NAME));
    }

    @Test
    void addAll() {
        List<String> values = new ArrayList<>();
        values.add(PERSON_NAME);
        values.add(EVIL_PERSON_NAME);
        myHashSet.addAll(values);

        Assertions.assertTrue(myHashSet.contains(PERSON_NAME));
        Assertions.assertTrue(myHashSet.contains(EVIL_PERSON_NAME));
    }

    @Test
    void removeAll() {
        List<String> values = new ArrayList<>();
        values.add(PERSON_NAME);
        values.add(EVIL_PERSON_NAME);
        myHashSet.addAll(values);
        myHashSet.removeAll(values);

        Assertions.assertFalse(myHashSet.contains(PERSON_NAME));
        Assertions.assertFalse(myHashSet.contains(EVIL_PERSON_NAME));
    }

    @Test
    void containsAll() {
        List<String> values = new ArrayList<>();
        values.add(PERSON_NAME);
        values.add(EVIL_PERSON_NAME);

        Assertions.assertFalse(myHashSet.containsAll(values));

        myHashSet.addAll(values);

        Assertions.assertTrue(myHashSet.containsAll(values));
    }
}