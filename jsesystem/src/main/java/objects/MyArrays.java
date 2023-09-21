package objects;

import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class MyArrays {

	/**
	 * Sinh ngẫu nhiên mảng int 1 chiều
	 * 
	 * @param n
	 * @return
	 */
	public static int[] generateArray(int n) {
		int[] arrInt = new int[n];

		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = (int) (Math.random() * 100);
		}
		return arrInt;
	}

	/**
	 * 
	 * @param rows
	 * @param cols
	 * @return
	 */
	public static int[][] generateArray(int rows, int cols) {
		int[][] arrInt = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			arrInt[i] = MyArrays.generateArray(cols);
		}

		return arrInt;
	}

	public static Person[] generatePerson(int n) {
		Person[] list = new Person[n];

		String[] firstNames = { "Anh", "Anh Tuấn", "Bình", "Bảo", "Cường", "Đông", "Tuấn Anh", "Huyền Anh", "Huyền",
				"Minh", "Minh Anh", "Yến", "Yến Anh", "Châu", "Châu Anh", "Hải", "Tùng", "Tùng Anh", "Anh Cường",
				"Việt", "Thủy", "Hưng", "Hùng", "Anh Vân" };

		String[] lastNames = { "An", "Bùi", "Cấn", "Dương", "Đoàn", "Đinh", "Đào", "Huỳnh", "Hoàng", "Hồ", "Ma", "Ngô",
				"Nguyễn", "Phan", "Phạm", "Phùng", "Trần", "Trương", "Ninh", "Vũ", "Võ" };

		// Sinh đối tượng
		int index;
		for (int i = 0; i < n; i++) {
			// Cấp phát bộ nhớ cho phần tử mảng
			list[i] = new Person();

			// Ngẫu nhiên tên
			index = (int) (Math.random() * firstNames.length);
			list[i].setFirstName(firstNames[index]);

			// Ngẫu nhiên họ
			index = (int) (Math.random() * lastNames.length);
			list[i].setLastName(lastNames[index]);

			// Ngẫu nhiên tuổi
			index = 18 + (int) (Math.random() * 5);
			list[i].setAge((byte) index);

		}

		return list;
	}

	/**
	 * 
	 * @param arrInt
	 * @param isINC
	 * @return
	 */
	public static int[] sortedArray(int[] arrInt, boolean isINC) {
		byte ori = (byte) (isINC ? 1 : -1);

		int tmp;
		for (int i = 0; i < arrInt.length - 1; i++) {
			for (int j = i + 1; j < arrInt.length; j++) {
				if (arrInt[i] * ori > arrInt[j] * ori) {
					tmp = arrInt[j];
					arrInt[j] = arrInt[i];
					arrInt[i] = tmp;
				}
			}
		}

		return arrInt;
	}

	public static Integer[] sortedArrayV2(int[] arrInt, boolean isINC) {
		// Chuyển về đối tượng
		// Integer[] data = Arrays.stream(arrInt).boxed().toArray(Integer[]::new);

		Integer[] data = new Integer[arrInt.length];
		Arrays.setAll(data, i -> arrInt[i]);

		if (isINC) {
			Arrays.sort(data);
		} else {
			Arrays.sort(data, Collections.reverseOrder());
		}

		return data;
	}

	public static int[][] sortedArray(int[][] arrInt, boolean isINC) {

		int rows = arrInt.length;
		int cols = arrInt[0].length;

		int[] tmp = new int[rows * cols];

		int r = 0, c = 0;

		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = arrInt[r][c++];

			if (c == cols) {
				r++;
				c = 0;
			}
		}

		tmp = MyArrays.sortedArray(tmp, isINC);

		r = 0;
		c = 0;
		for (int i = 0; i < tmp.length; i++) {
			arrInt[r][c++] = tmp[i];
			if (c == cols) {
				r++;
				c = 0;
			}
		}

		return arrInt;
	}

	public static int[] filterPrime(int[] arrInt, boolean isINC) {
		// Sắp xếp
		arrInt = MyArrays.sortedArray(arrInt, isINC);

		// Tách nguyên tố và không nguyên tố
		int[] temp1 = new int[arrInt.length];// Nguyên tố
		int[] temp2 = new int[arrInt.length];// Không nguyên tố
		int t1 = 0, t2 = 0;
		for (int value : arrInt) {
			if (core.Examples.isPrime(value)) {
				temp1[t1++] = value;
			} else {
				temp2[t2++] = value;
			}
		}

		// Gộp mảng
		for (int i = t1; i < temp1.length; i++) {
			temp1[i] = temp2[i - t1];
		}

		return temp1;
	}

	public static Person[] searchPerson(Person[] list, String name) {
		Person[] results = null;

		// Đếm số kết quả
		int count = 0;
		for (Person p : list) {
			if (p.getFirstName().toLowerCase().trim().contains(name.toLowerCase().trim())) {
				count++;
			}
		}

		results = new Person[count];

		// Ghi nhận kết quả
		count = 0;
		for (Person p : list) {
			if (p.getFirstName().toLowerCase().trim().contains(name.toLowerCase().trim())) {
				results[count++] = p;
			}
		}

		return results;
	}

	
	public static ArrayList<Person> searchPersonV2(Person[] list, String name) {
		ArrayList<Person> results = new ArrayList<>();

		String tmp;
		name = name.toLowerCase().trim();
		for (Person p : list) {
			tmp = p.getFirstName().toLowerCase().trim();
			if (tmp.contains(name)) {
				results.add(p);
			}
		}

		return results;
	}
	
	public static ArrayList<Person> sortedByAge(Person[] list, boolean isASC) {
		// Tập hợp trung gian
		ArrayList<Person> tmp = new ArrayList<>();
		Collections.addAll(tmp, list);
		
		//sắp xếp
		if(isASC) {
			Collections.sort(tmp);
		} else {
			Collections.sort(tmp, Collections.reverseOrder());
		}
		return tmp;
	}
	
	public static ArrayList<Person> sortedByName(Person[] list, boolean isASC) {
		// Tập hợp trung gian
		ArrayList<Person> tmp = new ArrayList<>();
		Collections.addAll(tmp, list);
		
		//Xác định dk sắp xếp
		
		//sắp xếp
		if(isASC) {
			Collections.sort(tmp, new byName());
		} else {
			Collections.sort(tmp, new byName().reversed());
		}
		return tmp;
	}

	public static void printArray(int[] arrInt) {
		// Cách 1 - theo c/c++
//		for (int i = 0; i < arrInt.length; i++) {
//			System.out.print(arrInt[i] + " ");
//		}

		// Cách 2 - theo java 5
//		for (int v : arrInt) {
//			System.out.print(v + " ");
//		}

		// Cách 3 - Chuyển mảng nguyên thủy sang đối tượng tương ứng
		Integer[] data = Arrays.stream(arrInt).boxed().toArray(Integer[]::new);
		System.out.print(Arrays.toString(data));

		System.out.println();
	}

	/**
	 * 
	 * @param arrInt
	 */
	public static void printArray(int[][] arrInt) {
		for (int[] row : arrInt) {
			MyArrays.printArray(row);
		}
	}

	public static void printPerson(Person[] list) {
		for (Person p : list) {
			System.out.println(p);
		}
	}
	
	public static void printPerson(ArrayList<Person> list) {
//		for (Person p : list) {
//			System.out.println(p);
//		}
		
		//Java 8
		//list.forEach(p -> System.out.println(p));
		
		list.forEach(System.out::println);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] arrInt = MyArrays.generateArray(20);
//
//		MyArrays.printArray(arrInt);
//
//		Integer[] tmp = MyArrays.sortedArrayV2(arrInt, true);
//
//		System.out.print(Arrays.toString(tmp));

		
		Person[] list = MyArrays.generatePerson(20);
		MyArrays.printPerson(list);
		System.out.print("---------------------\n");
		ArrayList<Person> results = MyArrays.sortedByName(list, true);
		MyArrays.printPerson(results);
	}
}

class byName implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		String name1 = o1.getFirstName();
		String name2 = o2.getFirstName();
		
		// lấy tên 1 từ để sắp xếp
		int at = name1.lastIndexOf(' ');
		if(at != -1) {
			name1 = name1.substring(at+1);
		}
		
		at = name1.lastIndexOf(' ');
		if(at != -1) {
			name1 = name1.substring(at+1);
		}
		return name1.compareToIgnoreCase(name2);
	}
	
}
