package webflux.core;

import reactor.core.publisher.Flux;
import webflux.drivers.*;
import webflux.model.SearchRequest;
import webflux.model.Trip;

import java.util.List;
import java.util.stream.Collectors;

public class StandardTripsRepository implements TripsRepository {

    @Override
    public Flux<Trip> getAll(SearchRequest searchRequest) {

        List<DriverRepository> drivers = assignDrivers();

        return Flux.merge(
                drivers
                        .stream()
                        .map(driver -> driver.performRequest(searchRequest))
                        .collect(Collectors.toList())
        );

    }

    private List<DriverRepository> assignDrivers() {
        return List.of(
                new TravelfusionRepository(),
                new AmadeusRepository(),
                new SabreRepository(),
                new KiwiRepository());
    }


}
