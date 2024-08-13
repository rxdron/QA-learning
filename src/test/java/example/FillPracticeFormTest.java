package example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Selenide.open;


public class FillPracticeFormTest extends TestBase {

    String firstName = "Ars";
    String lastName = "Saluki";
    String userEmail = "beachhotel@gmial.com";
    String userNumber = "9964003352";
    String gender = "Female";
    String currentAddress = "UFA RB";
    String day = "1";
    String mount = "July";
    String year = "2000";
    String state = "Rajasthan";
    String city = "Jaipur";


    @CsvFileSource(resources = "/testDataFillPracticeForm.csv")
    @Tags({@Tag("UI Test"), @Tag("Critical")})
    @ParameterizedTest(name = "Заполнение поля Subjects {0}, Заполнение поля Hobbies {1}")
    void fillPracticeForm (String subject, String hobbies){
        open("https://demoqa.com/automation-practice-form");
        registrationStudy
                .fillName(firstName, lastName)
                .fillUserContactInfo(userEmail, userNumber, currentAddress)
                .fillGenderAndHobbies(gender, hobbies)
                .fillBirthday(day, mount, year)
                .fillSubject(subject).
                uploadPicture().fillCity(state, city)
                .clickSubmit();

        registrationStudy.verifyTextForm();

        registrationStudy.verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", "01 July,2000")
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", "Screenshot_5.png")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);
    }
}
