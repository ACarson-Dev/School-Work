/**
 * DoublyLinkedSortedList class that maintains hurricane data in sorted order by ACE index (descending).
 * Implements the DoublyLinkedSortedListInterface.
 */
public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface {
    private Node first;
    private Node last;
    private int size;

    /**
     * Constructor to create an empty doubly linked sorted list.
     */
    public DoublyLinkedSortedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Returns a reference to the first Node in the list.
     * @return the first node
     */
    @Override
    public Node getFirst() {
        return first;
    }

    /**
     * Returns a reference to the last Node in the list.
     * @return the last node
     */
    @Override
    public Node getLast() {
        return last;
    }

    /**
     * Removes the Node that has toRemove as its value.
     * @param toRemove the HurricaneRowData to remove
     * @return the removed node, or null if not found
     */
    @Override
    public Node remove(HurricaneRowData toRemove) {
        Node current = first;

        while (current != null) {
            if (current.getValue().getYear() == toRemove.getYear() &&
                current.getValue().getAceIndex() == toRemove.getAceIndex()) {

                // Remove the node
                if (current == first && current == last) {
                    // Only one node in the list
                    first = null;
                    last = null;
                } else if (current == first) {
                    // Remove first node
                    first = current.getNext();
                    first.setPrevious(null);
                } else if (current == last) {
                    // Remove last node
                    last = current.getPrevious();
                    last.setNext(null);
                } else {
                    // Remove middle node
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                }
                size--;
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * Inserts a new Node with the given newValue into the list in sorted order (descending by ACE index).
     * @param newValue the HurricaneRowData to insert
     * @return
     */
    @Override
    public void insert(HurricaneRowData newValue) {
        Node newNode = new Node(newValue);

        // If list is empty
        if (first == null) {
            first = newNode;
            last = newNode;
            size++;
            return;
        }

        // Find the correct position to insert (sorted by ACE index descending)
        Node current = first;

        // Check if new value should be inserted at the beginning
        if (newValue.getAceIndex() > current.getValue().getAceIndex()) {
            newNode.setNext(first);
            first.setPrevious(newNode);
            first = newNode;
            size++;
            return;
        }

        // Traverse to find the correct position
        while (current != null) {
            if (newValue.getAceIndex() > current.getValue().getAceIndex()) {
                // Insert before current
                newNode.setNext(current);
                newNode.setPrevious(current.getPrevious());

                if (current.getPrevious() != null) {
                    current.getPrevious().setNext(newNode);
                }
                current.setPrevious(newNode);

                if (current == first) {
                    first = newNode;
                }
                size++;
                return;
            }

            // If we're at the last node and still haven't inserted
            if (current.getNext() == null) {
                current.setNext(newNode);
                newNode.setPrevious(current);
                last = newNode;
                size++;
                return;
            }

            current = current.getNext();
        }
    }

    /**
     * Returns the entire list as a multi-line String.
     * @return string representation of the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = first;

        while (current != null) {
            HurricaneRowData data = current.getValue();
            sb.append(String.format("%10d%11d%11d%11d%11d\n",
                data.getYear(),
                data.getAceIndex(),
                data.getNumTropStorms(),
                data.getNumHurricanes(),
                data.getNumMajorStorms()));
            current = current.getNext();
        }

        return sb.toString();
    }

    /**
     * Returns the size of the list.
     * @return the number of nodes in the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this linked list contains the given value.
     * @param value the HurricaneRowData to search for
     * @return true if found, false otherwise
     */
    // EXTRA CREDIT
    public boolean contains(HurricaneRowData value) {
        Node current = first;

        while (current != null) {
            if (current.getValue().getYear() == value.getYear() &&
                current.getValue().getAceIndex() == value.getAceIndex()) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Returns the node whose value matches the given value.
     * Pre: This linked list contains the given value.
     * @param value the HurricaneRowData to search for
     * @return the node with a matching value, or null if not found
     */
    // EXTRA CREDIT
    public Node getByValue(HurricaneRowData value) {
        Node current = first;

        while (current != null) {
            if (current.getValue().getYear() == value.getYear() &&
                current.getValue().getAceIndex() == value.getAceIndex()) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
} // End of class DoublyLinkedSortedList
