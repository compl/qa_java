package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    /*
        Здесь не нравится тест, т.к. сразу проверяется и вызываемый метод getFood супер-класса,
        который должен быть покрыт своим тестом. Метод eatMeat по сути это прокси, и здесь должна быть проверка,
        что просто вызывается getFood, но как это сделать - неясно.
    */
    @Test
    public void eatMeatReturnPredatorFood() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        assertEquals(food, feline.eatMeat());
    }

    @Test
    public void getFamilyFeline() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getOneKitten() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getTwoKittens() {
        int count = 2;
        assertEquals(count, feline.getKittens(count));
    }
}