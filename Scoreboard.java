/**
 * <p>A Scoreboard is a simple container for player names and their current
 * scores. It can do the obvious things like increment someone's score,
 * find the score for a particular player, and determine the winner at the
 * end of the game.</p>
 * @since 1.0
 * 
 * @author Hannah Saethereng
 */
public class Scoreboard {
   private int[] score;
   private String[] listPlayers;


   /**
    * Instantiate a new Scoreboard object, given an array of player names.
    */
   public Scoreboard(String[] playerList) {
      listPlayers = playerList;
      score = new int[playerList.length];
   }

   /**
    * Award points to a particular player.
    * @param player The zero-based player number who just won a game.
    * @param points The number of points to award.
    */
   public void addToScore(int player, int points) {
      score[player] += points;
   
   }

   /**
    * Obtain the score of a particular player.
    * @param player The zero-based player number whose score is desired.
    */
   public int getScore(int player) {
      return score[player];
   }

   /**
    * Render the Scoreboard as a string for display during game play.
    * The returned string should list each player's name and their current
    * score.
    */
   public String toString() {
      String scoreboard = "";
      for (int i=0; i<listPlayers.length; i++) {
         scoreboard += listPlayers[i];
         scoreboard += ": ";
         scoreboard += score[i];
         scoreboard += "\n";
      }
        
      return scoreboard;
   }

   /**
    * Return the list of player names.
    */
   public String[] getPlayerList() {
      return listPlayers;
   }

   /**
    * Return the number of players in the game.
    */
   public int getNumPlayers() {
      return listPlayers.length;
   }

   /**
    * Return the zero-based number of the player who has won the game,
    * <i>presuming someone has.</i> (This method should only be called
    * once the end of the entire match has been detected by some other
    * means, and returns the number of the player with the highest score.)
    */
   public int getWinner() {
      int winnerScore = 0;
      int winner = 0;
      for(int i = 0; i < listPlayers.length; i++){
         if (score[i] > winnerScore){
            winnerScore = score[i];
            winner = i;
         }
      }
      return winner;
   }
}
