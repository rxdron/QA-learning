package randomData;




import com.github.javafaker.Faker;

import java.util.Locale;


public class TestData {
    Faker faker = new Faker(new Locale("Ru"));
    Faker noLocal = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = noLocal.internet().emailAddress();
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String currentAddress = faker.address().fullAddress();
    public String day = faker.number().numberBetween(1,31) + "";
    public String month = getRandomMonths();
    public String year = faker.number().numberBetween(1940,2007) + "";


    protected int randomNumberMouth() {
        int randomNumberMonths = faker.number().numberBetween(1, 12);
        return randomNumberMonths;
    }

    protected String getRandomMonths() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String randomMonth = months[randomNumberMouth() - 1];
        return randomMonth;
    }

}