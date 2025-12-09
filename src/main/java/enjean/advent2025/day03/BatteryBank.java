package enjean.advent2025.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BatteryBank {
    private final List<Integer> joltageRatings;

    public BatteryBank(List<Integer> joltageRatings) {
        this.joltageRatings = new ArrayList<>(joltageRatings);
    }

    public int largestPossibleJoltage() {
        int firstDigit = joltageRatings.getFirst();
        int firstDigitIndex = 0;
        for (int i = 1; i < joltageRatings.size() - 1; i++) {
            int digit = joltageRatings.get(i);
            if (digit > firstDigit) {
                firstDigit = digit;
                firstDigitIndex = i;
            }
        }

        int secondDigit = joltageRatings.get(firstDigitIndex + 1);
        for (int j = firstDigitIndex + 2; j < joltageRatings.size(); j++) {
            int digit = joltageRatings.get(j);
            if (digit > secondDigit) {
                secondDigit = digit;
            }
        }

        String ratingStr = String.valueOf(firstDigit) + String.valueOf(secondDigit);
        return Integer.parseInt(ratingStr);
    }
}
