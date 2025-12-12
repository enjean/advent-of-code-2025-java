package enjean.advent2025.day04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day4Test {
    private final Grid exampleGrid = Day4.parseGrid(
        Arrays.asList(
            "..@@.@@@@.",
            "@@@.@.@.@@",
            "@@@@@.@.@@",
            "@.@@@@..@.",
            "@@.@@@@.@@",
            ".@@@@@@@.@",
            ".@.@.@.@@@",
            "@.@@@.@@@@",
            ".@@@@@@@@.",
            "@.@.@@@.@."
        )
    );

    @Test
    void testCountRollsToBePulled() {
        assertEquals(13L, Day4.countRollsToBePulled(exampleGrid));
    }

    @Test
    void testRemoveAllRollsPossible() {
        assertEquals(43L, Day4.removeAllRollsPossible(exampleGrid));
    }
}