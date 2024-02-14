package webflux.drivers;

import reactor.core.publisher.Flux;
import webflux.model.SearchRequest;
import webflux.model.Trip;

public class SabreRepository implements DriverRepository {
    @Override
    public Flux<Trip> performRequest(SearchRequest searchRequest) {
        return null;
    }
}
