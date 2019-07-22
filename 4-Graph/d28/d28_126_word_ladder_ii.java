public class d28_126_word_ladder_ii {
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<String>(wordList);
        HashMap<String, Integer> distance = new HashMap<>();
        HashMap<String, List<String>> adj = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dict.add(beginWord);
        bfs(beginWord, endWord, dict, adj, distance);
        path.add(beginWord);
        dfs(beginWord, endWord, res, path, dict, adj, distance);
        return res;
    }

    public List<String> getNeighbor(String word, HashSet<String> dict) {
        List<String> res = new ArrayList<>();
        char[] arr = word.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == c) {
                    continue;
                }
                char ch = arr[i];
                arr[i] = c;
                if (dict.contains(String.valueOf(arr))) {
                    res.add(String.valueOf(arr));
                }
                arr[i] = ch;
            }
        }
        return res;
    }

    public void bfs(String start, String end, HashSet<String> dict, HashMap<String, List<String>> adj, HashMap<String, Integer> distance) {
        for (String word: dict) {
            adj.put(word, new ArrayList<String>());
        }
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        distance.put(start, 0);
        while (!q.isEmpty()) {
            String curr = q.poll();
            int level = distance.get(curr);
            List<String> neighbor = getNeighbor(curr, dict);
            for (String nei: neighbor) {
                adj.get(curr).add(nei);
                if (!distance.containsKey(nei)) {
                    distance.put(nei, level + 1);
                    if (!end.equals(nei)) {
                        q.offer(nei);
                    }
                }
            }
        }
    }

    public void dfs(String curr, String end, List<List<String>> res, List<String> path, HashSet<String> dict, HashMap<String, List<String>> adj, HashMap<String, Integer> distance) {
        if (curr.equals(end)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (String nei: adj.get(curr)) {
            path.add(nei);
            if (distance.containsKey(nei) && distance.get(nei) == distance.get(curr) + 1) {
                dfs(nei, end, res, path, dict, adj, distance);
            }
            path.remove(path.size() - 1);
        }
    }
}
