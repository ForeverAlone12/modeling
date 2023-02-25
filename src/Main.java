import lab.ILab;
import lab.Lab1;
import lab.Lab2;
import lib.RandomValue;
import lib.distribution.Gaussian;

public class Main {

    /**
     * Количество значений случайной величины.
     */
    private final static int VOLUME = 10000;
    public static void main(String[] args) {

        ILab lab1 = new Lab2();
        lab1.start(VOLUME);
    }
}