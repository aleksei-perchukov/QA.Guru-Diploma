package tests.api.archive;

import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static helpers.mobile.models.Specs.*;
import static io.restassured.RestAssured.given;

public class ApiMethods {
    static String getLoginResponse() {
        String url = given()
                .spec(requestSpecification)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
//                .body("state=93e6d1fca661ad6ffc0764efbb090cd5&consumer=habr&host=habr.com&email=aleksei.perchukov%40gmail.com&password=Nanana88" +
//                        "&captcha=&g-recaptcha-response=&captcha_type=recaptcha")
                .when()
                .post("https://account.habr.com/ajax/login/state=93e6d1fca661ad6ffc0764efbb090cd5&consumer=habr&host=habr.com&email=aleksei.perchukov%40gmail.com&password=Nanana88&captcha=&g-recaptcha-response=&captcha_type=recaptcha")
                .then()
                .contentType("text/javascript;charset=UTF-8")
                .spec(responseSpecification)
                .statusCode(200)
                .extract().body().asString().substring(26, 204);
        return url;
    }

    static Cookies getCookies0() {

        Cookies cookie0 = given()
                .spec(requestSpecification)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .header("Referer", "https://account.habr.com/login/?state=93e6d1fca661ad6ffc0764efbb090cd5&consumer=habr&host=habr.com&hl=ru_RU")
                .body("state=93e6d1fca661ad6ffc0764efbb090cd5&consumer=habr&host=habr.com&email=aleksei.perchukov%40gmail.com&password=Nanana88" +
                        "&captcha=&g-recaptcha-response=&captcha_type=recaptcha")
                .when()
                .post("https://account.habr.com/ajax/login/")
                .then()
                .contentType("text/javascript;charset=UTF-8")
                .spec(responseSpecification)
                .statusCode(200)
                .extract().detailedCookies();
        System.out.println(cookie0);
        return cookie0;
    }

    static Headers getHeadersSetCookie() {

        Headers headers0 = given()
                .spec(requestSpecification)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .header("Referer", "https://account.habr.com/login/?state=93e6d1fca661ad6ffc0764efbb090cd5&consumer=habr&host=habr.com&hl=ru_RU")
                .body("state=93e6d1fca661ad6ffc0764efbb090cd5&consumer=habr&host=habr.com&email=aleksei.perchukov%40gmail.com&password=Nanana88" +
                        "&captcha=&g-recaptcha-response=&captcha_type=recaptcha")
                .when()
                .post("https://account.habr.com/ajax/login/")
                .then()
                .contentType("text/javascript;charset=UTF-8")
                .spec(responseSpecification)
                .statusCode(200)
                .extract().headers();
        System.out.println(headers0);
        return headers0;
    }

    static Response getResponse() {
        Response url = given()
                .spec(requestSpecification)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .header("Referer", "https://account.habr.com/login/?state=93e6d1fca661ad6ffc0764efbb090cd5&consumer=habr&host=habr.com&hl=ru_RU")
                .body("state=93e6d1fca661ad6ffc0764efbb090cd5&consumer=habr&host=habr.com&email=aleksei.perchukov%40gmail.com&password=Nanana88" +
                        "&captcha=&g-recaptcha-response=&captcha_type=recaptcha")
                .when()
                .post("https://account.habr.com/ajax/login/")
                .then()
                .contentType("text/javascript;charset=UTF-8")
                .spec(responseSpecification)
                .statusCode(200)
                .extract().response();
        return url;


    }
}
