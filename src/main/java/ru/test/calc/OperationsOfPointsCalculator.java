package ru.test.calc;

import ru.test.Operation;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class OperationsOfPointsCalculator implements Calculator {

    private final Map<String, BigDecimal> operations;

    OperationsOfPointsCalculator() {
        this.operations = new ConcurrentHashMap<>();
    }

    @Override
    public void calculate(Operation operation) {
        BigDecimal amount = operations.putIfAbsent(operation.getPointNumber(), operation.getAmount());
        if (amount != null) {
            operations.put(operation.getPointNumber(), amount.add(operation.getAmount()));
        }
    }

    @Override
    public List<String> getResult() {
        return operations.entrySet().stream()
                .sorted((o1, o2) -> -o1.getValue().compareTo(o2.getValue()))
                .map(l -> l.getKey() + Operation.DELIMITER + l.getValue())
                .collect(Collectors.toList());
    }
}
