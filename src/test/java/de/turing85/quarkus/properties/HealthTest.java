package de.turing85.quarkus.properties;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class HealthTest {
  @Test
  void healthTest() {
    // @formatter:off
    RestAssured
        .when().get("/q/health")
        .then()
            .body("checks.find { it.name = 'Database connections health check' }.status", is("UP"))
            .body("checks.find { it.name = 'Database connections health check' }.data.'<default>'", is("UP"));
    // @formatter:on
  }
}
