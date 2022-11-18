package tests.api.archive.test;

import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

import static io.restassured.RestAssured.given;

public class Test13 extends TestBase {

   @Test
   @Tag("API")
   @DisplayName("Test 13")
   void test1() throws ParserConfigurationException, SAXException {
      // habr.com
      Response response = given()
              .redirects().follow(false)
              .log().uri()
              .get("https://habr.com/")
              .then()
              .log().headers()
              .log().cookies()
              .statusCode(302)
              .extract().response();
      String headerLocation = response.getHeader("Location");
      String headerXRequestId = response.getHeader("X-Request-Id");
      String headerXXssProtectionequestId = response.getHeader("X-XSS-Protection");
      System.out.println("Yes!");

      // habr.com/ru/all
      response = given()
              .redirects().follow(false)
              .log().uri()
              .get(headerLocation)
              .then()
              .log().headers()
              .log().cookies()
              .statusCode(200)
              .extract().response();

      String headerETag = response.getHeader("ETag");

      // habr.com/kek/v1/auth/habrahabr/?back=/ru/all/&hl=ru
      response = given()
              .redirects().follow(false)
              .log().uri()
              .get("https://habr.com/kek/v1/auth/habrahabr/?back=/ru/all/&hl=ru")
              .then()
              .log().headers()
              .log().cookies()
              .statusCode(302)
              .extract().response();

      headerLocation = response.getHeader("Location");
      Cookie cookieHabrWebRedirectBack = response.getDetailedCookie("habr_web_redirect_back");
      Cookie cookieConnectSid = response.getDetailedCookie("connect_sid");

              // habr.com/ru/auth/o/login/?response_type=code&redirect_uri=https%3A%2F%2Fhabr.com%2Fkek%2Fv1%2Fauth%2Fhabrahabr%2Fcallback%3Fh
              // l%3Dru&state=i1sOvn2PoQ1GQF0Xj8Zlf2QO&client_id=45b151dad545995.06192751
              response = given()
              .redirects().follow(false)
              .cookie("habr_web_redirect_back", cookieHabrWebRedirectBack)
              .cookie("connect_sid", cookieConnectSid)
              .log().uri()
              .get(headerLocation)
              .then()
              .log().headers()
              .log().cookies()
              .statusCode(302)
              .extract().response();

      headerLocation = response.getHeader("Location");

      // habr.com/ru/auth/login/?back_link=https%3A%2F%2Fhabr.com%2Fru%2Fauth%2Fo%2Flogin%2F%3Fresponse_type%3Dcode%26
      // redirect_uri%3Dhttps%253A%252F%252Fhabr.com%252Fkek%252Fv1%252Fauth%252Fhabrahabr%252Fcallback%253Fhl%253Dru%26
      // state%3Di1sOvn2PoQ1GQF0Xj8Zlf2QO%26client_id%3D45b151dad545995.06192751
      response = given()
              .redirects().follow(false)
              .cookie("habr_web_redirect_back", cookieHabrWebRedirectBack)
              .cookie("connect_sid", cookieConnectSid)
              .log().uri()
              .get(headerLocation)
              .then()
              .log().headers()
              .log().cookies()
              .statusCode(302)
              .extract().response();

      headerLocation = response.getHeader("Location");
      Cookie cookieHabrSessionId = response.getDetailedCookie("habrsession_id");
      Cookie cookieFl = response.getDetailedCookie("fl");
      String urlParams = headerLocation.substring(31);
      String paramState = urlParams.substring(7, 39);
      String paramConsumer = urlParams.substring(50, 53);
      String paramHost = urlParams.substring(60, 63);
      String paramHl = urlParams.substring(72);

      // account.habr.com/login/?state=84c597ba933d8308e395dab6d5250e85&consumer=habr&host=habr.com&hl=ru_RU
      response = given()
              .redirects().follow(false)
              .cookie("habr_web_redirect_back", cookieHabrWebRedirectBack)
              .cookie("connect_sid", cookieConnectSid)
              .cookie("habrsession_id", cookieHabrSessionId)
              .cookie("fl", cookieFl)
              .log().uri()
              .get(headerLocation)
              .then()
              .log().headers()
              .log().cookies()
              .statusCode(200)
              .extract().response();

      Cookie cookieHl = response.getDetailedCookie("hl");
      Cookie cookieAccCsid = response.getDetailedCookie("acc_csid");

//      response = given()
//              .redirects().follow(false)
//              .log().uri()
//              .get("https://www.google.com/recaptcha/api2/anchor?ar=1&k=6LftHuoSAAAAAORONRXn_6xb2f_QCtXqfbRPfY2e&co=aHR0cHM6Ly9hY2NvdW50LmhhYnIuY29tOjQ0Mw..&hl=ru&v=jF-AgDWy8ih0GfLx4Semh9UK&theme=light&size=normal&cb=c0ijvfwq5b31")
//              .then()
//              .log().headers()
//              .statusCode(200)
//              .extract().response();
//
//      Cookie cookie__Secure3PSIDCC = response.getDetailedCookie("__Secure-3PSIDCC");
//
//      response = given()
//              .redirects().follow(false)
//              .cookie("hl", cookieHl)
//              .log().uri()
//              .get("https://www.google.com/recaptcha/api2/bframe?hl=ru&v=jF-AgDWy8ih0GfLx4Semh9UK&k=6LftHuoSAAAAAORONRXn_6xb2f_QCtXqfbRPfY2e\n")
//              .then()
//              .log().headers()
//              .statusCode(200)
//              .extract().response();
//
//      cookie__Secure3PSIDCC = response.getDetailedCookie("__Secure-3PSIDCC");

      // habr.com/ac/entrance/?token=c5a44088e1b990622ca777bb7682f714&state=84c597ba933d8308e395dab6d5250e85&
      // time=1668713706&sign=ec0b7c8b393bf177202e3e68562d59b1&utm_nooverride=1

      response = given()
              .redirects().follow(false)
              .cookie("connect_sid", cookieConnectSid)
              .cookie("habrsession_id", cookieHabrSessionId)
              .cookie("habr_web_redirect_back", cookieHabrWebRedirectBack)
              .cookie("fl", cookieFl)
              .cookie("hl", cookieHl)
              .cookie("acc_csid", cookieAccCsid)
              .log().uri()
              .get("https://habr.com/ac/entrance/?token=c5a44088e1b990622ca777bb7682f714&state=84c597ba933d8308e395dab6d5250e85&time=1668713706&sign=ec0b7c8b393bf177202e3e68562d59b1&utm_nooverride=1")
              .then()
              .log().headers()
              .log().cookies()
              .statusCode(302)
              .extract().response();

      headerLocation = response.getHeader("Location");

      response = given()
              .redirects().follow(false)
              .cookie("connect_sid", cookieConnectSid)
              .cookie("habrsession_id", cookieHabrSessionId)
              .cookie("fl", cookieFl)
              .cookie("hl", cookieHl)
              .cookie("acc_csid", cookieAccCsid)
              .cookie("PHPSESSID", "ri4eei1ljjk2lire98m6lcbj65")
              .log().uri()
              .get(headerLocation)
              .then()
              .log().headers()
              .log().cookies()
              .statusCode(302)
              .extract().response();

      headerLocation = response.getHeader("Location");

      // habr.com/en/all
      response = given()
              .redirects().follow(false)
              .cookie("connect_sid", cookieConnectSid)
              .cookie("habrsession_id", cookieHabrSessionId)
              .cookie("fl", cookieFl)
              .cookie("hl", cookieHl)
              .cookie("acc_csid", cookieAccCsid)
              .cookie("PHPSESSID", "ri4eei1ljjk2lire98m6lcbj65")
              .log().uri()
              .get(headerLocation)
              .then()
              .contentType("text/html; charset=utf-8")
              .log().headers()
              .log().cookies()
              .statusCode(200)
              .extract().response();


      // habr.com/ru/all
//      response = given()
//              .redirects().follow(false)
//              .cookie("connect_sid", cookieConnectSid)
//              .cookie("habrsession_id", cookieHabrSessionId)
//              .cookie("fl", cookieFl)
//              .cookie("hl", cookieHl)
//              .log().uri()
//              .get(headerLocation)
//              .then()
//              .contentType("text/html; charset=utf-8")
//              .log().headers()
//              .statusCode(200)
//              .extract().response();

      cookieConnectSid = response.getDetailedCookie("connect_sid");
      String htmlContent = response.body().asString();
      System.out.println(htmlContent);
      Assertions.assertTrue(htmlContent.contains("/ru/publication/new/"));
      System.out.println("Yes!");

   }

}
