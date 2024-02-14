package redis.voting.articles;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        SetupData setupData = new SetupData();


        Article firstArticle = Article
                .builder()
                .id("100408")
                .title("Better performance")
                .url("http://macheneso.it")
                .poster("Giuseppe")
                .votes(3)
                .date(LocalDateTime.of(2023, Month.NOVEMBER, 13, 8, 0))
                .build();


        Article secondArticle = Article
                .builder()
                .id("100635")
                .title("Better scalability")
                .url("http://boooh.it")
                .poster("Vincenzo")
                .votes(10)
                .date(LocalDateTime.of(2023, Month.NOVEMBER, 13, 9, 0))
                .build();


        Article thirdArticle = Article
                .builder()
                .id("100716")
                .title("Better Code")
                .url("http://ciaociao.it")
                .poster("Antonio")
                .votes(0)
                .date(LocalDateTime.of(2023, Month.NOVEMBER, 13, 10, 0))
                .build();

        List<Article> articleList = List.of(firstArticle, secondArticle, thirdArticle);

        setupData.addObjects(articleList);
        setupData.addSortedObjects(articleList);
    }

}
