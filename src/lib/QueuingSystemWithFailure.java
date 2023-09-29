package org.example;

public class QueuingSystemWithFailure
extends QueuingSystem{

    public QueuingSystemWithFailure(
            double lambda,
            double mu,
            int count_chanel,
            int count_request)
    {
        super(lambda, mu, count_chanel, count_request);
    }


    @Override
    void calculate_p0() {
        double summa = 0;

        for (int i = 1; i <= count_chanel; i++)
            summa += Math.pow(alfa, i) / factorial(i);

        p0 = Math.pow(1 + summa, -1);
    }

    @Override
    double calculate_p_i(int index) {
        return Math.pow(alfa, index) * p0 / factorial(index);
    }

    @Override
    void calculate_p_occurrence()
    {

    }

    @Override
    void calculate_avg_number_chanel() {
        avg_number_chanel = alfa * (1 - p_fail);
    }

    @Override
    void calculate_avg_number_request_queue() {

    }

    @Override
    void calculate_avg_number_request_system() {

    }

    @Override
    void calculate_bandwidth() {
        bandwidth = lambda * (1 - p_fail);
    }

    @Override
    void calculate_avg_time_request_queue() {

    }

    @Override
    void calculate_avg_time_request_system() {
        avg_time_request_system = avg_number_chanel / lambda;
    }

    @Override
    void calculate_p_fail() {
        p_fail =calculate_p_i(count_chanel);
    }
}
