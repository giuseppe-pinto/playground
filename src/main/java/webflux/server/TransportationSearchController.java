package webflux.server;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import webflux.usecase.SearchUseCase;
import webflux.usecase.StandardSearchUseCase;

public class TransportationSearchController {

    SearchUseCase searchUseCase = new StandardSearchUseCase();

    @PostMapping("/search")
    public Flux<TripDTO> getEmployeeById(@RequestBody SearchRequestDTO searchRequest) {
        return searchUseCase.searchOn(searchRequest);
    }



}
