package webflux.usecase;

import reactor.core.publisher.Flux;
import webflux.model.Trip;
import webflux.server.TripDTO;

import java.time.format.DateTimeFormatter;

public class TripDTOAdapter {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");

    Flux<TripDTO> from(Flux<Trip> trips){

        return trips.map(trip ->
                TripDTO.builder()
                        .identifier(String.join( "|",
                                trip.getDeparture(),
                                trip.getArrival(),
                                trip.getDepartureDate().format(formatter),
                                trip.getArrivalDate().format(formatter),
                                trip.getAirline(),
                                trip.getFlightNumber(),
                                trip.getPrice().toString(),
                                trip.getCurrency().getCurrencyCode(),
                                trip.getDriver().name()))
                        .build());

    }

}
