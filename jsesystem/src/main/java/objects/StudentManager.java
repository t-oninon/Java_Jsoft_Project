package objects;

public class StudentManager extends Manager {

	public StudentManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getInfo(Person p) {
		// TODO Auto-generated method stub
		return "SM " + p.toString();
	}

}
