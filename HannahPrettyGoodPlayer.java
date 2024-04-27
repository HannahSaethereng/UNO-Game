/**
 * A class for HannahPrettyGoodPlayer
 *
 * @author Hannah
 */

public class HannahPrettyGoodPlayer extends EagerPlayer {
   public int play(Card[] hand, Card upCard, Color calledColor, GameState state){
      
      int notThisColor = -1;
      Color[] prevCalledColor = state.getUpcomingPlayerCalledColors();
      int[] handSize = state.getUpcomingPlayerHandSizes();
      
      
      for (int i = 0; i < handSize.length; i++){
         if (handSize[i] < 2){
            notThisColor = i;
            for (int j = 0; j < hand.length; j++){
               if (hand[j].canPlayOn(upCard, calledColor)== true 
               && hand[j].getRank() != Rank.WILD_D4 
               && hand[j].getColor() != prevCalledColor[notThisColor]){
                     
                  return j;
                  
               }
            }
         }
      }
      
      
      for (int i = 0; i < hand.length; i++){
         if (hand[i].canPlayOn(upCard, calledColor)== true 
         && (hand[i].getRank() != Rank.WILD_D4 && hand[i].getRank() != Rank.CUSTOM)
         && (hand[i].forfeitCost() > 10 && hand[i].getRank() != Rank.WILD)){
            
            return i; 
               
         }
      }
      
      
      
      return super.play(hand, upCard, calledColor, state);
      
      
     
   }
   
   public Color callColor(Card[] hand)
   {
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
}