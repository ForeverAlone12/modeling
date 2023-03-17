import lab.ILab;
import lab.Lab1;
import lab.Lab2;
import lab.Lab3;
import lib.RandomValue;
import lib.distribution.Gaussian;

public class Main {

    /**
     * Количество значений случайной величины.
     */
    private final static int VOLUME = 100000;
    public static void main(String[] args) {

        ILab lab = new Lab3();
        lab.start(VOLUME);
    }
}