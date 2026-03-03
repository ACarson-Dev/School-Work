public class PersonImperialSet extends PersonSet {
	
	/**
	 * Adds a person to the set, converting their height and weight from metric to imperial.
	 *
	 * @param p the Person object to add
	 */
	@Override
	public void add(Person p) {
		p.setHeight(p.getHeight() / 2.54);
		p.setWeight(p.getWeight() / 2.2046);
		super.add(p);
	}
}