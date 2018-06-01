package ru.test.calc;

import ru.test.Operation;

import java.util.List;

public interface Calculator {
    void calculate(Operation operation);
    List<String> getResult();
}
