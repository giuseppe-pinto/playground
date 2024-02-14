package webflux.drivers;

import reactor.core.publisher.Flux;
import webflux.model.SearchRequest;
import webflux.model.Trip;

public interface DriverRepository {

    Flux<Trip> performRequest(SearchRequest searchRequest);

}
