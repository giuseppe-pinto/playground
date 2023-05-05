package exercises.algorithms;

import exercises.algorithms.MaxSubArray.MaxSubArrayBuilder;

import static exercises.algorithms.MaxSubArray.MaxSubArrayBuilder.*;

public class FindMaximumSubArray {

    public MaxSubArray execute(Integer[] array, int low, int high){

        if( high == low){
            return aMaxSubArray()
                    .withMaxLeft(low)
                    .withMaxRight(high)
                    .withSum(array[low])
                    .build();
        } else {

            int mid = (low + high) / 2; //floor of x
            MaxSubArray leftMaxSubArray = execute(array, low, mid);
            MaxSubArray rightMaxSubArray = execute(array, mid+1, high);
            MaxSubArray crossMidSubArray = findMaxCrossingSubArray(array, low, mid, high);

            if(leftMaxSubArray.getSum() >= rightMaxSubArray.getSum() &&
                    leftMaxSubArray.getSum() >= crossMidSubArray.getSum()){
                return leftMaxSubArray;
            } else if (rightMaxSubArray.getSum() >= leftMaxSubArray.getSum() &&
                    rightMaxSubArray.getSum() >= crossMidSubArray.getSum()) {
                return rightMaxSubArray;
            } else {
                return crossMidSubArray;
            }

        }
    }


    private MaxSubArray findMaxCrossingSubArray(Integer[] array, int low, int mid, int high){
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        MaxSubArrayBuilder result = aMaxSubArray();

        for (int i = mid; i >= low; i--) {
            sum = sum + array[i];
            if(sum > leftSum){
                leftSum = sum;
                result.withMaxLeft(i);
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;

        for (int j = mid + 1; j <= high; j++) {

            sum = sum + array[j];
            if(sum > rightSum){
                rightSum = sum;
                result.withMaxRight(j);
            }

        }

        return result.withSum(leftSum + rightSum).build();

    }


}
