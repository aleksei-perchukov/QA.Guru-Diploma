package tests.api.archive;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static tests.api.archive.ApiMethods.getResponse;
import static helpers.mobile.models.Specs.requestSpecification;
import static helpers.mobile.models.Specs.responseSpecification;
import static io.restassured.RestAssured.given;

@Tag("API")
public class ApiTests extends TestBase {
    @Test
    @AllureId("12690")
    @DisplayName("Change @alekseiperchukov password")
    @Tags({@Tag("User"), @Tag("Desktop"), @Tag("Settings")})
    @Owner("allure8")
    void apiChangePasswordTest() {

    }

    @Test
    @AllureId("12688")
    @DisplayName("Change website language to EN, then to RU")
    @Tags({@Tag("Desktop"), @Tag("Main"), @Tag("Settings")})
    @Owner("allure8")
    void apiChangeLanguageTest() {

    }

    @Test
    @AllureId("12686")
    @DisplayName("Create user")
    @Tags({@Tag("User"), @Tag("Desktop")})
    @Owner("allure8")
    void apiCreateUserTest() {

    }

    @Test
    @AllureId("12689")
    @DisplayName("Login aleksei.perchukov@gmail.com account")
    @Tags({@Tag("User"), @Tag("Desktop")})
    @Owner("allure8")
    void apiLoginTest() {
        Response response = getResponse();
        String url = response.body().asString().substring(26, 55);
        String token = response.body().asString().substring(62, 74);
        String body1 = response.body().asString().substring(55, 204);
        String cookieAcc_sess_id = response.getCookie("acc_sess_id");
        String cookieHl = response.getCookie("hl");
        String auth = "Bearer " + cookieAcc_sess_id;

        Cookies cookies2 = given().spec(requestSpecification)
                .get(url + body1)
                .then()
                .extract().detailedCookies();
        System.out.println(cookies2.asList());
        String cookiePhpSessId = cookies2.getValue("PHPSESSID");

        String homepageOK = given()
                .spec(requestSpecification)
                .header("authorization", auth)
                .header("hl", cookieHl)
                .header("X-Request-Id", cookieAcc_sess_id)
                .cookie("connect_sid", "s%3A6hcanFPphqSPIC0g2Q-fFaQ33VP9gKUH.nkv5lvJxzjrwlDmEkPTAV2S4jkjaUHQCoia9xb17ftc")
                .when()
                .get("/feed/")
                .then()
                .contentType("text/html; charset=utf-8")
                .spec(responseSpecification)
                .statusCode(200)
                .extract().body().asString();
        Assertions.assertTrue(homepageOK.contains("/ru/publication/new/"));
        // /ru/publication/new/
    }

    @Test
    @AllureId("12687")
    @DisplayName("Quantity of search results is 20")
    @Tags({@Tag("Desktop"), @Tag("Search")})
    @Owner("allure8")
    void apiQtySearch20Test() {

    }

    @Test
    @AllureId("12939")
    @DisplayName("Upload photo in user account")
    @Owner("allure8")
    @Tags({@Tag("User"), @Tag("Desktop"), @Tag("Settings")})
    void apiUploadPhotoTest() {

    }


}
