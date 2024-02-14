package webflux.usecase;

import reactor.core.publisher.Flux;
import webflux.server.SearchRequestDTO;
import webflux.server.TripDTO;

public interface SearchUseCase {

    Flux<TripDTO> searchOn(SearchRequestDTO searchRequestDTO);

}
