package webflux.usecase;

import webflux.model.SearchRequest;
import webflux.server.SearchRequestDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class RequestAdapter {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");

    public SearchRequest from(SearchRequestDTO searchRequestDTO){

        return SearchRequest.builder()
                .departure(searchRequestDTO.getDeparture())
                .arrival(searchRequestDTO.getArrival())
                .departureDate(LocalDate.parse(searchRequestDTO.getDepartureDate(), formatter))
                .returnDate(LocalDate.parse(searchRequestDTO.getReturnDate(), formatter))
                .build();
    }

}
