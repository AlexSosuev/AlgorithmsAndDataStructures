import java.util.ArrayList;

public class Hash<K, V> {
    private static final int initBasketCount = 16;
    private static final double loadFactor = 0.75;
    private int size = 0;

    private void recolculate() {
        basket[] old = baskets;
        baskets = (basket[]) new Object[old.length * 2];
        for (int i = 0; i < old.length; i++) {
            basket baske = old[i];
            basket.Node newNode = baske.head;
            while (newNode != null) {
                putOut(newNode.value.key, newNode.value.value);
                newNode = newNode.next;
            }
            old[i] = null;
        }
    }

    private basket[] baskets;

    public Hash() {
        this(initBasketCount);
    }

    public Hash(int initSize) {
        baskets = (basket[]) new Object[initSize];
    }

    private int calculateBasketIndex(K key) {
        return key.hashCode() % baskets.length;
    }

    private class entity {
        private K key;
        private V value;
    }

    private class basket {
        private Node head;

        private class Node {
            private Node next;
            private entity value;
        }

        public V getBasket(K key) {
            Node node = head;
            while (node != null) {
                if (node.value.key.equals(key)) {
                    return node.value.value;
                }
                node = node.next;
            }
            return null;
        }

        public boolean put(entity E) {
            Node node = new Node();
            node.value = E;
            Node item = head;
            if (item != null) {
                while (true) {
                    if (item.value.key.equals(E.key)) {
                        return false;
                    }
                    if (item.next == null) {
                        item.next = node;
                        return true;
                    }
                    item = item.next;
                }
            }
            head = node;
            return true;
        }

        public boolean remove(K key) {
            if (head != null) {
                if (head.value.key.equals(key)) {
                    head = head.next;
                    return true;
                } else {
                    Node node = head;
                    while (node.next != null) {
                        if (node.next.value.key.equals(key)) {
                            node.next = node.next.next;
                            return true;
                        }
                        node = node.next;
                    }
                }
            }
            return false;
        }


    }

    public V getBasketOut(K key) {
        int index = calculateBasketIndex(key);
        basket basket = baskets[index];
        if (basket != null) {
            return basket.getBasket(key);
        }
        return null;
    }

    public boolean putOut(K key, V value) {
        if (baskets.length*loadFactor<size){
            recolculate();
        }
        int index = calculateBasketIndex(key);
        basket baske = baskets[index];
        if (baske == null) {
            baske = new basket();
            baskets[index] = baske;
        }
        entity E = new entity();
        E.key = key;
        E.value = value;
        boolean add =baske.put(E);
        if (add){
            size++;
        }
        return add;
    }

    public boolean removeOut(K key) {
        int index = calculateBasketIndex(key);
        basket baske = baskets[index];
        boolean delete = baske.remove(key);
        if (delete){
            size--;
        }
        return delete;
    }


}

