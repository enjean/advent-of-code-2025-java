package enjean.advent2025.day04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    @Test
    void testCountNeighbors() {
        Grid grid = new Grid(10, 10);
        Arrays.asList(2, 3, 5, 6, 7, 8).forEach(c -> grid.setRollPresent(0, c));
        Arrays.asList(0, 1, 2, 4, 6, 8, 9).forEach(c -> grid.setRollPresent(1, c));
        Arrays.asList(0, 1, 2, 3, 4, 6, 8, 9).forEach(c -> grid.setRollPresent(2, c));
        Arrays.asList(0, 2, 3, 4, 5, 8).forEach(c -> grid.setRollPresent(3, c));
        Arrays.asList(0, 1, 3, 4, 5, 6, 8, 9).forEach(c -> grid.setRollPresent(4, c));
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9).forEach(c -> grid.setRollPresent(5, c));
        Arrays.asList(1, 3, 5, 7, 8, 9).forEach(c -> grid.setRollPresent(6, c));
        Arrays.asList(0, 2, 3, 4, 6, 7, 8, 9).forEach(c -> grid.setRollPresent(7, c));
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8).forEach(c -> grid.setRollPresent(8, c));
        Arrays.asList(0, 2, 4, 5, 6, 8).forEach(c -> grid.setRollPresent(9, c));

        assertEquals(6, grid.countNeighbors(1, 1));
        assertEquals(7, grid.countNeighbors(2, 1));
        assertEquals(2, grid.countNeighbors(0, 0));
        assertEquals(3, grid.countNeighbors(0, 9));
        assertEquals(1, grid.countNeighbors(9, 0));
        assertEquals(2, grid.countNeighbors(9, 9));
    }
}