package features.trip.steps;

import com.heiwait.tripagency.pricer.domain.*;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTripFeesSteps {

    private String destination;
    private TravelClass travelClass;
    private Integer ticketPrice;
    private Integer stayFees;
    private Integer agencyFees;

    private Integer computedTripPrice;

    @Before
    public void setUp() {
        Locale usLocale = new Locale("en", "US");
        Locale.setDefault(usLocale);
    }

    @Given("the customer wants to travel to {string}")
    public void the_customer_wants_to_travel_to(String dest) {
        this.destination = dest;
    }

    @ParameterType(".*")
    public TravelClass travelClass(String travelClassName) {
        return TravelClass.valueOf(travelClassName);
    }

    @Given("the customer wants to travel in {travelClass} class")
    public void the_customer_wants_to_travel_in_class(TravelClass travelClass) {
        this.travelClass = travelClass;
    }

    @Given("the economic travel ticket price is {int}€")
    public void the_economic_travel_ticket_price_is_€(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Given("the stay fees are {int}€")
    public void the_stay_fees_are_€(Integer stayFees) {
        this.stayFees = stayFees;
    }

    @Given("the agency fees are {int}€")
    public void the_agency_fees_are_€(Integer agencyFees) {
        this.agencyFees = agencyFees;
    }

    @When("the customer asked for the trip price")
    public void the_customer_asked_for_the_trip_price() {
        TripPricer pricer = new TripPricer();

        computedTripPrice = pricer.priceTrip(this.ticketPrice, this.travelClass.coefficient(), this.stayFees, this.agencyFees);
    }

    @Then("the trip price is {int}€")
    public void the_trip_price_is_€(Integer expectedPrice) {
        assertThat(expectedPrice).isEqualTo(computedTripPrice);
    }

    @Then("the trip price returns the following message {string}")
    public void the_trip_price_returns_the_following_message(String expectedMessage) {
        throw new PendingException();
    }
}