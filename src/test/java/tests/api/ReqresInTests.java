package tests.api;

import helpers.mobile.models.PutUpdateRequestPojoModel;
import helpers.mobile.models.UserBodyRequestPojoModel;
import helpers.mobile.models.UserBodyResponsePojoModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static helpers.mobile.models.Specs.requestSpecification;
import static helpers.mobile.models.Specs.responseSpecification;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("API")
@DisplayName("API - Reqres.in Tests")
public class ReqresInTests {
    @DisplayName("Register user test - successful")
    @Test
    void postRegisterSuccessful() {

        UserBodyRequestPojoModel request = new UserBodyRequestPojoModel();
        request.setEmail("eve.holt@reqres.in");
        request.setPassword("pistol");

        UserBodyResponsePojoModel response = given()
                .spec(requestSpecification)
                .body(request)
                .when()
                .post("/api/register")
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .extract()
                .as(UserBodyResponsePojoModel.class);

        assertThat(response.getId()).isEqualTo("4");
        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");

    }

    @DisplayName("Register user test - unsuccessful")
    @Test
    void postRegisterUnsuccessful() {

        UserBodyRequestPojoModel request = new UserBodyRequestPojoModel();
        request.setEmail("sydney@fife");

        UserBodyResponsePojoModel response = given()
                .spec(requestSpecification)
                .body(request)
                .when()
                .post("/api/register")
                .then()
                .spec(responseSpecification)
                .statusCode(400)
                .extract()
                .as(UserBodyResponsePojoModel.class);

        assertThat(response.getError()).isEqualTo("Missing password");
    }

    @DisplayName("Put update test")
    @Test
    void putUpdate() {

        PutUpdateRequestPojoModel request = new PutUpdateRequestPojoModel();
        request.setName("morpheus");
        request.setJob("zion resident");

        UserBodyResponsePojoModel response = given()
                .spec(requestSpecification)
                .body(request)
                .when()
                .put("/api/users/2")
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .extract()
                .as(UserBodyResponsePojoModel.class);

        assertThat(response.getName()).isEqualTo("morpheus");
        assertThat(response.getJob()).isEqualTo("zion resident");
    }

    @DisplayName("Delete user test")
    @Test
    void delete() {
        given()
                .spec(requestSpecification)
                .when()
                .delete("/api/users/2")
                .then()
                .spec(responseSpecification)
                .statusCode(204);
    }

    @DisplayName("Single resource test")
    @Test
    void singleResource() {

        UserBodyRequestPojoModel request = new UserBodyRequestPojoModel();
        request.setEmail("eve.holt@reqres.in");
        request.setPassword("pistol");

        UserBodyResponsePojoModel response = given()
                .spec(requestSpecification)
                .when()
                .get("/api/unknown/2")
                .then()
                .spec(responseSpecification)
                .statusCode(200)
                .extract()
                .as(UserBodyResponsePojoModel.class);

        assertThat(response.data.getId()).isEqualTo("2");
        assertThat(response.data.getName()).isEqualTo("fuchsia rose");
        assertThat(response.data.getYear()).isEqualTo("2001");
        assertThat(response.data.getColor()).isEqualTo("#C74375");
        assertThat(response.data.getPantone_value()).isEqualTo("17-2031");
        assertThat(response.support.getUrl()).isEqualTo("https://reqres.in/#support-heading");
        assertThat(response.support.getText()).isEqualTo("To keep ReqRes free, contributions towards server costs are appreciated!");
    }
}

