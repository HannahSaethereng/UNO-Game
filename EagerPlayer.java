
/**
 * A class for EagerPlayer
 *
 * @author Hannah
 */

public class EagerPlayer extends Player{
   public int play(Card[] hand, Card upCard, Color calledColor, GameState state)
   {
   
      int noPlayPossible = 0;
      int hasWildCard = -1;
      for (int i = 0; i < hand.length; i++){
         Card current =  hand[i];
         if (hand[i].getRank().equals(Rank.WILD_D4)){
            hasWildCard = i;
         }
         else if (hand[i].canPlayOn(upCard, calledColor) == true){
            return i;
         }
         
                     
         else if(hand[i].canPlayOn(upCard, calledColor) == false){
            noPlayPossible++;
            if (noPlayPossible == (hand.length))
               return NO_PLAY_POSSIBLE;
         }
         
      }
      if (hasWildCard > -1)
         return hasWildCard;
      
      else
         return -1;
   }
   public Color callColor(Card[] hand)
   {
   
      return Color.YELLOW;
   }
   public static void main(String[] args) {
   
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
   }
}