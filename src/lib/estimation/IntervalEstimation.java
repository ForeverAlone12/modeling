package lib.estimation;

/**
 * Интервальная оценка (доверительный интервал).
 *
 */
public class IntervalEstimation
        implements IEstimation {
    /**
     * Квантиль.
     */
    protected final double QUANTILE = 1.96;

    /**
     * Левая граница.
     */
    protected double left;

    /**
     * Правая граница.
     */
    protected double right;

    /**
     * @param countValues       количество случайных величин.
     * @param standardDeviation среднеквадратическое отклонение.
     * @param expectedValue     математическое ожидание.
     */
    public IntervalEstimation(int countValues, double standardDeviation, double expectedValue) {
        double sigma = this.QUANTILE * standardDeviation / Math.sqrt(countValues);
        this.left = expectedValue - sigma;
        this.right = expectedValue + sigma;
    }

    public void print() {
        System.out.println("Доверительный интеграл : [" + this.left + "; " + this.right + "]");
    }
}
