package exercises.leetcode.designTwitter.domain;

import java.util.*;

public class User {

    private final int id;
    private final Collection<User> followers = new HashSet<>();

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Collection<User> getFollowers() {
        return Set.copyOf(followers);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", followers=" + followers +
                '}';
    }

    public void add(User follower) {
        followers.add(follower);
    }
}
