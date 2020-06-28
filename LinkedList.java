import java.util.NoSuchElementException;

/**
 * @author Hex. implement a linked list
 **/

public class LinkedList {

    Node first;
    Node last;

    /**
     * adds a node to the list
     */
    public void add(int value) {
        Node nNode = new Node(value);

        if (first == null) {
            first = last = nNode;
        } else {
            nNode.next = first;
            first = nNode;
        }
    }

    /**
     * removes the first element on top of the stack
     */
    public void remove() {
        var second = first.next;

        if (first == last) {
            first = null;
        } else if (first == null) {
            throw new NoSuchElementException("Empty list");
        } else {
            first.next = null;
            first = second;
        }
    }

    /**
     * prints the nodes
     */
    public void print() {
        var current = first;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    /**
     * removes last node
     */
    public void removeLast() {
        // [1->2->3->4->5]
        var current = last;
        var previous = getPrevious(current);
        while (current != null) {
            if (current.next == null) {
                previous.next = null;
                last = previous;
            }
            current = current.next;
        }
    }

    /**
     * gets previous element e.g., if last node is the arg then return previous node
     * before last node
     */
    public Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * returns index of a node value
     */
    public int indexOf(int value) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return 0;
    }

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        obj.add(5);
        obj.add(10);
        obj.add(15);
        obj.add(20);
        obj.print();
    }
}
