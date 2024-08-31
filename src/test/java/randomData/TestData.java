package randomData;


import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class TestData {
    Faker faker = new Faker(new Locale("Ru"));
    Faker noLocal = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = noLocal.internet().emailAddress();
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String currentAddress = faker.address().streetAddress();
    public String day = faker.number().numberBetween(1, 31) + "";
    public String month = getRandomMonths();
    public String year = faker.number().numberBetween(1940, 2007) + "";
    public String gender = getGender();
    public String state = getState();
    public String city  = getCity(state);


    protected int randomNumberMouth() {
        return faker.number().numberBetween(1, 12);
    }

    protected String getRandomMonths() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        return months[randomNumberMouth() - 1];
    }

    protected String getGender() {
        List<String> gender = Arrays.asList("Male", "Female", "Other");
        int randomGenderNumber = faker.number().numberBetween(0, 2);
        return gender.get(randomGenderNumber);
    }

    protected String getState() {
        List<String> state = Arrays.asList("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        int randomNumberForState = faker.number().numberBetween(0, 3);
        return state.get(randomNumberForState);
    }

    protected String getCity(String state){
        List<String> cityNCR = Arrays.asList("Delhi", "Gurgaon", "Noida");
        List<String> cityUttarPradesh = Arrays.asList("Agra", "Lucknow", "Merrut");
        List<String> cityHaryana = Arrays.asList("Karnal", "Panipat");
        List<String> cityRajasthan = Arrays.asList("Jaipur", "Jaiselmer");


        String randomCity = "";
        switch (state) {
            case "NCR":
                int randomNumberForNcr = faker.number().numberBetween(0, 2);
                randomCity = cityNCR.get(randomNumberForNcr);
                break;
            case "Uttar Pradesh":
                int randomNumberForUttarPradesh = faker.number().numberBetween(0, 2);
                randomCity = cityUttarPradesh.get(randomNumberForUttarPradesh);
                break;
            case "Haryana":
                int randomNumberForHaryana = faker.number().numberBetween(0, 1);
                randomCity = cityHaryana.get(randomNumberForHaryana);
                break;
            case "Rajasthan":
                int randomNumberForRajasthan = faker.number().numberBetween(0, 1);
                randomCity = cityRajasthan.get(randomNumberForRajasthan);
                break;
            default:
                System.out.println("Неверный штат. Пожалуйста, выберите из NCR, Uttar Pradesh, Haryana или Rajasthan.");
                break;
        }

        return randomCity;
    }

}