package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest extends TestBase {
    static ValidatableResponse response;
    @BeforeClass

    public static void inIt() {

        RestAssured.baseURI="https://gorest.co.in/public/v2";
        response = given()
                .when()
                .get("/users")
                .then().statusCode(200);

    }

//    1. Extract the All Ids
    @Test
    public void test001(){
        List<Integer> ids = response.extract().path("id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of all Ids is : " + ids);
        System.out.println("------------------End of Test---------------------------");


    }
//2. Extract the all Names
    @Test
    public void test002(){
        List<String> names = response.extract().path("name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of all names are : " + names);
        System.out.println("------------------End of Test---------------------------");

    }
//3. Extract the name of 5th object
    @Test
    public void test003(){
        String name = response.extract().path("[5].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the name of 5th is : " + name);
        System.out.println("------------------End of Test---------------------------");

    }
//
//4. Extract the names of all object whose status = inactive
    @Test
    public void test004(){
        boolean status = response.extract().path("status").equals("inactive");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all object whose status inactive : " + status);
        System.out.println("------------------End of Test---------------------------");

    }
//5. Extract the gender of all the object whose status = active
    @Test
    public void test005(){
        List<String> status = response.extract().path("status");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all object whose status active : " + status);
        System.out.println("------------------End of Test---------------------------");

    }
//6. Print the names of the object whose gender = female
    @Test
    public void test006(){
        boolean status = response.extract().path("name").equals("female");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all object whose status female : " + status);
        System.out.println("------------------End of Test---------------------------");
    }
//7. Get all the emails of the object where status = inactive
    @Test
    public void test007(){
        List<String> email = response.extract().path("email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The emails of the object where status inactive : " + email);
        System.out.println("------------------End of Test---------------------------");
    }
//8. Get the ids of the object where gender = male
    @Test
    public void test008(){
        List<String> gender = response.extract().path("gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all object whose status inactive : " + gender);
        System.out.println("------------------End of Test---------------------------");

    }
//9. Get all the status
    @Test
    public void test009(){
        List<String> status = response.extract().path("status");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The get all the status : " + status);
        System.out.println("------------------End of Test---------------------------");

    }
//10. Get email of the object where name = Karthik Dubashi IV
    @Test
    public void test010(){
       String email = response.extract().path("[3].email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("get email of the object is : " + email);
        System.out.println("------------------End of Test---------------------------");

    }
//11. Get gender of id = 5471
    @Test
    public void test011(){
        String genderOfId = response.extract().path("[4].gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get gender of id is : " + genderOfId);
        System.out.println("------------------End of Test---------------------------");


    }
}
