package lib;

/**
 * Случайное значение.
 */
public interface IRandomValue {

    /**
     * Генерация последовательности случайных чисел.
     */
    void generateRandomValue();


    /**
     * Вычисление значений.
     */
    void calculate();

    /**
     * Вычисление математического ожидания.
     */
    void calculateExpectedValue();

    /**
     * Вычисление дисперсии.
     */
    void calculateVariance();

    /**
     * Вычисление среднеквадратического отклонения.
     */
    void calculateStandardDeviation();

    /**
     * Вывод данных.
     */
    void print();

    double[] getRandomValues();
}
