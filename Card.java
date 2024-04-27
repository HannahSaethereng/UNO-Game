/**
 * <p>A Card in an Uno deck. Each Card knows its particular type, which is
 * comprised of a 3-tuple (color, rank, number). Not all of these values
 * are relevant for every particular type of card, however; for instance,
 * wild cards have no color (getColor() will return Color.NONE) or number
 * (getNumber() will return -1).</p>
 * <p>A Card knows its forfeit cost (<i>i.e.</i>, how many points it counts
 * against a loser who gets stuck with it) and how it should act during
 * game play (whether it permits the player to change the color, what
 * effect it has on the game state, etc.)</p>
 * @since 1.0
 * 
 * @author Hannah Saetherng
 */
public class Card {
//add instance variables here
   private int number;
   private Color color;
   private Rank rank;
   

 /**
    * Constructor for non-number cards (skips, wilds, etc.)
    */
   public Card(Color color, Rank rank) {
      this.color = color;
      this.rank = rank;
      number = -1;
   }

   /**
    * Constructor for number cards.
    */
   public Card(Color color, int number) {
      this.number = number;
      this.color = color;
      rank = Rank.NUMBER;
   }

   /**
    * Constructor to explicitly set entire card state.
    */
   public Card(Color color, Rank rank, int number) {
      this.color = color;
      this.rank = rank;
      this.number = number;
   }

   /**
    * Returns the number of points this card will count against a player
    * who holds it in his/her hand when another player goes out.
    */
   public int forfeitCost() {
      if (rank.equals(Rank.SKIP) || rank.equals(rank.REVERSE) || rank.equals(Rank.DRAW_TWO))
         return 20;
      else if (rank.equals(Rank.WILD) || rank.equals(Rank.WILD_D4) || rank.equals(Rank.CUSTOM))
         return 50;
      else if (number == 0)
         return 0;
      else if (number == 1)
         return 1;
      else if (number == 2)
         return 2;
      else if (number == 3)
         return 3;
      else if (number == 4)
         return 4;
      else if (number == 5)
         return 5;
      else if (number == 6)
         return 6;
      else if (number == 7)
         return 7;
      else if (number == 8)
         return 8;
      else 
         return 9;
      
      
   }

   /**
    * Returns true only if this Card can legally be played on the up card
    * passed as an argument. The second argument is relevant only if the
    * up card is a wild.
    * @param upCard An "up card" upon which the current object might (or might
    * not) be a legal play.
    * @param calledColor If the up card is a wild card, this parameter
    * contains the color the player of that color called.
    */ 
   public boolean canPlayOn(Card upCard, Color calledColor) {
      //Card card = new Card(color,rank,number);
      if (this.getColor().equals(upCard.getColor()))
         return true;
      else if (upCard.getRank().equals(Rank.CUSTOM))
         return true;
      else if ((upCard.getRank().equals(Rank.WILD) || upCard.getRank().equals(Rank.WILD_D4)) && calledColor.equals(getColor()))
         return true;
      else if (this.getNumber() == upCard.getNumber() && getRank().equals(Rank.NUMBER))
         return true;
      else if (upCard.getRank().equals(getRank()) && !(upCard.getRank().equals(Rank.NUMBER)))
         return true;
      else if (getRank().equals(Rank.WILD) || getRank().equals(Rank.WILD_D4) || getRank().equals(Rank.CUSTOM))
         return true;
      else
         return false;
   }

   /**
    * Returns true only if playing this Card object would result in the
    * player being asked for a color to call. (In the standard game, this
    * is true only for wild cards.)
    */
   public boolean isWildCard() {
      //Card card = new Card(color,rank,number);
      if (getRank().equals(Rank.WILD) || getRank().equals(Rank.WILD_D4))
         return true;
      else
         return false;
   }

   /**
    * Returns the color of this card, which is Color.NONE in the case of
    * wild cards.
    */
   public Color getColor() {
      return color;
   }

   /**
    * Returns the rank of this card, which is Rank.NUMBER in the case of
    * number cards (calling getNumber() will retrieve the specific
    * number.)
    */
   public Rank getRank() {
      return rank;
   }

   /**
    * Returns the number of this card, which is guaranteed to be -1 for
    * non-number cards (cards of non-Rank.NUMBER rank.)
    */
   public int getNumber() {
      //Card card = new Card(color,rank,number);
      if (rank==Rank.NUMBER)
         return number;
      else
         return -1;
   }

   /**
    * Returns this Card object as a string. 
    */
   public String toString() {
      if (color.equals(Color.NONE))
         return "" + rank;
      else if (number == -1)
         return "" + color + " " + rank;
      else
         return "" + color + " " + number;
   }
   
   /*public static void main(String[] args) {
   
      Card gs = new Card(Color.GREEN, Rank.SKIP);
      Card gd2 = new Card(Color.GREEN, Rank.DRAW_TWO);
      //System.out.println(gs.canPlayOn(gd2, Color.BLUE));
      Card ys = new Card(Color.YELLOW, Rank.SKIP);
      Card b4 = new Card(Color.BLUE, 4);
      Card y3 = new Card(Color.YELLOW, 3);
      Card g3 = new Card(Color.GREEN,3);
      Card r1 = new Card(Color.RED, 1);
      Card wd4 = new Card(Color.NONE, Rank.WILD_D4);
      EagerPlayer test = new EagerPlayer();  
      Card[] testHand = {g3, r1, wd4}; 
      GameState state = new GameState(); 
      //System.out.println(test.play(testHand, gd2, Color.BLUE, state));  
      System.out.println(test.play(testHand, b4, Color.RED, state)); 
   }*/

}
