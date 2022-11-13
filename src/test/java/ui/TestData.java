package ui;

import com.github.javafaker.Faker;
import testdata.RandomUtil;

import static testdata.RandomUtil.getRandomPhone;

public class TestData {
    static Faker faker = new Faker();
    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String login = "aleksei.perchukov@gmail.com";
    public static String nickName = "@alekseiperchukov";
    public static String loginPassword = "Nanana88";

    public static String email = firstName + "_" + lastName + "@test.com";
    public static String password = RandomUtil.getRandomString(10);
    public static String phoneNumber = getRandomPhone();
    public static String zipCode = faker.address().zipCode();
//    public static String country = faker.address().countyByZipCode(zipCode);
    public static String city = faker.address().city();
    public static String address = faker.address().streetAddressNumber();
    public static String searchArticle = "Tutorial: Frontity — Setting Up Authorization for WordPress Private Endpoints";
    public static String searchText = "As a result of the work done, you will set up an authorization mechanism for WordPress private endpoints.";
}
