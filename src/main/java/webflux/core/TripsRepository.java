package webflux.core;

import reactor.core.publisher.Flux;
import webflux.model.SearchRequest;
import webflux.model.Trip;

public interface TripsRepository {

    Flux<Trip> getAll(SearchRequest searchRequest);

}

