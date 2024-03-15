package exercises.leetcode.designTwitter;

import exercises.leetcode.designTwitter.adapter.out.SimpleUserRepository;
import exercises.leetcode.designTwitter.domain.Tweet;
import exercises.leetcode.designTwitter.domain.TwitterPostRepositoryResult;
import exercises.leetcode.designTwitter.domain.TwitterPostRepositoryResultOK;
import exercises.leetcode.designTwitter.domain.User;
import exercises.leetcode.designTwitter.port.out.TwitterPostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TwitterTest {

    private static final int USER_ID = 1234;
    private static final int TWEET_ID = 8989;
    private SimpleUserRepository simpleUserRepository;
    private FakeTwitterPostRepository twitterPostRepository;
    private Twitter sut;

    @BeforeEach
    void setUp() {
        this.twitterPostRepository = new FakeTwitterPostRepository();
        this.simpleUserRepository = new SimpleUserRepository(List.of(new User(6789), new User(1234), new User(1030)));
        this.sut = new Twitter(twitterPostRepository, simpleUserRepository);
    }

    @Test
    void postTweet() {
        sut.postTweet(USER_ID, TWEET_ID);
        assertThat(twitterPostRepository.isTweetSaved()).isTrue();
    }

    @Test
    void follow() {
        //6789 has 2 followers
        sut.follow(1234, 6789);
        sut.follow(1030, 6789);
        Collection<User> followers = simpleUserRepository.get(6789).getFollowers();
        assertThat(followers).containsExactlyInAnyOrder(new User(1234), new User(1030));
    }

    private class FakeTwitterPostRepository implements TwitterPostRepository {

        private boolean tweetSaved = false;

        @Override
        public TwitterPostRepositoryResult save(Tweet tweet) {
            tweetSaved = true;
            return new TwitterPostRepositoryResultOK();
        }

        @Override
        public List<Tweet> getAll() {
            return null;
        }

        public boolean isTweetSaved() {
            return tweetSaved;
        }
    }

}