package objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NDImpl2 implements ND, BTT {

	public NDImpl2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addPerson(Person p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editPerson(Person p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delPerson(Person p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getInfo(Person p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> searchPerson(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> searchPerson(Person similar, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> searchPerson(Address addr, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> searchPerson(Person similar, Address addr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, Person> statisticPerson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, Person> statisticPerson(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, Person> statisticPerson(Person similar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, Person> statisticPerson(Address addr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> getAllStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> getAllStudent(Person p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Employee> getAllEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Employee> getAllEmployee(Person p) {
		// TODO Auto-generated method stub
		return null;
	}

}
