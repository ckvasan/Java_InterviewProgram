package practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StringManipulation {

	public static void main(String[] args) {
		String text = "This is java program";
		sortString(text);
		wordsCount("big black bug bit a big black bear");
	}

	private static void wordsCount(String str) {
		String[] words=  str.split("\\s");
		Map<String, Integer> m = new HashMap<String, Integer>();
		for (String w : words)
		{
			m.computeIfPresent(w, (k,v) -> v +1);
			m.computeIfAbsent(w, k -> 1);
			
		}
		
		m.forEach((k,v) -> System.out.println( "The Word : '"+ k + "' occured: " +v +" times") );
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
