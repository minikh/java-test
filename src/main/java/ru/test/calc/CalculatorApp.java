package ru.test.calc;

import ru.test.Operation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.stream.Stream;

public class CalculatorApp {

    public static void main(String[] args) {
        if (args.length != 3) {
            throw new  RuntimeException("Параметров должно быть 3");
        }

        String operationsFileName = args[0];
        String operationsOfDaysFileName = args[1];
        String operationsOfPointsFileName = args[2];

        LocalDateTime start = LocalDateTime.now();

        new CalculatorApp().start(operationsFileName, operationsOfDaysFileName, operationsOfPointsFileName);

        LocalDateTime end = LocalDateTime.now();
        long diffSec = start.until(end, ChronoUnit.SECONDS);
        long diffMin = start.until(end, ChronoUnit.MINUTES);
        System.out.println("time = " + diffSec + " sec");
        System.out.println("time = " + diffMin + " min");
    }

    void start(String operationsFileName, String operationsOfDaysFileName, String operationsOfPointsFileName) {
        try (Stream<String> lineStream = Files.newBufferedReader(Paths.get(operationsFileName)).lines()) {

            Calculator pointsCalculator = new OperationsOfPointsCalculator();
            Calculator daysCalculator = new OperationsOfDaysCalculator();

            lineStream
                    .map(Operation::create)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .parallel()
                    .forEach(operation -> {
                        pointsCalculator.calculate(operation);
                        daysCalculator.calculate(operation);
                    });


            Files.write(Paths.get(operationsOfDaysFileName), pointsCalculator.getResult());
            Files.write(Paths.get(operationsOfPointsFileName), daysCalculator.getResult());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("end calculated");
    }
}
