package enjean.advent2025.day02;

import java.util.regex.Pattern;

public class Part2IdValidator extends IdValidator {
    @Override
    protected Pattern getPattern(String possiblePattern) {
        return Pattern.compile("^(" + possiblePattern + ")+$");
    }
}
