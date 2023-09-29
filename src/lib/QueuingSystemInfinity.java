package org.example;

public class QueuingSystemInfinity
extends QueuingSystem
{

    public QueuingSystemInfinity(double lambda,
        double mu,
        int count_chanel,
        int count_request)
    {
        super(lambda, mu, count_chanel, count_request);
    }

    @Override
    void calculate_p0()
    {
        double fractional1 = 0;
        for (int i = 1; i <= count_chanel+1; i++)
            fractional1 += Math.pow(alfa, i) / factorial(i);


        double fractional2 = Math.pow(alfa, count_chanel+1)
            / (factorial(count_chanel) * (count_chanel - alfa));

        p0 = Math.pow(1 + fractional1 + fractional2, -1);
    }

    @Override
    double calculate_p_i(int index)
    {
        if (index <= count_chanel)
        {
            return Math.pow(alfa, index) * p0 /factorial(index);
        }
        else
        {
            return 2;
        }
    }

    @Override
    void calculate_p_occurrence()
    {
        p_occurrence = p0;
        for (int i=1;i<=count_chanel;i++)
            p_occurrence+=calculate_p_i(i);
        p_occurrence=1-p_occurrence;
    }

    @Override
    void calculate_avg_number_chanel()
    {
        avg_number_chanel = alfa;
    }

    @Override
    void calculate_avg_number_request_queue()
    {
        avg_number_request_queue = (alfa * p_occurrence) / (count_chanel - alfa);
    }

    @Override
    void calculate_avg_number_request_system()
    {
        avg_number_request_system = avg_number_chanel + avg_number_request_queue;
    }

    @Override
    void calculate_bandwidth()
    {
        bandwidth = lambda;
    }

    @Override
    void calculate_avg_time_request_queue()
    {
        avg_time_request_queue = avg_number_request_queue / lambda;
    }

    @Override
    void calculate_avg_time_request_system()
    {
        avg_time_request_system = avg_number_request_system / lambda;
    }

    @Override
    void calculate_p_fail() {

    }
}
