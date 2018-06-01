package ru.test.gen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PointsLoader {
    private List<String> points;
    private Random random;
    private final String fileName;

    PointsLoader(String fileName) {
        this.fileName = fileName;
        random = new Random();
    }

    void load() {
        Path pointsPath = Paths.get(fileName);
        try (Stream<String> lineStream = Files.newBufferedReader(pointsPath).lines()) {

            points = lineStream
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String getAnyPoint() {
        if (points.size() == 0) {
            throw new RuntimeException("Нет точек продаж");
        }

        int anInt = random.nextInt(points.size());
        return points.get(anInt);
    }
}
