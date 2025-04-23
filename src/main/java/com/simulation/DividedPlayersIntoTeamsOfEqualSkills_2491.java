package com.simulation;

import java.util.Arrays;

public class DividedPlayersIntoTeamsOfEqualSkills_2491 {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long sum = 0L;
        int tem = skill[0] + skill[skill.length - 1];
        for(int i = 0, j = skill.length - 1; i < skill.length / 2; i++, j--){
            if(skill[i] + skill[j] != tem) return -1;
            else {
                sum += (long) skill[i] * skill[j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        DividedPlayersIntoTeamsOfEqualSkills_2491 d = new DividedPlayersIntoTeamsOfEqualSkills_2491();
        d.dividePlayers(new int[]{3,2,5,1,3,4});
    }
}
