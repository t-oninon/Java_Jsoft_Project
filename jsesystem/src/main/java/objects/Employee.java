/**
 * 
 */
package objects;

/**
 * @author T_Onion
 *
 */
public class Employee extends Person{
	// Constants
	public static final int ID = 0;
	public static final double NET = 0;
	public static final String POSITION = "???";
	
	//Employee property
	private int id;
	private double net;
	private String position;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstName, String lastName, byte age, Address address, int id, double net, String position) {
		super(firstName, lastName, age, address);
		
		this.id = id;
		this.net = net;
		this.position = position;
	}
	
	public int getId() {
		return id;
	}

	public double getNet() {
		return net;
	}

	public String getPosition() {
		return position;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setNet(double net) {
		this.net = net;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", " + super.toString() + ", net=" + net + ", position=" + position + "]";
	}
	
	public static void main(String[] args) {
		Address addr = new Address("Hà Nội", "Bắc Từ Liêm", "Phố Nhổn");
		
		Person e = new Employee("Thành", "Nguyễn Trung", (byte)20, addr, 12, 12000000, "Kỹ sư");
		
		System.out.println(e);
	}

}
