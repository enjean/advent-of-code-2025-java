package enjean.advent2025.day02;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class IdValidatorTest {
    @Nested
    class Part1 {
        private final IdValidator idValidator = new Part1IdValidator();

        @ParameterizedTest
        @ValueSource(longs = {12, 21, 110, 111, 999, 1012, 1188511880, 222220, 1698522, 446443, 38593856, 565656, 824824824, 2121212121})
        void validIds(long id) {
            assertTrue(idValidator.isValid(id));
        }

        @ParameterizedTest
        @ValueSource(longs = {11, 22, 99, 1010, 1919, 1188511885, 222222, 446446, 38593859})
        void invalidIds(long id) {
            assertFalse(idValidator.isValid(id));
        }
    }

    @Nested
    class Part2 {
        private final IdValidator idValidator = new Part2IdValidator();

        @ParameterizedTest
        @ValueSource(longs = {12, 21, 110, 1012, 1188511880, 222220, 1698522, 446443, 38593856})
        void validIds(long id) {
            assertTrue(idValidator.isValid(id));
        }

        @ParameterizedTest
        @ValueSource(longs = {11, 22, 99, 111, 999, 1010, 1919, 1188511885, 222222, 446446, 38593859, 565656, 824824824, 2121212121})
        void invalidIds(long id) {
            assertFalse(idValidator.isValid(id));
        }
    }
}
