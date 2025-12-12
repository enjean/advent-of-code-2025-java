package enjean.advent2025.day05;

import enjean.advent2025.utils.ParseUtils;

import java.util.List;

public class Day5 {
    static CafeteriaData parseCafeteriaData(List<String> lines) {
        CafeteriaData cafeteriaData = new CafeteriaData();

        int currentLineNum = 0;
        while (!lines.get(currentLineNum).isEmpty()) {
            String rangeLine = lines.get(currentLineNum);
            String[] rangeParts = rangeLine.split("-");
            cafeteriaData.addFreshIngredientRange(
                Long.parseLong(rangeParts[0]),
                Long.parseLong(rangeParts[1])
            );
            currentLineNum++;
        }
        for (int i = currentLineNum + 1; i < lines.size(); i++) {
            cafeteriaData.addAvailableIngredient(Long.parseLong(lines.get(i)));
        }

        return cafeteriaData;
    }

    static void main() {
        CafeteriaData cafeteriaData = parseCafeteriaData(ParseUtils.readLinesFromFile(5));

        long part1 = cafeteriaData.countFreshIngredients();
        IO.println("Part 1 = " + part1);
    }
}
