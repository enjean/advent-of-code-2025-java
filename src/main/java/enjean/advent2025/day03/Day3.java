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

    static int calculateTotalOutputJoltage(List<BatteryBank> batteryBanks) {
        return batteryBanks.stream().mapToInt(BatteryBank::largestPossibleJoltage).sum();
    }

    static void main() {
        List<BatteryBank> batteryBanks = ParseUtils.readLinesFromFile(3)
            .stream().map(Day3::parseBatteryBank)
            .toList();

        int part1 = calculateTotalOutputJoltage(batteryBanks);
        IO.println("Part 1 = " + part1);
    }
}
