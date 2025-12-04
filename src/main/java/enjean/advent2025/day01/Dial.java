package enjean.advent2025.day01;

public class Dial {
    private static final int SIZE = 100;

    private int position;

    public Dial(int initialPosition) {
        this.position = initialPosition;
    }

    public int getPosition() {
        return position;
    }

    public int rotate(Instruction instruction) {
        int numRotations = instruction.clicks() / SIZE;
        int remainder = instruction.clicks() % SIZE;

        int newPosition = switch (instruction.direction()) {
            case LEFT -> position - remainder;
            case RIGHT -> position + remainder;
        };

        int numTimesPassing0 = numRotations;
        if ((position != 0 && newPosition < 0) || newPosition > 100) {
            numTimesPassing0++;
        }

        position = (newPosition + SIZE) % SIZE;
        return numTimesPassing0;
    }
}
