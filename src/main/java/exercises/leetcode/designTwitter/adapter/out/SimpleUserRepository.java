package exercises.leetcode.designTwitter.adapter.out;

import exercises.leetcode.designTwitter.domain.User;
import exercises.leetcode.designTwitter.port.out.UserRepository;

import java.util.List;

public class SimpleUserRepository implements UserRepository {

    private final List<User> users;

    public SimpleUserRepository(List<User> users) {
        this.users = users;
    }

    @Override
    public User get(int id) {
        return users.stream().filter(t -> t.getId() == id).toList().get(0);
    }
}
