package ru.test.gen;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class GeneratorApp {

    public static void main(String[] args) {
        if (args.length != 3) {
            throw new RuntimeException("Параметров должно быть 3");
        }

        String pointsFileName = args[0];
        Long countOperations = Long.parseLong(args[1].replace("_", ""));
        String operationsFileName = args[2];

        LocalDateTime start = LocalDateTime.now();

        new GeneratorApp().start(pointsFileName, countOperations, operationsFileName);

        LocalDateTime end = LocalDateTime.now();
        long diffSec = start.until(end, ChronoUnit.SECONDS);
        long diffMin = start.until(end, ChronoUnit.MINUTES);
        System.out.println("time = " + diffSec + " sec");
        System.out.println("time = " + diffMin + " min");
    }

    private void start(String pointsFileName, Long countOperations, String operationsFileName) {

        AmountGenerator amountGenerator = new AmountGenerator(10_000, 100_000);
        TimeGenerator timeGenerator = new TimeGenerator();
        PointsLoader pointsLoader = new PointsLoader(pointsFileName);
        pointsLoader.load();

        OperationsGenerator operationsGenerator =
                new OperationsGenerator(operationsFileName, amountGenerator, timeGenerator, pointsLoader);
        operationsGenerator.generate(countOperations);

        System.out.println("end generated");
    }
}
