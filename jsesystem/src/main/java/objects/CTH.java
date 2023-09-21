package objects;

import java.util.*;

public interface CTH {
	public List<Person> searchPerson(String name);
	public List<Person> searchPerson(Person similar, String name);
	public List<Person> searchPerson(Address addr, String name);
	public List<Person> searchPerson(Person similar, Address addr);
}
