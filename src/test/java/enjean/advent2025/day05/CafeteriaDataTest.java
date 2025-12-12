package enjean.advent2025.day05;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CafeteriaDataTest {

    private static final CafeteriaData exampleCafeteriaData = new CafeteriaData();

    @BeforeAll
    static void setup() {
        exampleCafeteriaData.addFreshIngredientRange(3, 5);
        exampleCafeteriaData.addFreshIngredientRange(10, 14);
        exampleCafeteriaData.addFreshIngredientRange(16, 20);
        exampleCafeteriaData.addFreshIngredientRange(12, 18);
        exampleCafeteriaData.addAvailableIngredient(1);
        exampleCafeteriaData.addAvailableIngredient(5);
        exampleCafeteriaData.addAvailableIngredient(8);
        exampleCafeteriaData.addAvailableIngredient(11);
        exampleCafeteriaData.addAvailableIngredient(17);
        exampleCafeteriaData.addAvailableIngredient(32);
    }

    @Test
    void countFreshIngredients() {
        assertEquals(3L, exampleCafeteriaData.countFreshIngredients());
    }
}