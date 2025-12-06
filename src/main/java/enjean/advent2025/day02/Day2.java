package enjean.advent2025.day02;

import enjean.advent2025.utils.ParseUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class Day2 {

    static LongStream parseInput(String line) {
        return Arrays.stream(line.split(","))
            .map(rangeStr -> {
                List<Long> bounds = Arrays.stream(rangeStr.split("-")).map(Long::valueOf).toList();
                return LongStream.rangeClosed(bounds.getFirst(), bounds.getLast());
            })
            .flatMapToLong(i -> i);
    }

    static Long sumInvalidIds(LongStream ids, IdValidator idValidator) {
        return ids.filter(id -> !idValidator.isValid(id))
            .sum();
    }

    static void main() {
        String inputLine = ParseUtils.readLinesFromFile(2).getFirst();
        LongStream parsedInput = parseInput(inputLine);

//        long part1 = sumInvalidIds(parsedInput, new Part1IdValidator());
//        IO.println("Part 1 = " + part1);

        long part2 = sumInvalidIds(parsedInput, new Part2IdValidator());
        IO.println("Part 2 = " + part2);
    }
}
