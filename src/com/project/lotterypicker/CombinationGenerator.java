package com.project.lotterypicker;

import java.util.ArrayList;

public class CombinationGenerator {

	/*
	 * generateCombinations
	 * 
	 * Generates all r-sized combinations of values in arr
	 * 
	 * example: r=5, n=20.. Generates all combinations of 5 values from the first 20
	 * numbers provided in the array arr[]
	 * 
	 * @param arr[] - array of winning number possibilities
	 * 
	 * @param n - count of winning numbers (from array)
	 * 
	 * @param r - combination size
	 * 
	 */
	protected ArrayList<int[]> generateCombinations(int arr[], int n, int r) {

		// A temporary array to store all combination one by one
		int data[] = new int[r];
		ArrayList<int[]> saveResults = new ArrayList<>();

		// Print all combination using temporary array 'data[]'
		combinationUtil(arr, data, 0, n - 1, 0, r, saveResults);
		return saveResults;
	}

	/*
	 * combinationUtil
	 * 
	 * Utility behind generateCombinations. Generates all r-sized combinations of
	 * values in arr. Puts results in results array
	 * 
	 * @param arr[] - array of winning number possibilities
	 * 
	 * @param data[] - array used for recursion to maintain from previous recursion
	 * level
	 * 
	 * @param start - point in arr array where winning num possibles start
	 * 
	 * @param index - starting point in r-number combo process (ex. if 2 winning
	 * numbers are 'given', we may only need to find all combinations for 3 of the
	 * numbers. In this case index would be set to 2)
	 * 
	 * @param r - combination size
	 * 
	 * @param results - list of combinations found
	 * 
	 */
	private void combinationUtil(int arr[], int data[], int start, int end, int index, int r,
			ArrayList<int[]> results) {
		// Current combination is ready to be printed, print it
		if (index == r) {
			int save[] = new int[r];
			for (int j = 0; j < r; j++) {
				// System.out.print(data[j]+" ");
				save[j] = data[j];
			}
			// System.out.println("");
			results.add(save);
			return;
		}

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i + 1, end, index + 1, r, results);
		}
	}
}
