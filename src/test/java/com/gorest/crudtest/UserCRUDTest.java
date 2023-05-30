package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import com.gorest.utils.TestUtils;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasValue;

public class UserCRUDTest extends TestBase {
    static String name = "PrimeUser";
    static String email = TestUtils.getRandomValue() + "xyz@gmail.com";
    static String gender = "male";
    static String status = "active";

//    @BeforeClass
//    public static void inIt() {
//        RestAssured.baseURI = "https://gorest.co.in/public/v2";
//        RestAssured.basePath = "/users";
//       // RestAssured.authentication = "8eb0757e7b3e6a8597375b31aa300d95f1096f568de7d4c950728defe4d3e8a1";
//    }

    @Test
    public void test001() {

        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);
        Response response = given()
//                .contentType(ContentType.JSON)
                .header("Content-Type","application/json")
                .header("Connection","keep-alive")
                .header("Authorization","Bearer b68804a565ce64279752413286834ff14f9d23abf9dc7dd8ed765b05b051f7e4")
                .when()
                .body(userPojo)
                .post("/users");
        response.then().log().all().statusCode(201);

    }
    @Test
    public void test002() {
        String s1 = "findAll{it.name == '";
        String s2 = "'}.get(0)";
        HashMap<String, Objects> userMap = given()
                .header("Authorization","Bearer b68804a565ce64279752413286834ff14f9d23abf9dc7dd8ed765b05b051f7e4")
                .header("Connection","keep-alive")
                .when()
                .get("/users")
                .then().statusCode(200)
                .extract()
                .path(s1 + name + s2);
        Assert.assertThat(userMap,hasValue(name));


    }

    @Test
    public void test003() {
        UserPojo userPojo = new UserPojo();
        userPojo.setStatus("active");
        userPojo.setName("Jenny");
        userPojo.setEmail("Prime12@gmail.com");
        userPojo.setGender("female");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer b68804a565ce64279752413286834ff14f9d23abf9dc7dd8ed765b05b051f7e4")
                .header("Connection", "keep-alive")
                .pathParam("id", 2326787)
                .when()
                .body(userPojo)
                .put("/users/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void test004() {
        given()
                .header("Connection","keep-alive")
                .header("Authorization","Bearer b68804a565ce64279752413286834ff14f9d23abf9dc7dd8ed765b05b051f7e4")
                .header("Connection", "keep-alive")
                .pathParam("id",2326787)
                .when()
                .delete("/users/{id}")
                .then()
                .statusCode(204);



    }
    }

