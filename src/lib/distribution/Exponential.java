package lib.distribution;

import lib.IRandomValue;
import lib.RandomValue;

/**
 * Показательный закон.
 */
public class Exponential
        extends RandomValue {

    /**
     * Математическое ожидание
     */
    protected double expectedValue;

    /**
     * Среднеквадратичное отклонение.
     */
    protected double standardDeviation;

    protected IRandomValue z;

    public Exponential(
            int countValues,
            double expectedValue,
            double standardDeviation) {
        super(countValues);
        this.expectedValue = expectedValue;
        this.standardDeviation = standardDeviation;


        z = new CentralLimitTheorem(countValues);
        z.generateRandomValue();
        z.calculate();
        System.out.println("Данные для Z");
        z.print();
        System.out.println();
    }

    @Override
    public void generateRandomValue() {
        double[] zi = z.getRandomValues();
        for (int i = 0; i < randomValue.length; i++) {
            randomValue[i] = expectedValue + standardDeviation * zi[i];
        }
    }

}
