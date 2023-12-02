package thebergers.adventofcode2023.day01;

import com.google.common.annotations.VisibleForTesting;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Slf4j
public class Calibrator {

    @Setter
    private List<String> data = new LinkedList<>();

    @Getter(value = AccessLevel.PACKAGE, onMethod_ = @VisibleForTesting)
    private String conversion;

    private final Map<String, String> wordConversions = new HashMap<>();

    Calibrator() {
        loadWordConversions();
    }

    Calibrator(List<String> data) {
        this();
        this.data = data;
    }

    private void loadWordConversions() {
        wordConversions.put("one", "o1e");
        wordConversions.put("two", "t2o");
        wordConversions.put("three", "t3e");
        wordConversions.put("four", "4");
        wordConversions.put("five", "5e");
        wordConversions.put("six", "6");
        wordConversions.put("seven", "s7n");
        wordConversions.put("eight", "e8t");
        wordConversions.put("nine", "n9e");
    }

    Integer calibrateLine(String line) {

        String wordsToDigits = convertWordsToDigits(line);
        conversion = wordsToDigits.replaceAll("[A-Za-z]", "");
        String answer = "%s%s".formatted(conversion.substring(0, 1), conversion.substring(conversion.length() - 1));
        LOG.debug("input={}, converted={} result={}, answer={}", line, wordsToDigits, conversion, answer);
        return Integer.parseInt(answer);
    }

    private String convertWordsToDigits(String line) {
        String output = line;
        for (Map.Entry<String, String> conversion : wordConversions.entrySet()) {
            output = output.replaceAll(conversion.getKey(), conversion.getValue());
        }
        LOG.debug("input={},output={}", line, output);
        return output;
    }

    public int calibrate() {
        return data.stream().mapToInt(this::calibrateLine).sum();
    }
}
