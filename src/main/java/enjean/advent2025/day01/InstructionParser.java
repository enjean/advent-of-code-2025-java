package enjean.advent2025.day01;

public class InstructionParser {
    public static Instruction parseInstruction(String line) {
        char directionChar = line.charAt(0);
        Direction direction = switch(directionChar) {
            case 'L' -> Direction.LEFT;
            case 'R' -> Direction.RIGHT;
            default -> throw new IllegalArgumentException("Invalid direction char " + directionChar);
        };
        int clicks = Integer.parseInt(line.substring(1));
        return new Instruction(direction, clicks);
    }
}
