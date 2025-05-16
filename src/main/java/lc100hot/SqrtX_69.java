package lc100hot;

public class SqrtX_69 {
    public int mySqrt(int x) {
        int low = 1, high = x / 2 + 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            long p = (long) mid * mid;
            if (p == x) {
                return mid;
            }
            if (p < x){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        SqrtX_69 s = new SqrtX_69();
        s.mySqrt(2147395599);
    }
}
