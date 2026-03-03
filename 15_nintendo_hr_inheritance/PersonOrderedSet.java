public class PersonOrderedSet extends PersonSet {
	
	/**
	 * Adds a person to the set, maintaining the order of the set.
	 *
	 * @param p the Person object to add
	 */
	@Override
	public void add(Person p) {
		if (!people.contains(p)) {
			for (int i = 0; i < people.size(); i++) {
				if (p.getName().compareTo(people.get(i).getName()) < 0) {
					people.add(i, p);
					return;
				}
			}
			people.add(p);
		}
	}
}