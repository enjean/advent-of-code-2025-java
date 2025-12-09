package enjean.advent2025.day03;

import java.util.ArrayList;
import java.util.List;

public class BatteryBank {
    private final List<Integer> joltageRatings;

    public BatteryBank(List<Integer> joltageRatings) {
        this.joltageRatings = new ArrayList<>(joltageRatings);
    }

    public long largestPossibleJoltage(int digitCount) {
        StringBuilder digitsString = new StringBuilder();
        int startDigitToConsider = 0;
        for (int digitNum = 0; digitNum < digitCount; digitNum++) {
            int endDigitToConsider = joltageRatings.size() - (digitCount - digitNum);
            int highestRating = joltageRatings.get(startDigitToConsider);
            startDigitToConsider++;
            for (int i = startDigitToConsider; i <= endDigitToConsider; i++) {
                int joltageRating = joltageRatings.get(i);
                if (joltageRating > highestRating) {
                    highestRating = joltageRating;
                    startDigitToConsider = i + 1;
                }
            }
            digitsString.append(highestRating);
        }
        return Long.parseLong(digitsString.toString());
    }
}
