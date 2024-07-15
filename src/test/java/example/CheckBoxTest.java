package example;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckBoxTest extends TestBase{

    @Test
    void checkBoxTest() {
        open("https://demoqa.com/checkbox");

        $("#tree-node-home").parent().click();
        $("#result").shouldHave(text("You have selected : " +
                "home desktop notes commands documents workspace react angular veu " +
                "office public private classified general downloads wordFile excelFile"));
        $(".rct-collapse-btn").click();
        $("#tree-node-desktop").parent().click();
        $("#result").shouldHave(text("You have selected : " +
                "documents workspace react angular veu office public private " +
                "classified general downloads wordFile excelFile"));

        sleep(5000);
    }
}
