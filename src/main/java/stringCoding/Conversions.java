package stringCoding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Conversions {
	
	public static void convertFromStrToInt() {
		String str = "123456";
		int num = Integer.parseInt(str);
		int count = 0;
		System.out.println("Converted to Integer: " + num);
		
		//Appending COMMA to each number
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			result.append(str.charAt(i));
			if(i < str.length() - 1) {
				result.append(",");
			}
			count++;
		}
		System.out.println("Converted to Integer with Comma: " + result + ". Total Count: " + count);
	}
	
	public static void convertFromIntToStr() {
		int num = 123789;
		//METHOD1
		String str = Integer.toString(num);
		
		//METHOD2
//		String str = String.valueOf(num);
		System.out.println("Converted to String : " + str);
	}
	
	public static void convertListToMap() {
		List<String> li = Arrays.asList("Archith", "Selena", "John");
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		//Manual Conversion
//		for(int i = 0; i < li.size(); i++) {
//			map.put(i, li.get(i));
//		}
		
		//Using Stream
		map = IntStream.range(0, li.size())
				.boxed()
				.collect(Collectors.toMap(i -> i, li::get));
		
		//For Real Object
//		map = li.stream().collect(Collectors.toMap(employee::getId, employee::getName));
		
		System.out.println("Converted Map: " + map);
	}
	
	public static void convertMapToList() {
		Map<Integer, String> map = Map.of(1,"Apple", 2,"Banana", 3,"Cat", 4,"Dog");
		
		List<Map.Entry<Integer, String>> li = map.entrySet().stream().collect(Collectors.toList());
		System.out.println("Converted List: " + li);
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

	
	public static void conversionSummary() {
		System.out.println("------------CONVERSION BASICS-------------------\r\n"
				        + "String to Int: Integer.parseInt(str)\r\n"
				        + "Int to String: String.valueOf(number) or Integer.toString(number)\r\n"
				        + "List to Map: Use Collectors.toMap() with streams\r\n"
				        + "Map to List: Use entrySet(), keySet(), or values()\r\n"
				        + "Array to List: Arrays.asList(array)\r\n"
				        + "List to Array: list.toArray()\r\n"
				        + "String to Double: Double.parseDouble(str)\r\n"
				        + "Double to String: String.valueOf(number) or Double.toString(number)\r\n"
				        + "String to Date: Use SimpleDateFormat\r\n"
				        + "Date to String: Use SimpleDateFormat\r\n"
				        + "String to Char Array: str.toCharArray()\r\n"
				        + "Char Array to String: new String(charArray)\r\n"
	                       + "----------------------------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String args[]) {
		convertFromStrToInt();
		convertFromIntToStr();
		convertListToMap();
		convertMapToList();
		romanToInteger();
		
		
		conversionSummary();
		

	}

}
