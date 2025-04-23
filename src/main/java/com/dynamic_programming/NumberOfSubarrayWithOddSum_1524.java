package com.dynamic_programming;

public class NumberOfSubarrayWithOddSum_1524 {
    public int numOfSubarrays(int[] arr) {
        int modulo = 1000000007;
        int n = arr.length;

        int[] odds = new int[n];
        int[] evens = new int[n];

        // Initialize the first element
        odds[0] = (arr[0] % 2 == 0) ? 0 : 1;
        evens[0] = (arr[0] % 2 == 0) ? 1 : 0;

        int result = odds[0]; // Store final result count

        for (int i = 1; i < n; i++) {
            if (arr[i] % 2 == 1) {  // If arr[i] is ODD
                odds[i] = evens[i - 1] + 1; // New odd subarrays from previous even
                evens[i] = odds[i - 1]; // Extending previous odd subarrays makes even
            } else {  // If arr[i] is EVEN
                odds[i] = odds[i - 1];  // Extending previous odd subarrays (no new odd)
                evens[i] = evens[i - 1] + 1; // Extending previous even subarrays
            }

            result = (result + odds[i]) % modulo; // Sum up all odd subarrays
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfSubarrayWithOddSum_1524 n = new NumberOfSubarrayWithOddSum_1524();
        n.numOfSubarrays(new int[]{1,2,3,4,5,6,7});
        // n.numOfSubarrays(new int[]{1,3,5});
    }
}
