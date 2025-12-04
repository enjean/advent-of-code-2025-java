package enjean.advent2025.day01;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DialTest {

    @ParameterizedTest
    @ArgumentsSource(RotateDialArgumentsProvider.class)
    void rotateDial(
        int currentPosition,
        Instruction instruction,
        int expectedPosition,
        int expectedTimesPassing0
    ) {
        Dial dial = new Dial(currentPosition);
        int timesAtO = dial.rotate(instruction);
        assertEquals(expectedPosition, dial.getPosition());
        assertEquals(expectedTimesPassing0, timesAtO);
    }

    static class RotateDialArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                Arguments.of(11, new Instruction(Direction.RIGHT, 8), 19, 0),
                Arguments.of(19, new Instruction(Direction.LEFT, 19), 0, 0),
                Arguments.of(0, new Instruction(Direction.RIGHT, 1), 1, 0),
                Arguments.of(99, new Instruction(Direction.RIGHT, 1), 0, 0),
                Arguments.of(50, new Instruction(Direction.LEFT, 68), 82, 1),
                Arguments.of(82, new Instruction(Direction.LEFT, 30), 52, 0),
                Arguments.of(52, new Instruction(Direction.RIGHT, 48), 0, 0),
                Arguments.of(0, new Instruction(Direction.LEFT, 5), 95, 0),
                Arguments.of(95, new Instruction(Direction.RIGHT, 60), 55, 1),
                Arguments.of(55, new Instruction(Direction.LEFT, 55), 0, 0),
                Arguments.of(0, new Instruction(Direction.LEFT, 1), 99, 0),
                Arguments.of(99, new Instruction(Direction.LEFT, 99), 0, 0),
                Arguments.of(0, new Instruction(Direction.RIGHT, 14), 14, 0),
                Arguments.of(14, new Instruction(Direction.LEFT, 82), 32, 1),
                Arguments.of(50, new Instruction(Direction.RIGHT, 1000), 50, 10)
            );
        }
    }
}