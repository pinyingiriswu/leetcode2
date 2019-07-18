public class d24_127_word_ladder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 1;
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        int count = 2;
        q.add(beginWord);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String top = q.poll();
                for(int j = 0; j < top.length(); j++){
                    StringBuilder sb = new StringBuilder(top);
                    for(char c = 'a'; c <= 'z'; c++){
                        sb.setCharAt(j, c);
                        String s = sb.toString();
                        if(set.contains(s)){
                            if(s.equals(endWord)) return count;
                            q.add(s);
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
