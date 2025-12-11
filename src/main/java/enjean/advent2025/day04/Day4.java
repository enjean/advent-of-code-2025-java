package enjean.advent2025.day04;

import enjean.advent2025.utils.ParseUtils;

import java.util.List;

public class Day4 {
    static Grid parseGrid(List<String> lines) {
        int rowCount = lines.size();
        int colCount = lines.getFirst().length();
        Grid grid = new Grid(rowCount, colCount);

        for (int row = 0; row < lines.size(); row++) {
            String line = lines.get(row);
            for (int col = 0; col < line.length(); col++) {
                if (line.charAt(col) == '@') {
                    grid.setRollPresent(row, col);
                }
            }
        }

        return grid;
    }

    static long countRollsToBePulled(Grid grid) {
        int count = 0;
        for (int row = 0; row < grid.getRowCount(); row++) {
            for (int col = 0; col < grid.getColumnCount(); col++) {
                if (grid.hasRoll(row, col) && grid.countNeighbors(row, col) < 4) {
                    count++;
                }
            }
        }
        return count;
    }

    static void main() {
        Grid grid = parseGrid(ParseUtils.readLinesFromFile(4));

        long part1 = countRollsToBePulled(grid);
        IO.println("Part 1 = " + part1);
    }
}
