package yangxinwu.algorithm;


//运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
//        获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
//        写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//
//         
//
//        进阶:
//
//        你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//         
//
//        示例:
//
//        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // 返回  1
//        cache.put(3, 3);    // 该操作会使得关键字 2 作废
//        cache.get(2);       // 返回 -1 (未找到)
//        cache.put(4, 4);    // 该操作会使得关键字 1 作废
//        cache.get(1);       // 返回 -1 (未找到)
//        cache.get(3);       // 返回  3
//        cache.get(4);       // 返回  4
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/lru-cache
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import android.util.LruCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {


    class DLinkedNode{

    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;

    public DLinkedNode(){

    }

    public DLinkedNode(int key, int value){
       this.key = key;
       this.value = value;
    }
    }



    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;
    private Map<Integer,DLinkedNode> cache = new HashMap<Integer,DLinkedNode>();
    int size;


    public LRUCache(int capacity){
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }



    public int get(int key){
        DLinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }


    public void put(int key,int value){
        DLinkedNode node = cache.get(key);

        if (node == null){
            DLinkedNode newNode = new DLinkedNode(key,value);
            cache.put(key,newNode);
            size ++;
            if (capacity < cache.size()){
                cache.remove(removeTailNode().key);
                 size -- ;
            }
            addToHead(newNode);
        }else {

            node.value = value;
            moveToHead(node);

        }
    }

   public void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
   }


   public void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
   }

   public DLinkedNode removeTailNode(){
     DLinkedNode node = tail.prev;
     removeNode(node);
     return node;
   }

   public void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
   }

//    复杂度分析
//
//    时间复杂度：对于 put 和 get 都是 O(1)O(1)。
//
//    空间复杂度：O(\text{capacity})O(capacity)，因为哈希表和双向链表最多存储 \text{capacity} + 1capacity+1 个元素。



}
