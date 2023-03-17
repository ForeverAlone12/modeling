package lab;

import lib.IRandomValue;
import lib.distribution.MonteKarloExponential;
import lib.distribution.MonteKarloPokazatel;

public class Lab3
implements ILab
{
    @Override
    public void start(int volume) {
        System.out.println("Лабораторная работа № 3");
        System.out.println("Вычисление интегралов методом Монте-Карло");
        System.out.println();

        double lambda = 1.5;
        double a = 1.0;
        double b = 4.0;

        double Fb = integral1(b, lambda);
        double Fa = integral1(a, lambda);

        System.out.println("F(b) = " + Fb);
        System.out.println("F(a) = " + Fa);
        System.out.println("F(b) - F(a) = " + (Fb - Fa));
        System.out.println();

        System.out.println("Метод Монте-Карло");


        double randomValue = 0.0;
        double summa = 0.0;
        for (int i = 0; i < volume; i++)
        {
            randomValue = -1.0 * Math.log(Math.random()) / lambda;
            if (randomValue < b && randomValue > a)
                summa += randomValue * randomValue / lambda;
        }

        System.out.println("Значение методом Монте-Карло (экспоненциальный закон) = " + summa/volume);

        randomValue = 0.0;
        summa = 0.0;
        for (int i = 0; i < volume; i++)
        {
            randomValue = 3.0 * Math.random() + 1.0;
            summa +=  3.0 * randomValue * randomValue * Math.exp(-1.0 * lambda * randomValue);
        }

        System.out.println("Значение методом Монте-Карло (показательный закон)  = " + summa/volume);
        System.out.println();

        System.out.println("Расчёты из библиотек");
        IRandomValue monteKarloExponential = new MonteKarloExponential(volume, lambda, a, b);
        monteKarloExponential.generateRandomValue();
        monteKarloExponential.calculate();
        System.out.println("Метод Монте-Карло (экспоненциальный закон)");
        monteKarloExponential.print();
        System.out.println();

        IRandomValue monteKarloPokazatel = new MonteKarloPokazatel(volume, lambda, a, b);
        monteKarloPokazatel.generateRandomValue();
        monteKarloPokazatel.calculate();
        System.out.println("Метод Монте-Карло (показательный закон)");
        monteKarloPokazatel.print();
        System.out.println();
    }

    double integral1(double x, double lambda)
    {
        return -1.0 * Math.exp(-1.0 * lambda * x) * ((x * x / lambda) + ( 2.0 * x / (lambda * lambda)) + (2.0 / (lambda * lambda * lambda)) );
    }

    double integral2(double x, double lambda)
    {
        return -1.0 * Math.exp(-1.0 * lambda * x) * (lambda * Math.sin(x) + Math.cos(x)) / (lambda * lambda + 1);
    }

    double integral3(double x, double lambda)
    {
        return Math.exp(-1.0 * lambda * x) * (lambda * Math.sin(x) - Math.cos(x)) / (lambda * lambda + 1);
    }
}