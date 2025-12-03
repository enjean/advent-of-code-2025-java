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
        Direction direction,
        int numberOfClicks,
        int expected
    ) {
        Dial dial = new Dial(currentPosition);
        dial.rotate(direction, numberOfClicks);
        assertEquals(expected, dial.getPosition());
    }

    static class RotateDialArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                Arguments.of(11, Direction.RIGHT, 8, 19),
                Arguments.of(19, Direction.LEFT, 19, 0),
                Arguments.of(0, Direction.RIGHT, 1, 1),
                Arguments.of(99, Direction.RIGHT, 1, 0),
                Arguments.of(50, Direction.LEFT, 68, 82),
                Arguments.of(82, Direction.LEFT, 30, 52),
                Arguments.of(52, Direction.RIGHT, 48, 0),
                Arguments.of(0, Direction.LEFT, 5, 95),
                Arguments.of(95, Direction.RIGHT, 60, 55),
                Arguments.of(55, Direction.LEFT, 55, 0),
                Arguments.of(0, Direction.LEFT, 1, 99),
                Arguments.of(99, Direction.LEFT, 99, 0),
                Arguments.of(0, Direction.RIGHT, 14, 14),
                Arguments.of(14, Direction.LEFT, 82, 32)
            );
        }
    }
}