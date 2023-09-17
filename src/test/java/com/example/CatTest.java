package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CatTest {

    @Test
    public void testGetSound() {
        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound());
    }

    public void testGetFood() {
    }
}