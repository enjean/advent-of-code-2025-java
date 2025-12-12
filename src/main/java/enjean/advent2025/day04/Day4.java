package enjean.advent2025.day04;

import enjean.advent2025.utils.ParseUtils;

import java.util.ArrayList;
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

    record Coordinate(
        int row,
        int col
    ) {
    }

    static long removeAllRollsPossible(Grid grid) {
        List<Coordinate> rollLocations = new ArrayList<>();
        for (int row = 0; row < grid.getRowCount(); row++) {
            for (int col = 0; col < grid.getColumnCount(); col++) {
                if (grid.hasRoll(row, col)) {
                    rollLocations.add(new Coordinate(row, col));
                }
            }
        }

        long totalRemoved = 0;
        int removedThisRound = 0;
        do {
            List<Coordinate> toRemove = rollLocations.stream()
                .filter(c -> grid.countNeighbors(c.row, c.col) < 4)
                .toList();

            for (Coordinate coordinateToRemove : toRemove) {
                grid.removeRoll(coordinateToRemove.row, coordinateToRemove.col);
                if (!rollLocations.remove(coordinateToRemove)) {
                    throw new RuntimeException("Unable to remove");
                }
            }

            removedThisRound = toRemove.size();
            totalRemoved += removedThisRound;
        } while (removedThisRound > 0);

        return totalRemoved;
    }

    static void main() {
        Grid grid = parseGrid(ParseUtils.readLinesFromFile(4));

//        long part1 = countRollsToBePulled(grid);
//        IO.println("Part 1 = " + part1);

        long part2 = removeAllRollsPossible(grid);
        IO.println("Part 2 = " + part2);
    }
}
