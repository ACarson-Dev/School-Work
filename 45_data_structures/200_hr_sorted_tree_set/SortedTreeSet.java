/**
 * A self-sorting binary search tree set for Person objects.
 * Each instance acts as a node. Data is inserted in sorted order using
 * Person's compareTo() method. Duplicate names are not allowed.
 */
public class SortedTreeSet implements SortedTreeSetInterface
{
	private Person person;
	private SortedTreeSet left;
	private SortedTreeSet right;

	/**
	 * Constructs an empty SortedTreeSet.
	 */
	public SortedTreeSet()
	{
		this.person = null;
		this.left = null;
		this.right = null;
	}

	/**
	 * Constructs a SortedTreeSet node with the given person.
	 *
	 * @param p the Person to store at this node
	 */
	public SortedTreeSet(Person p)
	{
		this.person = p;
		this.left = null;
		this.right = null;
	}

	/**
	 * Returns the Person stored at this node.
	 *
	 * @return the Person at this node
	 */
	@Override
	public Person getPerson()
	{
		return person;
	}

	/**
	 * Returns true if this node has a left child.
	 *
	 * @return true if left child exists
	 */
	@Override
	public boolean hasLeft()
	{
		return left != null;
	}

	/**
	 * Sets the left child of this node.
	 *
	 * @param left the SortedTreeSet to set as the left child
	 */
	@Override
	public void setLeft(SortedTreeSet left)
	{
		this.left = left;
	}

	/**
	 * Returns the left child of this node.
	 *
	 * @return on the left child SortedTreeSet
	 */
	@Override
	public SortedTreeSet getLeft()
	{
		return left;
	}

	/**
	 * Returns true if this node has a right child.
	 *
	 * @return true if the right child exists
	 */
	@Override
	public boolean hasRight()
	{
		return right != null;
	}

	/**
	 * Sets the right child of this node.
	 *
	 * @param right the SortedTreeSet to set as the right child
	 */
	@Override
	public void setRight(SortedTreeSet right)
	{
		this.right = right;
	}

	/**
	 * Returns the right child of this node.
	 *
	 * @return the right child SortedTreeSet
	 */
	@Override
	public SortedTreeSet getRight()
	{
		return right;
	}

	/**
	 * Adds a Person to the tree in sorted order using BST insertion.
	 * If a person with the same name already exists, they are not added.
	 * The tree remains sorted at all times as a result of BST insertion rules.
	 *
	 * @param p the Person to add
	 */
	@Override
	public void add(Person p)
	{
		// If this node is empty, store the person here
		if (this.person == null)
		{
			this.person = p;
			return;
		}

		int cmp = p.compareTo(this.person);

		if (cmp < 0)
		{
			// p comes before this node alphabetically — go left
			if (hasLeft())
			{
				left.add(p);
			}
			else
			{
				setLeft(new SortedTreeSet(p));
			}
		}
		else if (cmp > 0)
		{
			// p comes after this node alphabetically — go right
			if (hasRight())
			{
				right.add(p);
			}
			else
			{
				setRight(new SortedTreeSet(p));
			}
		}
		// cmp == 0: duplicate name, do not add

	} // End of add()

	/**
	 * Returns an in-order traversal of the tree as a formatted string
	 * with a header row for Name, Height, and Weight.
	 *
	 * @return formatted string of all persons in alphabetical order
	 */
	@Override
	public String toString()
	{
		String header = String.format("%-10s %-15s %-15s\n", "Name", "Height", "Weight");
		return header + inOrderString();
	}

	/**
	 * Recursively builds an in-order string of all persons in the tree.
	 *
	 * @return in-order string of persons
	 */
	private String inOrderString()
	{
		if (person == null) return "";

		String result = "";

		if (hasLeft())
		{
			result += left.inOrderString();
		}

		result += person.toString() + "\n";

		if (hasRight())
		{
			result += right.inOrderString();
		}

		return result;
	}

} // End of SortedTreeSet class