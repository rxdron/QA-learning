package example;

import application.RegistrationStudy;
import com.codeborne.selenide.logevents.SelenideLogger;
import example.Allure.TestBaseExtend;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import randomData.TestData;

import static com.codeborne.selenide.Selenide.*;


public class FillPracticeFormTest extends TestBaseExtend {
    TestData testData = new TestData();
    RegistrationStudy registrationStudy = new RegistrationStudy();
    String firstName = testData.firstName;
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


    @CsvFileSource(resources = "/testDataFillPracticeForm.csv")
    @Tags({@Tag("UI Test"), @Tag("Critical")})
    @ParameterizedTest(name = "Заполнение поля Subjects {0}, Заполнение поля Hobbies {1}")
    void fillPracticeForm (String subject, String hobbies){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open("https://demoqa.com/automation-practice-form");
        registrationStudy
                .fillName(firstName, lastName)
                .fillUserContactInfo(userEmail, userNumber, currentAddress)
                .fillGenderAndHobbies(gender, hobbies)
                .fillBirthday(day, month, year)
                .fillSubject(subject).
                uploadPicture().fillCity(state, city)
                .clickSubmit();

        registrationStudy.verifyTextForm();

        registrationStudy.verifyResult("Student Name", firstName + " " + lastName)
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
