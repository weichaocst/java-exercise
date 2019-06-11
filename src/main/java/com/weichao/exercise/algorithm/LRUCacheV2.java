package com.weichao.exercise.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 * 核心思想就是构建出带有表头和表尾的双链表，并用一个map存储所有节点，更新和添加时将节点放在双链表头部，超限时删除表尾。获取时直接从map中获取节点值。
 */
public class LRUCacheV2 {

    // 双链表节点
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }

    private int capacity;
    private Node first;
    private Node last;

    private Map<Integer, Node> map;

    public LRUCacheV2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    private void moveToHead(Node node) {
        if (node == first) {
            return;
        } else if (node == last) {
            last.prev.next = null;
            last = last.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.next = first;
        node.prev = first.prev;
        first.prev = node;
        first = node;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node == null) {
            node = new Node();
            node.key = key;
            node.val = value;

            if(map.size() == capacity) {
                removeLast();
            }

            addToHead(node);
            map.put(key, node);
        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void addToHead(Node node) {
        if (map.isEmpty()) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }
    }

    private void removeLast() {
        map.remove(last.key);
        Node prevNode = last.prev;
        if (prevNode != null) {
            prevNode.next = null;
            last = prevNode;
        }
    }
}

