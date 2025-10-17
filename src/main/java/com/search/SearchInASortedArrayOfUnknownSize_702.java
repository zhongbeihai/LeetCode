package com.search;

 interface ArrayReader {
     int get(int index);
 }

public class SearchInASortedArrayOfUnknownSize_702 {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 1_0000;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == 2147483647) right = mid - 1;
            if (reader.get(mid) == target) return mid;
            if (reader.get(mid) > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
