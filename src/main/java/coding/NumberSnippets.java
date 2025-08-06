package coding;

import java.util.Arrays;
import java.util.HashSet;

public class NumberSnippets {

	public static void checkSumEqualWithAnyPositionCombination() {
		int[] intArray = { 1, 3, 4, -7, -1, 5, 2, 6, 9, 0, 80, -11 };
		int sum = 5;
		int sumCombinations = 0;

		for (int i = 0; i < intArray.length; i++) {
			for (int j = i + 1; j < intArray.length; j++) {
				if (intArray[i] + intArray[j] == sum) {
					System.out.println("Sum Combination found with : " + intArray[i] + " & " + intArray[j]);
					sumCombinations++;

				}
			}
//			System.out.println("Sum Combination NOT found");
		}
		System.out.println("Toal Sum Combinations: " + sumCombinations);
	}

	public static void removeDuplicates() {
		int[] dupArray = { 1, 3, 3, 4, 5, 2, 80, 6, 9, 0, 80, -1, -1, -1, 'A', 0 };

		System.out.println("Duplicated Removed Unsorted:");
		// APPROACH 1
		for (int i = 0; i < dupArray.length; i++) {
			for (int j = i + 1; j < dupArray.length; j++) {
				if (dupArray[i] == dupArray[j]) {
					dupArray[j] = Integer.MIN_VALUE; // mark duplicate
				}
			}

			if (dupArray[i] != Integer.MIN_VALUE) {
				System.out.print(dupArray[i] + " ");
			}
		}

		// APPROACH 2
		Arrays.sort(dupArray);
		int index = 0; // points to position for next unique element

		System.out.println("\nDuplicated Removed Sorted:");
		for (int i = 0; i < dupArray.length; i++) {
			if (dupArray[i] != dupArray[index]) {
				index++;
				dupArray[index] = dupArray[i];
				System.out.print(dupArray[i] + " ");
			}
		}

	}

	public static void checksiblingNumbers() {
		int[] wholeArray = { 1, 1, -6, -06, 2, 2, 2, 3, 0, 3 };
//		Arrays.sort(wholeArray); //Use this if we want to match sibling at any position
		String pairedSiblingArray;

		System.out.println("Paired Sibling Array: ");
		for (int i = 0; i < wholeArray.length - 1; i++) {
			if (wholeArray[i] == wholeArray[i + 1]) {
				int start = i;

				while (i < wholeArray.length - 1 && wholeArray[i] == wholeArray[i + 1]) {
					i++;
				}

				int end = i;
				int pairSize = end - start + 1;
				int[] group = new int[pairSize];
				for (int j = 0; j < pairSize; j++) {
					group[j] = wholeArray[start + j];
				}
				pairedSiblingArray = Arrays.toString(group).replace(" ", "");

				System.out.print(pairedSiblingArray);
			}
		}

	}

	public static void secondLargestSmallest() {
		int[] numberArray = { 100, -1, 0, 5, 1, 9, 2, 7, 3, 8 };
		int n = 2; // change to 3 for 3rd largest/smallest

		Arrays.sort(numberArray);

		int nthSmallest = numberArray[n - 1];
		int nthLargest = numberArray[numberArray.length - n];

		System.out.println(n + "nd Smallest number: " + nthSmallest);
		System.out.println(n + "nd Largest number: " + nthLargest);
	}

	public static void moveZeroesToEndOrStart() {
		int[] arr = { 100, -1, 0, 5, 0, 0, 1, 9, 2, 7, 3, 8,16,-0 };
		boolean toEnd = true; // Change this to position the zeros to start or end of Array
		int index = toEnd ? 0 : arr.length - 1;

		if (toEnd) {
			for (int num : arr) {
				if (num != 0) {
					arr[index++] = num;
				}
			}
			while (index < arr.length)
				arr[index++] = 0;
		} else {
			for (int i = arr.length - 1; i >= 0; i--) {
				if (arr[i] != 0) {
					arr[index--] = arr[i];
				}
			}
			while (index >= 0)
				arr[index--] = 0;
		}

		System.out.println("Moved Zeros to Start/End of Array: " + Arrays.toString(arr));
	}
	
	
	public static void findMissingNumber() {
		int[] missNumArray = {1,4,6,12,15,-2,2,5};
		Arrays.sort(missNumArray);
		
		System.out.print("Missing Numbers: ");
		
		for (int i = missNumArray[0]; i <= missNumArray[missNumArray.length - 1]; i++) {
            boolean found = false;
            for (int num : missNumArray) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.print(i + " ");
            }
        }
    
	}

	
	public static void longestConsecutive() {
		int[] nums = {1,2,35,46,47,3,48,49,-1,0};
	    HashSet<Integer> set = new HashSet<>();
	    for (int num : nums) set.add(num);

	    int longest = 0;
	    for (int num : set) {
	        if (!set.contains(num - 1)) {
	            int currentNum = num;
	            int count = 1;
	            while (set.contains(currentNum + 1)) {
	                currentNum++;
	                count++;
	            }
	            longest = Math.max(longest, count);
	        }
	    }
	    System.out.println("Longest Consecutive number: " + longest);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		checkSumEqualWithAnyPositionCombination();
		System.out.println("-------------------");
		removeDuplicates();
		System.out.println("\n-------------------");
		checksiblingNumbers();
		System.out.println("\n-------------------");
		secondLargestSmallest();
		System.out.println("-------------------");
		moveZeroesToEndOrStart();
		System.out.println("-------------------");
		findMissingNumber();
		System.out.println("\n-------------------");
		longestConsecutive();
		System.out.println("\n-------------------");
	}

}
