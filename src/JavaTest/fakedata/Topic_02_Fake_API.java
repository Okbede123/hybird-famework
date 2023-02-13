package JavaTest.fakedata;

import com.github.javafaker.Faker;

public class Topic_02_Fake_API {


    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println(faker.dragonBall().character());
    }
}
