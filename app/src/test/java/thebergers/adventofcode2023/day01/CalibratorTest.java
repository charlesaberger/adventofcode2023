package thebergers.adventofcode2023.day01;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalibratorTest {

    private final Calibrator underTest = new Calibrator();

    private static final Map<String, Integer> inputData = new LinkedHashMap<>();

    public static Stream<Arguments> calibrateLineArguments() {
        return inputData.entrySet().stream().map(entry -> arguments(entry.getKey(), entry.getValue()));
    }

    @Nested
    class Part1 {

        @BeforeAll
        public static void setupAll() {

            inputData.put("1abc2", 12);
            inputData.put("pqr3stu8vwx", 38);
            inputData.put("a1b2c3d4e5f", 15);
            inputData.put("treb7uchet", 77);

        }

        @AfterAll
        public static void tearDown() {

            inputData.clear();
        }

        @ParameterizedTest
        @MethodSource("thebergers.adventofcode2023.day01.CalibratorTest#calibrateLineArguments")
        public void calibrateLineShouldCalculateCalibrationValueForLine(String line, Integer expectedResult) {

            Integer actualResult = underTest.calibrateLine(line);

            assertEquals(expectedResult, actualResult);
        }

        @Test
        public void calibrateShouldCalculateTotalForAllInputLines() {

            List<String> input = new ArrayList<>(inputData.keySet());
            underTest.setData(input);

            int result = underTest.calibrate();

            assertEquals(142, result);
        }

    }
}
