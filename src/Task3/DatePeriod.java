package Task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;

public class DatePeriod {
    LocalDate date1;
    LocalDate date2;


    DatePeriod(LocalDate date1, LocalDate date2) throws IOException {
        this.date1 = date1;
        this.date2 = date2;
        getApiBank(date1, date2);

    }

    private static void getApiBank(LocalDate date1, LocalDate date2) throws IOException {
        while (date1.isBefore(date2)) {
            String day = withZone(date1.getDayOfMonth());
            String mon = withZone(date1.getMonthValue());
            String year = String.valueOf(date1.getYear());
            String date = day + "/" + mon + "/" + year;
            String page = downloadWebPage("https://cbr.ru/scripts/XML_dynamic.asp?date_req1=" + date + "&date_req2=" + date + "&VAL_NM_RQ=R01235");
            int starIndex = page.lastIndexOf("<Value>");
            if (starIndex != -1) {
                int endIndex = page.lastIndexOf("</Value>");
                String str = page.substring(starIndex + 7, endIndex);
                System.out.println(date1 + ": " + str);
            }
            date1 = date1.plusDays(1);
        }
    }


    private static String withZone(int value) {
        if (value < 10) {
            return "0" + value;
        } else {
            return String.valueOf(value);
        }
    }


    private static String downloadWebPage(String url) throws IOException {

        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();


        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            while ((line = br.readLine()) != null) {
                result.append(line);
            }

        }

        return result.toString();

    }


}
