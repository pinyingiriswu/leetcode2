public class d68_212_word_search_ii {
    /** Time: O(m*n)
     * Space: O(m*n)
     * */
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String str;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
            this.str = "";
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (char c: word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
            cur.str = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        for (String w: words) {
            trie.insert(w);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        Set<String> res = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, trie.root, res, i, j);
            }
        }

        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, boolean[][] visited, TrieNode root, Set<String> res, int i, int j) {
        if (root.isWord) {
            res.add(root.str);
        }

        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || root.children[board[i][j] - 'a'] == null || visited[i][j]) return;

        visited[i][j] = true;

        dfs(board, visited, root.children[board[i][j] - 'a'], res, i + 1, j);
        dfs(board, visited, root.children[board[i][j] - 'a'], res, i - 1, j);
        dfs(board, visited, root.children[board[i][j] - 'a'], res, i, j + 1);
        dfs(board, visited, root.children[board[i][j] - 'a'], res, i, j - 1);

        visited[i][j] = false; // backtrack
    }
}
