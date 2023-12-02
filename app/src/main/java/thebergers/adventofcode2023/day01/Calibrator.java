package thebergers.adventofcode2023.day01;

import lombok.AccessLevel;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Calibrator {

    @Setter
    private List<String> data = new LinkedList<>();

    Calibrator() {

    }

    Calibrator(List<String> data) {
        this.data = data;
    }
    Integer calibrateLine(String line) {

        String noChars = line.replaceAll("[A-Za-z]", "");
        return Integer.parseInt("%s%s".formatted(noChars.substring(0, 1), noChars.substring(noChars.length() - 1)));
    }

    public int calibrate() {
        //return data.stream().map(this::calibrateLine).mapToInt(Integer::parseInt).sum();
        return data.stream().mapToInt(this::calibrateLine).sum();
    }
}
