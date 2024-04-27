/**
 * <p>A Hand of Uno cards, held by a particular player. A Hand object is
 * responsible for playing a Card (<i>i.e.</i>, actually choosing a card to
 * play) when the player's turn comes up. To do this, it implements the
 * strategy pattern by which this choice can be delegated to an arbitrary
 * implementer of the Player class.</p>
 * @since 1.0
 *
 * @author Hannah Saethereng
 */
public class Hand {

   private Card[] cards;
   private Player player;
   private String playerName;

   /**
    * Instantiate a Hand object to be played by the Player class, and
    * the player name, passed as arguments. This implements a strategy
    * pattern whereby the constructor accepts various strategies that
    * implement the Player interface.
    */
   public Hand(Player player, String playerName) {
      this.player = player;
      this.playerName = playerName;
      cards = new Card[0];
   }

   /**
    * Add (draw) a card to the hand.
    */
   protected void addCard(Card c) {
      Card[] newCards = new Card[cards.length + 1];
      for (int i = 0; i < cards.length; ++i)
         newCards[i] = cards[i];
      newCards[cards.length] = c;
      cards = newCards;
   }

   protected Card removeCard(int index) {
      Card cardToRemove = cards[index];
      Card[] newCards = new Card[cards.length - 1];
      for (int i = 0; i < index; ++i)
         newCards[i] = cards[i];
      for (int i = index + 1; i < cards.length; ++i)
         newCards[i - 1] = cards[i];
      cards = newCards;
   
      return cardToRemove;
   }

   /**
    * Return the number of cards in the hand.
    */
   public int size() {
      return cards.length;
   }

   /**
    * Return true only if this Hand has no cards, which should trigger a
    * winning condition.
    */
   public boolean isEmpty() {
      return cards.length == 0;
   }

   /**
    * Return a string rendering of this Hand.
    */
   public String toString() {
      String retval = "";
      for (int i=0; i<cards.length; i++) {
         retval += cards[i];
         if (i<cards.length-1) {
            retval += ",";
         }
      }
      return retval;
   }

   /**
    * Return the name of the contestant.
    */
   public String getPlayerName() {
      return playerName;
   }

   // --- The methods you are to fill in follow ---

   /**
    * Return the forfeit value of this Hand, as it now stands (in other
    * words, the sum of all the forfeit values of cards still possessed.)
    */
   public int countCards() {
      int count = 0;
      for(int i = 0; i< cards.length; i++)
         count += cards[i].forfeitCost();
      
      return count;
   }

   /**
    * It's your turn: play a card. When this method is called, the Hand
    * object choose a Card from the Hand based on the strategy that is
    * controlling it (<i>i.e.</i>, whose code was passed to the Hand
    * constructor.) If the player cannot legally play any of his/her
    * cards, null should be returned.
    * @return The Card object to be played (which has been removed from
    * this Hand as a side effect), or null if no card can be played.
    */
   protected Card play(Game game) {
    // don't forget to call removeCard on the card you are playing
      
      int indexPlayedCard = player.play(cards, game.getUpCard(), game.getCalledColor(), game.getGameState());
      
      if (indexPlayedCard == -1)
         return null;
      
      else
         return removeCard(indexPlayedCard);
   }

   /**
    * Designed to be called in response to a wild card having been played
    * on the previous call to this object's play() method. This method
    * will choose one of the four colors based on the strategy controlling
    * it (<i>i.e.</i>, the class whose code was passed to the Hand
    * constructor.)
    * @return A Color value, <i>not</i> Color.NONE.
    */
   protected Color callColor(Game game) {
      
      
      return player.callColor(cards);
   }
}
