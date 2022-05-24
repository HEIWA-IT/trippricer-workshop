package features.trip.steps;

import com.heiwait.tripagency.pricer.driver.exposition.ExpositionApplication;
import com.heiwait.tripagency.pricer.domain.error.ErrorMessagesProperties;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.net.HttpURLConnection;
import java.util.Locale;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@CucumberContextConfiguration
@ContextConfiguration(classes = ExpositionApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class CalculateTripFeesSteps {
    private final static String BUSINESS_ERRORS_CODE_KEY = "code";
    private Response response;

    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        Locale usLocale = new Locale("en", "US");
        Locale.setDefault(usLocale);

        RestAssured.port = port;
    }

    @Given("the customer wants to travel to {string}")
    public void the_customer_wants_to_travel_to(String dest) {
        throw new PendingException();
    }

    @Given("the customer wants to travel in {} class")
    public void the_customer_wants_to_travel_in_class(String travelClass) {
        throw new PendingException();
    }

    @Given("the economic travel ticket price is {int}€")
    public void the_economic_travel_ticket_price_is_€(int ticketPrice) {
        throw new PendingException();
    }

    @Given("the stay fees are {int}€")
    public void the_stay_fees_are_€(Integer stayFees) {
        throw new PendingException();
    }

    @Given("the agency fees are {int}€")
    public void the_agency_fees_are_€(Integer agencyFees) {
        throw new PendingException();
    }

    @When("the customer asked for the trip price")
    public void the_customer_asked_for_the_trip_price() {
        throw new PendingException();
    }

    @Then("the trip price is {int}€")
    public void the_trip_price_is_€(Integer expectedPrice) {throw new PendingException();
    }

    @Then("the trip price returns the following message {string}")
    public void the_trip_price_returns_the_following_message(String expectedMessage){
        throw new PendingException();
    }

    private String errorMessageFromResponse(String responseAsString){
        String errorCode = JsonPath.from(responseAsString).get(BUSINESS_ERRORS_CODE_KEY);
        return ErrorMessagesProperties.getErrorMessageFromErrorCode(errorCode);
    }
}