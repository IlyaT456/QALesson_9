package QALesson;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestForm {

    @BeforeAll
    public static void beForeAll() {
      Configuration.baseUrl = "https://demoqa.com";
      Configuration.browserSize = "1440x900";
      Configuration.holdBrowserOpen = true;
    }

    @Test
    public void testForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Тапок");
        $("#lastName").setValue("Котофей");
        $("#userEmail").setValue("TapokKoTof@yandex.ru");
        $x("//*[text() = 'Male']").click();
        $("#userNumber").setValue("8342546385");
        $("#subjectsInput").setValue("English").pressEnter();
        $("#uploadPicture").uploadFile(new File("src/test/resources/cat.jpg"));
        $x("//*[text() = 'Music']").click();
        $("#currentAddress").setValue("Москва, колбасный завод");
        $("#state").scrollIntoView(true).click();
        $x("//*[text() = 'NCR']").scrollIntoView(true).click();
        $("#city").scrollIntoView(true).click();
        $x("//*[text() = 'Delhi']").scrollIntoView(true).click();
        $("#submit").submit();
        $x("//*[. = 'Thanks for submitting the form']").should(exist);


        $(".table-responsive").shouldHave(text("Тапок Котофей"),
                text("TapokKoTof@yandex.ru"),
                text("Male"),
                text("8342546385"),
                text("24 September,2022"),
                text("English"),
                text("Music"),
                text("cat.jpg"),
                text("Москва, колбасный завод"),
                text("NCR Delhi"));
    }
}
