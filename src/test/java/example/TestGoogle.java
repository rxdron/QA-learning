package example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import example.Allure.TestBaseExtend;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestGoogle extends TestBaseExtend {

    //@Test
    void successfulSearch() {
        Configuration.browserSize = "1980 x 1080";
        open("https://eu.account.battle.net/login");
        $x("//div[@class='controls']//input[@name='accountName']").click();
        $x("//div[@class='controls']//input[@name='accountName']").setValue("1234@gmail.com");
        $x("//div[@class='controls']//input[@name='password']").click();
        $x("//div[@class='blz-password-wrapper']//input[@name='password']").setValue("1234qwerty");
        sleep(5000);

    }

    //@Test
    void TestElements() {
        Configuration.browserSize = "1980 x 1080";
        open("http://85.192.34.140:8081/");
        $x("//div[@class='card-bo  dy']//h5[text()='Elements']").click();
        $x("//div[@class='header-text' and text()='Forms']").click();
        $("[class='col-12 mt-4 col-md-6']")
                .shouldBe(text("Please select an item from left to start practice."));
        sleep(5000);
    }

   // @Test
    void TestSelenideGitHub() {
        Configuration.browserSize ="1980 x 1080";
        sleep(5000);
        open("https://github.com/");
        $("[data-target*=inputButtonText]").click();
        $("[name='query-builder-test']").setValue("Selenide").pressEnter();
        $$("div[data-testid=results-list]").first().$("a").click();
        $("a[href='/selenide/selenide/wiki']").click();
        $("button[type='button'][class*='Link--muted']").click();
        $("a[href='/selenide/selenide/wiki/SoftAssertions'][class*=text-bold]")
                .shouldHave(text("SoftAssertions"));
        $("a[href='/selenide/selenide/wiki/SoftAssertions'][class*=text-bold]").click();
        $(".gollum-markdown-content")
                .shouldHave(text("3. Using JUnit5 extend test class:"));
    }

    @Test
    void TestSolutionHover() {
        open("https://github.com/");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        $("ul.d-lg-flex").$(withText("Solutions")).hover();
        $("a[href='https://github.com/enterprise']").click();
        $("h1#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));
        sleep(5000);
    }

    @Test
    void TestDragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //actions().moveToElement($("div#column-a")).clickAndHold().moveByOffset(200, 0).release().perform();
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
        $$("div.column").last().$("header").shouldHave(text("A"));
        sleep(5000);
    }
}
