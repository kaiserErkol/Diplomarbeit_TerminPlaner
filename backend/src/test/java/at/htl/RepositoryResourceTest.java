package at.htl;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@QuarkusTest
public class RepositoryResourceTest {

    @Test
    public void testGetAllKunden() {
        RestAssured.given()
                .when().get("/api/kunden")
                .then()
                .statusCode(200)
                .body("$", hasSize(greaterThan(0))); // Prüft, dass das Ergebnis ein nicht-leeres Array ist
    }

    @Test
    public void testGetAllFeedback() {
        RestAssured.given()
                .when().get("/api/feedback")
                .then()
                .statusCode(200)
                .body("$", hasSize(greaterThan(0)));
    }

    @Test
    public void testGetAllFahrzeuge() {
        RestAssured.given()
                .when().get("/api/fahrzeuge")
                .then()
                .statusCode(200)
                .body("$", hasSize(greaterThan(0)));
    }

    @Test
    public void testGetAllKostenvorschlag() {
        RestAssured.given()
                .when().get("/api/kostenvorschlag")
                .then()
                .statusCode(200)
                .body("$", hasSize(greaterThan(0)));
    }

    @Test
    public void testGetAllMechaniker() {
        RestAssured.given()
                .when().get("/api/mechaniker")
                .then()
                .statusCode(200)
                .body("$", hasSize(greaterThan(0)));
    }

    @Test
    public void testGetAllReparaturtyp() {
        RestAssured.given()
                .when().get("/api/reparaturtyp")
                .then()
                .statusCode(200)
                .body("$", hasSize(greaterThan(0)));
    }

    @Test
    public void testGetAllTermine() {
        RestAssured.given()
                .when().get("/api/termin")
                .then()
                .statusCode(200)
                .body("$", hasSize(greaterThan(0)));
    }

    @Test
    public void testGetAllTerminvorschlag() {
        RestAssured.given()
                .when().get("/api/terminvorschlag")
                .then()
                .statusCode(200)
                .body("$", hasSize(greaterThan(0)));
    }

    @Test
    public void testGetAllVerwalter() {
        RestAssured.given()
                .when().get("/api/verwalter")
                .then()
                .statusCode(200)
                .body("$", hasSize(greaterThan(0)));
    }

    @Test
    public void testGetAllReparatur() {
        RestAssured.given()
                .when().get("/api/reparatur")
                .then()
                .statusCode(200)
                .body("$", hasSize(greaterThan(0)));
    }
}
