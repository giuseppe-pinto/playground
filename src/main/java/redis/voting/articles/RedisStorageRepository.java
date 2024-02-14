package redis.voting.articles;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisStorageRepository implements StorageRepository {

    JedisPool pool = new JedisPool("localhost", 6379);

    @Override
    public void save(Article article) {

        try (Jedis jedis = pool.getResource()) {
            Map<String, String> hash = new HashMap<>();
            hash.put("title", article.getTitle());
            hash.put("poster", article.getPoster());
            hash.put("url", article.getUrl());
            hash.put("votes", String.valueOf(article.getVotes()));
            hash.put("time", String.valueOf(article.getDate().atZone(ZoneId.systemDefault()).toEpochSecond()));
            jedis.hset("article:"+article.getId(), hash);
        }



    }

    @Override
    public void saveInOrderByTime(List<Article> articles) {


        try (Jedis jedis = pool.getResource()) {

            for (Article ar : articles) {
                jedis.zadd("time",
                        ar.getDate().atZone(ZoneId.systemDefault()).toEpochSecond(),
                        "article:"+ar.getId() );
            }

        }


    }

    @Override
    public void saveInOrderByScore(List<Article> articles) {

        try (Jedis jedis = pool.getResource()) {

            for (Article ar : articles) {
                jedis.zadd("score",
                        ar.getDate().atZone(ZoneId.systemDefault()).toEpochSecond() + (ar.getVotes() * 432L),
                        "article:"+ar.getId() );
            }

        }

    }

    @Override
    public void flushAll() {

        try (Jedis jedis = pool.getResource()) {
            jedis.flushAll();
        }

    }
}
