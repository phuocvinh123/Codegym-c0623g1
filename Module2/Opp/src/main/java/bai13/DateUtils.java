package bai13;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static LocalDate parseDate(String strDate) {
        LocalDate date = LocalDate.parse(strDate, formatter);
        return date;
    }
}
