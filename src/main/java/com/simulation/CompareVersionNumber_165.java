package com.simulation;

public class CompareVersionNumber_165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i < len; i++){
            int r1 = i >= v1.length ? 0 : Integer.parseInt(v1[i]);
            int r2 = i >= v2.length ? 0 : Integer.parseInt(v2[i]);

            if (r1 > r2) return 1;
            else if (r1 < r2) {
                return -1;
            }
        }

        return 0;
    }
}
