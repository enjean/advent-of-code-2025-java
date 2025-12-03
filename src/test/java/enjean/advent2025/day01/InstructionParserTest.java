package enjean.advent2025.day01;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {

    @ParameterizedTest
    @ArgumentsSource(ParseTestArgumentsProvider.class)
    void parseTest(String line, Instruction expected) {
        Instruction result = InstructionParser.parseInstruction(line);
        assertEquals(expected, result);
    }

    private static class ParseTestArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                Arguments.of("L1", new Instruction(Direction.LEFT, 1)),
                Arguments.of("R1", new Instruction(Direction.RIGHT, 1)),
                Arguments.of("L68", new Instruction(Direction.LEFT, 68)),
                Arguments.of("R682", new Instruction(Direction.RIGHT, 682))
            );
        }
    }

}