package enjean.advent2025.day05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CafeteriaData {
    record Range(
        long low,
        long high
    ) {
        boolean isInRange(long value) {
            return value >= low && value <= high;
        }
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

    public long countAllFreshIngredients() {
        List<Range> rangesSorted = new ArrayList<>(freshIngredientRanges);
        rangesSorted.sort(Comparator.comparing(Range::low));

        List<Range> combinedRanges = new LinkedList<>();
        Range activeRange = rangesSorted.getFirst();
        for (int i = 1; i < rangesSorted.size(); i++) {
            Range rangeToAdd = rangesSorted.get(i);
            if (activeRange.isInRange(rangeToAdd.low)) {
                if (!activeRange.isInRange(rangeToAdd.high)) {
                    activeRange = new Range(activeRange.low, rangeToAdd.high);
                }
            } else {
                combinedRanges.add(activeRange);
                activeRange = rangeToAdd;
            }
        }
        combinedRanges.add(activeRange);

        return combinedRanges.stream()
            .mapToLong(r -> r.high - r.low + 1)
            .sum();
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
