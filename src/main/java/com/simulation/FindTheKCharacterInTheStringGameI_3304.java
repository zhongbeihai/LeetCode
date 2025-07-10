package com.simulation;

public class FindTheKCharacterInTheStringGameI_3304 {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");

        while (sb.length() < k){
            char[] arr = sb.toString().toCharArray();
            for (int i = 0; i < arr.length; i++){
                arr[i] = (char) (((arr[i] - 'a' + 1) % 26) + 'a');
            }
            sb.append(arr);
        }

        return sb.charAt(k - 1);
    }

    public static void main(String[] args) {
        FindTheKCharacterInTheStringGameI_3304 f = new FindTheKCharacterInTheStringGameI_3304();
        f.kthCharacter(5);
    }
}
