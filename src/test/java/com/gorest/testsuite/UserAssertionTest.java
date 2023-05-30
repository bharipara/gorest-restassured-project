package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class UserAssertionTest extends TestBase {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI="https://gorest.co.in/public/v2";
        response = given()
                .when()
                .get("/users")
                .then().statusCode(200);

    }

//    1. Verify the if the total record is 20
    @Test
    public void test001(){
        response.body("user_id",equalTo(20));

    }
//            2. Verify the if the name of id = 2272644 is equal to "Aaratrika Namboothiri"
    @Test
    public void test002(){
        response.body("[0].name",equalTo("Ms. Bhaswar Kocchar"));

    }
//            3. Check the single ‘Name’ in the Array list ("Mrs. Saraswati Kapoor")
    @Test
    public void test003(){
        response.body("[2].name",equalTo("Rajendra Bhat"));

    }
//4. Check the multiple ‘Names’ in the ArrayList (Mrs. Menaka Bharadwaj, Msgr. Bodhan
//            Guha, Karthik Dubashi IV)
    @Test
    public void test004(){
        response.body("name",hasItems("Mrs. Menaka Bharadwaj", "Mrs. Bodhan + Guha", "Karthik Dubashi IV"));

    }
//5. Verify the emai of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void test005(){
     response.body("[4].email",equalTo("khan_phd_deven@gibson.test"));
    }
//            6. Verify the status is “Active” of user name is “Shanti Bhat V”
    @Test
    public void test006(){
      response.body("[4].status",equalTo("Active"));
    }
//            7. Verify the Gender = male of user name is “Niro Prajapat”
    @Test
    public void test007(){
   response.body("[2].gender",equalTo("male"));
    }
}
