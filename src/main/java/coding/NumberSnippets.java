package coding;

import java.util.Arrays;

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

	public static void main(String[] args) {
		checkSumEqualWithAnyPositionCombination();
		System.out.println("-------------------");
		removeDuplicates();
		System.out.println("\n-------------------");
	}

}
