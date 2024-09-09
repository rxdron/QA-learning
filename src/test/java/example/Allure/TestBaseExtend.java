package example.Allure;


import Helper.Attach;
import application.RegistrationStudy;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import randomData.TestData;

import java.util.Map;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBaseExtend {
    TestData testData = new TestData();
    RegistrationStudy registrationStudy = new RegistrationStudy();

    @BeforeAll
    static void beforeAll() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920х1080";
        Configuration.browserVersion = "126.0";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        removeElements();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
    public void removeElements() {
        executeJavaScript("if ($('#fixedban').length > 0) { $('#fixedban').remove(); }");
        executeJavaScript("if ($('#adplus-anchor').length > 0) { $('#adplus-anchor').remove(); }");
        executeJavaScript("if ($('footer').length > 0) { $('footer').remove(); }");
    }
}