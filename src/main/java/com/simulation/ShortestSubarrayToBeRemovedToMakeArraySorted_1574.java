package com.simulation;

public class ShortestSubarrayToBeRemovedToMakeArraySorted_1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 1;
        int fromLeft = 0, fromRight = n - 1;
        while (fromLeft + 1 < n && arr[fromLeft + 1] >= arr[fromLeft]){
            fromLeft++;
        }
        if(fromLeft == n - 1) return 0;

        while (fromRight - 1 >= 0 && arr[fromRight - 1] <= arr[fromRight]){
            fromRight--;
        }

        int i = 0;
        int res = Math.min(fromRight, n - fromLeft - 1);
        while (i <= fromLeft && fromRight < n){
            if(arr[i] <= arr[fromRight]){
                i++;
                res = Math.min(fromRight - i, res);
            }else {
                fromRight++;
            }

        }

        return res;
    }


    public static void main(String[] args) {
        ShortestSubarrayToBeRemovedToMakeArraySorted_1574 s = new ShortestSubarrayToBeRemovedToMakeArraySorted_1574();
        s.findLengthOfShortestSubarray(new int[]{10,13,17,21,15,15,9,17,22,22,13});
    }
}
