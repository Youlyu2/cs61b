public class LinkedListDeque<T>{

    public int size;
    private Node sentinel;


    public LinkedListDeque() {
        sentinel = new Node(null, null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }


    private class Node {
        public Node prev;
        public T item;
        public Node next;

        Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public void addFirst(T i) {
        size += 1;
        sentinel.next = new Node(sentinel, i, sentinel.next);
    }

    public void addLast(T i) {
        size += 1;
        sentinel.prev = new Node(sentinel.prev, i, sentinel);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node curr = sentinel.next;
        while(curr != sentinel) {
            System.out.print(curr.item + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        size -= 1;
        T t = sentinel.next.item;
        sentinel.next = new Node(sentinel, sentinel.next.next.item, sentinel.next.next.next);
        return t;
    }

    public T removeLast() {
        size -= 1;
        T t = sentinel.prev.item;
        sentinel.prev = new Node(sentinel.prev.prev, sentinel.prev.prev.item, sentinel);
        return t;
    }

    public T get(int index) {
        Node curr = sentinel.next;
        for(int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.item;
    }
}