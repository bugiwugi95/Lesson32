package Task6;

import java.io.IOException;
import java.time.LocalDate;

public class Task6 {
    //Реализуйте класс DatePeriod, в котором будет две LocalDate.
    // Переделайте анализатор курса валют, что б он на вход принимал DatePeriod

    public static void main(String[] args) throws IOException {
        LocalDate now = LocalDate.of(2024, 1, 1);
        LocalDate date = LocalDate.now();
        DatePeriod datePeriod = new DatePeriod(now, date);

    }
}
