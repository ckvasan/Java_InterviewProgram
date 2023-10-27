package practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class StringStoring {

	public static void main(String[] args) {
		String text = "This is java program";
		sortString(text);
	}

	private static void sortString(String text) {
		String[] words = text.split("\\s");
		Optional<String> sorted = Arrays.stream(words).sorted(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length()) {
					return 1;
				} else if (o1.length() == o2.length()) {
					return 0;
				}
				return -1;
			}
		}).reduce((s1,s2) -> s1+" "+s2);
		
		System.out.println("Sorted String based length >> " + sorted.get());
	}
}
