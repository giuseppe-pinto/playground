package exercises.leetcode.designTwitter;

import exercises.leetcode.designTwitter.adapter.out.CollectionTwitterPostRepository;
import exercises.leetcode.designTwitter.domain.Tweet;
import exercises.leetcode.designTwitter.domain.TwitterPostRepositoryResult;
import exercises.leetcode.designTwitter.domain.TwitterPostRepositoryResultKO;
import exercises.leetcode.designTwitter.domain.TwitterPostRepositoryResultOK;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;


class CollectionTwitterPostRepositoryTest {

    private CollectionTwitterPostRepository sut;

    @BeforeEach
    void setUp() {
        sut = new CollectionTwitterPostRepository();
    }

    @Test
    void saveANewTweet() {

        Tweet tweet = new Tweet(1234, 6767);
        TwitterPostRepositoryResult actual = sut.save(tweet);
        assertThat(actual instanceof TwitterPostRepositoryResultOK).isTrue();
    }

    @Test
    void saveAndGetTweets() {

        Tweet firstTweet = new Tweet(1234, 6767);
        Tweet secondTweet = new Tweet(584, 7889);
        sut.save(firstTweet);
        sut.save(secondTweet);
        Collection<Tweet> actual = sut.getAll();
        assertThat(actual).containsExactlyInAnyOrder(firstTweet, secondTweet);
    }

    @Test
    void savingTheSameTweetIsNotPossible() {
        Tweet firstTweet = new Tweet(1234, 6767);
        Tweet secondTweet = new Tweet(1234, 6767);
        sut.save(firstTweet);
        TwitterPostRepositoryResult actual = sut.save(secondTweet);
        assertThat(actual instanceof TwitterPostRepositoryResultKO).isTrue();
        assertThat(sut.getAll().size()).isEqualTo(1);
    }


    @Test
    void savingTheSameTweetFromDifferentUserIsNotPossible() {
        Tweet firstTweet = new Tweet(1234, 6767);
        Tweet secondTweet = new Tweet(5698, 6767);
        sut.save(firstTweet);
        TwitterPostRepositoryResult actual = sut.save(secondTweet);
        assertThat(actual instanceof  TwitterPostRepositoryResultKO).isTrue();
        assertThat(sut.getAll().size()).isEqualTo(1);
    }


    @Test
    void savingDifferentTweetFromSameUser() {
        Tweet firstTweet = new Tweet(1234, 5656);
        Tweet secondTweet = new Tweet(1234, 6767);
        sut.save(firstTweet);
        sut.save(secondTweet);
        Collection<Tweet> actual = sut.getAll();
        assertThat(actual).containsExactlyInAnyOrder(firstTweet, secondTweet);
    }
}