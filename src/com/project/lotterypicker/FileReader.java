package com.project.lotterypicker;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
	
	//List of all winning lottery combinations
	private ArrayList<int[]> fullList = new ArrayList<int[]>();
	//List of possible lottery values (1 to 36)
	private ArrayList<LotteryValue> lottoValueCalc = new ArrayList<LotteryValue>();
	
	
	public FileReader(String fileName) {
		//Load list of lottery values with 36 LotteryValue's
		for(int i=1; i<=36; i++) {
			lottoValueCalc.add(new LotteryValue(i));
		}
		readFile(fileName);
	}
	
	/*
	 * readFile
	 * 
	 * Reads file from file system containing winning lottery numbers
	 * 
	 * @param fileName
	 * 
	 */
	public void readFile(String fileName) {
		try {
			
			Scanner reader = new Scanner(new File(fileName));
			
			while (reader.hasNextLine()) {
				String line = reader.nextLine();

				if (line.contains("EVENING") || line.contains("MIDDAY")) {
					//Split out each winning number
					String[] splitup = line.split(" ");
					int one = Integer.parseInt(splitup[2]);
					int two = Integer.parseInt(splitup[3]);
					int three = Integer.parseInt(splitup[4]);
					int four = Integer.parseInt(splitup[5]);
					int five = Integer.parseInt(splitup[6]);
					
					//Add new set of winning numbers to full list of winning sets
					int[] winners = new int[] {one,two,three,four,five};
					fullList.add(winners);
					
					//Increment count for each winning number
					lottoValueCalc.get(one-1).incrementCount();
					lottoValueCalc.get(two-1).incrementCount();
					lottoValueCalc.get(three-1).incrementCount();
					lottoValueCalc.get(four-1).incrementCount();
					lottoValueCalc.get(five-1).incrementCount();
					
				} 
			}
			reader.close();
			for(int i=fullList.size()-1; i >= 0; i--) {
				//Go through each lotto value selected and reset number of drawings since selected
				lottoValueCalc.get(fullList.get(i)[0]-1).resetDrawingsSinceSelected();
				lottoValueCalc.get(fullList.get(i)[1]-1).resetDrawingsSinceSelected();
				lottoValueCalc.get(fullList.get(i)[2]-1).resetDrawingsSinceSelected();
				lottoValueCalc.get(fullList.get(i)[3]-1).resetDrawingsSinceSelected();
				lottoValueCalc.get(fullList.get(i)[4]-1).resetDrawingsSinceSelected();
				//Go through each lotto value not selected and increment number of drawings since selected
				for (int j=1; j<=lottoValueCalc.size(); j++) {
					if(j!=fullList.get(i)[0] && j!=fullList.get(i)[1] && j!=fullList.get(i)[2] && j!=fullList.get(i)[3] && j!=fullList.get(i)[4]) {
						lottoValueCalc.get(j-1).incrementDrawingsSinceSelected();
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * getAllWinningNumbers
	 * 
	 * Returns full list of all winning numbers
	 * 
	 * @return fullList
	 * 
	 */
	public ArrayList<int[]> getAllWinningNumbers() {
		return fullList;
	}
	
	/*
	 * getCalcForEachPossibleValue
	 * 
	 * Returns all calculation values done for each possible winning number
	 * 
	 * @return lottoValueCalc
	 * 
	 */
	public ArrayList<LotteryValue> getCalcForEachPossibleValue() {
		return lottoValueCalc;
	}
}
