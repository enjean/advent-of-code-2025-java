package enjean.advent2025.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ParseUtils {
    public static List<String> readLinesFromFile(int day) {
        String adventInputDirectory = System.getenv("ADVENT_INPUT_DIR");
        String fileName = adventInputDirectory + "/2025/" + day + "/input.txt";
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
