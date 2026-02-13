package lc100hot;

public class FindCloestNumberToZero_2239 {
    public int findClosestNumber(int[] nums) {
        int closestNum = Integer.MAX_VALUE;

        for (int num: nums){
            if (Math.abs(num) < Math.abs(closestNum) || (Math.abs(num) == Math.abs(closestNum) && num > closestNum)) closestNum = num;
        }

        return closestNum;
    }
}
