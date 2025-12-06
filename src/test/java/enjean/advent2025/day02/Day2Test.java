package enjean.advent2025.day02;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {
    @Nested
    class Part1 {
        private final IdValidator idValidator = new Part1IdValidator();

        @Test
        void testSmallExample() {
            String line = "11-22,95-115";
            LongStream parsedLine = Day2.parseInput(line);
            long invalidIdsSum = Day2.sumInvalidIds(parsedLine, idValidator);
            // 11 + 22 + 99
            assertEquals(132L, invalidIdsSum);
        }

        @Test
        void testFullExample() {
            String line = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124";
            LongStream parsedLine = Day2.parseInput(line);
            long invalidIdsSum = Day2.sumInvalidIds(parsedLine, idValidator);
            assertEquals(1227775554L, invalidIdsSum);
        }
    }

    @Nested
    class Part2 {
        private final IdValidator idValidator = new Part2IdValidator();

        @Test
        void testSmallExample() {
            String line = "11-22,95-115";
            LongStream parsedLine = Day2.parseInput(line);
            long invalidIdsSum = Day2.sumInvalidIds(parsedLine, idValidator);
            // 11 + 22 + 99 + 111
            assertEquals(243L, invalidIdsSum);
        }

        @Test
        void testFullExample() {
            String line = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124";
            LongStream parsedLine = Day2.parseInput(line);
            long invalidIdsSum = Day2.sumInvalidIds(parsedLine, idValidator);
            assertEquals(4174379265L, invalidIdsSum);
        }
    }
}
