package com.project.lotterypicker;

import java.util.ArrayList;

public class LotteryValue {
	
	private int lottoValue=0; //lottery value from 1 to 36
	private int count=0; //Number of times this value chosen as a winner
	private int drawingsSinceSelected=0; //Number of drawings since this value selected as winner
	private ArrayList<Integer> numsBetweenSelect = new ArrayList<>(); //Number of drawings between selection of this value as winner
	
	/**
	 * LotteryValue
	 * 
	 * Object represents each lottery value possible as a winning value 
	 * 
	 * @param lValue
	 */
	public LotteryValue(int lValue) {
		this.lottoValue=lValue;
	}
	
	public int getLottoValue() {
		return lottoValue;
	}
	
	public void incrementCount() {
		count++;
	}
	
	public void incrementDrawingsSinceSelected() {
		drawingsSinceSelected++;
	}
	
	public void resetDrawingsSinceSelected() {
		numsBetweenSelect.add(drawingsSinceSelected);
		drawingsSinceSelected=0;
	}
	
	public int getCount() {
		return count;
	}
	
	public int getDrawingsSinceSelected() {
		return drawingsSinceSelected;
	}
	
	public double getAvgDrawingsBetweenSelection() {
		double total = 0.0;
		for (int selCount : numsBetweenSelect) {
			total += (double)selCount;
		}
		
		double avg = total/numsBetweenSelect.size();
		return avg;
	}
	
	public ArrayList<Integer> getNumbersBetweenSelected() {
		return numsBetweenSelect;
	}
}