package com.icc;

import java.util.*;


public class CentralSystem {
	private static List<Batsman> batsmanList = new ArrayList<Batsman>();
	private static List<Bowlers> bowlersList= new ArrayList<Bowlers>();
	private static List<Teams> teamsList= new ArrayList<Teams>();
	private static List<TeamPlayers> teamPlayersList = new ArrayList<TeamPlayers>();
	static int countTeamPlayers=0;
	static int countTeams=0;
	

	public static void addPlayers(Batsman batsman, Bowlers bowler) {
		if(batsman!=null) { 
			batsmanList.add(batsman);
			System.out.println("Batsman added successfully");
		}
		Collections.sort(batsmanList);
		System.out.println(batsmanList);
		
		if(bowler!=null) { 
			bowlersList.add(bowler);
			System.out.println("Bowler added successfully");
		}
		Collections.sort(bowlersList);
		System.out.println(bowlersList);
		
	}
	public static void addTeams(Teams team) {
		teamsList.add(team);
		countTeams++;
		Collections.sort(teamsList);
		System.out.println("Team added successfully");
		System.out.println(teamsList);
		
		
	}
	 
	public static void addPlayersToTeam() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Full Name of the player you want to add?");
		String name =sc.nextLine();
		System.out.println("is it a batsman or a bowler");
		String playerType=sc.nextLine();
		if(playerType.equalsIgnoreCase("batsman")) {
			int flagPlayer=0;
			System.out.println("Checking the batsman list....");
		for(int i=0;i<batsmanList.size();i++) {
			Batsman b=batsmanList.get(i);
			String s = b.getName();
			if(name.equalsIgnoreCase(s)) {
				System.out.println("Which country do want to add " +name+"?");
				String country =sc.nextLine();
				int n=teamsList.size();
				int flagCountry=0;
				for(int j=0; j<n; j++ ) {
					Teams t = teamsList.get(j);
					String s1=t.getCountry();
					if(country.equalsIgnoreCase(s1)) {
						TeamPlayers tp= new TeamPlayers();
						countTeamPlayers++;
						tp.setSrNo(countTeamPlayers);
						tp.setPlayer(b);
						tp.setTeam(t);
						System.out.println(name+" added successfully added to "+country+" team");
						teamPlayersList.add(tp);
						//System.out.println(teamPlayersList);
					}
					else 
						flagCountry++;
				}
				if(flagCountry==n) {
					System.out.println("The team of this country is not available in the database. Please add "+country+" team to the database first");
				}
			
				
			}
			else
				flagPlayer++;
			}
		if(flagPlayer==batsmanList.size()) {
			System.out.println("No batsman with this name is available in the database.Please add player "+name+" to the batsman database first");
		}
		}
		else {
			System.out.println("Checking the bowlers list.... ");
				int flagPlayer=0;
				int m = bowlersList.size();
		for(int k=0;k<m;k++) {
			Bowlers bw = bowlersList.get(k);
			String str = bw.getName();
			if(name.equalsIgnoreCase(str)) {
				System.out.println("Which country do want to add " +name+"?");
				String country =sc.nextLine();
				int n=teamsList.size();
				int flagCountry=0;
				for(int j=0; j<n; j++ ) {
					Teams t = teamsList.get(j);
					String s1=t.getCountry();
					if(country.equalsIgnoreCase(s1)) {
						TeamPlayers tp= new TeamPlayers();
						countTeamPlayers++;
						tp.setSrNo(countTeamPlayers);
						tp.setPlayer(bw);
						tp.setTeam(t);
						System.out.println(name+" added successfully added to "+country+" team");
						teamPlayersList.add(tp);
						//System.out.println(teamPlayersList);
					}
					else 
						flagCountry++;
				}
				if(flagCountry==n) {
					System.out.println("The team of this country is not available in the database. Please add "+country+" team to the database first");
				}
			}
			else
					flagPlayer++;
		}
		if(flagPlayer==m) {
			System.out.println("No bowler with this name is available in the database.Please add player "+name+" to the bowlers database first");
		}
	}
	
		
}
	public static void searchPlayers() {
	
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter the name of the player you want to search");
			String str= sc.nextLine();
			str=str.toLowerCase();
			int n= batsmanList.size();
			int m=bowlersList.size();
			int flag=0;
			if(n!=0) {
			
			for(int i=0;i<n;i++) {
				Batsman b = batsmanList.get(i);
				String s1=b.getName().toLowerCase();
				if(s1.contains(str)) {
					System.out.println("Player "+str+" is present in the batsman database. His details are as follows");
					System.out.println(b.toString());
				}
				else
					flag++;
			}
			if(flag==n) {
				System.out.println("player " +str+" is not present in the batsman database.");
			}
			}
			else
			{
				System.out.println("Batsman List is empty");
			}
			if(m!=0) {
		for(int j=0;j<m;j++) {
			Bowlers bw = bowlersList.get(j);
			String s1=bw.getName().toLowerCase();
			if(s1.contains(str)) {
				System.out.println("Player "+str+" is present in the bowler database. His details are as follows");
				System.out.println(bw.toString());
			}
			else
				flag++;
		}
		if(flag==n) {
			System.out.println("player " +str+" has not been added to the bowlers database");
		}
	}
			else
			{
				System.out.println("Batsman List is empty");
			}
	}
	
	
	public static void searchTeams() {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the name of the team you want to search");
		String str= sc.nextLine();
		str=str.toLowerCase();
		int n= teamsList.size();
		int flag=0;
		if(n!=0) {
		for(int i=0;i<n;i++) {
			Teams t = teamsList.get(i);
			String s1= t.getTeamName().toLowerCase();
			if(s1.contains(str)) {
				System.out.println("Team "+str+" is present in the database. The details are as follows");
				System.out.println(t.toString());
			}
			else
				flag++;
		}
		if(flag==n) {
			System.out.println("Team " +str+" is not present in the database.");
			System.out.println("List of teams available in database are:");
			System.out.println(teamsList);
		}
	}
		else
			System.out.println("List of team is empty. Please add teams by entering the respective choice from the menu.");
}
 
	public static void playerByCountry() {
		
		Collections.sort(teamPlayersList);
		for(int i=0; i<teamPlayersList.size();i++) {
			String s=teamPlayersList.get(i).getTeam().getTeamName();
			int count=1;
			for(int j=i+1; j<teamPlayersList.size();j++) {
				String s2=teamPlayersList.get(j).getTeam().getTeamName();
				if(s.equalsIgnoreCase(s2)) 
					count++;
				else 
					break;
				}
			if(count>=1) {
				System.out.println(s+" has "+count+" players");
				i=i+(count-1);
			}
		}
		
	}
	
	public static void main(String args[]) {
		int n=0;
		
		do {
			System.out.println("**************Welcome to ICC ODI Records********************");
			System.out.println("Enter 1 to add players in the database");
			System.out.println("Enter 2 to add teams in the database");
			System.out.println("Enter 3 to add players to their respective teams");
			System.out.println("Enter 4 to print No. of players per team");
			System.out.println("Enter 5 to search for players in the database");
			System.out.println("Enter 6 to search for teams in the database");
			System.out.println("Enter 7 to EXIT");
			System.out.println("Enter your choice");
			Scanner s2= new Scanner(System.in);
			n=s2.nextInt();
			switch(n) {
			case 1:
				System.out.println("Which player you wan to add? batsman/bowler?");
				Scanner sc= new Scanner(System.in);
				String str =sc.nextLine();
			
				if(str.equalsIgnoreCase("batsman")) {
					Batsman batsman= new Batsman();
					System.out.println("Enter the name of the batsman you want to add:");
					String name= sc.nextLine();
					batsman.setName(name);
					System.out.println("\nEnter the total no of runs scored in the ODI by "+name);
					batsman.setRuns(sc.nextInt());
					System.out.println("\nEnter no. of 100s scored by "+name);
					batsman.setCenturies(sc.nextInt());
					System.out.println("\nEnter no. of 50s scored by "+name);
					batsman.setHalfCenturies(sc.nextInt());
					System.out.println("\nEnter ODI average of "+name);
					batsman.setAverage(sc.nextFloat());
					System.out.println("\nEnter the strike rate of "+name);
					batsman.setStrikeRate(sc.nextFloat());
					System.out.println("\nEnter total no. of matches played by "+name);
					batsman.setNoOfMatches(sc.nextInt());
					addPlayers(batsman,null);
				}
				if(str.equalsIgnoreCase("bowler")){
					Bowlers bowler= new Bowlers();
					System.out.println("Enter the name of the bowler you want to add:");
					String name= sc.nextLine();
					bowler.setName(name);
					System.out.println("\nEnter ODI average of "+name);
					bowler.setAverage(sc.nextFloat());
					System.out.println("\nEnter total no. of matches played by "+name);
					bowler.setNoOfMatches(sc.nextInt());
					System.out.println("\nEnter Five wicket haul played by "+name+ " if any(otherwise put 0)");
					bowler.setFiveWicketHaul(sc.nextInt());
					System.out.println("\nEnter total No. of wickets taken by "+name+ " (otherwise put 0)");
					bowler.setWickets(sc.nextInt());
					System.out.println("\nEnter the strike rate of "+name);
					bowler.setStrikeRate(sc.nextFloat());
					addPlayers(null,bowler);
				}
				break;
			case 2:
				String ans= new String();
				Teams team= new Teams();
				System.out.println("Enter the name of the team you want to add: ");
				Scanner b=new Scanner(System.in);
				String name= b.nextLine();
				team.setTeamName(name);
				name=name.toLowerCase();
				int a= teamsList.size();
				if(a!=0) {
				int flag=0;
				for(int i=0;i<n;i++) {
					Teams t = teamsList.get(i);
					String s1= t.getTeamName().toLowerCase();
					if(s1.contains(name)) {
						System.out.println("Team "+name+" is already present in the database. The details are as follows");
						System.out.println(t.toString());
					}
					else
						flag++;
				}
				if(flag==n) {
					System.out.println("Team " +name+" is not present in the database.Do you want to be added as a new team? (type yes or no)");
					Scanner s= new Scanner(System.in);
					ans =s.nextLine();
					ans=ans.toLowerCase();
				}
			}
				if(ans.equalsIgnoreCase("yes")) {
				System.out.println("which country is the team from?: ");
				team.setCountry( b.nextLine());
				System.out.println("Enter name of "+name+" captian: ");
				team.setCaptain(b.nextLine());
				System.out.println("\nEnter total no. of matches played by "+name);
				team.setNoOfMatchesPlayed(b.nextInt());
				System.out.println("\nEnter total no. of matches won by "+name);
				team.setNoOfMatchesWon(b.nextInt());
				System.out.println("\nEnter total no. of matches Lost by "+name);
				team.setNoOfMatchesLost(b.nextInt());
				addTeams(team);
				}
				break;
			case 3: 
				addPlayersToTeam();
				break;
			case 4:
				playerByCountry();
				break;
			case 5:
				searchPlayers();
				break;
				
			case 6:
				searchTeams();
				break;
				
			case 7: 
				System.out.println("Thank you...");
				break;
				
			default:
				System.out.println("oopss!!you have entered the wrong choice. Please try again!");
			}
		}while(n!=7);
	   
//		Teams team1= new Teams();
//		team1.setTeamName("Team India");
//		team1.setCountry("India");
//		team1.setCaptain("Virat Kohli");
//		team1.setNoOfMatchesPlayed(990);
//		team1.setNoOfMatchesWon(514);
//		team1.setNoOfMatchesLost(426);
//		
//		Batsman batsman1= new Batsman();
//		batsman1.setName("Virat Kohli");
//		batsman1.setAverage(59.3f);
//		batsman1.setCenturies(43);
//		batsman1.setHalfCenturies(60);
//		batsman1.setNoOfMatches(251);
//		batsman1.setRuns(12040);
//		batsman1.setStrikeRate(93.25f);
//		
//		Batsman batsman2= new Batsman();
//		batsman2.setName("M.S Dhoni");
//		batsman2.setAverage(59.3f);
//		batsman2.setCenturies(43);
//		batsman2.setHalfCenturies(60);
//		batsman2.setNoOfMatches(251);
//		batsman2.setRuns(12040);
//		batsman2.setStrikeRate(93.25f);
//		
//		Bowlers bowler1= new Bowlers();
//		bowler1.setName("Jasprit Bhumrah");
//		bowler1.setAverage(59.3f);
//		bowler1.setNoOfMatches(251);
//		bowler1.setFiveWicketHaul(0);
//		bowler1.setWickets(0);
//		bowler1.setStrikeRate(93.25f);
//		
//		Bowlers bowler2= new Bowlers();
//		bowler2.setName("Md shami");
//		bowler2.setAverage(59.3f);
//		bowler2.setNoOfMatches(251);
//		bowler2.setFiveWicketHaul(0);
//		bowler2.setWickets(0);
//		bowler2.setStrikeRate(93.25f);
//		
//		
//		
//		Teams team2= new Teams();
//		team2.setTeamName("Team Australia");
//		team2.setCountry("Australia");
//		team2.setCaptain("Aaron Finch");
//		team2.setNoOfMatchesPlayed(995);
//		team2.setNoOfMatchesWon(579);
//		team2.setNoOfMatchesLost(333);
//		
//		Batsman batsman3= new Batsman();
//		batsman3.setName("Aaron Finch");
//		batsman3.setAverage(59.3f);
//		batsman3.setCenturies(43);
//		batsman3.setHalfCenturies(60);
//		batsman3.setNoOfMatches(251);
//		batsman3.setRuns(12040);
//		batsman3.setStrikeRate(93.25f);
//		
//		Batsman batsman4= new Batsman();
//		batsman4.setName("Glen Maxwell");
//		batsman4.setAverage(59.3f);
//		batsman4.setCenturies(43);
//		batsman4.setHalfCenturies(60);
//		batsman4.setNoOfMatches(251);
//		batsman4.setRuns(12040);
//		batsman4.setStrikeRate(93.25f);
//		
//		Bowlers bowler3= new Bowlers();
//		bowler3.setName("GD McGrath");
//		bowler3.setAverage(59.3f);
//		bowler3.setNoOfMatches(251);
//		bowler3.setFiveWicketHaul(0);
//		bowler3.setWickets(0);
//		bowler3.setStrikeRate(93.25f);
//		
//		Teams team3= new Teams();
//		team3.setTeamName("Team Pakistan");
//		team3.setCountry("Pakistan");
//		team3.setCaptain("Babar Azam");
//		team3.setNoOfMatchesPlayed(0);
//		team3.setNoOfMatchesWon(0);
//		team3.setNoOfMatchesLost(0);
//		
//
//		Batsman batsman5= new Batsman();
//		batsman5.setName("Md Hafeez");
//		batsman5.setAverage(59.3f);
//		batsman5.setCenturies(43);
//		batsman5.setHalfCenturies(60);
//		batsman5.setNoOfMatches(251);
//		batsman5.setRuns(12040);
//		batsman5.setStrikeRate(93.25f);
//		
//		Bowlers bowler5 = new Bowlers();
//		bowler5.setName("Sayyed Ajmal");
//		bowler5.setAverage(59.3f);
//		bowler5.setNoOfMatches(251);
//		bowler5.setFiveWicketHaul(0);
//		bowler5.setWickets(0);
//		bowler5.setStrikeRate(93.25f);
//		
//		
//		addTeams(team1);
//		addTeams(team2);
//		addTeams(team3);
//		System.out.println(teamsList);
//		System.out.println("Total no of teams added are : "+countTeams);
//		System.out.println("****************************************************************");
//		addPlayers(batsman1,bowler1);
//		addPlayers(batsman2,bowler2);
//		addPlayers(batsman3,bowler3);
//		addPlayers(batsman4,null);
//		addPlayers(batsman5,bowler5);
//		System.out.println(bowlersList);
//		System.out.println("****************************************************************");
//		//seearchPlayers();
//		seearchTeams();
////		addPlayersToTeam();
////		addPlayersToTeam();
////		addPlayersToTeam();
////		addPlayersToTeam();
////		System.out.println(teamPlayersList);
////		System.out.println("****************************************************************");
////		playerByCountry();
		
		
		
		
	}
}
