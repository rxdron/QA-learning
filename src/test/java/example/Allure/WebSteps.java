package example.Allure;

import application.RegistrationStudy;
import io.qameta.allure.Step;

public class WebSteps {

    RegistrationStudy registrationStudy = new RegistrationStudy();

    @Step("Нажимаем на кнопку Submit")
    public void clickSubmit(){
        registrationStudy.clickSubmit();
    }
}
