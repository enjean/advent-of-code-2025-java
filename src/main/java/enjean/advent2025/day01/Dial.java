package enjean.advent2025.day01;

public class Dial {
    private int position;

    public Dial(int initialPosition) {
        this.position = initialPosition;
    }

    public int getPosition() {
        return position;
    }

    public void rotate(Direction direction, int clicks) {
        position = switch (direction) {
            case RIGHT -> (position + (clicks % 100)) % 100;
            case LEFT -> (position - (clicks % 100) + 100) % 100;
        };
    }
}
