package lib.distribution;

import lib.RandomValue;

/**
 * Нормальное распределение.
 */
public class Gaussian
        extends RandomValue {

    /**
     * Минимальное значение.
     */
    protected double min;

    /**
     * Максимальное значение.
     */
    protected double max;

    public Gaussian(int countValues, double min, double max) {
        super(countValues);
        this.min = min;
        this.max = max;
    }

    @Override
    public void generateRandomValue() {
        for (int i = 0; i < randomValue.length; i++) {
            randomValue[i] = this.min + (this.max - this.min) * Math.random();
        }
    }
}
