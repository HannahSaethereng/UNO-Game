/**
 * A class for SomewhatLessEagerPlayer
 *
 * @author Hannah Saethereng
 */ 
public class SomewhatLessEagerPlayer extends EagerPlayer {
   public int play(Card[] hand, Card upCard, Color calledColor, GameState state){
   
      for (int i = 0; i<hand.length; i++){
         if (hand[i].getRank().equals(Rank.CUSTOM)){
            return i;
         }
      }
      return super.play(hand, upCard, calledColor, state);
   }

   public Color callColor(Card[] hand){
      int green = 0;
      int red = 0;
      int blue = 0; 
      int yellow = 0;
      int colorlessCards = 0;
      for (int i = 0; i < hand.length; i++) {
         
         if (hand[i].getColor().equals(Color.GREEN)){
            green += hand[i].forfeitCost();
         }
         else if (hand[i].getColor().equals(Color.RED)){
            red += hand[i].forfeitCost();
         }
         else if (hand[i].getColor().equals(Color.BLUE)){
            blue += hand[i].forfeitCost();
         }
         else if (hand[i].getColor().equals(Color.YELLOW)){
            yellow += hand[i].forfeitCost();
         }
         else {
            colorlessCards++;
            
         }
      }
      if (colorlessCards == hand.length){
         return super.callColor(hand);
      }
      else if(green>=red && green>=blue && green>=yellow)
         return Color.GREEN;
      else if (red>=green && red>=blue && red>=yellow)
         return Color.RED;
      else if (blue>=green && blue>=red && blue>=yellow)
         return Color.BLUE;
      else
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
      Card wd = new Card(Color.NONE, Rank.WILD);
      Card c = new Card(Color.NONE, Rank.CUSTOM);
      Card rd2 = new Card(Color.RED, Rank.DRAW_TWO);
      Card b9 = new Card(Color.BLUE, 9);
      Card y6 = new Card(Color.YELLOW, 6);
      Card b7 = new Card(Color.BLUE, 7);
      SomewhatLessEagerPlayer test = new SomewhatLessEagerPlayer();  
      
      Card[] testHand = {wd,c }; 
      GameState state = new GameState(); 
      //System.out.println(test.play(testHand, gd2, Color.BLUE, state));  
      //System.out.println(test.play(testHand, b4, Color.RED, state)); 
      System.out.println(test.callColor(testHand));
   }

}