package application;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckBox {

    String result = "#result";
    String resultWithAllCheckBoxOn = "You have selected : home desktop notes commands documents workspace react angular" +
            " veu  office public private classified general downloads wordFile excelFile";
    String resultWithOutCheckBoxDesktop = "You have selected : documents workspace react angular veu office" +
            " public private classified general downloads wordFile excelFile";
    String resultWithOutCheckBoxDocuments = "You have selected : downloads wordFile excelFile";
    String noResult = "You have selected : ";

    public void clickCheckBoxHome (){
        $("#tree-node-home").parent().click();
    }

    public void clickTreeViewHome(){
        $$(".rct-collapse-btn").get(0).click();
    }

    public void clickCheckBoxDesktop(){
        $("#tree-node-desktop").parent().click();
    }

    public void clickTreeViewDesktop(){
        $$(".rct-collapse-btn").get(1).click();
    }

    public void clickTreeViewDocuments(){
        $$(".rct-collapse-btn").get(2).click();
    }

    public void clickCheckBoxDocuments(){
        $("#tree-node-documents").parent().click();
    }

    public void clickTreeViewDownloads(){
        $$(".rct-collapse-btn").get(5).click();
    }
    public void clickCheckBoxDownloads(){
        $("#tree-node-downloads").parent().click();
    }

    public void verifyResultWithAllCheckBoxOn(){
        $(result).shouldHave(text(resultWithAllCheckBoxOn));
    }

    public void verifyResultWithOutCheckBoxDesktop(){
        $(result).shouldHave(text(resultWithOutCheckBoxDesktop));
    }
    public void verifyResultWithOutCheckBoxDocuments(){
        $(result).shouldHave(text(resultWithOutCheckBoxDocuments));
    }
    public void verifyResultNotHaveText(){
        $(".check-box-tree-wrapper").shouldNotHave(text(noResult));
    }
}
