package application;



import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationStudy {
    String goToFirstName = "#firstName";
    String goToLastName = "#lastName";
    String goToUserEmail = "#userEmail";
    String goToUserNumber = "#userNumber";
    String goToUserCurrentAddress = "#currentAddress";
    String goToGender = "#genterWrapper";
    String goToHobbies = "#hobbiesWrapper";
    String goToSubject = "#subjectsInput";
    String goToUpLoadPicture = "#uploadPicture";


    RegistrationStudyResult registrationStudy = new RegistrationStudyResult();

    public RegistrationStudy fillName(String firstName, String lastName) {

        $(".text-center").shouldHave(text("Practice Form"));
        $(goToFirstName).setValue(firstName);
        $(goToLastName).setValue(lastName);
        return this;
    }
    public RegistrationStudy fillUserContactInfo(String userEmail, String userNumber, String currentAddress){
        $(goToUserEmail).setValue(userEmail);
        $(goToUserNumber).setValue(userNumber);
        $(goToUserCurrentAddress).setValue(currentAddress);
        return this;
    }

    public RegistrationStudy fillGenderAndHobbies(String gender, String hobbies){
        $(goToGender).$(byText(gender)).click();
        $(goToHobbies).$(byText(hobbies)).click();
        return this;
    }

    public RegistrationStudy fillBirthday (String day, String month, String year){
        $("#dateOfBirthInput").click();
        $("[class*=\"month-dropdown-container\"]").$(byText(month)).click();
        $("[class*=\"year-dropdown-container\"]").$(byText(year)).click();
        $("[class=\"react-datepicker__month\"]").$(byText(day)).click();
        return this;
    }
    public RegistrationStudy fillSubject(String subject){
        $(goToSubject).setValue(subject).pressEnter();
        return this;
    }
    public RegistrationStudy uploadPicture(){
        $(goToUpLoadPicture).uploadFile(new File("src/test/resources/Screenshot_5.png"));
        return this;
    }

    public RegistrationStudy fillCity(String state, String city){
        $("#state").click();
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }
    public void verifyTextForm(){
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
    }

    public RegistrationStudy verifyResult(String key, String value) {
        registrationStudy.verifyResult(key, value);
        return this;
    }
    public void clickSubmit(){
        $("#submit").click();
    }
}

/*$(byText("Thanks for submitting the form")).shouldHave(text("Thanks for submitting the form"));
$(".table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail), text(gender), text(userNumber),
text("01 July,2000"), text("Computer Science"), text("Screenshot_5.png"), text(currentAddress),
text("Rajasthan Jaipur"))*/