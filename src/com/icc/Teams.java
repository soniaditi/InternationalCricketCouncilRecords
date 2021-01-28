package com.icc;

public class Teams implements Comparable<Teams> {
	private String teamName;
	private String country;
	private String currentCaptain;
	private int noOfMatchesPlayed;
	private int noOfMatchesWon;
	private int noOfMatchesLost;
	public Teams() {
		
	}
	public String getCaptain() {
		return currentCaptain;
	}
	public void setCaptain(String currentCaptain) {
		this.currentCaptain = currentCaptain;
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getNoOfMatchesPlayed() {
		return noOfMatchesPlayed;
	}
	public void setNoOfMatchesPlayed(int noOfMatchesPlayed) {
		this.noOfMatchesPlayed = noOfMatchesPlayed;
	}
	public int getNoOfMatchesWon() {
		return noOfMatchesWon;
	}
	public void setNoOfMatchesWon(int noOfMatchesWon) {
		this.noOfMatchesWon = noOfMatchesWon;
	}
	public int getNoOfMatchesLost() {
		return noOfMatchesLost;
	}
	public void setNoOfMatchesLost(int noOfMatchesLost) {
		this.noOfMatchesLost = noOfMatchesLost;
	}
	public Teams(String teamName, String country,String currentCaptain, int noOfMatchesPlayed, int noOfMatchesWon, int noOfMatchesLost, Batsman batsman, Bowlers bowler) {
		this.teamName = teamName;
		this.country = country;
		this.currentCaptain= currentCaptain;
		this.noOfMatchesPlayed = noOfMatchesPlayed;
		this.noOfMatchesWon = noOfMatchesWon;
		this.noOfMatchesLost = noOfMatchesLost;
	}
	@Override
	public String toString() {
		return "\nTeams ODI Records: TeamName=" + getTeamName() +  ", Country=" + getCountry() +",current Captain= "+getCaptain()+", No Of Matches Played=" + getNoOfMatchesPlayed()
				+ ", No Of Matches Won=" + getNoOfMatchesWon() + ", No Of Matches Lost=" + getNoOfMatchesLost();
	}
	
	@Override
	public int compareTo(Teams t) {
		int compare= teamName.compareTo(t.teamName);
		if(compare==0) {
			compare = country.compareTo(t.country);
			if(compare==0) {
				compare=Integer.compare(noOfMatchesPlayed, t.noOfMatchesPlayed);
			}
				
		}
		return compare;
	}
	
	
}
