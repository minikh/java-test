package ru.test.gen;

public class GeneratorApp {

    public static void main(String[] args) {
        if (args.length != 3) {
            throw new RuntimeException("Параметров должно быть 3");
        }

        String pointsFileName = args[0];
        Long countOperations = Long.parseLong(args[1]);
        String operationsFileName = args[2];

        new GeneratorApp().start(pointsFileName, countOperations, operationsFileName);
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
