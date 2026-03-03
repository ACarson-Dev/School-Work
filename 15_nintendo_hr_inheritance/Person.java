/*Sources:
*/

/**
 * Represents a person with a name, weight, and height.
 * This class provides methods to access and modify person attribute
 * and overrides equals() and toString() for proper object comparison and display.
 */
public class Person implements Comparable<Person> {
	private String name;
	private double weight;
	private double height;

	/**
	 * Constructs a Person object with the specified attributes.
	 *
	 * @param name the name of the person
	 * @param height the height of the person in centimeters
	 * @param weight the weight of the person in kilograms
	 */
	public Person(String name, double height, double weight) {
		this.name = name; // 'this' is a reference to the current object
		this.height = height;
		this.weight = weight;
	}

	/**
	 * Copy constructor for Person.
	 *
	 * @param p the person to copy
	 */
	public Person(Person p) {
		this.name = p.name;
		this.height = p.height;
		this.weight = p.weight;
	}

	/**
	 * Gets the height of the person.
	 *
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Gets the weight of the person.
	 *
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * Gets the name of the person.
	 *
	 * @return the name of the person
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the height of the person.
	 *
	 * @param height the new height
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * Sets the weight of the person.
	 *
	 * @param weight the new weight
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
		return String.format("%-10s %-15.2f %-15.2f", name, height, weight);
	}

	/**
	 * Compares this person to another for alphabetical ordering by name.
	 *
	 * @param p the person to compare with
	 * @return a negative integer, zero, or a positive integer as this person's
	 */
	@Override
	public int compareTo(Person p) {
		return this.name.compareTo(p.getName());
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