package com.icc;



public class Players implements Comparable<Players> {
private String name;
private float average;
private float strikeRate;
private int noOfMatches;

public Players() {
	
}

public Players(String name, float average, float strikeRate, int noOfMatches) {
	super();
	this.name = name;
	this.average = average;
	this.strikeRate = strikeRate;
	this.noOfMatches = noOfMatches;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getAverage() {
	return average;
}
public void setAverage(float average) {
	this.average = average;
}
public float getStrikeRate() {
	return strikeRate;
}
public void setStrikeRate(float strikeRate) {
	this.strikeRate = strikeRate;
}
public int getNoOfMatches() {
	return noOfMatches;
}
public void setNoOfMatches(int noOfMatches) {
	this.noOfMatches = noOfMatches;
}
@Override
public int compareTo(Players p) {
	int compare= name.compareTo(p.name);
	if(compare==0) {
		compare = Integer.compare(noOfMatches, p.noOfMatches);
	}
	return compare;
}


}

class Batsman extends Players{
	private int runs;
	private int centuries;
	private int halfCenturies;
	
	public Batsman() {
		
	}
	
	public Batsman(int runs, int centuries, int halfCenturies) {
		super();
		this.runs = runs;
		this.centuries = centuries;
		this.halfCenturies = halfCenturies;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getCenturies() {
		return centuries;
	}
	public void setCenturies(int centuries) {
		this.centuries = centuries;
	}
	public int getHalfCenturies() {
		return halfCenturies;
	}
	public void setHalfCenturies(int halfCenturies) {
		this.halfCenturies = halfCenturies;
	}
	@Override
	public String toString() {
		return "\nBatsman ODI Score Card: Name= " + getName() + " Runs= " + getRuns() + ", 100s= " + getCenturies() + ", 50s= "
				+ getHalfCenturies() +  ", Average= " + getAverage()
				+ ", StrikeRate= " + getStrikeRate() + ", NoOfMatches= " + getNoOfMatches();
	}
	
	
	
}
 
class Bowlers extends Players{
	private int wickets;
	private int fiveWicketHaul;
	
	public Bowlers() {
		
	}
	
	public Bowlers(int wickets, int fiveWicketHaul) {
		super();
		this.wickets = wickets;
		this.fiveWicketHaul = fiveWicketHaul;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public int getFiveWicketHaul() {
		return fiveWicketHaul;
	}
	public void setFiveWicketHaul(int fiveWicketHaul) {
		this.fiveWicketHaul = fiveWicketHaul;
	}
	
	@Override
	public String toString() {
		return "\nBowlers ODI Score Card: Name= "+ getName() + " Wickets= " + getWickets() + ", FiveWicketHaul= " + getFiveWicketHaul() +  ", Average= " + getAverage() + ", StrikeRate= " + getStrikeRate()
				+ ", NoOfMatches= " + getNoOfMatches();
	}
}