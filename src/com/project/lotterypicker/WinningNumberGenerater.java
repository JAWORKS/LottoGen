package com.project.lotterypicker;

import java.util.ArrayList;
import java.util.Random;

public class WinningNumberGenerater extends CombinationGenerator {

	AnalysisListGenerater analyzer;

	public WinningNumberGenerater() {
		analyzer = new AnalysisListGenerater();
	}

	/*
	 * pickFiveFromCountTenMostTenLeast
	 * 
	 * Takes result from findTenMostWithTenLeastCountCombos, picks 5 of combos at
	 * random and prints results to the screen
	 * 
	 */
	public void pickFiveFromCountTenMostTenLeast() {

		ArrayList<int[]> result = findTenMostWithTenLeastCountCombos();

		int max = result.size() - 1;
		int min = 0;
		Random rand = new Random();
		int count = 5;

		for (int i = 0; i < count; i++) {

			int r = rand.nextInt(max - min + 1) + min;
			for (int j = 0; j < 5; j++) {
				System.out.print(result.get(r)[j] + " ");
			}
			System.out.println("");
		}
	}

	/*
	 * findTenMostWithTenLeastCountCombos
	 * 
	 * Takes list of each numbers pick count and finds 10 most selected and 10 least
	 * selected. Finds all 5 count combinations of those 20 numbers
	 * 
	 * @return list of all possible 5 number combos of the 20 total
	 * 
	 */
	public ArrayList<int[]> findTenMostWithTenLeastCountCombos() {

		int numberBucketSize = 20;
		int combinationSize = 5;
		ArrayList<LotteryValue> values = analyzer.printSortedCount(false);

		int[] numberBucket = new int[numberBucketSize];
		int index = 0;

		for (int i = 0; i < values.size(); i++) {

			if (i < 10 || i > 25) {
				numberBucket[index] = values.get(i).getLottoValue();
				index++;
			}
		}

		return generateCombinations(numberBucket, numberBucketSize, combinationSize);
	}

	// put in a new CombonationGenerator class
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
//	public static ArrayList<int[]> generateCombinations(int arr[], int n, int r) {
//		// A temporary array to store all combination one by one
//		int data[] = new int[r];
//		ArrayList<int[]> saveResults = new ArrayList<>();
//
//		// Print all combination using temporary array 'data[]'
//		combinationUtil(arr, data, 0, n - 1, 0, r, saveResults);
//		return saveResults;
//	}
//
//	/*
//	 * combinationUtil
//	 * 
//	 * Utility behind generateCombinations. Generates all r-sized combinations of
//	 * values in arr. Puts results in results array
//	 * 
//	 * @param arr[] - array of winning number possibilities
//	 * 
//	 * @param data[] - array used for recursion to maintain from previous recursion
//	 * level
//	 * 
//	 * @param start - point in arr array where winning num possibles start
//	 * 
//	 * @param index - starting point in r-number combo process (ex. if 2 winning
//	 * numbers are 'given', we may only need to find all combinations for 3 of the
//	 * numbers. In this case index would be set to 2)
//	 * 
//	 * @param r - combination size
//	 * 
//	 * @param results - list of combinations found
//	 * 
//	 */
//	public static void combinationUtil(int arr[], int data[], int start, int end, int index, int r,
//			ArrayList<int[]> results) {
//		// Current combination is ready to be printed, print it
//		if (index == r) {
//			int save[] = new int[r];
//			for (int j = 0; j < r; j++) {
//				// System.out.print(data[j]+" ");
//				save[j] = data[j];
//			}
//			// System.out.println("");
//			results.add(save);
//			return;
//		}
//
//		// replace index with all possible elements. The condition
//		// "end-i+1 >= r-index" makes sure that including one element
//		// at index will make a combination with remaining elements
//		// at remaining positions
//		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
//			data[index] = arr[i];
//			combinationUtil(arr, data, i + 1, end, index + 1, r, results);
//		}
//	}

}
