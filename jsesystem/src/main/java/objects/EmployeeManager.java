package objects;

public class EmployeeManager extends Manager {

	public EmployeeManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getInfo(Person p) {
		// TODO Auto-generated method stub
		return "EM " + p.toString();
	}
	
	public String getDetail(Person p) {
		return "Here " + super.getDetail(p);
	}

}
