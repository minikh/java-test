package ru.test.gen;

import java.math.BigDecimal;
import java.util.Random;

class AmountGenerator {
    private Random rand = new Random();
    private final float min;
    private final float max;

    AmountGenerator(float min, float max) {
        this.min = min;
        this.max = max;
    }

    BigDecimal next() {
        return new BigDecimal(rand.nextFloat() * (max - min) + min);
    }
}
