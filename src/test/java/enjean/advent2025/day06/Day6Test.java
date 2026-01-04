package enjean.advent2025.day06;

import org.junit.jupiter.api.Test;

import java.util.List;

import static enjean.advent2025.day06.Operator.ADD;
import static enjean.advent2025.day06.Operator.MULTIPLY;
import static org.junit.jupiter.api.Assertions.*;

class Day6Test {
    private final ProblemSet exampleProblemSet = new ProblemSet(
        new long[][] {
            {123, 328, 51, 64},
            {45, 64, 387, 23},
            {6, 98, 215, 314}
        },
        List.of(MULTIPLY, ADD, MULTIPLY, ADD)
    );

    @Test
    void part1Example() {
        assertEquals(4277556L, Day6.solveAllProblems(exampleProblemSet));
    }
}
