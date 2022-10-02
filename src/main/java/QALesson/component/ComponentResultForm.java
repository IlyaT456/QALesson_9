package QALesson.component;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class ComponentResultForm {

    public ComponentResultForm checkResult(String valueOne, String valueTwo) {
        $x("//td[.='" + valueOne + "']/following-sibling::td").shouldHave(Condition.text(valueTwo));
        return this;
    }

}
