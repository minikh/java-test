package ru.test.calc;

import ru.test.Operation;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperationsOfDaysCalculator implements Calculator {

    private Map<String, BigDecimal> operations;

    OperationsOfDaysCalculator() {
        operations = new HashMap<>();
    }

    @Override
    public void calculate(Operation operation) {
        BigDecimal amount = operations.putIfAbsent(operation.date(), operation.getAmount());
        if (amount != null) {
            operations.put(operation.date(), amount.add(operation.getAmount()));
        }
    }

    @Override
    public List<String> getResult() {
        return operations.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(l -> l.getKey() + Operation.DELIMITER + l.getValue())
                .collect(Collectors.toList());
    }
}
