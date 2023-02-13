package src2.cores.ultilities;

import com.github.javafaker.Faker;

public class DataFaker {
      Faker faker;

    public DataFaker(){
        faker = new Faker();
    }

    public static DataFaker getDataFaker(){
        return new DataFaker();
    }

    public String getLastNameUser(){
        return faker.address().lastName();
    }

    public String getFirstNameUser(){
        return faker.address().firstName();
    }

    public String getAddressUser(){
        return faker.address().streetAddress();
    }
    public String getPhoneNumber(){
        return faker.phoneNumber().cellPhone();
    }

    public String getEmailAddress(){
        return faker.internet().emailAddress();
    }

    public String getPassword(){
        return faker.internet().password();
    }
}
