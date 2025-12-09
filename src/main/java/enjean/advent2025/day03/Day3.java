package enjean.advent2025.day03;

import enjean.advent2025.utils.ParseUtils;

import java.util.ArrayList;
import java.util.List;

public class Day3 {
    static BatteryBank parseBatteryBank(String line) {
        List<Integer> joltageRatings = new ArrayList<>();
        for (char c : line.toCharArray()) {
            int rating = Integer.parseInt(String.valueOf(c));
            joltageRatings.add(rating);
        }
        return new BatteryBank(joltageRatings);
    }

    static long calculateTotalOutputJoltage(List<BatteryBank> batteryBanks, int digitCount) {
        return batteryBanks.stream().mapToLong(b -> b.largestPossibleJoltage(digitCount)).sum();
    }

    static void main() {
        List<BatteryBank> batteryBanks = ParseUtils.readLinesFromFile(3)
            .stream().map(Day3::parseBatteryBank)
            .toList();

        long part1 = calculateTotalOutputJoltage(batteryBanks, 2);
        IO.println("Part 1 = " + part1);

        long part2 = calculateTotalOutputJoltage(batteryBanks, 12);
        IO.println("Part 2 = " + part2);
    }
}
