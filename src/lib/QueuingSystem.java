package org.example;

/**
 * Система массового обслуживания
 */
public abstract class QueuingSystem
{
    /**
     * Интенсивность потока заявок (λ).
     */
    protected double lambda ;

    /**
     * Интенсивность потока обслуживания.
     */
    protected double mu ;

    /**
     * Количество обслуживающих каналов.
     */
    protected int count_chanel;

    /**
     * Количество заявок в очереди.
     */
    protected int count_request;

    /**
     * Среднее число занятых каналов.
     */
    protected double avg_number_chanel;

    /**
     * Среднее число заявок в очереди.
     */
    protected double avg_number_request_queue;

    /**
     * Среднее число заявок в системе.
     */
    protected double avg_number_request_system;

    /**
     * Пропускная способность.
     */
    protected double bandwidth;

    /**
     * Среднее время нахождения заявки в очереди.
     */
    protected double avg_time_request_queue;

    /**
     * Среднее время нахождения заявки в системе.
     */
    protected double avg_time_request_system;

    /**
     * Вероятность занятости системы
     */
    protected double p_occurrence;

    /**
     * Интенсивность нагрузки.
     */
    protected double alfa;

    /**
     * Вероятность что канал свободен (доля времени простоя канала)
     */
    protected double p0;

    /**
     * Вероятность отказа.
     */
    protected double p_fail;


    public QueuingSystem(
        double lambda,
        double mu,
        int count_chanel,
        int count_request)
    {
        this.lambda = lambda;
        this.mu = mu;
        this.count_chanel = count_chanel;
        this.count_request = count_request;
        alfa = lambda / mu;
    }

    /**
     * Вычисление вероятности отсутствия заявок в системе.
     */
    abstract void calculate_p0();

    /**
     * Вычисление вероятности нахождения в системе определенного количества заявок.
     * @param index количество заявок в системе.
     * @return вероятности нахождения в системе count_request заявок.
     */
    abstract double calculate_p_i(int index);

    /**
     * Вычисление вероятности занятости системы.
     */
    abstract void calculate_p_occurrence();

    /**
     * Вычисление среднего числа занятых приборов.
     */
    abstract void calculate_avg_number_chanel();

    /**
     * Вычисление среднего числа заявок в очереди.
     */
    abstract void calculate_avg_number_request_queue();

    /**
     * Вычисление среднего числа заявок в системе.
     */
    abstract void calculate_avg_number_request_system();

    /**
     * Вычисление пропускной способности.
     */
    abstract void calculate_bandwidth();

    /**
     * Вычисление среднего времени нахождения заявки в очереди.
     */
    abstract void calculate_avg_time_request_queue();

    /**
     * Вычисление среднего времени нахождения заявки в системе.
     */
    abstract void calculate_avg_time_request_system();

    /**
     * Вычисление вероятности отказа.
     */
    abstract void calculate_p_fail();

    public void calculate(){
        calculate_p0();
        calculate_p_fail();
        calculate_p_occurrence();
        calculate_avg_number_chanel();
        calculate_avg_number_request_queue();
        calculate_avg_number_request_system();
        calculate_bandwidth();
        calculate_avg_time_request_queue();
        calculate_avg_time_request_system();
    }

    public void printParams(){
        printInputData();

        System.out.println("Вычесленные показатели эффективности:");
        print("alfa" , alfa);
        System.out.print("Вероятности P[k]: ");
        System.out.printf("P[0] = %f \t", p0);
        for (int i=1; i<= count_chanel; i++){
            System.out.printf("P[%d] = %f \t", i, calculate_p_i(i));
        }
        System.out.println();
        print("Вероятность отказа (P_отк)" , p_fail);

        print("среднее число занятых каналов (n_)" , avg_number_chanel);
        print("Среднее число заявок в очереди (m_)" , avg_number_request_queue);
        print("Вероятность занятости системы (N_)" , avg_number_request_system);
        print("Вероятность занятости системы (P_оч)" , p_occurrence);
        print("Пропускная способность (Q)" , bandwidth);
        print("Среднее время нахождения заявки в очереди (t_оч)" , avg_time_request_queue);
        print("Среднее время нахождения заявки в системе (t_с)" , avg_time_request_system);
    }

    private void print(String name, double value)
    {
        System.out.printf("%s \t= %f\n\r", name, value);
    }

    private void print(String name, int value)
    {
        if (value != 0)
            System.out.printf("%s \t= %d\n\r", name, value);
    }

    private void printInputData()
    {
        System.out.println("Для входных данных:");
        print("Интенсивности входного потока (λ)", lambda);
        print("Интенсивности потока обслуживания (μ)", mu);
        print("Количество обслуживающих каналов (n)", count_chanel);
        print("Интенсивности входного потока (m)", count_request);
        System.out.println();
    }

    protected int factorial(int number) {
        if (number <= 2) {
            return number;
        }
        return number * factorial(number - 1);
    }
}
