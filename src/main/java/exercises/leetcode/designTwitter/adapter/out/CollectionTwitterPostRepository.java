package exercises.leetcode.designTwitter.adapter.out;

import exercises.leetcode.designTwitter.domain.TwitterPostRepositoryResult;
import exercises.leetcode.designTwitter.domain.TwitterPostRepositoryResultKO;
import exercises.leetcode.designTwitter.domain.TwitterPostRepositoryResultOK;
import exercises.leetcode.designTwitter.domain.Tweet;
import exercises.leetcode.designTwitter.port.out.TwitterPostRepository;

import java.util.Collection;
import java.util.HashSet;

public class CollectionTwitterPostRepository implements TwitterPostRepository {
    private final Collection<Tweet> tweetsContainer = new HashSet<>();

    @Override
    public TwitterPostRepositoryResult save(Tweet tweet) {
        return tweetsContainer.add(tweet) ?
                new TwitterPostRepositoryResultOK() :
                new TwitterPostRepositoryResultKO("Something went wrong during the saving of tweet "+ tweet.toString());
    }

    @Override
    public Collection<Tweet> getAll() {
        return tweetsContainer;
    }
}
