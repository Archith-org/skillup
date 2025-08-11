package coding;

import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Conversions {

	public static void convertFromStrToInt() {
		String str = "123456";
		int num = Integer.parseInt(str);
		int count = 0;
		System.out.println("Converted to Integer: " + num);

		// Appending COMMA to each number
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			result.append(str.charAt(i));
			if (i < str.length() - 1) {
				result.append(",");
			}
			count++;
		}
		System.out.println("Converted to Integer with Comma: " + result + ". Total Count: " + count);
	}

	public static void convertFromIntToStr() {
		int num = 123789;
		// METHOD1
		String str = Integer.toString(num);

		// METHOD2
//		String str = String.valueOf(num);
		System.out.println("Converted to String : " + str);
	}

	public static void convertListToMap() {
		List<String> li = Arrays.asList("Archith", "Selena", "John");
		Map<Integer, String> map = new HashMap<Integer, String>();

		// Manual Conversion
//		for(int i = 0; i < li.size(); i++) {
//			map.put(i, li.get(i));
//		}

		// Using Stream
		map = IntStream.range(0, li.size()).boxed().collect(Collectors.toMap(i -> i, li::get));

		// For Real Object
//		map = li.stream().collect(Collectors.toMap(employee::getId, employee::getName));

		System.out.println("Converted Map: " + map);
	}

	public static void convertMapToList() {
		Map<Integer, String> map = Map.of(1, "Apple", 2, "Banana", 3, "Cat", 4, "Dog");

		List<Map.Entry<Integer, String>> li = map.entrySet().stream().collect(Collectors.toList());
		System.out.println("Converted List: " + li);
	}
	
	public static void convertListToSet() {
		List<String> list = Arrays.asList("a", "b", "a", "c");
		
		Set<String> set = new HashSet<>(list);
		
		//Using Java 8
//		Set<String> set = list.stream().collect(Collectors.toSet());
		
		System.out.println("Converted Set: " + set);
	}

	public static void romanToInteger() {

		Map<Character, Integer> romanMap = new HashMap<Character, Integer>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);

		String roman = "LVIXI";
		int total = 0;
		int prevValue = 0;

		for (int i = roman.length() - 1; i >= 0; i--) {
			int currValue = romanMap.get(roman.charAt(i));
			if (currValue < prevValue) {
				total -= currValue; // subtract if smaller before bigger (e.g., IV)
			} else {
				total += currValue; // add otherwise
			}
			prevValue = currValue;
		}

		System.out.println("Converted Roman (LVIXI) to Integer: " + total);

	}

	public static void convertStringArrayToMap() {
		String[] strArray = { "abc", "efghij", "qwer" };

		Map<String, Integer> map = Arrays.stream(strArray).collect(Collectors.toMap(s -> s, s -> 1, Integer::sum // Merge
																													// function
																													// for
																													// duplicates
		));
		System.out.println("Converted String Array to Map: " + map);
	}
	
	public static void convertWordsToNumbers() {
		
		String words = "fifteen crore Six lakh forty thousand eight hundred and ninety two";
		
		final Map<String, Integer> numMap = new HashMap<>();
	    final Map<String, Integer> multMap = new HashMap<>();
	    
	     {
	        numMap.put("one", 1);    numMap.put("two", 2);    numMap.put("three", 3);
	        numMap.put("four", 4);   numMap.put("five", 5);   numMap.put("six", 6);
	        numMap.put("seven", 7);  numMap.put("eight", 8);  numMap.put("nine", 9);
	        numMap.put("ten", 10);   numMap.put("eleven", 11);numMap.put("twelve", 12);
	        numMap.put("thirteen", 13); numMap.put("fourteen", 14);
	        numMap.put("fifteen", 15); numMap.put("sixteen", 16);
	        numMap.put("seventeen", 17); numMap.put("eighteen", 18);
	        numMap.put("nineteen", 19); numMap.put("twenty", 20);
	        numMap.put("thirty", 30); numMap.put("forty", 40); numMap.put("fifty", 50);
	        numMap.put("sixty", 60); numMap.put("seventy", 70);
	        numMap.put("eighty", 80); numMap.put("ninety", 90);

	        multMap.put("hundred", 100);
	        multMap.put("thousand", 1000);
	        // Indian system
	        multMap.put("lakh", 1_00_000);
	        multMap.put("crore", 1_00_00_000);
	        // International system
	        multMap.put("million", 1000000);
	        multMap.put("billion", 1000000000);
	    }
	     
	     words = words.toLowerCase().replaceAll("[-]", " ").replaceAll(" and ", " ");
	        String[] parts = words.split("\\s+");

	        long total = 0;
	        long current = 0;

	        for (String word : parts) {
	            if (numMap.containsKey(word)) {
	                current += numMap.get(word);
	            } else if (multMap.containsKey(word)) {
	            	if (current == 0) current = 1;
	                current *= multMap.get(word);
	                if (multMap.get(word) >= 1000) {
	                    total += current;
	                    current = 0;
	                }
	            }
	        }
	        long resultedNumber = total + current;
	        String formattedNumber = NumberFormat.getNumberInstance(Locale.US).format(resultedNumber); // To add Comma (,) to digits.
	        System.out.println("Converted Words: (" + words + ") To Number:" + " ["+formattedNumber + "] .");   
	    
	}

	public static void conversionSummary() {
		System.out.println("------------CONVERSION BASICS-------------------\r\n"
				+ "String to Int: Integer.parseInt(str)\r\n"
				+ "Int to String: String.valueOf(number) or Integer.toString(number)\r\n"
				+ "List to Map: Use Collectors.toMap() with streams\r\n"
				+ "Map to List: Use entrySet(), keySet(), or values()\r\n" + "Array to List: Arrays.asList(array)\r\n"
				+ "List to Array: list.toArray()\r\n" + "String to Double: Double.parseDouble(str)\r\n"
				+ "Double to String: String.valueOf(number) or Double.toString(number)\r\n"
				+ "String to Date: Use SimpleDateFormat\r\n" + "Date to String: Use SimpleDateFormat\r\n"
				+ "String to Char Array: str.toCharArray()\r\n" + "Char Array to String: new String(charArray)\r\n"
				+ "----------------------------------");
	}

	public static void main(String args[]) {
		convertFromStrToInt();
		convertFromIntToStr();
		convertListToMap();
		convertMapToList();
		convertListToSet();
		romanToInteger();
		convertStringArrayToMap();
		convertWordsToNumbers();
		conversionSummary();

	}

}
