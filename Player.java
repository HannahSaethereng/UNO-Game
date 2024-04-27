/**
 * <p>An abstract class that Uno-playing strategies extend in order to
 * compete in an Uno tournament. It consists of two methods which the
 * game calls each time a player's turn arises: play(), which chooses
 * a card from the hand according to some custom algorithm, and callColor()
 * (which is only called if the user chooses to play a wild) that asks the
 * player what color to call.</p>
 * @since 1.0
 */
public abstract class Player {

   public static final int NO_PLAY_POSSIBLE = -1;

   /**
    * <p>This method is called when it's your turn and you need to
    * choose what card to play.</p>
    *
    * <p>The hand parameter tells you what's in your hand. You can call
    * getColor(), getRank(), and getNumber() on each of the cards it
    * contains to see what it is. The color will be the color of the card,
    * or "Color.NONE" if the card is a wild card. The rank will be
    * "Rank.NUMBER" for all numbered cards, and another value (e.g.,
    * "Rank.SKIP," "Rank.REVERSE," etc.) for special cards. The value of
    * a card's "number" only has meaning if it is a number card. 
    * (Otherwise, it will be -1.)</p>
    *
    * <p>The upCard parameter works the same way, and tells you what the 
    * up card (in the middle of the table) is.</p>
    *
    * <p>The calledColor parameter only has meaning if the up card is a
    * wild, and tells you what color the player who played that wild card
    * called.</p>
    *
    * <p>Finally, the state parameter is a GameState object on which you
    * can invoke methods if you choose to access certain detailed
    * information about the game (like who is currently ahead, what colors
    * each player has recently called, etc.)</p>
    *
    * <p>You must return a value from this method indicating which card you
    * wish to play. If you return a number 0 or greater, that means you
    * want to play the card at that index. If you cannot play any of your 
    * cards (none of them are legal plays), you should return NO_PLAY_POSSIBLE,
    * in which case you will be forced to draw a card (this will happen
    * automatically for you.)</p>
    */
   public abstract int play(Card[] hand, Card upCard, Color calledColor, GameState state);

   /**
    * <p>This method will be called when you have just played a
    * wild card, and is your way of specifying which color you want to 
    * change it to.</p>
    *
    * <p>You must return a valid Color value from this method. You must
    * not return the value Color.NONE under any circumstances.</p>
    */
   public abstract Color callColor(Card[] hand);

}
