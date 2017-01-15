package personal_solves;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import personal_solves.Poker.Card;

import static org.hamcrest.CoreMatchers.startsWith;

import static org.junit.Assert.*;

/**
 * Created by olehb on 14.01.17.
 */
public class CardTest {

    @Test
    public void testRank() throws Exception {
        new Card(2,0);
        new Card(14, 0);
        try {
            new Card(1, 0);
        } catch (PersonalException e) {
            assertTrue(e.getMessage().startsWith("Rank"));
            System.out.println(e.getMessage());
        }
        try {
            new Card(15, 0);
        } catch (PersonalException e) {
            assertTrue(e.getMessage().startsWith("Rank"));
            System.out.println(e.getMessage());
        }
        System.out.println("Rank tested");
    }

    @Test
    public void testSuit() throws Exception {
        new Card(2,0);
        new Card(2, 3);
        try {
            new Card(2, -1);
        } catch (PersonalException e) {
            assertTrue(e.getMessage().startsWith("Suit"));
            System.out.println(e.getMessage());
        }
        try {
            new Card(2, 4);
        } catch (PersonalException e) {
            assertTrue(e.getMessage().startsWith("Suit"));
            System.out.println(e.getMessage());
        }
        System.out.println("Suit tested");
    }

}