public class ArrayDeque<T> {
    int size;
    T[] items;

    public ArrayDeque() {
        size = 0;
        item = (T[])new Object[size];
    }

    public ArrayDeque(ArrayDeque a) {
        T[] copy = new T[a.size];
        System.arraycopy(a, 0, items, 0, size);
        size = a.size;
    }

    public void resize(int x) {
        T[] a = (T[]) new Object[x];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addFirst(T item) {
        if(size == items.length) {
            resize(size + 1);
        }
        T[] copy = (T[]) new Object[items.length];
        System.arraycopy(items, 1, items, 1, size);
        items[0] = item;
        size += 1;
    }

    public void addLast(T item) {
        if(size == items.length) {
            resize(size + 1);
        }
        items[size] = item;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for(int i = 0; i < size; i++) {
            System.out.println(items[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        T firstItem = items[0];
        System.arraycopy(items, 0, items, 1. size - 1);
        size -= 1
        return firstItem;
    }

    public T removeLast() {
        T lastItem = items[size - 1];
        size -= 1;
        return lastItem;
    }

    public T get(int index) {
        return items[index];
    }
}