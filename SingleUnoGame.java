/**
 * A class for playing a single Uno game.
 *
 * @author Hannah Saethereng
 */
public class SingleUnoGame {

   private Scoreboard scoreboard;
   private Player[] players;

   /**
    * Creates a new SingleUnoGame.
    * @param scoreboard the scoreboard to use to keep score
    * @param players the players playing the game
    */
   public SingleUnoGame(Scoreboard scoreboard, Player[] players) {
      this.scoreboard = scoreboard;
      this.players = players;
   }
   
   /**
    * Returns the game's scoreboard.
    */
   public Scoreboard getScoreboard() {
      return scoreboard;
   }
   
   /**
    * Returns the game's players.
    */
   public Player[] getPlayers() {
      return players;
   }
   
   /**
    * Plays a single round of Uno. The winner can be determined by calling the
    * scoreboard's getWinner method.
    */
   public void playGame() {
      Game game = new Game(scoreboard, players);
      game.play();
   }

   public static void main(String[] args) {
      // Fill this in with your Player classes to run a four-player Uno game.
      String[] playerList = {"Jupe", "Lana", "Hannah", "Holden"};
      // Set the PRINT_VERBOSE class variable in Game to true to tell it to
      // display the details of the game.
      Game.PRINT_VERBOSE = true;
      // You will need to create a Scoreboard and an array of Players, then
      // create a new SingleUnoGame object and call its playGame method.
      Scoreboard scoreboard = new Scoreboard(playerList);
      Player[] players = {new EagerPlayer(), new EagerPlayer(), new EagerPlayer(), new EagerPlayer()};
      SingleUnoGame gameOne = new SingleUnoGame(scoreboard, players);
      gameOne.playGame();
   
   }
}