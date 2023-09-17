package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(3, lion.getKittens());
    }

    @Test
    public void getFood() throws Exception {
        List<String> food = List.of("картошечка", "лук", "грибы");
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(food);
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(food, lion.getFood());
    }

    @Test
    public void verifyIncorrectSex() {
        assertThrows(Exception.class, () -> new Lion("qwerty", feline));
    }
}