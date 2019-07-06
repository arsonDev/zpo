
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalDate startIIWar = LocalDate.of(1939, 9, 1);
        LocalDate endIIwar = LocalDate.of(1945, 5, 8);

        System.out.println("Rozpoczenie II wojny swiatowej :" + startIIWar);
        System.out.println("Zakonczenie II wojny swiatowej :" + endIIwar);

        System.out.println("II wojna swiatowa trwala: " + ChronoUnit.DAYS.between(startIIWar, endIIwar) + " dni");

        LocalDate startDay = LocalDate.of(2016, 1, 1);
        System.out.println("68-my dzien 2016 roku to " + startDay.plusDays(67));

        LocalDate birthDay = LocalDate.of(1995, Month.AUGUST, 31);
        LocalDate localDate = birthDay;
        int count = 0;
        while (localDate.isBefore(LocalDate.now())) {
            localDate = localDate.plusDays(1);
            if (localDate.toString().contains("-02-29")) {
                count++;
            }
        }
        System.out.println("29 lutego przeżyłem" + count + " razy.");
    }
}
