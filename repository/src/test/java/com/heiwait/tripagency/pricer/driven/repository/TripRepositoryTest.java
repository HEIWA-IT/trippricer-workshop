package com.heiwait.tripagency.pricer.driven.repository;

import com.heiwait.tripagency.pricer.domain.Destination;
import com.heiwait.tripagency.pricer.domain.Trip;
import com.heiwait.tripagency.pricer.domain.TripRepositoryPort;
import com.heiwait.tripagency.pricer.domain.error.BusinessErrors;
import com.heiwait.tripagency.pricer.driven.repository.config.AppConfig;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@TestPropertySource(locations = "classpath:test.properties")
class TripRepositoryTest {

    @Autowired
    @Qualifier("TripRepositoryJpaAdapter")
    private TripRepositoryPort tripRepositoryJpa;

    @Autowired
    @Qualifier("TripRepositoryJdbcTemplateAdapter")
    private TripRepositoryPort tripRepositoryJdbcTemplate;

    @Autowired
    @Qualifier("TripRepositoryMockAdapter")
    private TripRepositoryPort tripRepositoryMock;


    final Destination pari = new Destination("Pari");
    final Destination paris = new Destination("Paris");
    final Trip expectedTripForParis = new Trip(50, 800, 100);

    /**********************************************************************************************************************/
    @Test
    void should_find_a_trip_with_the_mock_adapter_and_a_valid_destination() {
        Either<BusinessErrors, Trip> parisTripEither = tripRepositoryMock.findTripByDestination(paris);

        Trip parisTrip = parisTripEither.get();

        assertThat(parisTrip.agencyFees()).isEqualTo(expectedTripForParis.agencyFees());
        assertThat(parisTrip.ticketPrice()).isEqualTo(expectedTripForParis.ticketPrice());
    }

    @Test
    void should_return_a_missing_destination_with_the_mock_adapter_and_a_missing_destination() {
        Either<BusinessErrors, Trip> pariTripEither = tripRepositoryMock.findTripByDestination(pari);
        assertThat(pariTripEither.getLeft()).isEqualTo(BusinessErrors.MISSING_DESTINATION);
    }

    /**********************************************************************************************************************/
    @Test
    void findTripByDestination_should_find_a_trip_with_the_jpa_adapter_and_a_valid_destination() {
        Either<BusinessErrors, Trip> parisTripEither = tripRepositoryJpa.findTripByDestination(paris);

        Trip parisTrip = parisTripEither.get();

        assertThat(parisTrip.agencyFees()).isEqualTo(expectedTripForParis.agencyFees());
        assertThat(parisTrip.ticketPrice()).isEqualTo(expectedTripForParis.ticketPrice());
    }

    @Test
    void should_return_a_missing_destination_with_the_jpa_adapter_and_a_missing_destination() {
        Either<BusinessErrors, Trip> pariTripEither = tripRepositoryJpa.findTripByDestination(pari);
        assertThat(pariTripEither.getLeft()).isEqualTo(BusinessErrors.MISSING_DESTINATION);
    }

    /**********************************************************************************************************************/
    @Test
    void should_find_a_trip_with_the_jdbc_adapter_and_a_valid_destination() {
        Either<BusinessErrors, Trip> parisTripEither = tripRepositoryJdbcTemplate.findTripByDestination(paris);
        Trip parisTrip = parisTripEither.get();

        assertThat(parisTrip.agencyFees()).isEqualTo(expectedTripForParis.agencyFees());
        assertThat(parisTrip.ticketPrice()).isEqualTo(expectedTripForParis.ticketPrice());
    }

    @Test
    void should_return_a_missing_destination_with_the_jdbc_adapter_and_a_missing_destination() {
        Either<BusinessErrors, Trip> pariTripEither = tripRepositoryJdbcTemplate.findTripByDestination(pari);
        assertThat(pariTripEither.getLeft()).isEqualTo(BusinessErrors.MISSING_DESTINATION);
    }
}