package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress_93 {
    private List<List<String>> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, new ArrayList<>(), 0);
        for (List<String> cur: res){
            StringBuilder o = new StringBuilder();
            o.append(cur.get(0));
            for (int i = 1; i < 4; i++){
                o.append(".");
                o.append(cur.get(i));
            }
            ans.add(o.toString());
        }
        return ans;
    }

    public void backtrack(String s, List<String> tem, int start){
        if (!tem.isEmpty() && tem.get(tem.size() - 1).startsWith("0") && tem.get(tem.size() - 1).length() > 1) return;
        if (tem.size() > 4) return;
        if (tem.size() == 4  && start == s.length()){
            res.add(new ArrayList<>(tem));
            return;
        }

        int i = 0;
        while (start + i + 1 <= s.length() && Integer.parseInt(s.substring(start, start + i + 1)) <= 255){
            tem.add(s.substring(start, start + i + 1));
            backtrack(s, tem, start + i + 1);
            tem.remove(tem.size() - 1);
            i++;
        }

    }

    public static void main(String[] args) {
        RestoreIPAddress_93 r = new RestoreIPAddress_93();
        r.restoreIpAddresses("101023");
    }
}
