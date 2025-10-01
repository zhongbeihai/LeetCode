package com.backtrack;

import java.util.HashSet;

public class Robot {
    HashSet<String> visited = new HashSet<>();
    int[][] dirs = new int[][]{{-1,0},{0,1}, {1, 0}, {0, -1}};

    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, 0);
    }

    private void dfs(Robot robot, int x, int y, int curDir){
        String key = x + "#" + y;
        if (visited.contains(key)) return;
        visited.add(key);
        robot.clean();

        for (int d = curDir; d < curDir + 4; d++){
            int nx = x + dirs[d % 4][0], ny = y + dirs[d % 4][1];

            if (!visited.contains(nx + "#" + ny) && robot.move()){
                dfs(robot, nx, ny, d);
                goback(robot);
            }

            robot.turnRight();
        }

    }

    private void goback(Robot robot){
        // return to previous location
        robot.turnRight();
        robot.turnRight();
        robot.move();

        // recover origin direction
        robot.turnRight();
        robot.turnRight();
    }

    private void clean(){}
    private void turnRight(){}
    private boolean move(){return true;}

}
