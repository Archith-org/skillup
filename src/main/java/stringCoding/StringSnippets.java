package stringCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringSnippets {
	
	//REVESER STRING
	public static void stringSimpleReverse() {
		String original = "Mongoose";
		System.out.println("Simple Original: " + original);
		String reversed="";
		for(int i=0;i<original.length();i++) {
			reversed = original.charAt(i)+reversed;
		}
		System.out.println("Simple reversed: " + reversed);
	}
	
	public static void stringReverse() {
		String oneString = "Archith, Kulkarni";
		System.out.println("Original String: " + oneString);
		StringBuilder reversedString = new StringBuilder(oneString).reverse();
		System.out.println("Revesred String: " + reversedString);
	}
	
	
	public static void stringReverseUseChar() {
		String oneString = "JoshGates";
		System.out.println("Original String: " + oneString);
		char[] charArray = oneString.toCharArray();
        // Reverse the char array
        for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        // Convert char array back to string
        String reversedString = new String(charArray);
        System.out.println("Reversed using char array: " + reversedString);
	}
	
	
	public static void stringRotationCheck() {
		String str1 = "abcd"; //monday
		String str2 = "bcda"; //cdab, dabc, ymonda
		
		if(str1.length() != str2.length()) {
			System.out.println("String lenght is different to check rotation");
		}
		else {
			String concatedStr = str1 + str1;
			if(concatedStr.contains(str2)) {
				System.out.println("String Rotated");
			}
			else {
				System.out.println("String NOT rotated");
			}
		}
		
		
	}
	
	
	
	//REMOVE DUPLICATES
	public static void removeDuplicateWords() {
		String duplicatedString = "Apple Banana Orange Apple Sun moon Sun Orange";
		
		List<String> listOfStrings = Arrays.asList(duplicatedString.split(" "));
		
		//Using SET
        List<String> uniqueWordLists = new ArrayList<>(new LinkedHashSet<>(listOfStrings));
        String results = String.join(" ", uniqueWordLists);
        System.out.println("String without duplicates using SET: " + results);
        
        //Using JAVA8
		List<String> uniqueWordsList = listOfStrings.stream()
                .distinct()
                .collect(Collectors.toList());

        // Join the unique words into a string
        String result = String.join(" ", uniqueWordsList);

        System.out.println("Original String: " + duplicatedString);
        System.out.println("String without duplicates - JAVA8: " + result);
	}
	
	public static void removeDuplicateChars() {
		String duplicateStr = "aabcdeef";
		String uniqueString = duplicateStr.chars()
										  .distinct()
										  .mapToObj(c -> String.valueOf((char) c))
										  .collect(Collectors.joining());
		System.out.println("String without duplicates CHARS - JAVA8: " + uniqueString);
	}
	
	//GET DUPLICATES
	public static void getOnlyDuplicates() {
		List<String> listWithDuplicates = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");
		
		Map<String, Long> duplicates = listWithDuplicates.stream()
										.collect(Collectors.groupingBy(s->s, Collectors.counting()))
										.entrySet().stream()
										.filter(entry -> entry.getValue() > 1)
										.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		System.out.println("ONLY DUPLICATES: " + duplicates);
	}
	
	//GET ONLY UNIQUE
	public static void getOnlyUnique() {
		String str = "Today is a good day and Today is also a beautifulDay also";
		String[] words = str.split(" ");
        List<String> uniqueWords = new ArrayList<String>();
        List<String> listOfwords = Arrays.asList(words);
        for(String iterateWords :listOfwords)  {
            if(Collections.frequency(listOfwords,iterateWords)==1){
            	uniqueWords.add(iterateWords);
            }
        }  
        System.out.println("Unique Words: "+uniqueWords);
	}
	
	
	//NON-REPEATING
	private static void firstNonRepeatingChar() {
			String str = "Archith";
			boolean flag = true;
			for(char c : str.toCharArray()) {
				if(str.indexOf(c) == str.lastIndexOf(c)) {
					System.out.println("First Non Repeating Char: " + c);
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println("There is no non repeating character in input string");
			}
	}
	
	public static void nonRepeatingWords() {
		String str = "Archith, Kumar, Kulkarni, Kumar, JoshGates, BillGates, etc.. Kulkarni + JoshGates";
		String regEx = ("[ \\,\\+]");
		String[] words = str.split(regEx);
		
		Map<String, Long> wordCount = Arrays.stream(words)
											.collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
//									.collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		System.out.println("wordCount: " + wordCount);
		List<String> nonRept = Arrays.stream(words)
									 .filter(word -> wordCount.getOrDefault(word.toLowerCase(), 0L) == 1)
									 .collect(Collectors.toList());
		
		System.out.println("Non RepeatingWords : " + nonRept);
	}
	
	
	//PALINDROME
	public static void stringPalindrome() {
		String str = "MadAm";
		str = str.toLowerCase();
//		String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		String reversed="";
		boolean palindrome = true;
		
		for(int i=0;i<str.length();i++) {
			reversed = str.charAt(i)+reversed;
		}
		if(str.equals(reversed)) {
			System.out.println("Panlindrome: " + palindrome);
		}
		else {
			System.out.println("Panlindrome: " + !palindrome);
		}
	}
	
	public static void getOnlyStartsWith() {
		String[] strArray = {"Sea", "Ocean","sunset","Dish","Ship","Order","Restaurant","Food","Night"};
		List<String> list = Arrays.asList(strArray);
		List li = list.stream()
				.map(String::toLowerCase)
				.filter(c -> c.startsWith("s"))
				.collect(Collectors.toList());
		System.out.println("List Starts with : " + li.toString());
	}
	
	public static void streamCheck() {
		String[] str = {"Dummy","dummy","","Duplicate","Copy","Inherit"};
		String[] strs = {"Abc123","87Hey","OkGoogle","Ni8gth","Austr@lia","H&M","@gmail.com","#e!^0"};

		List<String> li = Arrays.asList(str);
		List<String> li2 = Arrays.asList(strs);
		//STREAM-COUNT
		long count = li.stream().count();
		System.out.println("Stream count: " + count);
		//STREAM-DISTINCT
		if(count > 1) {
			List distinct = li.stream().map(String::toLowerCase).distinct().toList();
			System.out.println("Stream Distinct: " + distinct);
		}
		//STREAM-EQUALS
		if(count == count) {
			boolean b = li.stream().equals("dummy");
			System.out.println("Stream equals: " + b);
		}
		//STREAM-DROPWHILE
		List dropWhile = li.stream().dropWhile(predicate -> !predicate.matches("")).toList();
		System.out.println("Stream Drop while: " + dropWhile);
		//STREAM-ONLYALPHA
		String[] onlyAlpha = Arrays.stream(strs).map(temp -> temp.replaceAll("[^a-zA-Z]", "")).toArray(String[]::new);
		List onlyAlphaList = new ArrayList<>();
		for(String alpha: onlyAlpha) {
			onlyAlphaList.add(alpha);
		}
		System.out.println("Alphabetics only: " + onlyAlphaList.toString());
		//STREAM-ONLYNUMERIC
		String[] onlyNumeric = Arrays.stream(strs).map(temp -> temp.replaceAll("[^0-9]", "")).toArray(String[]::new);
		List onlyNumericList = new ArrayList<>();
		for(String num : onlyNumeric) {
			onlyNumericList.add(num);
		}
		System.out.println("Numerics only: " + onlyNumericList.toString());
		//STREAM-ONLYSPECIALCHARS
		String[] onlySpecialChars = Arrays.stream(strs)
                .map(temp -> temp.chars()
                		.mapToObj(c -> (char) c)
                        .filter(ch -> !Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch))
                        .map(String::valueOf)
                        .collect(Collectors.joining()))
                      	.toArray(String[]::new);
		List onlySpecialCharList = new ArrayList<>();
		for(Object specialChar : onlySpecialChars) {
			onlySpecialCharList.add(specialChar);
		}
		System.out.println("Special Chars only: " + onlySpecialCharList.toString());        
		
	}
	
	
	public static void findMinMax() {
		List<Integer> li = Arrays.asList(1,2,3,6,8,9,10,15,89,101,500);
		Optional<Integer>  maxNum = li.stream().max(Integer::compareTo);
		Optional<Integer> minNum = li.stream().min(Integer::compareTo);
		
		if(maxNum.isPresent() && minNum.isPresent() ) {
			System.out.println("Max Number: " + maxNum);
			System.out.println("Min Number: " + minNum);
		}
		else {
			System.out.println("List is EMPTY");
		}
	}
	
	public static void getAscendingDescendingOrder() {
		
		List<Integer> li = Arrays.asList(1,240,31,60,8,9,10,105,89,101,50);
		
		//Asceding Order Java 8
		List ascedingList = li.stream().sorted().collect(Collectors.toList());
		
		//Desceding Order Java 8
		List descedingList = li.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		System.out.println("Original List without sort: " + li);
		System.out.println("Asceding Order: " + ascedingList);
		System.out.println("Desceding Order: " + descedingList);
	}
	
	
	public static void stringCharsSameCheck() {
		String str1 = "hello";
		String str2 = "olehl";
		
		if(str1.length() != str2.length()) {
			System.out.println("String lenghts are not same to check chars are present in String2 or not !");
		}
		else {
			Map<Character, Long> charCountMap = str2.chars()
	                .mapToObj(c -> (char) c)
	                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			
			boolean isAllCharsAvailable = str1.chars()
	                .mapToObj(c -> (char) c)
	                .allMatch(ch -> charCountMap.containsKey(ch) && charCountMap.get(ch) > 0);

			if(isAllCharsAvailable) {
				System.out.println("All chars in second string are same");
			}
			else {
				System.out.println("All chars in second string NOT same");
			}
	        
		}
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stringSimpleReverse();
		stringReverse();
		stringReverseUseChar();
		stringRotationCheck();
		removeDuplicateWords();
		getOnlyDuplicates();
		removeDuplicateChars();
		getOnlyUnique();
		firstNonRepeatingChar();
		nonRepeatingWords();
		stringPalindrome();
		getOnlyStartsWith();
		streamCheck();
		findMinMax();
		getAscendingDescendingOrder();
		stringCharsSameCheck();
	}

	

}
