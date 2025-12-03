package enjean.advent2025.day01;

import java.util.List;

import static enjean.advent2025.utils.ParseUtils.readLinesFromFile;

public class Day1 {

    protected static int countTimesAt0(List<Instruction> instructions) {
        int timesAt0 = 0;
        Dial dial = new Dial(50);
        for (Instruction instruction : instructions) {
            dial.rotate(instruction.direction(), instruction.clicks());
            if (dial.getPosition() == 0) {
                timesAt0++;
            }
        }
        return timesAt0;
    }

    static void main(String[] args) {
        List<Instruction> instructions = readLinesFromFile(1)
            .stream()
            .map(InstructionParser::parseInstruction)
            .toList();

        int part1Answer = countTimesAt0(instructions);
        IO.println("Part 1: " + part1Answer);
    }
}
