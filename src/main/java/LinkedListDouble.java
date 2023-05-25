public class LinkedListDouble {
    private Node head;
    private Node tail;

    private class Node {
        private int value;
        private Node next;
        private Node previous;
    }

    public void addFirst(int value) {
        Node first = new Node();
        first.value = value;
        if (head != null) {
            first.next = head;
            head.previous = first;
        } else {
            tail = first;
        }
        head = first;
    }

    public void deleteFirst() {
        if (head != null && head.next != null) {
            head = head.next;
            head.previous = null;
        } else {
            head = null;
            tail = null;
        }
    }

    public boolean ifFind(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void addLast(int value) {
        Node last = new Node();
        last.value = value;
        if (tail != null) {
            last.next = tail;
            tail.previous = last;
        } else {
            head = last;
        }
        tail = last;
    }

    public void deleteLast() {
        if (head != null && head.next != null) {
            tail = tail.previous;
            head.next = null;
        } else {
            head = null;
            tail = null;
        }
    }

    public void bubbleSort() {
        boolean needSort = true;
        while (needSort) {
            needSort = false;
            Node currentNode = head;
            while (currentNode != null && currentNode.next != null){
                if (currentNode.value > currentNode.next.value){
                    int tmp = currentNode.value;
                    currentNode.value = currentNode.next.value;
                    currentNode.next.value= tmp;
                    needSort = true;

//                    Node before = node.prev;
//                    Node after = node.next.next;
//                    Node current = node;
//                    Node next = node.next;
//
//                    current.next = after;
//                    current.prev = next;
//                    next.next = current;
//                    next.prev = before;
//                    if (before != null){
//                        before.next = next;
//                    } else {
//                        head = next;
//                    }
//                    if (after != null) {
//                        after.prev = current;
//                    } else  {
//                        tail = current;
//                    }
                }
                currentNode = currentNode.next;
            }
        }
    }
}
