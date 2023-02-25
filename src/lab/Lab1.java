package lab;

import lib.IRandomValue;
import lib.distribution.Gaussian;

/**
 * Лабораторная 1.
 */
public class Lab1
        implements ILab {
    @Override
    public void start(int volume) {
        System.out.println("Лабораторная работа № 1");
        System.out.println("Моделирование значений, с помощью нормального закона");
        System.out.println();

        IRandomValue gaussian = new Gaussian(volume, 0.0, 1.0);
        gaussian.generateRandomValue();
        gaussian.calculate();
        gaussian.print();
    }
}
