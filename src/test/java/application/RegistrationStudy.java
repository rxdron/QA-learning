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
        $(goToUserNumber).setValue(String.valueOf(userNumber));
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
        $("[class*=\"year-dropdown-container\"]").$(byText(String.valueOf(year))).click();
        $("[class=\"react-datepicker__month\"]").$(byText(String.valueOf(day))).click();
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
        registrationStudy.verifyResult(key, String.valueOf(value));
        return this;
    }
    public void clickSubmit(){
        $("#submit").click();
    }
}