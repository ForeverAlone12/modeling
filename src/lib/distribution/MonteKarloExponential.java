package lib.distribution;

import lib.RandomValue;

public class MonteKarloExponential
extends RandomValue {

    private double lambda;
    private double start;
    private double end;

    /**
     * Создание случайной величины.
     *
     * @param countValues количество значений случайной величины.
     */
    public MonteKarloExponential(int countValues, double lambda, double start, double end) {
        super(countValues);
        this.lambda = lambda;
        this.start = start;
        this.end = end;
    }

    @Override
    public void generateRandomValue() {
        for (int i = 0; i < randomValue.length; i++) {
            randomValue[i] = -1.0 * Math.log(Math.random()) / lambda;
        }
    }

    @Override
    public void calculateExpectedValue() {
        for (int i = 0; i < this.randomValue.length; i++) {
            if (this.randomValue[i] < end && this.randomValue[i] > start )
                this.expectedValue += this.randomValue[i] * this.randomValue[i] / lambda;
        }
        this.expectedValue /= this.randomValue.length;
    }
}
