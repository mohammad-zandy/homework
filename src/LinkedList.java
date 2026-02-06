public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null; // true is list is empty
    }

    /**
     * Adds a new node to the lined list
     * @param data - the String we are adding
     */
    public void add(String data) {
        Node node = new Node(data);// Make a new node object
        if (isEmpty()) { // if the list is empty this is the first item
            head = node;
            tail = node;
        } else { // otherwise add it to the tail
            tail.setNext(node); // What was the tail is now pointing to the new item
            tail = node; // the new item is now the tail
        }
    }

    public void print() {
        Node next = head;
        while (next != null) {
            System.out.println(next.getData());
            next = next.getNext();
        }
    }

    public String search(String item) {
        Node next = head;
        String itemFound = "";
        while (next != null) {
            if (next.getData().equals(item)) {
                itemFound = item;
            }
            next = next.getNext();
        }
        return itemFound;
    }

import java.util.Scanner;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(String data) {
        Node n = new Node(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
        size++;
    }

    public void addAtHead(String data) {
        Node n = new Node(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setNext(head);
            head = n;
        }
        size++;
    }

    public void print() {
        Node current = head;

        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public String search(String item) {
        Node current = head;

        while (current != null) {
            if (current.getData().equals(item)) {
                return item;
            }
            current = current.getNext();
        }
        return "";
    }

    public boolean remove(String item) {
        if (isEmpty()) {
            return false;
        }

        if (head.getData().equals(item)) {
            head = head.getNext();
            size--;

            if (head == null) {
                tail = null;
            }
            return true;
        }

        Node current = head;

        while (current.getNext() != null) {
            if (current.getNext().getData().equals(item)) {

                if (current.getNext() == tail) {
                    tail = current;
                }

                current.setNext(current.getNext().getNext());
                size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean replace(String oldItem, String newItem) {
        Node current = head;

        while (current != null) {
            if (current.getData().equals(oldItem)) {
                current.setData(newItem);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        if (index == 0) {
            head = head.getNext();
            size--;

            if (head == null) {
                tail = null;
            }
            return true;
        }

        Node current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }

        if (current.getNext() == tail) {
            tail = current;
        }

        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1 Add");
            System.out.println("2 Remove");
            System.out.println("3 Search");
            System.out.println("4 Print");
            System.out.println("5 Replace");
            System.out.println("6 Delete by index");
            System.out.println("7 Add at head");
            System.out.println("0 Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    add(sc.nextLine());
                    break;
                case 2:
                    remove(sc.nextLine());
                    break;
                case 3:
                    System.out.println(search(sc.nextLine()));
                    break;
                case 4:
                    print();
                    break;
                case 5:
                    String oldItem = sc.nextLine();
                    String newItem = sc.nextLine();
                    replace(oldItem, newItem);
                    break;
                case 6:
                    delete(sc.nextInt());
                    break;
                case 7:
                    addAtHead(sc.nextLine());
                    break;
            }

        } while (choice != 0);
    }
}




    /**
     * For your in class exercise explore completing the following methods for a Singly Linked list supported by
     * your tutor.
     *     // remove
     *     // replace
     *     // delete
     *     // add at head
     *     // menu
     * If you complete all of these save the code, copy  and refactor the entire project as a doubly linked list.
     */

}
