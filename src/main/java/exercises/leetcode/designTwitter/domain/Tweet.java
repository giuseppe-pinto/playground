package exercises.leetcode.designTwitter.domain;

import java.util.Objects;

public class Tweet {

    private final int userId;
    private final int tweetId;

    public Tweet(int userId, int tweetId) {
        this.userId = userId;
        this.tweetId = tweetId;
    }

    public int getUserId() {
        return userId;
    }

    public int getTweetId() {
        return tweetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet = (Tweet) o;
        return tweetId == tweet.tweetId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tweetId);
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "userId=" + userId +
                ", tweetId=" + tweetId +
                '}';
    }
}
