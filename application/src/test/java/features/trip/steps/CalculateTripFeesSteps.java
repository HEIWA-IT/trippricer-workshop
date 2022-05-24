package features.trip.steps;

import com.heiwait.tripagency.pricer.domain.Destination;
import com.heiwait.tripagency.pricer.domain.PriceComputorDriverPort;
import com.heiwait.tripagency.pricer.domain.TravelClass;
import com.heiwait.tripagency.pricer.domain.error.BusinessErrors;
import com.heiwait.tripagency.pricer.domain.error.ErrorMessagesProperties;
import features.trip.config.AppConfig;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@CucumberContextConfiguration
@ContextConfiguration(classes = AppConfig.class)
@TestPropertySource(locations = "classpath:test.properties")
public class CalculateTripFeesSteps {

    @Autowired
    private PriceComputorDriverPort tripPricer;

    private Destination destination;
    private TravelClass travelClass;
    protected Integer agencyFees;
    protected Integer stayFees;
    protected Integer ticketPrice;

    private Either<BusinessErrors, Integer> computedPriceEither;
    private String errorMessage;

    @Before
    public void setUp() {
        Locale usLocale = new Locale("en", "US");
        Locale.setDefault(usLocale);
    }

    @Given("the customer wants to travel to {string}")
    public void the_customer_wants_to_travel_to(String dest) {
        new PendingException();
    }

    @ParameterType(".*")
    public TravelClass travelClass(String travelClassName) {
        return TravelClass.valueOf(travelClassName);
    }

    @Given("the customer wants to travel in {travelClass} class")
    public void the_customer_wants_to_travel_in_class(TravelClass travelClass) {
        new PendingException();
    }

    @Given("the economic travel ticket price is {int}€")
    public void the_economic_travel_ticket_price_is_€(int ticketPrice) {
        new PendingException();
    }

    @Given("the stay fees are {int}€")
    public void the_stay_fees_are_€(Integer stayFees) {
        new PendingException();
    }

    @Given("the agency fees are {int}€")
    public void the_agency_fees_are_€(Integer agencyFees) {
        new PendingException();
    }

    @When("the customer asked for the trip price")
    public void the_customer_asked_for_the_trip_price() {
        new PendingException();
    }

    @Then("the trip price is {int}€")
    public void the_trip_price_is_€(Integer expectedPrice) {
        new PendingException();
    }

    @Then("the trip price returns the following message {string}")
    public void the_trip_price_returns_the_following_message(String expectedMessage) {
        new PendingException();
    }
}