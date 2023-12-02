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

    @Nested
    class Part2 {
        @BeforeAll
        public static void setupAll() {

            inputData.put("two1nine,219", 29);
            inputData.put("eightwothree,823", 83);
            inputData.put("abcone2threexyz,123", 13);
            inputData.put("xtwone3four,2134", 24);
            inputData.put("4nineeightseven2,49872", 42);
            inputData.put("zoneight234,18234", 14);
            inputData.put("7pqrstsixteen,76", 76);
            inputData.put("oneight,18", 18);
            inputData.put("twone,21", 21);
            inputData.put("threeight,38", 38);
            inputData.put("fiveight,58", 58);
            inputData.put("sevenine,79", 79);
            inputData.put("eightwo,82", 82);
            inputData.put("eightwone,821", 81);
            inputData.put("eighthree,83", 83);
            inputData.put("nineight,98", 98);
            inputData.put("sevenineight,798", 78);
            inputData.put("twoneighthreeight,21838", 28);
        }
        @AfterAll
        public static void tearDown() {

            inputData.clear();
        }

        @ParameterizedTest
        @MethodSource("thebergers.adventofcode2023.day01.CalibratorTest#calibrateLineArguments")
        public void calibrateLineShouldCalculateCalibrationValueForLine(String input, Integer expectedResult) {

            String[] data = input.split(",");
            String line = data[0];
            String expectedConversion = data[1];
            Integer actualResult = underTest.calibrateLine(line);

            assertEquals(expectedConversion, underTest.getConversion());
            assertEquals(expectedResult, actualResult);
        }
        @Test
        public void calibrateShouldCalculateTotalForAllInputLines() {

            List<String> input = new ArrayList<>(inputData.keySet());
            underTest.setData(input);

            int result = underTest.calibrate();

            assertEquals(945, result);
        }

    }
}
