/**
 * Node class for the doubly linked list.
 * Each node contains a HurricaneRowData value and references to the next and previous nodes.
 */
public class Node {
    private HurricaneRowData value;
    private Node next;
    private Node previous;

    /**Wh
     * Constructor to create a new Node with a given value.
     * @param value the HurricaneRowData to store in this node
     */
    public Node(HurricaneRowData value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    /**
     * Gets the value stored in this node.
     * @return the HurricaneRowData value
     */
    public HurricaneRowData getValue() {
        return value;
    }

    /**
     * Checks if this node has a next node.
     * @return true if there is a next node, false otherwise
     */
    public boolean hasNext() {
        return next != null;
    }

    /**
     * Sets the next node.
     * @param next the node to set as next
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Gets the next node.
     * @return the next node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Checks if this node has a previous node.
     * @return true if there is a previous node, false otherwise
     */
    public boolean hasPrevious() {
        return previous != null;
    }

    /**
     * Sets the previous node.
     * @param previous the node to set as previous
     */
    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    /**
     * Gets the previous node.
     * @return the previous node
     */
    public Node getPrevious() {
        return previous;
    }

    @Override
    public String toString() {
        return value.toString();
    }
} // End of class Node
