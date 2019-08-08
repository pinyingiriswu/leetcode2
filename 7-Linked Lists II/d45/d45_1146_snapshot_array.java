import java.util.HashMap;
import java.util.Map;

public class d45_1146_snapshot_array {

    class SnapshotArray {

        private int len;
        private int snap_times;
        Map<Integer, Integer>[] map;

        public SnapshotArray(int length) {
            this.map = new HashMap[length];
            this.len = length;
            this.snap_times = 0;
            for (int i = 0; i < len; i++) {
                this.map[i] = new HashMap<>();
            }
        }

        public void set(int index, int val) {
            map[index].put(snap_times, val);
        }

        public int snap() {
            return this.snap_times++;
        }

        public int get(int index, int snap_id) {
            while (snap_id >= 0) {
                if (map[index].containsKey(snap_id)) {
                    return map[index].get(snap_id);
                }
                snap_id--;
            }
            return 0;
        }
    }

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
}
