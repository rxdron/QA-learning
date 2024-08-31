package example;


import application.RegistrationStudy;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import randomData.TestData;


import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    public RegistrationStudy registrationStudy = new RegistrationStudy();
    public TestData testData = new TestData();
    @BeforeAll
    @Step("Подготовка к прохождению теста")
     static void setup(){
        Configuration.browserSize = "1920 x 1080";
        Configuration.pageLoadStrategy = "none";
        //Configuration.pageLoadTimeout = 90000;
        Configuration.browser = "Chrome";
        open("https://demoqa.com");
    }

}
