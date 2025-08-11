package coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
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
	
	//STRING ROTATION
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
	
	//Check COMMON CHARS IN SUB STRING
	public static void checkCharInSubString() {
		String originalString = "ABCDQWE197RTY";
		String subString = "AQWEB9CSTY";
		Set<Character> commonChars = new HashSet<Character>();
		
		for(int i = 0; i<originalString.length();i++) {
			char ch = originalString.charAt(i);
			if(subString.indexOf(ch) != -1) {
				commonChars.add(ch);
			}
		}
		
		if(!commonChars.isEmpty()) {
			//FOR SORTING ASC
			Set<Character> commonCharsSorted = new TreeSet<Character>();
			commonCharsSorted.addAll(commonChars);
			
			//FOR SORTING DESC
			Set<Character> commonCharsSortedReversed = new TreeSet<Character>(Collections.reverseOrder());
			commonCharsSortedReversed.addAll(commonCharsSorted);
			
			System.out.println("Common CHARS found in substring are: " + commonCharsSortedReversed);
		}
		else {
			System.out.println("NO Common CHARS found in substring ");
		}
			
		
	}
	
	
	
	//REMOVE DUPLICATES WORDS
	public static void removeDuplicateWords() {
		String duplicatedString = "Apple Banana Orange Apple Sun moon Sun Orange";
		
		List<String> listOfStrings = Arrays.asList(duplicatedString.split(" "));
		
		//Using SET
        List<String> uniqueWordLists = new ArrayList<>(new LinkedHashSet<>(listOfStrings));
        String results = String.join(" ", uniqueWordLists);
        System.out.println("String without duplicates using SET: " + results);
        
        //Using JAVA8
		List<String> uniqueWordsList = listOfStrings.stream()
//				.filter(word -> Collections.frequency(listOfStrings, word) == 1) // Used to remove completely  the duplicated words
                .distinct()
                .collect(Collectors.toList());

        // Join the unique words into a string
        String result = String.join(" ", uniqueWordsList);

        System.out.println("Original String: " + duplicatedString);
        System.out.println("String without duplicates - JAVA8: " + result);
	}
	
	//REMOVE DUPLICATE CHARS
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
	
	
	//NON-REPEATING CHARS
	private static void firstNonRepeatingChar() {
			String str = "Archith";
			boolean flag = true;
			for(char c : str.toCharArray()) {
				if(str.indexOf(c) == str.lastIndexOf(c)) {
					System.out.println("First Non Repeating Char: " + c);
					flag = false;
					break;
//					System.out.println("Next Non Repeating Char: " + c);
//					System.out.println("Only Repeating Char: " + c); // Conditon should be changed from == to != in IF block
				}
			}
			if(flag) {
				System.out.println("There is no non repeating character in input string");
			}
	}
	
	//NON-REPEATING WORDS
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
		System.out.println("List Starts with s: " + li.toString());
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
		
		//STREAM-TOUPERACSE/TOLOWERCASE
		List upperCaseList = li.stream()
		  .map(String::toUpperCase)
