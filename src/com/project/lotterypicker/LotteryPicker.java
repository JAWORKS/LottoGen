package com.project.lotterypicker;

import java.util.ArrayList;
import java.util.Scanner;

public class LotteryPicker {

	public static int[] lottoNums = new int[5];
	public static ArrayList<int[]> listOfLottoNums = new ArrayList<>();
	public static WinningNumberGenerater genWinners = new WinningNumberGenerater();
	public static AnalysisListGenerater analyzer = new AnalysisListGenerater();

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println("");
			System.out.println("---------------LOTTERY ANALYSIS TOOL---------------");
			System.out.println("0 - QUIT");
			System.out.println("");
			System.out.println("---------------LISTS AVAIL FOR PRINTING---------------");
			System.out.println("1 - Print list of drawn count for each number");
			System.out.println("2 - Print list of Number of drawings since drawn");
			System.out.println("3 - Print list of Avg number of drawings until drawn");
			System.out.println("");
			System.out.println("---------------NUMBER GENERATORS---------------");
			System.out.println(
					"4 - PICK 5 SETS OF WINNING NUMBERS, DRAWN FROM 10 MOST DRAWN EVER AND 10 LEAST DRAWN EVER");
			System.out.println("5 - ANOTHER SET OF WINNING NUMBERS");
			System.out.println("");
			System.out.print("Enter command here: ");

			String command = input.nextLine();

			switch (Integer.parseInt(command)) {
			case 1:
				System.out.println("----------------Number of times number drawn as winning number----------------");
				analyzer.printSortedCount(true);
				break;
			case 2:
				System.out.println("----------------Number of drawings since number drawn----------------");
				analyzer.printNumOfDrawingsSinceSelected(null);
				break;
			case 3:
				System.out.println("----------------Average Number of drawings between number drawn----------------");
				analyzer.printAvgBetweenSelected();
				break;
			case 4:
				System.out.println("----------------OPTION 4 - PICKS----------------");
				genWinners.pickFiveFromCountTenMostTenLeast();
				break;
			case 0:
				System.out.println("");
				System.out.println("Quitting...");
				System.out.println("");
				running = false;
				break;
			default:
				// empty code block
			}

		}

		// closes the scanner
		input.close();
		System.out.println("Done");
	}

}
