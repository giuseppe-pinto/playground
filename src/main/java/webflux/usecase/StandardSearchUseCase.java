package webflux.usecase;

import reactor.core.publisher.Flux;
import webflux.core.StandardTripsRepository;
import webflux.core.TripsRepository;
import webflux.server.SearchRequestDTO;
import webflux.server.TripDTO;

import java.util.List;

public class StandardSearchUseCase implements SearchUseCase {

    private final RequestAdapter requestAdapter = new RequestAdapter();
    private final TripDTOAdapter tripDTOAdapter = new TripDTOAdapter();
    private final StandardTripsRepository tripsRepository = new StandardTripsRepository();


    @Override
    public Flux<TripDTO> searchOn(SearchRequestDTO searchRequestDTO) {


        return tripDTOAdapter.from(
                tripsRepository.getAll(
                        requestAdapter.from(searchRequestDTO)));

    }


}
