package QALesson.pages;

import QALesson.component.ComponentCalendar;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    ComponentCalendar componentСalendar = new ComponentCalendar();

    @Step("открыть браузер")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }
    @Step("ввести имя {0}")
    public RegistrationPage setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }
    @Step("ввести фамилию {0}")
    public RegistrationPage setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }
    @Step("ввести почту {0}")
    public RegistrationPage setEmall(String value) {
        $("#userEmail").setValue(value);
        return this;
    }
    @Step("ввести день рождения {0}")
    public RegistrationPage setBirthDate(String birthDate) {
        $("#dateOfBirthInput").click();
        componentСalendar.setDate(birthDate);
        return this;
    }
    @Step("ввести пол {0}")
    public RegistrationPage setSex(String sex) {
        $x("//*[text() = '" + sex + "']").click();
        return this;
    }
    @Step("ввести номер {0}")
    public RegistrationPage setUserNumber(String number) {
        $("#userNumber").setValue(number);
        return this;
    }
    @Step("ввести субъектм")
    public RegistrationPage subjectsInput(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }
    @Step("добавить картинку")
    public RegistrationPage uploadPicture(String path) {
        $("#uploadPicture").uploadFile(new File(path));
        return this;
    }
    @Step("ввести хобби {0}")
    public RegistrationPage setHobby(String hobby) {
        $x("//*[text() = '" + hobby + "']").click();
        return this;
    }
    @Step("ввести адрес")
    public RegistrationPage setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        $("#state").scrollIntoView(true).click();
        $x("//*[text() = '" + value + "']").scrollIntoView(true).click();
        return this;
    }

    public RegistrationPage setСity(String value) {
        $("#city").scrollIntoView(true).click();
        $x("//*[text() = '" + value + "']").scrollIntoView(true).click();
        return this;
    }
    @Step("Сохранить")
    public RegistrationPage submit() {
        $("#submit").submit();
        return this;
    }
}