//		  .map(String::toLowerCase)
		  .toList();
		System.out.println("Upper case:" + upperCaseList);
		
		//STREAM-OCCURANCE OF EACH CHAR
		String str3 = "Heres the coding path";
		Map occurance = str3.chars()
			.mapToObj(ch -> (char) ch)
			.collect(Collectors.groupingBy(qw -> qw, Collectors.counting()));
		System.out.println("Char occurances: "+ occurance.entrySet());
		
		//STREAM-LENGTH OF CHARS IN WORD
		String str4 = "FAANG Companies are in top";
		Map<Object, Integer> lengthMap = Arrays.stream(str4.split(" "))
			  .collect(Collectors.toMap(word -> word, String::length, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println("Char length in word: " + lengthMap);
		
		//COMMON ELEMENTS IN ARRAY
		int[] array1 = {1,2,3,4,6,8,0};
		int[] array2 = {4,6,7,1,0,3};
		
		List commonElementsList = Arrays.stream(array1)
			  .filter(arr1Num -> Arrays.stream(array2)
					  .anyMatch(arr2Num -> arr2Num == arr1Num))
			  .boxed()
			  .collect(Collectors.toList());
		
		System.out.println("commonElements in Arrays: " + commonElementsList);
		
		//LONGEST STRING to print Count
		int longstString = Arrays.stream(str)
							     .mapToInt(String::length)
							     .max()
							     .orElse(0);
		System.out.println("Longst String COUNT: " + longstString);
		
		//Longest STRING To Print Word
		 Optional<String> longest = Arrays.stream(str)
	                .max((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		 longest.ifPresent(s -> System.out.println("Longest string WORD: " + s));
		
		
		
	}
	
	
	//MIN MAX
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
	
	//ASC DESC
	public static void getAscendingDescendingOrder() {
		
		List<Integer> li = Arrays.asList(1,240,31,60,8,9,10,105,89,101,50);
		
		//Asceding Order Java 8
		List ascedingList = li.stream().sorted().collect(Collectors.toList());
		
		//Desceding Order Java 8
		List descedingList = li.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//		                                       (Collections.reverseOrder())
		
		System.out.println("Original List without sort: " + li);
		System.out.println("Asceding Order: " + ascedingList);
		System.out.println("Desceding Order: " + descedingList);
	}
	
	//ODD EVEN
	public static void checkOddEven() {
		
		//Check Middle Element in Even or Odd values:
		List<String> list = Arrays.asList("A", "B", "D", "E"); 
		int size = list.size();
		int num = size;
		
		int midRightIndex = size / 2; // This gives RIGHT middle
		int midLeftIndex = (size - 1) / 2; // This gives LEFT middle
	    
		
	    if (size == 0) {System.out.println("List size is: " + size);}
	    
		if(num%2 == 0) {
			System.out.println("Even Number: " + num);
		}
		else {
			System.out.println("Odd Number: " + num);
		}
	    
	    System.out.println("Middle Element: " + list.get(midRightIndex));
	}
	
	//CHAR SAME CHECK
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
	
	//COUNT VOWELS
	public static void countVowelsConsonants() {
		String input = "Schandler";
	    String lower = input.toLowerCase().replaceAll("[^a-z]", "");
	    long vowels = lower.chars().filter(c -> "aeiou".indexOf(c) != -1).count();
	    long consonants = lower.length() - vowels;
	    System.out.println("Vowels: " + vowels +" "+ "Consonants: " + consonants);
	}
	
	//ANAGRAM & PANGRAM
	public static void checkAnagramAndPangram() {
		
		String str1 = "The brown fox jumps quick over the lazy dog";
	    String str2 = "The brown";
	    boolean anagram = false;
	    boolean pangram = false;
	    if(!str1.isEmpty() && str1.length() == str2.length()) {
	    	char[] arr1 = str1.toLowerCase().toCharArray();
		    char[] arr2 = str1.toLowerCase().toCharArray();
		    
		    
		    Arrays.sort(arr1);
		    Arrays.sort(arr2);
		    
		    anagram = Arrays.equals(arr1, arr2);

		    System.out.println("Anagram: "+ anagram + " - Yes it contains atleast one char");
	    }
	    else{
	    	System.out.println("Anagram: "+ anagram + " - Length is not equal to validate");
	    }
	    
	    
	    if(!str2.isEmpty()) {
	    	pangram = str2.toLowerCase().chars()
    							   .filter(Character::isLetter)
    							   .distinct()
    							   .count() == 26;
	    	System.out.println("Pangram: " + pangram + " - Should contain all 26 letters at least once"); 
	    }
	    
	}
	
	
	 public static void getMaxVersion() {
		 List<String> versions = Arrays.asList("1.1", "12.3.1", "16.0", "11.24.2", "18.1");
		 
		 String maxVersion = versions.stream()
		            				 .max((v1, v2) -> {
		            					   List<Integer> parts1 = Arrays.stream(v1.split("\\."))
		                                             .map(Integer::parseInt)
		                                             .collect(Collectors.toList());
		            					   List<Integer> parts2 = Arrays.stream(v2.split("\\."))
		                                             .map(Integer::parseInt)
		                                             .collect(Collectors.toList());
		            					   int length = Math.max(parts1.size(), parts2.size());
		            					   for (int i = 0; i < length; i++) {
		            						   int num1 = i < parts1.size() ? parts1.get(i) : 0;
		            						   int num2 = i < parts2.size() ? parts2.get(i) : 0;
		            						   if (num1 != num2) {
		            							   return Integer.compare(num1, num2);
		            						   }
		            					   }
		            					   return 0;
		            				 	})
		            				 .orElse(null);
		 
		 System.out.println("Max Version: " + maxVersion);
		    }
	  
	 //INDEX VALUES MATCH
	 public static void checkMiddleElement() {
		 List list = Arrays.asList(1,2,3,4,5);
		 
		 //Check only left and right index value with middle index
		 int midIndex = list.size()/2;
		 int midValue = (int) list.get(midIndex);
		 int leftValue = (int) list.get(midIndex-1);
		 int rightValue = (int) list.get(midIndex+1);
		 
		 if((leftValue == midValue) && (rightValue == midValue)) {
			 System.out.println("Middle index: "+midValue+ " is same as left and right indexes");
		 }else {
			 System.out.println("Middle index: "+midValue+ " is NOT same as left and right indexes");
		 }
		
		//Check All left and right index values with middle index
		int leftSum =0;
		int rightSum = 0;
		boolean sumOfindexValue = false;
		
		for(int i =0; i<midIndex;i++) {
			leftSum += (int) list.get(i);
		}
		
		for (int i = midIndex + 1; i < list.size(); i++) {
            rightSum += (int) list.get(i);
        }
		
		if(leftSum == midValue &&  rightSum == midValue) {
			sumOfindexValue = true;
			System.out.println("Both Sum of left and right indexes are matching with midindex value: " + sumOfindexValue);
		}
		else if(leftSum == midValue ||  rightSum == midValue){
			sumOfindexValue = true;
			System.out.println("Either sum of left or right indexes are matching with midIndex value: " + sumOfindexValue);
		}
		else {
			System.out.println("Any sum of left and right indexes are NOT matching with midIndex value: " + sumOfindexValue);
		}
						 
	 }
	 
	 public static void convertStringArrayToMapUsingAutoIncrementKey() {
		 
		 String[] strArray = {"abc", "efghij", "qwer"};
		 AtomicInteger stringIndex = new AtomicInteger(0); // Use for Key as abc
//	    AtomicInteger numberIndex = new AtomicInteger(1); // Use for Key as 123

	    Map<String, Integer> map = Arrays.stream(strArray)
	            .collect(Collectors.toMap(
	                    s -> String.valueOf((char) ('a' + stringIndex.getAndIncrement())), // key: 'a', 'b', 'c'...
//	                    s -> String.valueOf(numberIndex.getAndIncrement()), // key: "1", "2", "3"
	                    String::length // value: string length
	            ));

	    System.out.println("Converted String Array to Map using Auto Increment Key: "+ map); // Output: {a=3, b=7, c=4}
	 }
	 
	 public static void sortStringsByLength() {
		 List<String> unSortedList = List.of("Zebra ", "Apple", "Man", "A dog", "When12", "Archith@org.com");
		 
		 List result = unSortedList.stream()
		 			 .distinct()
		 			 .sorted(Comparator.comparingInt(String::length)) // For ASC
//		 			.sorted(Comparator.comparingInt(String::length).reversed()) // For DESC
		 			 .collect(Collectors.toList());
		 
		 System.out.println("Sorted List According to Length: " + result.toString());
	 }

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stringSimpleReverse();
		stringReverse();
		stringReverseUseChar();
		System.out.println("-------------------");
		stringRotationCheck();
		System.out.println("-------------------");
		checkCharInSubString();
		System.out.println("-------------------");
		removeDuplicateWords();
		removeDuplicateChars();
		System.out.println("-------------------");
		getOnlyDuplicates();
		getOnlyUnique();
		System.out.println("-------------------");
		firstNonRepeatingChar();
		nonRepeatingWords();
		System.out.println("-------------------");
		stringPalindrome();
		System.out.println("-------------------");
		getOnlyStartsWith();
		System.out.println("-------------------");
		streamCheck();
		System.out.println("-------------------");
		findMinMax();
		System.out.println("-------------------");
		getAscendingDescendingOrder();
		System.out.println("-------------------");
		checkOddEven();
		System.out.println("-------------------");
		stringCharsSameCheck();
		System.out.println("-------------------");
		countVowelsConsonants();
		System.out.println("-------------------");
		checkAnagramAndPangram();
		System.out.println("-------------------");
		getMaxVersion();
		System.out.println("-------------------");
		checkMiddleElement();
		System.out.println("-------------------");
		convertStringArrayToMapUsingAutoIncrementKey();
		System.out.println("-------------------");
		sortStringsByLength();
		System.out.println("-------------------");
		
	}

	

}
