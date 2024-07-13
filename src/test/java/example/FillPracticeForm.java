package example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FillPracticeForm {

    String firstName = "Ars";
    String lastName = "Saluki";
    String userEmail = "beachhotel@gmial.com";
    String userNumber = "9964003352";
    String gender = "Female";
    String hobbies = "Music";
    String subjects = "Computer science";
    String currentAddress = "UFA RB";


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
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#dateOfBirthInput").click();
        $("[class*=\"month-dropdown-container\"]").$(byText("July")).click();
        $("[class*=\"year-dropdown-container\"]").$(byText("2000")).click();
        $("[class=\"react-datepicker__month\"]").$(byText("1")).click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#uploadPicture").uploadFile(new File("src/test/resources/Screenshot_5.png"));
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();
        $("#submit").click();

        $(byText("Thanks for submitting the form")).shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail), text(gender), text(userNumber),
                text("01 July,2000"), text("Computer Science"), text("Screenshot_5.png"), text(currentAddress),
                text("Rajasthan Jaipur"));
    }
}
