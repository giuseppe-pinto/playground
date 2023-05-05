package exercises.algorithms;

import java.util.Objects;

public class MaxSubArray {

    private final Integer maxLeft;
    private final Integer maxRight;
    private final Integer sum;

    private MaxSubArray(Integer maxLeft, Integer maxRight, Integer sum) {
        this.maxLeft = maxLeft;
        this.maxRight = maxRight;
        this.sum = sum;
    }

    public Integer getMaxLeft() {
        return maxLeft;
    }

    public Integer getMaxRight() {
        return maxRight;
    }

    public Integer getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "MaxSubArray{" +
                "maxLeft=" + maxLeft +
                ", maxRight=" + maxRight +
                ", sum=" + sum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaxSubArray that = (MaxSubArray) o;
        return Objects.equals(maxLeft, that.maxLeft) && Objects.equals(maxRight, that.maxRight) && Objects.equals(sum, that.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxLeft, maxRight, sum);
    }

    public static final class MaxSubArrayBuilder {
        private Integer maxLeft;
        private Integer maxRight;
        private Integer sum;

        public static MaxSubArrayBuilder aMaxSubArray() {
            return new MaxSubArrayBuilder();
        }

        public MaxSubArrayBuilder withMaxLeft(Integer maxLeft) {
            this.maxLeft = maxLeft;
            return this;
        }

        public MaxSubArrayBuilder withMaxRight(Integer maxRight) {
            this.maxRight = maxRight;
            return this;
        }

        public MaxSubArrayBuilder withSum(Integer sum) {
            this.sum = sum;
            return this;
        }

        public MaxSubArray build() {
            return new MaxSubArray(maxLeft, maxRight, sum);
        }
    }
}
