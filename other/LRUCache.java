package other;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/**
 * 超时了，题目要求用O(1)，说明应该用HASH来查找而不是list遍历
 */
public class LRUCache {
    class Node {
        int key;
        int value;
    }


    private List<Node> linkedList;
    private int cap;

    public LRUCache(int capacity) {
        linkedList = new LinkedList<Node>();
        cap = capacity;
    }

    public int get(int key) {
        if (linkedList.size() == 0) return -1;
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).key == key) {
                Node node = linkedList.remove(i);
                linkedList.add(0, node);
                return linkedList.get(0).value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).key == key) {
                Node node = linkedList.remove(i);
                node.value = value;
                linkedList.add(0, node);
                return;
            }
        }
        Node node = new Node();
        node.key = key;
        node.value = value;
        if (linkedList.size() >= cap) {
            linkedList.remove(cap - 1);

            linkedList.add(0, node);
        } else {
            linkedList.add(0, node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(2, 1);
        cache.put(2, 2);
        cache.get(2);       // returns 1
        cache.put(1, 1);    // evicts key 2
        cache.put(4, 1);    // evicts key 1
        cache.get(2);       // returns 4
    }

}
