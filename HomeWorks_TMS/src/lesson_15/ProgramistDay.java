package lesson_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class ProgramistDay {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the year to know the Programmer-Day date of this year:");
        LocalDate day = LocalDate.ofYearDay(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()), 256);
        System.out.printf("The Programmer-Day date of %d year is %d %s.", day.getYear(), day.getDayOfMonth(), day.getMonth());
        System.in.close();
    }
}
