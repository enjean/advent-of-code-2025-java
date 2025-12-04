package enjean.advent2025.day01;

import java.util.List;

import static enjean.advent2025.utils.ParseUtils.readLinesFromFile;

public class Day1 {

    protected record DialStats(
        int timesAt0,
        int timesPassing0
    ) {
    }

    protected static DialStats turnDial(List<Instruction> instructions) {
        int timesAt0 = 0;
        int timesPassing0 = 0;
        Dial dial = new Dial(50);
        for (Instruction instruction : instructions) {
            int passing0ForInstruction = dial.rotate(instruction);
            timesPassing0 += passing0ForInstruction;
            if (dial.getPosition() == 0) {
                timesAt0++;
            }
        }

        return new DialStats(
            timesAt0,
            timesPassing0
        );
    }

    static void main(String[] args) {
        List<Instruction> instructions = readLinesFromFile(1)
            .stream()
            .map(InstructionParser::parseInstruction)
            .toList();

        DialStats dialStats = turnDial(instructions);

        IO.println("Part 1: " + dialStats.timesAt0());

        int timesPointingAt0 = dialStats.timesAt0() + dialStats.timesPassing0();
        IO.println("Part 2: " + timesPointingAt0);
    }
}
