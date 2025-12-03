package enjean.advent2025.day01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {

    @Test
    void countTimesAt0() {
        List<Instruction> instructions = Arrays.asList(
            new Instruction(Direction.LEFT, 68),
            new Instruction(Direction.LEFT, 30),
            new Instruction(Direction.RIGHT, 48),
            new Instruction(Direction.LEFT, 5),
            new Instruction(Direction.RIGHT, 60),
            new Instruction(Direction.LEFT, 55),
            new Instruction(Direction.LEFT, 1),
            new Instruction(Direction.LEFT, 99),
            new Instruction(Direction.RIGHT, 14),
            new Instruction(Direction.LEFT, 82)
        );
        int result = Day1.countTimesAt0(instructions);
        assertEquals(3, result);
    }
}