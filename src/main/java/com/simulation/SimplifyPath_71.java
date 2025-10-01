package com.simulation;

import java.util.*;

public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        // split path
        StringBuilder sb = new StringBuilder();
        List<String> levels = new ArrayList<>();
        for (int i = 0; i <= path.length(); i++) {
            if (i == path.length() || path.charAt(i) == '/'){
                String cur = sb.toString();
                if (cur.equals("..")){
                    if (levels.size() > 0) levels.remove(levels.size() - 1);
                } else {
                    if (!cur.equals(".") && !cur.isEmpty()) levels.add(cur);
                }
                sb = new StringBuilder();
            }else {
                sb.append(path.charAt(i));
            }
        }

        StringBuilder ssb = new StringBuilder();
        ssb.append('/');
        for (String s: levels){
            ssb.append(s);
            ssb.append('/');
        }
        if (ssb.length() != 1 && ssb.charAt(ssb.length() - 1) == '/')ssb.delete(ssb.length() - 1, ssb.length());

        return ssb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath_71 s = new SimplifyPath_71();
        // s.simplifyPath("/.../a/../b////c/../d/./");
        s.simplifyPath("/a/./b/../../c/");
    }
}
