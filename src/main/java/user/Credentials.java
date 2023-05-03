package user;
public class Credentials {
    static UserGenerator userGenerator = new UserGenerator();

    public static String fakeEmail=userGenerator.fakeUserEmail();
    public static String fakePassword=userGenerator.fakeUserPassword();
    public static String fakeName=userGenerator.fakeUserName();
    public static String fakePasswordFive=userGenerator.fakeUserPasswordFive();
    public static String fakePasswordSeven=userGenerator.fakeUserPasswordSeven();
    public static String fakePasswordZero=userGenerator.fakeUserPasswordZero();
    public static String fakePasswordLessSix=userGenerator.fakeUserPasswordLessSix();
    public static User userWithoutName = new User().setEmail(fakeEmail).setPassword(fakePassword);
    public static User user = new User().setEmail(fakeEmail).setPassword(fakePassword).setName(fakeName);
}
