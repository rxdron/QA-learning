package example;


import application.RegistrationStudy;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import randomData.TestData;


import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    RegistrationStudy registrationStudy = new RegistrationStudy();
    TestData testData = new TestData();
    @BeforeAll
     static void setup(){
        Configuration.browserSize = "1920 x 1080";
        Configuration.pageLoadStrategy = "none";
        //Configuration.pageLoadTimeout = 90000;
        Configuration.browser = "Chrome";
        open("https://demoqa.com");
    }

}
