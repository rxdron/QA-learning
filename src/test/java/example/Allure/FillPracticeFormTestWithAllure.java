package example.Allure;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;


public class FillPracticeFormTestWithAllure extends TestBaseExtend {
    public final String FIRST_NAME = testData.firstName;
    String lastName = testData.lastName;
    String userEmail = testData.userEmail;
    String userNumber = testData.userNumber;
    String gender = testData.gender;
    String currentAddress = testData.currentAddress;
    String day = testData.day;
    String month = testData.month;
    String year = testData.year;
    String state = testData.state;
    String city = testData.city;
    String dateBirth = String.format(day, month + "," + year);

    @ParameterizedTest(name = "Заполнение поля Subjects значением {0}, Заполнение поля Hobbies значением {1}")
    @Feature("Заполнение формы регистрации")
    @Story("Проверка формы регистрации")
    @CsvFileSource(resources = "/testDataFillPracticeForm.csv")
    @Tags({@Tag("UI Test"), @Tag("Blocker")})
    @DisplayName("Проверка заполнения формы PracticeForm")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("lyubtsovaa")
    void fillPracticeFormLambdaStep (String subject, String hobbies){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());


        step("Открываем страницу https://demoqa.com/automation-practice-form",
                () -> open("https://demoqa.com/automation-practice-form"));
        removeElements();

        registrationStudy
                .fillName(FIRST_NAME, lastName)
                .fillUserContactInfo(userEmail, userNumber, currentAddress)
                .fillGenderAndHobbies(gender, hobbies)
                .fillBirthday(day, month, year)
                .fillSubject(subject)
                .uploadPicture()
                .fillCity(state, city)
                .clickSubmit();


        registrationStudy.verifyTextForm();

        registrationStudy.verifyResult("Student Name", FIRST_NAME + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", dateBirth)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", "Screenshot_5.png")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);
    }
}
