package enjean.advent2025.day04;

import java.util.Arrays;
import java.util.List;

public class Grid {
    private final boolean [][] matrix;
    private final int rowCount;
    private final int columnCount;

    public Grid(
        int rowCount,
        int columnCount
    ) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.matrix = new boolean[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                matrix[i][j] = false;
            }
        }
    }

    public void setRollPresent(int row, int col) {
        matrix[row][col] = true;
    }

    public void removeRoll(int row, int col) {
        matrix[row][col] = false;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public boolean hasRoll(int row, int col) {
        return matrix[row][col];
    }

    public int countNeighbors(int row, int col) {
        int neighborCount = 0;

        List<Integer> possibleDiffs = Arrays.asList(-1, 0, 1);
        for (int dx : possibleDiffs) {
            for (int dy : possibleDiffs) {
                if (dx == 0 && dy == 0) continue;
                int r = row + dx;
                if (r < 0 || r >= rowCount) continue;
                int c = col + dy;
                if (c < 0 || c >= rowCount) continue;
                if (matrix[r][c]) neighborCount++;
            }
        }

        return neighborCount;
    }
}
