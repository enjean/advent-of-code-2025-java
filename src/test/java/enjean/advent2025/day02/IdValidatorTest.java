package enjean.advent2025.day02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class IdValidatorTest {

    @ParameterizedTest
    @ValueSource(longs = {12, 21, 110, 111, 1012, 1188511880, 222220, 1698522, 446443, 38593856})
    void validIds(long id) {
        assertTrue(IdValidator.isValid(id));
    }

    @ParameterizedTest
    @ValueSource(longs = {11, 22, 99, 1919, 1188511885, 222222, 446446, 38593859})
    void invalidIds(long id) {
        assertFalse(IdValidator.isValid(id));
    }
}
