package lab;

import lib.IRandomValue;
import lib.distribution.CentralLimitTheorem;
import lib.distribution.Exponential;

public class Lab2
implements ILab{
    @Override
    public void start(int volume) {
        System.out.println("Лабораторная работа № 2");
        System.out.println("Моделирование значений, с помощью показательного закона");
        System.out.println();

        IRandomValue exponential = new Exponential(volume, 1.0, 0.5);
        exponential.generateRandomValue();
        exponential.calculate();
        System.out.println("Данные для random");
        exponential.print();
    }
}