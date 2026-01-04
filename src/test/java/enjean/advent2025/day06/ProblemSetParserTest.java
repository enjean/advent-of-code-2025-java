package enjean.advent2025.day06;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static enjean.advent2025.day06.Operator.ADD;
import static enjean.advent2025.day06.Operator.MULTIPLY;
import static org.junit.jupiter.api.Assertions.*;

class ProblemSetParserTest {

    @Test
    void parseExample() {
        List<String> exampleInput = Arrays.asList(
            "123 328  51 64 ",
            " 45 64  387 23 ",
            "  6 98  215 314",
            "*   +   *   +  "
        );

        ProblemSet actual = ProblemSetParser.parseProblemSet(exampleInput);

        ProblemSet expected = new ProblemSet(
            new long[][] {
                {123, 328, 51, 64},
                {45, 64, 387, 23},
                {6, 98, 215, 314}
            },
            List.of(MULTIPLY, ADD, MULTIPLY, ADD)
        );
        assertEquals(expected.numbers().length, actual.numbers().length);
        for (int i = 0; i < expected.numbers().length; i++) {
            assertArrayEquals(expected.numbers()[i], actual.numbers()[i]);
        }
        assertEquals(expected.operators(), actual.operators());
    }
}