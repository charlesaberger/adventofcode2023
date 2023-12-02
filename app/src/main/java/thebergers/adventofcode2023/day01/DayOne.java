package thebergers.adventofcode2023.day01;

import lombok.extern.slf4j.Slf4j;
import thebergers.adventofcode2023.utils.Utils;

import java.util.List;

@Slf4j
public class DayOne {
    public static void main(String[] args) {
        System.out.println("Starting...");
        try {
            String fileName = "./app/src/main/resources/input/day01/input.txt";
            List<String> dataAsStr = Utils.getDataFromFile(fileName);
            Calibrator calibrator = new Calibrator(dataAsStr);
            int resultPart1 = calibrator.calibrate();
            LOG.info("Part1: result={}", resultPart1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
