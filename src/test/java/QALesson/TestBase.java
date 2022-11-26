package QALesson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestBase {

    Faker faker = new Faker();


    String firstname = faker.name().firstName(),
            lastname = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            day = String.valueOf(faker.number().numberBetween(1, 31)),
            month = Calendar.getInstance().get(Calendar.MONTH) +"",
            year = String.valueOf(faker.number().numberBetween(1995, 2020)),
            birthDate = (day + " " + month + " " + year),
            phone = faker.phoneNumber().subscriberNumber(10),
            currentAddress = faker.address().fullAddress();


    @BeforeAll
    public static void beForeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1440x900";
        Configuration.holdBrowserOpen = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}

