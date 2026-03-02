/*Sources:
*/

public class Person {
	private String name;
	private double weight;
	private double height;
	
	
	public Person(String name, double weight, double height) {
		this.name = name; // 'this' is a reference to the current object
		this.weight = weight;
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return name + " is " + height + " feet tall and " + weight + " pounds.";
	}
	
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