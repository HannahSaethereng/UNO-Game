import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class DeckTest {
   @Test
   public void testCustom() {
      Deck deck = new Deck();
      boolean customFound = false;
      
      try {
         while (!deck.isEmpty() && !customFound) {
            if (deck.draw().getRank() == Rank.CUSTOM)
               customFound = true;
         }
      }
      catch (DeckExhaustedException e) {
         fail("should never run out of cards");
      }    
         
      assertTrue("Deck has no custom cards", customFound);
   }
}