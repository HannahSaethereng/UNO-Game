/**
 * A class for playing multiple Uno games at once with a standing scoreboard.
 * The playGames method will play a specified number of games (using a 
 * SingleUnoGame's playGame method repeatedly).
 *
 * @author Hannah Saethereng
 */
public class MultipleUnoGame {

   private SingleUnoGame singleGame;
   private int gamesPlayed = 0;
   private long updateInterval = 0;
   
   /**
    * Create a new MultipleUnoGame using the given scoreboard and players.
    */
   public MultipleUnoGame(Scoreboard scoreboard, Player[] players) {
      this.singleGame = new SingleUnoGame(scoreboard, players);
   }
   
   /**
    * Returns the update interval (in milliseconds). If this number is positive
    * then the playGames method will periodically display scoreboard updates.
    */
   public long getUpdateInterval() {
      return updateInterval;
   }
   
   /**
    * Sets the update interval (in milliseconds, so for example 500 corresponds
    * to half a second). If this interval is positive, then scoreboard updates
    * will be printed out by the playGames method according to the interval.
    * (If the interval is 500, then updates will be printed every half second.)
    */
   public void setUpdateInterval(long updateInterval) {
      this.updateInterval = updateInterval;
   }
   
   /**
    * Play numGames games (by repeated call to SingleUnoGame.play()). The same
    * Scoreboard is used for all, so the points in it will accumulate across
    * all games. This method may be called repeatedly to play additional
    * batches of games.
    *
    * If updateInterval is positive (see setUpdateInterval), will display
    * periodic updates.
    */
   public void playGames(int numGames) {
      long lastUpdateTime = System.currentTimeMillis();
      for (int i = 0; i < numGames; i++, gamesPlayed++) {
         singleGame.playGame();
         
         long currentTime = System.currentTimeMillis();
         if (updateInterval > 0 && currentTime > lastUpdateTime + updateInterval) {
            // It's been 500 milliseconds (half a second) - show the current status
            printStatus();
            lastUpdateTime = currentTime;
         }
      }
      
      printStatus();
   
      Scoreboard board = getScoreboard();
      int winnerIndex = board.getWinner();
      String winnerName = board.getPlayerList()[winnerIndex];
   
      System.out.printf("=== The winner is %s! Congratulations! ===\n\n", winnerName);
   }
   
   /**
    * Prints a status message consisting of the number of games played and the
    * current scoreboard.
    */
   public void printStatus() {
      System.out.printf("After %,d games:\n", gamesPlayed);
      System.out.println(getScoreboard());
      System.out.println();
   }
   
   /**
    * Returns the scoreboard.
    */
   public Scoreboard getScoreboard() {
      return singleGame.getScoreboard();
   }

   /**
    * Returns the number of games played so far.
    */
   public int getGamesPlayed() {
      return gamesPlayed;
   }
   
   public static void main(String[] args) {
      Game.PRINT_VERBOSE = false;
      String[] playerNames = { "EagerPlayer", "HannahPrettyGoodPlayer",  "SomewhatLessEagerPlayer" };
      Scoreboard scoreboard = new Scoreboard(playerNames);
      Player[] players = {
         new EagerPlayer(),
         new HannahPrettyGoodPlayer(),
         new SomewhatLessEagerPlayer(),
         //new SomewhatLessEagerPlayer(),
         };
      
      MultipleUnoGame multiGame = new MultipleUnoGame(scoreboard, players);
      multiGame.setUpdateInterval(500); // updates every half second
      multiGame.playGames(100_000); // play 100,000 games
   }
}
