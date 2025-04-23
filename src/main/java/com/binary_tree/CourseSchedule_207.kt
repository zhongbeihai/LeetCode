package com.binary_tree

class CourseSchedule_207 {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = ArrayList<ArrayList<Int>>(numCourses)

        // 初始化 graph
        for (i in 0 until numCourses) {
            graph.add(ArrayList())
        }

        prerequisites.forEach {
            graph[it[0]].add(it[1])
        }

        val visited = IntArray(numCourses) { 0 }
        for(i in 0 until numCourses){
            if(!dfs(graph, i, visited)){
                return false
            }
        }
        return true
    }

    fun dfs(graph: List<List<Int>>, currentCourse: Int, visited: IntArray): Boolean {
        if(visited[currentCourse] == 1){
            return false
        }

        if (visited[currentCourse] == 2) {
            return true;
        }

        visited[currentCourse] = 1
        for (i in graph[currentCourse]){
            if (!dfs(graph, i, visited)){
                return false
            }
        }

        visited[currentCourse] = 2
        return true
    }
}