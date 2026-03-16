package lc100hot;

public class Mahjong {
    boolean win(int[] nums){
        int[] cnt = new int[10];
        for (int num: nums) cnt[num]++;

        for (int i = 0; i < 10; i++) {
            if (cnt[i] >= 2){
                cnt[i] -= 2;
                if (dfs(cnt)) return true;
                cnt[i] += 2;
            }
        }

        return false;
    }

    public boolean dfs(int[] cnt){
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            if (cnt[i] != 0) {
                flag = false;
                break;
            }
        }
        if (flag) return true;

        for (int i = 0; i < 10; i++) {
            if (cnt[i] >= 3){
                cnt[i] -= 3;
                if (dfs(cnt)) return true;
                cnt[i] += 3;
            }

            if (i + 2 <= 9 && cnt[i] >= 1 && cnt[i + 1] >= 1 && cnt[i + 2] >= 1){
                cnt[i] -=1;
                cnt[i + 1] -= 1;
                cnt[i + 2] -= 1;
                if (dfs(cnt)) return true;
                cnt[i] += 1;
                cnt[i + 1] += 1;
                cnt[i + 2] += 1;
            }
        }

        return false;
    }

}
