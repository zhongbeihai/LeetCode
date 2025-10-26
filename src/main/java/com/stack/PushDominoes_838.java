package com.stack;

public class PushDominoes_838 {
    public String pushDominoes(String dominoes) {
        char[] dominoesArr = dominoes.toCharArray();
        int left = 0;

        for (int right = 1; right < dominoes.length(); right++){
            if (dominoesArr[right] == '.') continue;
            else if ((dominoesArr[left] == '.' && dominoesArr[right] == 'L')|| dominoesArr[left] == dominoesArr[right]) {
                while (left < right) dominoesArr[left++] = dominoesArr[right];
            } else if ((dominoesArr[left] == 'L' && dominoesArr[right] == 'R') ||
                    (dominoesArr[left] == '.' && dominoesArr[right] == 'R') ) {
                left = right;
            } else if (dominoesArr[left] == 'R' && dominoesArr[right] == 'L') {
                int r = right;
                while (left < r){
                    dominoesArr[left++] = 'R';
                    dominoesArr[r--] = 'L';
                }
                left = right;
            }
        }
        while (left + 1 < dominoesArr.length && dominoesArr[left] == 'R'){
            dominoesArr[++left] = 'R';
        }

        return String.valueOf(dominoesArr);
    }

    public static void main(String[] args) {
        PushDominoes_838 p = new PushDominoes_838();
        p.pushDominoes(".R..L.");
    }
}
