package com.two_pointers;

public class MaximumSwap_670 {
    public int maximumSwap(int num) {
        String[] ss = String.valueOf(num).split("");
        Integer[] nums = new Integer[ss.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(ss[i]);
        }


        for(int l = 0; l < nums.length - 1; l++){
            int r = nums.length - 1, maxPlace = l;
            while (r >= l){
                if(nums[r] > nums[maxPlace]){
                    maxPlace = r;
                }
                r--;
            }
            if(nums[maxPlace] > nums[l]){
                int tem = nums[maxPlace];
                nums[maxPlace] = nums[l];
                nums[l] = tem;
                break;
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            sb.append(nums[i].toString());
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        MaximumSwap_670 m = new MaximumSwap_670();
        m.maximumSwap(9973);
    }

}
