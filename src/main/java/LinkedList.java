//Реализуем простой односвязный список. Пишем только структуру, никаких методов не требуется.
public class LinkedList {
    private Node head;

    private class Node {
        private int value;
        private Node next;
    }

    //Реализуем метод добавления новых элементов в начало списка и удаление первого элемента связного списка.
    public void addFirst(int value) {
        Node first = new Node();
        first.value = value;
        if (head != null) {
            first.next = head;
        }
        head = first;
    }

    //Удаление элемента
    public void deleteFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    //Реализуем метод поиска элемента в односвязном списке для проверки наличия элемента внутри списка.
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

    //Реализуем метод добавления новых элементов в конец списка и удаление последнего элемента связного списка.
    public void addLast(int value) {
        Node lastNode = new Node();
        lastNode.value = value;
        if (head == null) {
            head = lastNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = lastNode;
        }
    }

    public void deleteLast() {
        if (head != null) {
            Node currentNode = head;
            while (currentNode.next != null) {
                if (currentNode.next.next == null) {
                    currentNode.next = null;
                    return;
                }
                currentNode = currentNode.next;
            }
            head = null;
        }
    }


}
