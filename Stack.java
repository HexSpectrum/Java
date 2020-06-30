import java.util.NoSuchElementException;

/**
 * @author Hex 
 * stack implementation using linked list concept
 **/

public class Stack {

    Node first;
    Node last;

    /**
     * adds a node to the stack
     */
    public void add(int value) {
        // [x->1->2->3->4->5]
        Node nNode = new Node(value);

        if (first == null) {
            first = last = nNode;
        } else {
            nNode.next = first;
            first = nNode;
        }
    }

    /**
     * pops a node from the top of the stack
     */
    public void pop() {
        // [5->4->3->2->1]
        var second = first.next;
        if (first == null) {
            return;
        } else if (first == last) {
            first = null;
        } else {
            first.next = null;
            first = second;
        }
    }

    /**
     * fetches the element on top of the stack
     */
    public int peek() {
        if (first == null) {
            throw new NoSuchElementException("Stack is empty");
        } else {
            return first.data;
        }
    }

    public void print() {
        var current = first;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    private class Node {
        int data;
        Node next;

        private Node(int data) {
            this.data = data;
        }

    }

    public static void main(String args[]) {

        Stack obj = new Stack();
        obj.add(1);
        obj.add(2);
        obj.add(4);
        obj.add(8);
        obj.print();
    }
}
