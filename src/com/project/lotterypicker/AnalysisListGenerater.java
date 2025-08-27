package com.project.lotterypicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AnalysisListGenerater extends FileReader {

	// FileReader fileReader = new FileReader("lottoNumbers_latest.txt");

	public AnalysisListGenerater() {
		super("/Users/josephapple/Library/CloudStorage/OneDrive-Personal/eclipse-workspace/projectspring/src/main/java/com/project/services/projectspring/lottoNumbers_latest.txt");

	}

	public ArrayList<LotteryValue> printSortedCount(boolean print) {
		ArrayList<Integer> sortedList = new ArrayList<>();
		ArrayList<LotteryValue> sortedListOfValues = print ? null : new ArrayList<>();

		for (int i = 0; i < getCalcForEachPossibleValue().size(); i++) {
			sortedList.add(getCalcForEachPossibleValue().get(i).getCount());
		}

		Set<Integer> set = new HashSet<>(sortedList);
		sortedList.clear();
		sortedList.addAll(set);

		Collections.sort(sortedList);

		for (int num : sortedList) {
			for (LotteryValue lv : getCalcForEachPossibleValue()) {
				if (lv.getCount() == num) {
					if (print) {
						System.out.println("Number: " + lv.getLottoValue() + "  Count: " + lv.getCount());
					} else {
						sortedListOfValues.add(lv);
					}
				}
			}
		}
		// list is empty if print set to true. Possibly set this to null instead
		return sortedListOfValues;
	}

	// NEED TO UPDATE TO RETURN COLLECTION OF VALUES PRINTED
	public void printNumOfDrawingsSinceSelected() {

		ArrayList<Integer> sortedList = new ArrayList<>();

		for (int i = 0; i < getCalcForEachPossibleValue().size(); i++) {
			sortedList.add(getCalcForEachPossibleValue().get(i).getDrawingsSinceSelected());
		}

		Set<Integer> set = new HashSet<>(sortedList);
		sortedList.clear();
		sortedList.addAll(set);

		Collections.sort(sortedList);

		for (int num : sortedList) {
			for (LotteryValue lv : getCalcForEachPossibleValue()) {
				if (lv.getDrawingsSinceSelected() == num) {
					System.out.println("Number: " + lv.getLottoValue() + "  Drawings since selected: "
							+ lv.getDrawingsSinceSelected());
				}
			}
		}
	}

	// NEED TO UPDATE TO RETURN COLLECTION OF VALUES PRINTED
	public void printAvgBetweenSelected() {

		ArrayList<Double> sortedList = new ArrayList<>();

		for (int i = 0; i < getCalcForEachPossibleValue().size(); i++) {
			sortedList.add(getCalcForEachPossibleValue().get(i).getAvgDrawingsBetweenSelection());
		}

		Set<Double> set = new HashSet<>(sortedList);
		sortedList.clear();
		sortedList.addAll(set);

		Collections.sort(sortedList);

		for (double num : sortedList) {
			for (LotteryValue lv : getCalcForEachPossibleValue()) {
				if (lv.getAvgDrawingsBetweenSelection() == num) {
					System.out.println("Number: " + lv.getLottoValue() + "  Avg num of drawings since last selected: "
							+ lv.getAvgDrawingsBetweenSelection());
				}
			}
		}
	}
}
