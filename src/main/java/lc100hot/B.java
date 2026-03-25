package lc100hot;

public class B {
    // nums = [2,3,1,1,4]
    // maxPos = {2, 3, 3, 3, 4]
    // end = {
    public int miniStep(int[] nums){
        int n = nums.length;
        int maxPos = 0, steps = 0, end = 0;

        for (int i = 0; i < n - 1; i++){
            maxPos = Math.max(maxPos, i + nums[i]);

            if (i == end){
                steps++;
                end = maxPos;
            }
        }

        return steps;
    }

    public int nextBigger(int n){
        n += 1;

        char[] s = String.valueOf(n).toCharArray();
        int len = s.length;

        for (int i = 1; i < len; i++) {
            if (s[i] == s[i - 1]){
                int j = 1;
                while(j >= 0 && s[j] == '9') j--;

                // all digits are 9
                if (j < 0){
                    StringBuilder sb = new StringBuilder();
                    sb.append('1');
                    for(int kk = 1; kk <= len; kk++){
                        if(sb.charAt(kk - 1) == '0') sb.append('1');
                        else sb.append('0');
                    }

                    return Integer.parseInt(sb.toString());
                }

                s[j]++;
                for(int kk = j + 1; kk < len; kk++){
                    for(char c = '0'; c <= '9'; c++){
                        if (c != s[kk - 1]){
                            s[kk] = c;
                            break;
                        }
                    }
                }

                i = 0;
            }
        }


        return Integer.parseInt(String.valueOf(s));
    }

    public static void main(String[] args) {
        B b = new B();
        // int r = b.miniStep(new int[]{2,3,1,1,4});

        int rr = b.nextBigger(1234);
        System.out.println(rr);
    }
}
