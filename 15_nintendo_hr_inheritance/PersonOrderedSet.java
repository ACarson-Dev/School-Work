import java.util.Collections;

/**
 * A set of Person objects that maintains alphabetical order by name.
 */
public class PersonOrderedSet extends PersonSet {
	
	/**
	 * Adds a person to the set if they are not already present,
	 * then sorts the list alphabetically by name.
	 *
	 * @param p the Person object to add
	 */
	@Override
	public void add(Person p) {
		super.add(p);
		sort();
	}

	/**
	 * Sorts the list of persons alphabetically by name.
	 */
	private void sort() {
		Collections.sort(people);
	}
}