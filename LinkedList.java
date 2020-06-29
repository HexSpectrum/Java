import java.util.NoSuchElementException;

/**
 * @author Hex. implement a linked list and a few of its methods
 **/

public class LinkedList {

    Node first;
    Node last;

    /**
     * adds a node to the end of the list
     * 
     * @param value - node value
     */
    public void add(int value) {
        Node nNode = new Node(value);
        // add to the end of the list
        // [1->2->3->4->5 -> x]
        if (first == null) {
            first = last = nNode;
        } else {
            last.next = nNode;
            last = last.next;
        }
    }

    /**
     * checks if the list contains a specific node value
     * 
     * @param value - value of the node
     */
    public boolean contains(int value) {
        var current = first;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * adds a node to the end of the list
     * 
     * @param value - value of the node
     */
    public void addLast(int value) {
        Node nNode = new Node(value);
        // [c->1->2->3->4->x]

        if (first == null) {
            first = last = nNode;
        } else {
            last.next = nNode;
            last = last.next;
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
        obj.add(1);
        obj.add(2);
        obj.add(4);
        obj.add(8);
        obj.add(16);

        obj.print();
        System.out.println(obj.contains(16));

    }
}
