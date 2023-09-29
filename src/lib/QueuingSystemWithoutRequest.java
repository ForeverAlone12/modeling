package org.example;

public class QueuingSystemWithoutRequest
extends QueuingSystem {

    public QueuingSystemWithoutRequest(
        double lambda,
        double mu,
        int count_chanel,
        int count_request)
    {
        super(lambda, mu, count_chanel, count_request);
    }

    @Override
    void calculate_p0() {
        double summa1 = 0.0;
        for (int i=1; i< count_chanel; i++){
            summa1 += Math.pow(alfa, i)/factorial(i);
        }

        double summa2 = 0.0;
        for (int i=1; i< count_request; i++){
            summa2 += Math.pow(alfa/count_chanel, i);
        }

        summa2 *=  Math.pow(alfa, count_chanel) / factorial(count_chanel);

        p0= Math.pow(1+summa1+summa2, -1);
    }

    @Override
    double calculate_p_i(int count_request) {
        return 0;
    }

    @Override
    void calculate_p_occurrence() {

    }

    @Override
    void calculate_avg_number_chanel() {
        avg_number_chanel = alfa * (1 - p_occurrence);
    }

    @Override
    void calculate_avg_number_request_queue() {
        double summ = 0.0;
        double p = 0.0;

        for (int i=1; i< count_request; i++)
        {
            p = (Math.pow(alfa, count_chanel)/factorial(count_chanel)) * Math.pow(alfa / count_chanel, i) * p0;
            summ += i * p;
        }
    }

    @Override
    void calculate_avg_number_request_system() {
        avg_number_request_system = avg_number_chanel + avg_number_request_queue;
    }

    @Override
    void calculate_bandwidth() {
        bandwidth = count_request * avg_number_chanel;
    }

    @Override
    void calculate_avg_time_request_queue() {
        avg_time_request_queue = avg_number_request_queue / lambda;
    }

    @Override
    void calculate_avg_time_request_system() {
        avg_time_request_system = avg_number_request_system / lambda;
    }

    @Override
    void calculate_p_fail() {
        p_fail = calculate_p_i(count_chanel+count_request);
    }
}
