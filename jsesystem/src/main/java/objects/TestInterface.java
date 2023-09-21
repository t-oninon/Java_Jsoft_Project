package objects;

public class TestInterface {

	public static void main(String[] args) {
		ND nd1 = new NDImpl1(); //CTX
		
		ND nd2 = new NDImpl2(); //CTX, CTH, GDS, BTT
		
		BTT btt = new BTTImpl(); //CTX, CTH, GDS
	}

}
