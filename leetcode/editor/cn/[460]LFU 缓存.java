import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class LfuCache {
    //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {
        // 缓存容量，时间戳
        int capacity, time;
        Map<Integer, Node> key_table;
        TreeSet<Node> S;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.time = 0;
            key_table = new HashMap<Integer, Node>();
            S = new TreeSet<Node>();
        }

        public int get(int key) {
            if (capacity == 0) {
                return -1;
            }
            // 如果哈希表中没有键 key，返回 -1
            if (!key_table.containsKey(key)) {
                return -1;
            }
            // 从哈希表中得到旧的缓存
            Node cache = key_table.get(key);
            // 从平衡二叉树中删除旧的缓存
            S.remove(cache);
            // 将旧缓存更新
            cache.cnt += 1;
            cache.time = ++time;
            // 将新缓存重新放入哈希表和平衡二叉树中
            S.add(cache);
            key_table.put(key, cache);
            return cache.value;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (!key_table.containsKey(key)) {
                // 如果到达缓存容量上限
                if (key_table.size() == capacity) {
                    // 从哈希表和平衡二叉树中删除最近最少使用的缓存
                    key_table.remove(S.first().key);
                    S.remove(S.first());
                }
                // 创建新的缓存
                Node cache = new Node(1, ++time, key, value);
                // 将新缓存放入哈希表和平衡二叉树中
                key_table.put(key, cache);
                S.add(cache);
            } else {
                // 这里和 get() 函数类似
                Node cache = key_table.get(key);
                S.remove(cache);
                cache.cnt += 1;
                cache.time = ++time;
                cache.value = value;
                S.add(cache);
                key_table.put(key, cache);
            }
        }
    }

    class Node implements Comparable<Node> {
        int cnt, time, key, value;

        Node(int cnt, int time, int key, int value) {
            this.cnt = cnt;
            this.time = time;
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object anObject) {
            if (this == anObject) {
                return true;
            }
            if (anObject instanceof Node) {
                Node rhs = (Node) anObject;
                return this.cnt == rhs.cnt && this.time == rhs.time;
            }
            return false;
        }

        @Override
        public int compareTo(Node rhs) {
            return cnt == rhs.cnt ? time - rhs.time : cnt - rhs.cnt;
        }

        @Override
        public int hashCode() {
            return cnt * 1000000007 + time;
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}