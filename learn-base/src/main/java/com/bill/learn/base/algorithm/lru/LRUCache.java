package com.bill.learn.base.algorithm.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU：
 * Created by bill on 2018/11/21.
 */
public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * LRU的get方法，缓存命中后
     * @param key key
     * @return -1 不存在key
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            //缓存命中后，该结点设置在链表表头
            setHead(n);
            return n.value;
        }
        return -1;
    }

    /**
     * LRU的remove方法
     * @param n 结点
     */
    public void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }
    }

    /**
     * 设置为头结点
     * @param n 结点
     */
    public void setHead(Node n) {
        n.next = head;
        n.pre = null;
        if (head != null) {
            head.pre = n;
        }
        head = n;
        if (end == null) {
            end = head;
        }
    }

    /**
     * 设置方法
     * @param key   键
     * @param value 值
     */
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(created);
            } else {
                setHead(created);
            }
            map.put(key, created);
        }
    }

    /**
     * 测试
     * @param args a
     */
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.set(100, 1);
        lruCache.set(200, 2);
        lruCache.set(300, 3);
        lruCache.set(400, 4);
        lruCache.set(500, 5);
        traverse(lruCache.head);
        lruCache.set(600, 6);
        traverse(lruCache.head);
        lruCache.get(400);
        traverse(lruCache.head);




    }

    /**
     * 遍历结点
     * @param node 头结点
     */
    public static void traverse(Node node) {
        while (node != null) {
            System.out.println(node.value + " ");
            node = node.next;
        }
        System.out.println("-------------------");
    }
}
