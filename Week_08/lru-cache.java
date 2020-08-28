import java.util.*;

class LRUCache {
    class Node
    {
        public int key, val;
        public Node prev, next;

        public Node(int k, int v)
        {
            key = k;
            val = v;
            prev = next = null;
        }
    }

    class DoubleLinkedList
    {
        Node head, tail;
        int size;
        public DoubleLinkedList()
        {
            this.size = 0;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int size()
        {
            return size;
        }

        public void addFirst(Node node)
        {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        public void remove(Node node)
        {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeLast()
        {
            if(size==0)return null;
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    public int capacity;
    public Map<Integer, Node> map;
    public DoubleLinkedList list;
    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        list = new DoubleLinkedList();
    }

    public void put(int k, int v)
    {
        Node node = new Node(k, v);
        if(map.containsKey(k))
        {
            Node last = map.remove(k);
            list.remove(last);
            map.put(k, node);
            list.addFirst(node);
        }else
        {
            if(list.size()>=capacity)
            {
                Node last = list.removeLast();
                map.remove(last.key);
            }
            map.put(k, node);
            list.addFirst(node);
        }
    }

    public int get(int k)
    {
        if(!map.containsKey(k))return -1;
        Node node = map.get(k);
        put(node.key, node.val);
        return node.val;
    }
}