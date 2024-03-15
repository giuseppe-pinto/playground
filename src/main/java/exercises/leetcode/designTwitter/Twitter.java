package exercises.leetcode.designTwitter;

import exercises.leetcode.designTwitter.domain.Tweet;
import exercises.leetcode.designTwitter.domain.User;
import exercises.leetcode.designTwitter.port.out.TwitterPostRepository;
import exercises.leetcode.designTwitter.port.out.UserRepository;

import java.util.List;

public class Twitter {
    private final TwitterPostRepository twitterPostRepository;
    private final UserRepository userRepository;

    public Twitter(TwitterPostRepository twitterPostRepository, UserRepository userRepository) {
        this.twitterPostRepository = twitterPostRepository;
        this.userRepository = userRepository;
    }

    public void postTweet(int userId, int tweetId) {
        twitterPostRepository.save(new Tweet(userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {

        return null;
    }

    public void follow(int followerId, int followeeId) {
        User followee = userRepository.get(followeeId);
        User follower = userRepository.get(followerId);
        followee.add(follower);
    }

    public void unfollow(int followerId, int followeeId) {

    }


}
