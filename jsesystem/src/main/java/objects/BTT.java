package objects;

import java.util.*;

public interface BTT extends CTX, CTH, GDS {
	public ArrayList<Student> getAllStudent();
	public ArrayList<Student> getAllStudent(int id);
	public ArrayList<Student> getAllStudent(Person p);
	
	public ArrayList<Employee> getAllEmployee();
	public ArrayList<Employee> getAllEmployee(int id);
	public ArrayList<Employee> getAllEmployee(Person p);
}
