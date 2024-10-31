package com.example.demo.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class HomeControllerSteps {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;

    @Given("the application is running")
    public void theApplicationIsRunning() {
        // This can be a no-op since the Spring context ensures the app runs
    }

    @When("the client calls GET \\/")
    public void theClientCallsGET() {
        response = restTemplate.getForEntity("/", String.class);
    }

    @Then("the client receives status code {int}")
    public void theClientReceivesStatusCode(int statusCode) {
        assertEquals(statusCode, response.getStatusCodeValue());
    }

    @Then("the client receives the message {string}")
    public void theClientReceivesTheMessage(String message) {
        assertEquals(message, response.getBody());
    }
}
