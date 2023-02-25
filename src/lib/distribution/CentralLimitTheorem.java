package lib.distribution;

import lib.RandomValue;

/**
 * Центральная предельная теорема.
 */
public class CentralLimitTheorem
        extends RandomValue {
    /**
     * Создание случайной величины.
     *
     * @param countValues количество значений случайной величины.
     */
    public CentralLimitTheorem(int countValues) {
        super(countValues);
    }

    @Override
    public void generateRandomValue() {

        for (int i = 0; i < randomValue.length; i++) {
            double z = 0.0;
            for (int j = 0; j < 12; j++) {
                z += Math.random();
            }
            z -= 6.0;
            randomValue[i] = z;
        }
    }
}
