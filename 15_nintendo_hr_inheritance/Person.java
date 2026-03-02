/*Sources:
*/

/**
 * Represents a person with a name, weight, and height.
 * This class provides methods to access and modify person attributes,
 * and overrides equals() and toString() for proper object comparison and display.
 */
public class Person {
	private String name;
	private double weight;
	private double height;

	/**
	 * Constructs a Person object with the specified attributes.
	 *
	 * @param name the name of the person
	 * @param weight the weight of the person in pounds
	 * @param height the height of the person in feet
	 */
	public Person(String name, double weight, double height) {
		this.name = name; // 'this' is a reference to the current object
		this.weight = weight;
		this.height = height;
	}

	/**
	 * Gets the height of the person.
	 *
	 * @return the height in feet
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Gets the weight of the person.
	 *
	 * @return the weight in pounds
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Sets the height of the person.
	 *
	 * @param height the new height in feet
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * Sets the weight of the person.
	 *
	 * @param weight the new weight in pounds
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * Returns a string representation of the person.
	 *
	 * @return a formatted string containing the person's name, height, and weight
	 */
	@Override
	public String toString() {
		return name + " is " + height + " feet tall and " + weight + " pounds.";
	}

	/**
	 * Compares this person to another object for equality.
	 * Two persons are considered equal if they have the same name, height, and weight.
	 *
	 * @param o the object to compare with
	 * @return true if the objects are equal, false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		// if Object o is null, then return false
		if (o == null) return false;
		// if Object o == this then return true
		if (o == this) return true;
		// if Object o is not an instance of Person then return false
		if (!(o instanceof Person)) return false;

		Person p = (Person) o;

		return this.name.equals(p.name) &&
				Double.compare(this.height, p.height) == 0 &&
				Double.compare(this.weight, p.weight) == 0;
		}
	
} // End of Person class