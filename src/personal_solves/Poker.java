package personal_solves;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by olehb on 14.01.17.
 */
public class Poker {
    private static Card my2;

    static class Card {
        int rank;// 2-14
        int suit;// (mast') 0-3

        Card(int rank, int suit) {
            if (rank < 2 || rank > 14) throw new PersonalException("Rank can't be " + rank);
            if (suit < 0 || suit > 3) throw new PersonalException("Suit can't be " + suit);
            this.rank = rank;
            this.suit = suit;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Card card = (Card) o;
            if (rank != card.rank) return false;
            return suit == card.suit;
        }

        @Override
        public int hashCode() {
            int result = rank;
            result = 31 * result + suit;
            return result;
        }
    }

    // hearts - червы, diamonds - бубны, clubs - трефы, spades - пики
    // cards: A - ace, K - king, Q - queen, J - jack
    // A 2 3 4 5 6 7 8 9 10 J Q K
    private static int players = 2;
    private static int card_number = 52;
    private static Card my1;
    private static final String cardRank = "234567891jqka";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tmp;
//        System.out.print("Number of cards(52): ");
//        if ((tmp = in.nextLine()) != "") card_number = Integer.valueOf(tmp);

        System.out.print("Number of players(2): ");
        if ((tmp = in.nextLine()) != "") card_number = Integer.valueOf(tmp);

        System.out.print("My cards(rand): ");
        if ((tmp = in.nextLine()) != "") {
            String[] cards = tmp.split(" ");
            my1 = parseCard(cards[0]);
            my2 = parseCard(cards[1]);
        } else {
            Random rand = new Random();
            String s1 = ""+cardRank.charAt(rand.nextInt(cardRank.length()))+(rand.nextInt(4)+'0');
            String s2 = ""+cardRank.charAt(rand.nextInt(cardRank.length()))+(rand.nextInt(4)+'0');
            my1 = parseCard(s1);
            my1 = parseCard(s2);
            System.out.println(s1+ " " + s2);
        }


    }

    static Card parseCard(String s) {
        int rank, suit = -1;
        switch (s.charAt(1)) {
            case 'h':
            case 'H':
                suit = 0;
                break;
            case 'd':
            case 'D':
                suit = 1;
                break;
            case 'c':
            case 'C':
                suit = 2;
                break;
            case 's':
            case 'S':
                suit = 3;
                break;
            default:
                throw new PersonalException("Not suitable character - " + s.charAt(1));
        }
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9') rank = s.charAt(0) - '0';
        else switch (s.charAt(0)) {
            case 'j':
            case 'J':
                rank = 11;
                break;
            case 'q':
            case 'Q':
                rank = 12;
                break;
            case 'k':
            case 'K':
                rank = 13;
                break;
            case 'a':
            case 'A':
                rank = 14;
                break;
            default:
                throw new PersonalException("Not rankable character - " + s.charAt(0));
        }
        if (s.charAt(0) == '1') rank = 10;
        return new Card(rank, suit);
    }
}
