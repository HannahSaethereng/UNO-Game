/**
 * An exception representing the circumstance that there are no cards left when
 * trying to draw another.
 */
public class DeckExhaustedException extends Exception {

   public DeckExhaustedException() {
      super();
   }
   
   public DeckExhaustedException(String message) {
      super(message);
   }
}