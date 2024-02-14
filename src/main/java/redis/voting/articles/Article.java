package redis.voting.articles;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Article {
    private final String id;
    private final String title;
    private final String url;
    private final String poster;
    private final LocalDateTime date;
    private final int votes;
}
