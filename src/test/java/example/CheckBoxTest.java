package example;

import application.CheckBox;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckBoxTest extends TestBase{


    CheckBox checkBox = new CheckBox();

    @Test
    void checkBoxTest() {
        open("https://demoqa.com/checkbox");

        $$(".rct-title").filterBy(text("Home")).shouldHave(size(1));
        checkBox.clickCheckBoxHome();
        checkBox.verifyResultWithAllCheckBoxOn();
        checkBox.clickTreeViewHome();
        $$(".rct-title").filterBy(text("Documents")).shouldHave(size(1));
        checkBox.clickCheckBoxDesktop();
        checkBox.verifyResultWithOutCheckBoxDesktop();
        checkBox.clickTreeViewDesktop();
        checkBox.clickTreeViewDocuments();
        $$(".rct-title").filterBy(text("WorkSpace")).shouldHave(size(1));
        $$(".rct-title").filterBy(text("Office")).shouldHave(size(1));
        checkBox.clickCheckBoxDocuments();
        checkBox.verifyResultWithOutCheckBoxDocuments();
        checkBox.clickTreeViewDownloads();
        checkBox.clickCheckBoxDownloads();
        checkBox.verifyResultNotHaveText();
        sleep(5000);
    }
}
