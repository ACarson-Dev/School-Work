/**
 * A set of Person objects that converts measurements to imperial units (inches and pounds).
 */
public class PersonImperialSet extends PersonSet {
	
	/**
	 * Adds a person to the set, converting their height and weight from metric to imperial.
	 *
	 * @param p the Person object to add
	 */
	@Override
	public void add(Person p) {
		p.setHeight(convertHeight(p.getHeight()));
		p.setWeight(convertWeight(p.getWeight()));
		super.add(p);
	}

	/**
	 * Converts centimeters to inches.
	 *
	 * @param height the height in centimeters
	 * @return the height in inches
	 */
	private double convertHeight(double height) {
		return height / 2.54;
	}

	/**
	 * Converts kilograms to pounds.
	 *
	 * @param weight the weight in kilograms
	 * @return the weight in pounds
	 */
	private double convertWeight(double weight) {
		return weight * 2.20462;
	}
}