package common;

import java.time.LocalDate;
import java.time.Period;

public class HelperFunctions {

    public static int calculateAge(String dateOfBirth){
        LocalDate birthDate = LocalDate.parse(dateOfBirth);
        LocalDate currentDate = LocalDate.now();
       int age = Period.between(birthDate, currentDate).getYears();

        return age;
    }
}
