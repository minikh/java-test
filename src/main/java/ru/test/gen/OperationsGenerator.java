package ru.test.gen;

import ru.test.Operation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class OperationsGenerator {

    private final String operationsFileName;
    private final AmountGenerator amountGenerator;
    private final TimeGenerator timeGenerator;
    private final PointsLoader pointsLoader;

    OperationsGenerator(String operationsFileName,
                        AmountGenerator amountGenerator,
                        TimeGenerator timeGenerator, PointsLoader pointsLoader) {
        this.operationsFileName = operationsFileName;

        this.amountGenerator = amountGenerator;
        this.timeGenerator = timeGenerator;
        this.pointsLoader = pointsLoader;
    }

    void generate(Long countOperations) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(operationsFileName))) {
            for (long operationNumber = 0; operationNumber < countOperations; operationNumber++) {
                Operation operation = Operation.builder()
                        .date(timeGenerator.generate())
                        .pointNumber(pointsLoader.getAnyPoint())
                        .number(operationNumber)
                        .amount(amountGenerator.next())
                        .build();

                bufferedWriter.write(operation.print());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
