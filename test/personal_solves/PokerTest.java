package personal_solves;

import org.junit.Test;
import personal_solves.Poker.Card;

import static org.junit.Assert.*;
import static personal_solves.Poker.parseCard;

/**
 * Created by olehb on 14.01.17.
 */
public class PokerTest {
    @Test
    public void testParse() throws Exception {
        assertEquals(new Card(2, 0), parseCard("2h"));
        assertEquals(new Card(3, 0), parseCard("3h"));
        assertEquals(new Card(4, 0), parseCard("4h"));
        assertEquals(new Card(5, 0), parseCard("5h"));
        assertEquals(new Card(6, 0), parseCard("6h"));
        assertEquals(new Card(7, 0), parseCard("7h"));
        assertEquals(new Card(8, 0), parseCard("8h"));
        assertEquals(new Card(9, 0), parseCard("9h"));
        assertEquals(new Card(10, 0), parseCard("1h"));
        assertEquals(new Card(11, 0), parseCard("jh"));
        assertEquals(new Card(12, 0), parseCard("qh"));
        assertEquals(new Card(13, 0), parseCard("kh"));
        assertEquals(new Card(14, 0), parseCard("ah"));

        assertEquals(new Card(14, 1), parseCard("ad"));
        assertEquals(new Card(14, 2), parseCard("ac"));
        assertEquals(new Card(14, 3), parseCard("as"));
    }

}