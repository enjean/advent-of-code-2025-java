package enjean.advent2025.day05;

import java.util.ArrayList;
import java.util.List;

public class CafeteriaData {
    record Range(
        long low,
        long high
    ) {
    }

    private final List<Range> freshIngredientRanges = new ArrayList<>();
    private final List<Long> availableIngredients = new ArrayList<>();

    public void addFreshIngredientRange(long low, long high) {
        freshIngredientRanges.add(new Range(low, high));
    }

    public void addAvailableIngredient(long ingredient) {
        availableIngredients.add(ingredient);
    }

    public long countFreshIngredients() {
        return availableIngredients.stream()
            .filter(this::isFresh)
            .count();
    }

    private boolean isFresh(long ingredient) {
        for (Range range : freshIngredientRanges) {
            if (ingredient >= range.low && ingredient <= range.high) {
                return true;
            }
        }
        return false;
    }
}
