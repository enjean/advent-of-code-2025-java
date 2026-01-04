package enjean.advent2025.day06;

import enjean.advent2025.utils.ParseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class Day6 {
    public static long solveAllProblems(ProblemSet problemSet) {
        long total = 0;
        for (int column = 0; column < problemSet.numbers()[0].length; column++) {
            total += solveProblemsInColumn(problemSet, column);
        }
        return total;
    }

    private static long solveProblemsInColumn(ProblemSet problemSet, int column) {
        List<Long> numbersInColumn = new ArrayList<>();
        for (int row = 0; row < problemSet.numbers().length; row++) {
            numbersInColumn.add(problemSet.numbers()[row][column]);
        }

        LongStream columnStream = numbersInColumn.stream().mapToLong(Long::longValue);
        return switch (problemSet.operators().get(column)) {
            case ADD -> columnStream.sum();
            case MULTIPLY -> columnStream.reduce(1, (a, b) -> a * b);
        };
    }

    static void main() {
        ProblemSet problemSet = ProblemSetParser.parseProblemSet(ParseUtils.readLinesFromFile(6));

        long part1 = solveAllProblems(problemSet);
        IO.println("Part 1: " + part1);
    }
}
