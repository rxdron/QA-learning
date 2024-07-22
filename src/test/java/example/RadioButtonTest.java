package example;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class RadioButtonTest extends TestBase{

    String result = ".mt-3";
    String selectRadioYes = "#yesRadio";
    String hoverRadioNo = "#noRadio";
    String selectImpressiveRadio = "#impressiveRadio";
    String resultWithRadioYes = "You have selected Yes";
    String resultWithRadioImpressive = "You have selected Yes";

    @Test
    void selectRadioButtonTest(){
        open("https://demoqa.com/radio-button");
        $(".text-center").shouldHave(text("Radio Button"));
        $(".mb-3").shouldHave(text("Do you like the site?"));
        $(selectRadioYes).sibling(0).click();
        $(result).shouldBe(visible).shouldHave(text(resultWithRadioYes));
        $(hoverRadioNo).sibling(0).hover()
                .shouldHave(cssValue("cursor","not-allowed"));
        $(selectImpressiveRadio).sibling(0).click();
        $(result).shouldBe(visible).shouldHave(text(resultWithRadioImpressive));
    }
}
