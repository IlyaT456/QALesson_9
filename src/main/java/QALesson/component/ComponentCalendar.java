package QALesson.component;

import QALesson.pages.RegistrationPage;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ComponentCalendar {

    public void setDate(String birthDate) {
        String arrayBirthDate[] = birthDate.split(" ");

        // Выбор даты месяц
        $(".react-datepicker__month-select").selectOption(Integer.parseInt(arrayBirthDate[1]));
        // Выбор даты год
        $(".react-datepicker__year-select").selectOption(arrayBirthDate[2]);
        // Выбор даты дата
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text(arrayBirthDate[0])).click();
    }

    public String changeFormatDate(String birthDate) {
        String arrayBirthDate[] = birthDate.split(" ");
        String[] arr = birthDate.split(" ");
        GregorianCalendar cannes = new GregorianCalendar(Integer.parseInt(arr[2]),Integer.parseInt(arr[1]), Integer.parseInt(arr[0]));
        SimpleDateFormat df = new SimpleDateFormat("dd MMMM,yyyy", Locale.ENGLISH);
        birthDate = df.format(cannes.getTime());
        return birthDate;
    }

}
