package enjean.advent2025.day06;

import java.util.Arrays;
import java.util.List;

public class ProblemSetParser {
    public static ProblemSet parseProblemSet(List<String> lines) {
        int numberOfNumberRows = lines.size() - 1;
        long[][] numbers = new long[numberOfNumberRows][];
        for (int row = 0; row < numberOfNumberRows; row++) {
            String line = lines.get(row).trim();
            numbers[row] = Arrays.stream(line.split("\\s+")).mapToLong(Long::parseLong).toArray();
        }

        List<Operator> operators = Arrays.stream(lines.getLast().trim().split("\\s+"))
            .map(s ->
                switch (s) {
                    case "+" -> Operator.ADD;
                    case "*" -> Operator.MULTIPLY;
                    default -> throw new IllegalStateException("Unexpected value: " + s);
                }
            ).toList();

        return new ProblemSet(numbers, operators);
    }
}
