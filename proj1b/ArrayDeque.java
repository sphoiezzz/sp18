/*
ArrayDeque.
 */

public class ArrayDeque<T>{
        private class TNode{
        private TNode prev;
        private TNode next;
        private T item;

        private TNode(T x, TNode p, TNode n){
            prev = p;
            next = n;
            item = x;
        }
    }

    /**
     * Create a deep copy of other
     */
    public ArrayDeque(ArrayDeque L){
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

        for (int i = 0;i < L.size(); i++){
            addLast((T) L.get(i));// (T) is cast, since type of other is unknown
        }

    }

    /**
     *  The first item (if it exists) in the deque is the sentinel.next
     */
    private TNode sentinel;
    private int size;

    /**
     * Create an empty deque
     */
    public ArrayDeque(){
        sentinel = new TNode(null,null,null);
        sentinel.prev = sentinel.next;
        sentinel.next =  sentinel.prev;
        size = 0;
    }

    /**
     * Returns true if deque is empty, false otherwise
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Returns the size of the deque
     */
    public int size(){
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space
     */
    public void print(){
        TNode temp = sentinel.next;
        for (int i = 0; i< size; i++){
            System.out.println(temp.item + " ");
            temp = temp.next;
        }
    }

    /**
     * Adds an item of type T to the front of the deque
     */
    public void addFirst(T item){
        sentinel.next = new TNode(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /**
     * Adds an item of type T to the back of the deque
     */
    public void addLast(T item){
        sentinel.prev = new TNode(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null
     */
    public T removeFirst(){
        T remove = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        if (!isEmpty()) {
            size -= 1;
        }
        return remove;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null
     */
    public T removeLast(){
        T remove = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        if (!isEmpty()) {
            size -= 1;
        }
        return remove;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque
     */
    public T get(int index){
        TNode temp = sentinel.next;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp.item;
    }

    /**
     * Same as get, but uses recursion
     * First, need a private helper method
     */
    private T getRecursive(int index, TNode curr){
        if (index == 0){
            return curr.item;
        }
        return getRecursive(index-1, curr.next);

    }

    public T getRecursive(int index){
        return getRecursive(index, sentinel.next);
    }

}