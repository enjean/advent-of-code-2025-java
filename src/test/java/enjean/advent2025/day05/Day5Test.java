package enjean.advent2025.day05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day5Test {

    @Test
    void testParseCafeteriaData() {
        List<String> lines = Arrays.asList(
            "3-5",
            "10-14",
            "16-20",
            "12-18",
            "",
            "1",
            "5",
            "8",
            "11",
            "17",
            "32"
        );
        CafeteriaData cafeteriaData = Day5.parseCafeteriaData(lines);

        assertEquals(3, cafeteriaData.countFreshIngredients());
    }
}