package enjean.advent2025.day03;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BatteryBankTest {

    @ParameterizedTest
    @ArgumentsSource(LargestPossibleJoltageTestArgumentsProvider.class)
    void testLargestPossibleJoltage(BatteryBank batteryBank, int expected) {
        assertEquals(expected, batteryBank.largestPossibleJoltage());
    }

    private static class LargestPossibleJoltageTestArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                Arguments.of(new BatteryBank(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1)), 98),
                Arguments.of(new BatteryBank(Arrays.asList(8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9)), 89),
                Arguments.of(new BatteryBank(Arrays.asList(2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8)), 78),
                Arguments.of(new BatteryBank(Arrays.asList(8, 1, 8, 1, 8, 1, 9, 1, 1, 1, 1, 2, 1, 1, 1)), 92)
            );
        }
    }
}