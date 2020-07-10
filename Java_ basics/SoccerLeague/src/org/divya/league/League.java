package org.divya.league;

public class League {

	public static void main(String[] args) {
		
		Player player1 = new Player();
		player1.playerName = "Veenai Chowdary";
		
		Player player2 = new Player();
		player2.playerName = "Riya Apps";

		Player player3 = new Player();
		player3.playerName = "Malik Sheik";
		
		Player[] thePlayers = {player1, player2, player3};
		
		Team team1 = new Team();
		team1.teamName = "Red Team";
		team1.playerArray = thePlayers;
		
		Team team2 = new Team();
		team2.teamName = "Blue Team";
		
		team2.playerArray = new Player[3];
		
		team2.playerArray[0] = new Player();
 		team2.playerArray[0].playerName = "Divya Chowdary";
 		
 		team2.playerArray[1] = new Player();
 		team2.playerArray[1].playerName = "Sri Ram";
 		
 		team2.playerArray[2] = new Player();
 		team2.playerArray[2].playerName = "John Doe";
 		
 		
 		Game currGame = new Game();
 		currGame.homeTeam = team1;
 		currGame.awayTeam = team2;
 		
 		Goal goal1 = new Goal();
 		goal1.thePlayer = currGame.homeTeam.playerArray[1];
 		goal1.theTeam = currGame.homeTeam;
 		goal1.theTime = 55;
 		
 		Goal[] theGoals = {goal1};
 		
 		currGame.goals = theGoals;
 		
 		System.out.print("The player " + currGame.goals[0].thePlayer.playerName + " of "
 				+ currGame.goals[0].theTeam.teamName + " goals in " + currGame.goals[0].theTime + " ms");
 		
 		System.out.println();
 		
 		System.out.println("Winning Team :");
 		for(Player name: currGame.homeTeam.playerArray) {
 			if(name.playerName.matches(".*Vee.*"))
 				System.out.println(name.playerName);
 		}
		

	}

}
