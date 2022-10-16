package QALesson;

import QALesson.component.ComponentCalendar;
import QALesson.component.ComponentResultForm;
import QALesson.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class RegistrationPageTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ComponentResultForm componentResultForm = new ComponentResultForm();
    ComponentCalendar componentCalendar = new ComponentCalendar();

    @Test
    public void testForm() {

        registrationPage.openPage()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setEmall(email)
                .setBirthDate(birthDate)
                .setSex("Male")
                .setUserNumber(phone)
                .subjectsInput("English")
                .uploadPicture("src/test/resources/cat.jpg")
                .setHobby("Music")
                .setCurrentAddress(currentAddress)
                .setState("NCR")
                .setСity("Delhi")
                .submit();

        componentResultForm.checkTable()
                .checkResult("Student Name", firstname + " " + lastname)
                .checkResult("Student Email", email)
                .checkResult("Gender", "Male")
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", componentCalendar.changeFormatDate(birthDate))
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "cat.jpg")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", "NCR Delhi");
    }
}
