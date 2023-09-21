package objects;

public class TestPerson {

	public TestPerson() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Address addr = new Address("Hà Nội", "Bắc Từ Liêm", "Phố Nhổn");
		
		Person s = new Student("Thành", "Nguyễn Trung", (byte)20, addr, 2811, "(2023)0011223344", "Công nghệ thông tin");
		Person e = new Employee("Hòa", "Nguyễn Thị", (byte)20, addr, 14, 12000000, "Y tá");
		
		System.out.println(s + "\n" + e);
	}

}
