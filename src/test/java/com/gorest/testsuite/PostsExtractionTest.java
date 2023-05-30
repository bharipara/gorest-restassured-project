package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostsExtractionTest extends TestBase {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI="https://gorest.co.in/public/v2";
        response = given()
                .when()
                .get("/posts")
                .then().statusCode(200);

    }

    //    1. Extract the title
    @Test
    public void test001() {

            List<String> title = response.extract().path("title");

            System.out.println("------------------StartingTest---------------------------");
            System.out.println("The value of title is : " + title);
            System.out.println("------------------End of Test---------------------------");


        }

    //2. Extract the total number of record
    @Test
    public void test002() {
        List<Integer> total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //3. Extract the body of 15th record
    @Test
    public void test003() {
        List<String> body = response.extract().path("body");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of body is : " + body);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the user_id of all the records
    @Test
    public void test004() {
        List<Integer> userId = response.extract().path("user_id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of userid are : " + userId);
        System.out.println("------------------End of Test---------------------------");
    }



    //5. Extract the title of all the records
    @Test
    public void test005() {
        List<String> title = response.extract().path("title");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the tile of all : " + title);
        System.out.println("------------------End of Test---------------------------");
    }


    //6. Extract the title of all records whose user_id = 5456
    @Test
    public void test006() {
        String titleOfUserId = response.extract().path("[4].title");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the title of all : " + titleOfUserId);
        System.out.println("------------------End of Test---------------------------");
    }

    //7. Extract the body of all records whose id = 2671
    @Test
    public void test007() {
        String bodyOfUserId = response.extract().path("[5].body");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the body of all : " + bodyOfUserId);
        System.out.println("------------------End of Test---------------------------");
    }
}
