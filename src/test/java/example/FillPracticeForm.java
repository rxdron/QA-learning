package example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FillPracticeForm {


    @BeforeEach
     void setup(){
        Configuration.browserSize = "1920 x 1080";
        Configuration.pageLoadStrategy = "none";
        //Configuration.pageLoadTimeout = 90000;
        Configuration.browser = "Chrome";
        open("https://demoqa.com/automation-practice-form");

    }



    @Test
    void FillPracticeForm(){
        $(".text-center").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Ars");
        $("#lastName").setValue("Saluki");
        $("#userEmail").setValue("beachhotel@gmial.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9964003352");
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#dateOfBirthInput").click();
        $("[class*=\"month-dropdown-container\"]").$(byText("July")).click();
        $("[class*=\"year-dropdown-container\"]").$(byText("2000")).click();
        $("[class=\"react-datepicker__month\"]").$(byText("1")).click();
        //$("")
        //$(".react-datepicker__month-select").click();
        $("[aria-label=\"month  2024-07\"]").setValue("month  2000-07");
        sleep(5000);
    }
}
