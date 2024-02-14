package exercises;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class TestMainApp {


    public static void main(String[] args) throws InterruptedException {


        WebClient webClient = WebClient
                .create("http://127.0.0.1:8080");

        System.out.println("Ciao");

        webClient.post()
                .uri("/aggregator/search")
                .bodyValue(SearchRequestDTO.builder()
                        .departure("MIL")
                        .arrival("NAP")
                        .departureDate("2024-01-04")
                        .returnDate("2024-01-10")
                        .build())
                .exchangeToFlux(data -> {
                    System.out.println(data.statusCode());
                    System.out.println(data.toString());
                    return Flux.just(data);
                })
                .subscribe();

        //System.out.println(block1);


        List block2 = webClient.post()
                .uri("/aggregator/search")
                .bodyValue(SearchRequestDTO.builder()
                        .departure("MIL")
                        .arrival("NAP")
                        .departureDate("2024-01-04")
                        .returnDate("2024-01-10")
                        .build())
                .retrieve()
                .bodyToMono(List.class)
                .block();

        System.out.println(block2);




                //new ParameterizedTypeReference<List<TripDTO>>() {}

    }


    private static ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            log.info("Response status: {}", clientResponse.statusCode());
            clientResponse.headers().asHttpHeaders().forEach((name, values) -> values.forEach(value -> log.info("{}={}", name, value)));
            return Mono.just(clientResponse);
        });
    }
}
