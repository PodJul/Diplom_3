package user;

import com.github.javafaker.Faker;

import java.util.Locale;

public class UserGenerator {
    Faker faker = new Faker(new Locale("en-RU"));
    public String fakeUserEmail(){
        return faker.internet().emailAddress();}
    public String fakeUserPassword(){
        return faker.internet().password(6,15);}
    public String fakeUserPasswordFive(){
        return faker.internet().password(5,6);}
    public String fakeUserPasswordSeven(){
        return faker.internet().password(7,8);}
    public String fakeUserPasswordZero(){
        return faker.internet().password(0,1);}
    public String fakeUserPasswordLessSix(){
        return faker.internet().password(0,6);}
    public String fakeUserName(){
        return faker.letterify("?????");}
}
