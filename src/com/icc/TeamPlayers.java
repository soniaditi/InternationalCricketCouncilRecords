package com.icc;

public class TeamPlayers implements Comparable<TeamPlayers> {
	private int SrNo;
	private Teams team;
	private Players player;
	
	public TeamPlayers() {
		
	}
	public int getSrNo() {
		return SrNo;
	}
	public void setSrNo(int srNo) {
		SrNo = srNo;
	}
	public Teams getTeam() {
		return team;
	}
	public void setTeam(Teams team) {
		this.team = team;
	}
	public Players getPlayer() {
		return player;
	}
	public void setPlayer(Players player) {
		this.player = player;
	}
	
	
	
	public TeamPlayers(int srNo, Teams team, Batsman batsman, Bowlers bowler) {
		super();
		SrNo = srNo;
		this.team = team;
		this.player = player;
		
	}
	
	
	@Override
	public String toString() {
		return "\nTeamPlayers: Sr No.: " + getSrNo() + ", Team= " + getTeam().getTeamName() + ", Player Added= " + getPlayer().getName();
	}
	@Override
	public int compareTo(TeamPlayers t) {
		int compare= getTeam().getTeamName().compareTo(t.getTeam().getTeamName());
		if(compare==0) {
			compare = getPlayer().getName().compareTo(t.getPlayer().getName());
		}
		return compare;
	}
}
