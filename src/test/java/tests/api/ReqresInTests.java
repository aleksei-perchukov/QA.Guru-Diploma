package tests.api;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.api.models.PutUpdateRequestPojoModel;
import tests.api.models.UserBodyRequestPojoModel;
import tests.api.models.UserBodyResponsePojoModel;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static tests.api.specs.Specs.requestSpecification;
import static tests.api.specs.Specs.responseSpecification;

@Tags({@Tag("API"), @Tag("Desktop")})
@Owner("allure8")
@DisplayName("API - Reqres.in Tests")
public class ReqresInTests {
    @Test
    @AllureId("12986")
    @DisplayName("Register user test - successful")
    @Tags({@Tag("User"), @Tag("Settings")})
    void postRegisterSuccessful() {

            UserBodyRequestPojoModel requestBody = new UserBodyRequestPojoModel();
            requestBody.setEmail("eve.holt@reqres.in");
            requestBody.setPassword("pistol");
            UserBodyResponsePojoModel response = step("Register new user", () -> given()
                    .spec(requestSpecification)
                    .body(requestBody)
                    .when()
                    .post("/api/register")
                    .then()
                    .spec(responseSpecification)
                    .statusCode(200)
                    .extract()
                    .as(UserBodyResponsePojoModel.class));
        step("Check that user is registered", () -> {
            assertThat(response.getId()).isEqualTo("4");
            assertThat(response.getToken()).isNotNull();
        });
    }

    @Test
    @AllureId("12688")
    @DisplayName("Register user test - unsuccessful")
    @Tags({@Tag("Main"), @Tag("Settings")})
    void postRegisterUnsuccessful() {

            UserBodyRequestPojoModel request = new UserBodyRequestPojoModel();
            request.setEmail("sydney@fife");

            UserBodyResponsePojoModel response = step("Register user without password field filled", () -> given()
                    .spec(requestSpecification)
                    .body(request)
                    .when()
                    .post("/api/register")
                    .then()
                    .spec(responseSpecification)
                    .statusCode(400)
                    .extract()
                    .as(UserBodyResponsePojoModel.class));

        step("Check that user is not registered", () -> {
            assertThat(response.getError()).isEqualTo("Missing password");
        });
    }

    @Test
    @AllureId("12686")
    @DisplayName("Put update test")
    @Tags({@Tag("Main"), @Tag("Settings")})
    void putUpdate() {
            PutUpdateRequestPojoModel request = new PutUpdateRequestPojoModel();
            request.setName("morpheus");
            request.setJob("zion resident");

            UserBodyResponsePojoModel response = step("Register user without password field filled", () -> given()
                    .spec(requestSpecification)
                    .body(request)
                    .when()
                    .put("/api/users/2")
                    .then()
                    .spec(responseSpecification)
                    .statusCode(200)
                    .extract()
                    .as(UserBodyResponsePojoModel.class));
        step("Check that user is not registered", () -> {
            assertThat(response.getName()).isEqualTo("morpheus");
            assertThat(response.getJob()).isEqualTo("zion resident");
        });
    }

    @Test
    @AllureId("12689")
    @DisplayName("Delete user test")
    @Tag("User")
    void deleteUser() {
        step("Delete user and check 204 http-status returned", () -> {
            given()
                    .spec(requestSpecification)
                    .when()
                    .delete("/api/users/2")
                    .then()
                    .spec(responseSpecification)
                    .statusCode(204);
        });
    }

    @Test
    @AllureId("12687")
    @DisplayName("Single resource test")
    @Tag("Search")
    void singleResource() {
            UserBodyRequestPojoModel request = new UserBodyRequestPojoModel();
            request.setEmail("eve.holt@reqres.in");
            request.setPassword("pistol");

            UserBodyResponsePojoModel response = step("Getting single resource", () -> given()
                    .spec(requestSpecification)
                    .when()
                    .get("/api/unknown/2")
                    .then()
                    .spec(responseSpecification)
                    .statusCode(200)
                    .extract()
                    .as(UserBodyResponsePojoModel.class));
        step("Checking that resource data is correct", () -> {
            assertThat(response.getData().getId()).isEqualTo("2");
            assertThat(response.getData().getName()).isEqualTo("fuchsia rose");
            assertThat(response.getData().getYear()).isEqualTo("2001");
            assertThat(response.getData().getColor()).isEqualTo("#C74375");
            assertThat(response.getData().getPantone_value()).isEqualTo("17-2031");
            assertThat(response.getSupport().getUrl()).isEqualTo("https://reqres.in/#support-heading");
            assertThat(response.getSupport().getText()).isEqualTo("To keep ReqRes free, contributions towards server costs are appreciated!");
        });
    }
}

