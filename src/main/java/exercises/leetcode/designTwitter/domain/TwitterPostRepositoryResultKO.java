package exercises.leetcode.designTwitter.domain;

public final class TwitterPostRepositoryResultKO extends TwitterPostRepositoryResult {

    private final String errorMessage;

    public TwitterPostRepositoryResultKO(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
