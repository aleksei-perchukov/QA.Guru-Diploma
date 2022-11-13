package api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.ApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class Specs {
    public static RequestSpecification requestSpecification = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .contentType(ContentType.JSON);
    public static ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
}
