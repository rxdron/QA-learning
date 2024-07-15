package example;

import org.junit.jupiter.api.Test;



public class FillPracticeForm extends TestBase {

    String firstName = "Ars";
    String lastName = "Saluki";
    String userEmail = "beachhotel@gmial.com";
    String userNumber = "9964003352";
    String gender = "Female";
    String hobbies = "Music";
    String subject = "Computer science";
    String currentAddress = "UFA RB";
    String day = "1";
    String mount = "July";
    String year = "2000";
    String state = "Rajasthan";
    String city = "Jaipur";


    @Test
    void fillPracticeForm(){
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
