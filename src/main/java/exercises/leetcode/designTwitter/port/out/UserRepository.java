package exercises.leetcode.designTwitter.port.out;


import exercises.leetcode.designTwitter.domain.User;

public interface UserRepository {
    User get(int id);
}
