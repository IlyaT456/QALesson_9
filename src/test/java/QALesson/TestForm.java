package QALesson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
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

        Assertions.assertEquals($x("//td[.='Student Name']/following-sibling::td").getText(),"Тапок Котофей");
        Assertions.assertEquals($x("//td[.='Student Email']/following-sibling::td").getText(),"TapokKoTof@yandex.ru");
        Assertions.assertEquals($x("//td[.='Gender']/following-sibling::td").getText(),"Male");
        Assertions.assertEquals($x("//td[.='Mobile']/following-sibling::td").getText(),"8342546385");
        Assertions.assertEquals($x("//td[.='Date of Birth']/following-sibling::td").getText(),"24 September,2022");
        Assertions.assertEquals($x("//td[.='Subjects']/following-sibling::td").getText(),"English");
        Assertions.assertEquals($x("//td[.='Hobbies']/following-sibling::td").getText(),"Music");
        Assertions.assertEquals($x("//td[.='Picture']/following-sibling::td").getText(),"cat.jpg");
        Assertions.assertEquals($x("//td[.='Address']/following-sibling::td").getText(),"Москва, колбасный завод");
        Assertions.assertEquals($x("//td[.='State and City']/following-sibling::td").getText(),"NCR Delhi");











    }
}
