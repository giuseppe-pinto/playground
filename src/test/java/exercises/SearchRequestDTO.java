package exercises;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@Builder
public class SearchRequestDTO {
    private final String departure;
    private final String arrival;
    private final String departureDate;
    private final String returnDate;
}
