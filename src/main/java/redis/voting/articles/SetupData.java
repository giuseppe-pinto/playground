package redis.voting.articles;

import java.util.List;

public class SetupData {
    private final RedisStorageRepository repository = new RedisStorageRepository();

    public SetupData() {
        repository.flushAll();
    }

    public void addObjects(List<Article> articleList){
        articleList.forEach(repository::save);
    }


    public void addSortedObjects(List<Article> articleList){
        repository.saveInOrderByTime(articleList);
        repository.saveInOrderByScore(articleList);
    }

}
