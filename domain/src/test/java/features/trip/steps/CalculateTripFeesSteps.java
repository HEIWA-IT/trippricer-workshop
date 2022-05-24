package features.trip.steps;

import com.heiwait.tripagency.pricer.domain.error.BusinessErrors;
import com.heiwait.tripagency.pricer.domain.error.ErrorMessagesProperties;
import com.heiwait.tripagency.pricer.domain.*;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.vavr.control.Either;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTripFeesSteps {

    @Before
    public void setUp() {
        Locale usLocale = new Locale("en", "US");
        Locale.setDefault(usLocale);
    }

    @Given("the customer wants to travel to {string}")
    public void the_customer_wants_to_travel_to(String dest) {
        throw new PendingException();
    }

    @ParameterType(".*")
    public TravelClass travelClass(String travelClassName) {
        return TravelClass.valueOf(travelClassName);
    }

    @Given("the customer wants to travel in {travelClass} class")
    public void the_customer_wants_to_travel_in_class(TravelClass travelClass) {
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
    public void the_trip_price_is_€(Integer expectedPrice) {
        throw new PendingException();
    }

    @Then("the trip price returns the following message {string}")
    public void the_trip_price_returns_the_following_message(String expectedMessage) {
        throw new PendingException();
    }
}