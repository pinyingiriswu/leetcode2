public class d25_210_course_schedule_ii {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] map = new int[numCourses];
        int n = prerequisites.length;
        int[] res = new int[numCourses];

        // record outdegree
        for (int i = 0; i < n; i++) {
            map[prerequisites[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int index = numCourses - 1;

        for (int i = 0; i < numCourses; i++) {
            if (map[i] == 0) {
                q.offer(i);
                res[index--] = i;
            }
        }

        while (!q.isEmpty()) {
            int s = q.poll();
            for (int i = 0; i < n; i++) {
                int t = prerequisites[i][1];
                if (s == prerequisites[i][0]) {
                    map[t]--;
                    if (map[t] == 0) {
                        q.offer(t);
                        res[index--] = t;
                    }
                }
            }
        }

        if (index != - 1) return new int[0];
        else {
            return res;
        }
    }
}

