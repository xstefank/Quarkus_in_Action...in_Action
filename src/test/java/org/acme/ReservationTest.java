package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.Map;

@QuarkusTest
public class ReservationTest {

    @Test
    public void testCreate() {
        Reservation reservation = new Reservation();
        reservation.customerName = "dummy";
        RestAssured.given()
                .body(reservation)
                .contentType("application/json")
                .when()
                .post("/reservation")
                .then()
                .statusCode(200);
    }
}
