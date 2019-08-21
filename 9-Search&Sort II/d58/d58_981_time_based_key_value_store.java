public class d58_981_time_based_key_value_store {
    class TimeMap {

        class Pair {
            int timestamp;
            String value;
            public Pair(int timestamp, String value) {
                this.timestamp = timestamp;
                this.value = value;
            }
        }

        Map<String, List<Pair>> map;

        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<Pair>());
            }
            map.get(key).add(new Pair(timestamp, value));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            List<Pair> list = map.get(key);
            int start = 0;
            int end = list.size() - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (list.get(mid).timestamp < timestamp) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (list.get(end).timestamp <= timestamp) return list.get(end).value;
            if (list.get(start).timestamp <= timestamp) return list.get(start).value;
            return "";
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}
