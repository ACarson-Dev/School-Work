import java.util.ArrayList;

public class PersonSet implements PersonList {
	protected ArrayList<Person> people = new ArrayList<Person>();
	
	// Override the add method and checks for duplicates
	@Override
	public void add(Person p) {
		if(!people.contains(p)){
			people.add(p);
		}
	}
	
	// Override the get method and returns the person at the given index
	@Override
	public Person get(int index) {
		return people.get(index);
	}
	
	// Override the toString method and returns a string representation of the PersonSet
	@Override
	public String toString() {
		String result = "";
		for (Person p : people) {
			result += p.toString() + "\n";
		}
		return result;
	}
	
} // End of PersonSet class