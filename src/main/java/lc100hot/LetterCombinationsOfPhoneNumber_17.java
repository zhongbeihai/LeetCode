package lc100hot;

import java.util.*;

/**
 * backtrack
 */
public class LetterCombinationsOfPhoneNumber_17 {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        HashMap<Integer, List<Character>> phoneKeyPad = new HashMap<>();
        phoneKeyPad.put(2, Arrays.asList('a', 'b', 'c'));
        phoneKeyPad.put(3, Arrays.asList('d', 'e', 'f'));
        phoneKeyPad.put(4, Arrays.asList('g', 'h', 'i'));
        phoneKeyPad.put(5, Arrays.asList('j', 'k', 'l'));
        phoneKeyPad.put(6, Arrays.asList('m', 'n', 'o'));
        phoneKeyPad.put(7, Arrays.asList('p', 'q', 'r', 's'));
        phoneKeyPad.put(8, Arrays.asList('t', 'u', 'v'));
        phoneKeyPad.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        backtrack(phoneKeyPad, digits, 0, new StringBuilder());

        return res;
    }

    public void backtrack(Map<Integer, List<Character>> map, String digits, int pos, StringBuilder tem) {
        if (pos == digits.length()) {
            res.add(tem.toString());
            return;
        }

        int curDigit = Integer.parseInt(String.valueOf(digits.charAt(pos)));
        List<Character> dic = map.get(curDigit);
        for (char c : dic) {
            tem.append(c);

            backtrack(map, digits, pos + 1, tem);

            tem.deleteCharAt(tem.length() - 1);
        }
    }
}

