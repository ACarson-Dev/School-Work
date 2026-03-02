import java.util.ArrayList;

/**
 * A set implementation for Person objects that prevents duplicates.
 * This class implements the PersonList interface and uses an ArrayList internally
 * to store unique Person objects.
 */
public class PersonSet implements PersonList {
	/** The internal list storing unique Person objects */
	protected ArrayList<Person> people = new ArrayList<Person>();

	/**
	 * Adds a person to the set if they are not already present.
	 * This method checks for duplicates using the equals() method before adding.
	 *
	 * @param p the Person object to add
	 */
	@Override
	public void add(Person p) {
		if(!people.contains(p)){
			people.add(p);
		}
	}

	/**
	 * Retrieves the person at the specified index in the set.
	 *
	 * @param index the position of the person in the set
	 * @return the Person object at the specified index
	 */
	@Override
	public Person get(int index) {
		return people.get(index);
	}

	/**
	 * Returns a string representation of all persons in the set.
	 * Each person is displayed on a separate line.
	 *
	 * @return a string containing all persons in the set
	 */
	@Override
	public String toString() {
		String result = "";
		for (Person p : people) {
			result += p.toString() + "\n";
		}
		return result;
	}

} // End of PersonSet class