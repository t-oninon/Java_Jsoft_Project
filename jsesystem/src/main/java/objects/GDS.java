package objects;

import java.util.*;

public interface GDS {
	public HashMap<Integer, Person> statisticPerson();
	public HashMap<Integer, Person> statisticPerson(String name);
	public HashMap<Integer, Person> statisticPerson(Person similar);
	public HashMap<Integer, Person> statisticPerson(Address addr);
}
