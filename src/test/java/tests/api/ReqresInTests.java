package tests.api;

import tests.api.models.PutUpdateRequestPojoModel;
import tests.api.models.UserBodyRequestPojoModel;
import tests.api.models.UserBodyResponsePojoModel;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static tests.api.specs.Specs.requestSpecification;
import static tests.api.specs.Specs.responseSpecification;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("API")
@DisplayName("API - Reqres.in Tests")
public class ReqresInTests {
    @Test
    @AllureId("12986")
    @DisplayName("Register user test - successful")
    @Owner("allure8")
    @Tags({@Tag("User"), @Tag("Desktop"), @Tag("Settings")})
    void postRegisterSuccessful() {
        AtomicReference<UserBodyResponsePojoModel> response = new AtomicReference();

        step("Register new user", () -> {
            UserBodyRequestPojoModel request = new UserBodyRequestPojoModel();
            request.setEmail("eve.holt@reqres.in");
            request.setPassword("pistol");
            response.set(given()
                    .spec(requestSpecification)
                    .body(request)
                    .when()
                    .post("/api/register")
                    .then()
                    .spec(responseSpecification)
                    .statusCode(200)
                    .extract()
                    .as(UserBodyResponsePojoModel.class));
        });
        step("Check that user is registered", () -> {
            assertThat(response.get().getId()).isEqualTo("4");
            assertThat(response.get().getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
        });
    }

    @Test
    @AllureId("12688")
    @DisplayName("Register user test - unsuccessful")
    @Tags({@Tag("Desktop"), @Tag("Main"), @Tag("Settings")})
    @Owner("allure8")
    void postRegisterUnsuccessful() {
        AtomicReference<UserBodyResponsePojoModel> response = new AtomicReference();

        step("Register user without password field filled", () -> {
            UserBodyRequestPojoModel request = new UserBodyRequestPojoModel();
            request.setEmail("sydney@fife");

            response.set(given()
                    .spec(requestSpecification)
                    .body(request)
                    .when()
                    .post("/api/register")
                    .then()
                    .spec(responseSpecification)
                    .statusCode(400)
                    .extract()
                    .as(UserBodyResponsePojoModel.class));
        });
        step("Check that user is not registered", () -> {
            assertThat(response.get().getError()).isEqualTo("Missing password");
        });
    }

    @Test
    @AllureId("12688")
    @DisplayName("Register user test - unsuccessful")
    @Tags({@Tag("Desktop"), @Tag("Main"), @Tag("Settings")})
    @Owner("allure8")
    void putUpdate() {
        AtomicReference<UserBodyResponsePojoModel> response = new AtomicReference();

        step("Register user without password field filled", () -> {
            PutUpdateRequestPojoModel request = new PutUpdateRequestPojoModel();
            request.setName("morpheus");
            request.setJob("zion resident");

            response.set(given()
                    .spec(requestSpecification)
                    .body(request)
                    .when()
                    .put("/api/users/2")
                    .then()
                    .spec(responseSpecification)
                    .statusCode(200)
                    .extract()
                    .as(UserBodyResponsePojoModel.class));
        });
        step("Check that user is not registered", () -> {
            assertThat(response.get().getName()).isEqualTo("morpheus");
            assertThat(response.get().getJob()).isEqualTo("zion resident");
        });
    }

    @Test
    @AllureId("12689")
    @DisplayName("Delete user test")
    @Tags({@Tag("User"), @Tag("Desktop")})
    @Owner("allure8")
    void delete() {
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
    @Tags({@Tag("Desktop"), @Tag("Search")})
    @Owner("allure8")
    void singleResource() {
        AtomicReference<UserBodyResponsePojoModel> response = new AtomicReference();
        step("Getting single resource", () -> {
            UserBodyRequestPojoModel request = new UserBodyRequestPojoModel();
            request.setEmail("eve.holt@reqres.in");
            request.setPassword("pistol");

            response.set(given()
                    .spec(requestSpecification)
                    .when()
                    .get("/api/unknown/2")
                    .then()
                    .spec(responseSpecification)
                    .statusCode(200)
                    .extract()
                    .as(UserBodyResponsePojoModel.class));
        });
        step("Checking that resource data is correct", () -> {
            assertThat(response.get().data.getId()).isEqualTo("2");
            assertThat(response.get().data.getName()).isEqualTo("fuchsia rose");
            assertThat(response.get().data.getYear()).isEqualTo("2001");
            assertThat(response.get().data.getColor()).isEqualTo("#C74375");
            assertThat(response.get().data.getPantone_value()).isEqualTo("17-2031");
            assertThat(response.get().support.getUrl()).isEqualTo("https://reqres.in/#support-heading");
            assertThat(response.get().support.getText()).isEqualTo("To keep ReqRes free, contributions towards server costs are appreciated!");
        });
    }
}

