package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class PostsAssertionTest extends TestBase {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI="https://gorest.co.in/public/v2";
        response = given()
                .when()
                .get("/posts")
                .then().statusCode(200);

    }

    //    1. Verify the if the total record is 25
    @Test
    public void test001() {
   response.body("size",equalTo(10));

    }

    // 2. Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demitto centum.”
    @Test
    public void test002() {
  response.body("[3].title",equalTo("Suadeo ducimus qui calculus creo viridis amplexus coadunatio."));
    }

    //3. Check the single user_id in the Array list (5522)
    @Test
    public void test003() {
     response.body("[1].user_id",equalTo(2272669));
    }

    //4. Check the multiple ids in the ArrayList (2693, 2684,2681)
    @Test
    public void test004() {
     response.body("user_id",hasItems( 2302162, 2272684, 2272684));
    }

    //5. Verify the body of userid = 2678 is equal “Carus eaque voluptatem. Calcar
    //    spectaculum coniuratio. Abstergo consequatur deleo. Amiculum advenio dolorem.
    //    Sollers conservo adiuvo. Concedo campana capitulus. Adfectus tibi truculenter.
    //    Canto temptatio adimpleo. Ter degenero animus. Adeo optio crapula. Abduco et
    //    antiquus. Chirographum baiulus spoliatio. Suscipit fuga deleo. Comburo aequus
    //    cuppedia. Crur cuppedia voluptates. Argentum adduco vindico. Denique undique
    //    adflicto. Assentator umquam pel."”

    @Test
    public void test005() {

    }

}
