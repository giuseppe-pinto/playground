package exercises.leetcode.designTwitter.port.out;

import exercises.leetcode.designTwitter.domain.TwitterPostRepositoryResult;
import exercises.leetcode.designTwitter.domain.Tweet;

import java.util.Collection;

public interface TwitterPostRepository {
    TwitterPostRepositoryResult save(Tweet tweet);

    Collection<Tweet> getAll();
}


