package redis.voting.articles;

import java.util.List;

public interface StorageRepository {
    void save(Article article);

    void saveInOrderByTime(List<Article> article);
    void saveInOrderByScore(List<Article> article);

    void flushAll();

}
