package objects;

import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class MyStrings {
	/**
	 * 
	 * @param str
	 * @param ch
	 * @param isIgnoreCase
	 * @return
	 */
	public static int countChar(String str, char ch, boolean isIgnoreCase) {
		int count = 0;

		if (isIgnoreCase) {
			str = str.toLowerCase();
			ch = Character.toLowerCase(ch);
		}

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				count++;
			}
		}
		return count;
	}

	public static String formatString(String str, FORMAT_TYPE ft) {
		// Xác định ký tự đặc biệt cần loại bỏ
		char[] chs = { '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '<', '>', '?',
				'/', ':', ';', '\'', '"', '{', '[', '}', ']', '\\', '|' };

		// Loại bỏ các kí tự này
		for (char ch : chs) {
			str = str.replace(ch, ' ');
		}

		// Loại bỏ khoảng trống đầu và cuối
		str = str.trim();

		// Loại bỏ khoảng trắng bên trong
		while (str.indexOf("  ") != -1) {
			str = str.replace("  ", " ");
		}

		str = str.replace(" . ", ". ");
		str = str.replace(" , ", ", ");

		switch (ft) {
		case NAME:
		case FULLNAME:
			String[] tmp = str.split(" ");
			str = "";
			for (String w : tmp) {
				str += Character.toUpperCase(w.charAt(0)) + w.substring(1) + " ";
			}
			str = str.trim();
			break;
		case SENTENCE:
			str = str.toLowerCase();
			String[] tmp1 = str.split("\\.\\s");
			str = "";
			for (String w : tmp1) {
				str += Character.toUpperCase(w.charAt(0)) + w.substring(1) + ". ";
			}
			str = str.trim();
			break;
		case NOUND:
			str = str.toUpperCase();
			break;
		default:
		}
		return str;

	}

	public static int countWords(String str) {
		// Chuẩn hóa chuỗi
		str = MyStrings.formatString(str, FORMAT_TYPE.NORMAl);
		return MyStrings.countChar(str, ' ', false) + 1;
	}

	public static String getWords(String str) {
		// Chuẩn hóa chuỗi
		str = MyStrings.formatString(str, FORMAT_TYPE.NORMAl);

		int nWords = countWords(str);

		// Xác định vị trí đẻ cắt
		short i;
		short count = 0;
		for (i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				count++;

				if (count >= nWords) {
					break;
				}
			}
		}
		if (str.length() < str.length() - 1) {
			return str.substring(0, i) + "...";
		}
		return str;
	}

	public static HashMap<String, Integer> statisticWords(String str, String ch_split) {
		HashMap<String, Integer> tmp = new HashMap<>();
		String[] tmp_words = str.split(ch_split);
		for (String w : tmp_words) {
			if (!w.equalsIgnoreCase("")) {
				if (tmp.containsKey(w)) {
					tmp.replace(w, tmp.get(w) + 1);
				} else {
					tmp.put(w, 1);
				}
			}
		}
		return tmp;
	}

	public static void printStatistic(HashMap<String, Integer> tmp, boolean isSorted) {
		if(isSorted) {
			/*
			 * TreeMap<String, Integer> sorted_tmp = new TreeMap<>(tmp); for
			 * (Map.Entry<String, Integer> e : sorted_tmp.entrySet()) {
			 * System.out.println(e.getKey() + " - " + e.getValue()); }
			 */
		} else {
			/*
			 * //Java 5 for (Map.Entry<String, Integer> e : tmp.entrySet()) {
			 * System.out.println(e.getKey() + " - " + e.getValue()); }
			 */
			// JAVA 8
			//tmp.forEach((k,v) -> System.out.println(k + " - " + v));
		}
	}

	public static void main(String[] args) {
		/*
		 * String str =
		 * "Nguồn tin tiết lộ MU đã theo đuổi thương vụ này từ hồi mùa đông. Tuy nhiên, ban lãnh đạo đội bóng không duyệt chi nên Erik Ten Hag buộc phải đợi đến mùa hè. Vậy Axel Disasi có điểm mạnh là gì? Cầu thủ này không chiến rất tốt nhờ thể hình cao to (cao 1m90, nặng 83kg). Tuy nhiên, hậu vệ người Pháp không hề chậm chạp mà ngược lại, thường xuyên áp sát rất nhanh đối thủ. Đây là những đặc điểm phù hợp thi đấu tại Anh."
		 * ;
		 * 
		 * int count = MyStrings.countChar(str, 'e', true);
		 * System.out.println(formatString(str, FORMAT_TYPE.SENTENCE));
		 */
		String str = "abc##dfh##abc##ktm#dfh#abc";
		MyStrings.printStatistic(MyStrings.statisticWords(str, "#"), true);

	}
}

enum FORMAT_TYPE {
	NAME, FULLNAME, SENTENCE, NOUND, NORMAl
}