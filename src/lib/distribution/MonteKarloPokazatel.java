package lib.distribution;

import lib.RandomValue;

public class MonteKarloPokazatel
extends RandomValue {

    private double lambda;
    private double start;
    private double end;

    /**
     * Создание случайной величины.
     *
     * @param countValues количество значений случайной величины.
     */
    public MonteKarloPokazatel(int countValues, double lambda, double start, double end) {
        super(countValues);
        this.lambda = lambda;
        this.start = start;
        this.end = end;
    }

    @Override
    public void generateRandomValue() {
        for (int i = 0; i < randomValue.length; i++) {
            randomValue[i] = 3.0 * Math.random() + 1.0;
        }
    }

    @Override
    public void calculateExpectedValue() {
        for (int i = 0; i < this.randomValue.length; i++) {
            expectedValue +=  3.0 * randomValue[i] * randomValue[i] * Math.exp(-1.0 * lambda * randomValue[i]);
        }
        this.expectedValue /= this.randomValue.length;
    }
}
