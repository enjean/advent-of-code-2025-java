package enjean.advent2025.day02;

import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {
    @Test
    void testSmallExample() {
        String line = "11-22,95-115";
        LongStream parsedLine = Day2.parseInput(line);
        long invalidIdsSum = Day2.sumInvalidIds(parsedLine);
        assertEquals(132L, invalidIdsSum);
    }

    @Test
    void testFullExample() {
        String line = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124";
        LongStream parsedLine = Day2.parseInput(line);
        long invalidIdsSum = Day2.sumInvalidIds(parsedLine);
        assertEquals(1227775554L, invalidIdsSum);
    }
}
