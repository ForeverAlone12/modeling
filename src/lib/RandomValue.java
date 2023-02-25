package lib;

import lib.estimation.IntervalEstimation;
import lib.estimation.PointEstimation;

/**
 * Случайное число.
 */
public class RandomValue
        implements IRandomValue {

    /**
     * Точечная оценка.
     */
    protected PointEstimation pointEstimation;

    /**
     * Интервальная оценка.
     */
    protected IntervalEstimation intervalEstimation;

    /**
     * Математическое ожидание
     */
    protected double expectedValue;

    /**
     * Дисперсия.
     */
    protected double variance;

    /**
     * Среднеквадратичное отклонение.
     */
    protected double standardDeviation;

    /**
     * Значения случайных чисел.
     */
    protected double[] randomValue;

    /**
     * Создание случайной величины.
     *
     * @param countValues количество значений случайной величины.
     */
    public RandomValue(int countValues) {
        this.expectedValue = 0.0;
        this.variance = 0.0;
        this.standardDeviation = 0.0;
        this.randomValue = new double[countValues];
    }

    @Override
    public void generateRandomValue() {
        for (int i = 0; i < this.randomValue.length; i++)
            this.randomValue[i] = Math.random();
    }

    @Override
    public void calculate() {
        calculateExpectedValue();
        calculateVariance();
        calculateStandardDeviation();
        this.intervalEstimation = new IntervalEstimation(this.randomValue.length, this.standardDeviation, this.expectedValue);
    }

    @Override
    public void calculateExpectedValue() {
        for (int i = 0; i < this.randomValue.length; i++) {
            this.expectedValue += this.randomValue[i];
        }
        this.expectedValue /= this.randomValue.length;
    }

    @Override
    public void calculateVariance() {
        for (int i = 0; i < this.randomValue.length; i++) {
            this.variance += this.randomValue[i] * this.randomValue[i];
        }
        this.variance -= this.randomValue.length * this.expectedValue * this.expectedValue;
        this.variance /= (this.randomValue.length - 1);
    }

    @Override
    public void calculateStandardDeviation() {
        this.standardDeviation = Math.sqrt(this.variance);
    }

    @Override
    public void print() {
        System.out.println("Математическое ожидание: " + this.expectedValue);
        System.out.println("Дисперсия: " + this.variance);
        System.out.println("Среднеквадратьичное отклонение: " + this.standardDeviation);
        System.out.println();
        intervalEstimation.print();
    }

    @Override
    public double[] getRandomValues() {
        return this.randomValue;
    }

}
