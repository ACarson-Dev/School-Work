public interface PersonList {
	/**
	 * Adds a person to the list.
	 *
	 * @param p the Person object to add
	 */
	void add(Person p);

	/**
	 * Retrieves a person from the list at the specified index.
	 *
	 * @param index the position of the person in the list
	 * @return the Person object at the specified index
	 */
	Person get(int index);

} // End of PersonList class