package QALesson;

import QALesson.component.ComponentResultForm;
import QALesson.pages.RegistrationPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageTests {
    RegistrationPage registrationPage = new RegistrationPage();
    ComponentResultForm componentResultForm = new ComponentResultForm();

    @BeforeAll
    public static void beForeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1440x900";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void testForm() {
        registrationPage.openPage()
                .setFirstName("Котофей")
                .setLastName("Тапок")
                .setEmall("TapokKoTof@yandex.ru")
                .setBirthDate("25","September","2019")
                .setSex("Male")
                .setUserNumber("8342546385")
                .subjectsInput("English")
                .uploadPicture("src/test/resources/cat.jpg")
                .setHobby("Music")
                .setCurrentAddress("Москва, колбасный завод")
                .setState("NCR")
                .setСity("Delhi")
                .submit();

        $x("//*[. = 'Thanks for submitting the form']").should(exist);

                componentResultForm.checkResult("Student Name", "Котофей Тапок")
                        .checkResult("Student Email", "TapokKoTof@yandex.ru")
                        .checkResult("Gender", "Male")
                        .checkResult("Mobile", "8342546385")
                        .checkResult("Date of Birth", "25 September,2019")
                        .checkResult("Subjects", "English")
                        .checkResult("Hobbies", "Music")
                        .checkResult("Picture", "cat.jpg")
                        .checkResult("Address", "Москва, колбасный завод")
                        .checkResult("State and City", "NCR Delhi");
    }
}
