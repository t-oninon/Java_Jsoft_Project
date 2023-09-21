package core;

public class Examples {

	/**
	 * Phương thức này được sử dụng để kiểm tra một giá trị nguyên n có phải
	 * <b>nguyên tố</b>? <br>
	 * <i>Cập nhật 09/03/2023</i>
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n) {
		// Kiểm tra n có phải nguyên tố?
		boolean flag = true;

		if (n < 2) {
			flag = false;
		} else {
			for (int v = 2; v <= (int) (Math.sqrt(n)); v++) {
				if (n % v == 0) {
					flag = false;
					break;
				}
			}
		}

		return flag;
	}

	/**
	 * Phương thức tìm UCLN của 2 giá trị nguyên dương.<br>
	 * <i>Cập nhật 09/03/2023</i>
	 * 
	 * @author Huyfit JSOFT
	 * @param a
	 * @param b
	 * @return - Trả về giá trị UCLN hoặc -1 (không tồn tại UCLN)
	 */
	public static int getUCLN(int a, int b) {
		int ucln = -1;

		if (a * b != 0) {
			while (a != b) {
				if (a > b) {
					a -= b; // a = a-b;
				} else {
					b -= a;
				}
			}

			ucln = a;
		}

		return ucln;
	}

	public static int getUCLN(int a, int b, int c) {
		return Examples.getUCLN(Examples.getUCLN(a, b), c);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Sinh ngẫu nhiên một giá trị nguyên (int) trong phạm vi [0-100)
		int n = (int) (Math.random() * 100);
		int m = (int) (Math.random() * 100);

		// In ra màn hình
		System.out.print("UCLN của n=" + n + " và m=" + m + " là: " + Examples.getUCLN(n, m));

	}

}
