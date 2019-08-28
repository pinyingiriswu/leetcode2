public class d65_127_word_ladder {
    /** Reference: http://rainykat.blogspot.com/2017/01/leetcode-127-word-ladderbfs.html
     * Use BFS to traverse dictionary. The level is composed of the words that are 1 char diff from curWord.
     * If find such newWord, first check if is end word so we return min length, else check if in dict & remove it to avoid repeat.
     * 4 loops in total: 1st queue.isEmpty(); 2nd queue.size() -- current level
     *                   3rd curword.length() - chose every char; 4th 'a' to 'z' - replace each char
     *
     *  Note: if use DFS, we need to travel all path to decide the shortest one. If using BFS, we stop once we found since we start from short to find the path. */

    /** Time: O(n^3)
     * Space: O(n)
     * */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 1;
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        int count = 2; // beginWord + endWord count
        q.offer(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String top = q.poll();
                for (int j = 0; j < top.length(); j++) {
                    StringBuilder sb = new StringBuilder(top);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        String s = sb.toString();
                        if (set.contains(s)) {
                            if (s.equals(endWord)) return count;
                            q.offer(s);
                            set.remove(s);
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}
