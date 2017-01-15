package personal_solves;

import java.util.Random;
import java.util.Scanner;

/**
 * 21:49/40:00
 * Ctrl+Y - delete line
 * <p>
 * Created by olehb on 14.01.17.
 */
public class Poker {

    private static Card d1;
    private static Card d2;
    private static Card d3;
    private static Card d4;
    private static Card d5;

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

        @Override
        public String toString() {
            return ""+cardRank.charAt(rank-2)+cardSuit.charAt(suit);
        }
    }

    // hearts - червы, diamonds - бубны, clubs - трефы, spades - пики
    // cards: A - ace, K - king, Q - queen, J - jack
    // A 2 3 4 5 6 7 8 9 10 J Q K
    private static int players = 2;
    private static int card_number = 52;
    private static Card my1;
    private static Card my2;
    private static final String cardRank = "234567891jqka";
    private static final String cardSuit = "hdcs";

    private static final Random rand = new Random();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tmp;
//        System.out.print("Number of cards(52): ");
//        if ((tmp = in.nextLine()) != "") card_number = Integer.valueOf(tmp);

        System.out.print("Number of players(2): ");
        if (!(tmp = in.nextLine()).equals("")) card_number = Integer.valueOf(tmp);

        System.out.print("My cards(rand): ");
        if (!(tmp = in.nextLine()).equals("")) {
            String[] cards = tmp.split(" ");
            my1 = parseCard(cards[0]);
            my2 = parseCard(cards[1]);
        } else {
            String s1 = "" + cardRank.charAt(rand.nextInt(cardRank.length())) + cardSuit.charAt(rand.nextInt(4));
            String s2 = "" + cardRank.charAt(rand.nextInt(cardRank.length())) + cardSuit.charAt(rand.nextInt(4));
            my1 = parseCard(s1);
            my2 = parseCard(s2);
            System.out.println(my1.toString() + " " + my2.toString());
        }
        // calculate probability for combinations


        System.out.print("Desk 3 cards(rand): ");
        if (!(tmp = in.nextLine()).equals("")) {
            String[] cards = tmp.split(" ");
            d1 = parseCard(cards[0]);
            d2 = parseCard(cards[1]);
            d3 = parseCard(cards[2]);
        } else {
            String s1 = "" + cardRank.charAt(rand.nextInt(cardRank.length())) + cardSuit.charAt(rand.nextInt(4));
            String s2 = "" + cardRank.charAt(rand.nextInt(cardRank.length())) + cardSuit.charAt(rand.nextInt(4));
            String s3 = "" + cardRank.charAt(rand.nextInt(cardRank.length())) + cardSuit.charAt(rand.nextInt(4));
            d1 = parseCard(s1);
            d2 = parseCard(s2);
            d3 = parseCard(s3);
            System.out.println(d1.toString() + " " + d2.toString() + " " + d3.toString());
        }
        // calculate probability for combinations


        System.out.print("Desk 4-th card(rand): ");
        if (!(tmp = in.nextLine()).equals("")) {
            d4 = parseCard(tmp);
        } else {
            String s4 = "" + cardRank.charAt(rand.nextInt(cardRank.length())) + cardSuit.charAt(rand.nextInt(4));
            d4 = parseCard(s4);
            System.out.println(d1.toString() + " " + d2.toString() + " " + d3.toString() + " " + d4.toString());
        }
        // calculate probability for combinations


        System.out.print("Desk 5-th card(rand): ");
        if (!(tmp = in.nextLine()).equals("")) {
            d5 = parseCard(tmp);
        } else {
            String s5 = "" + cardRank.charAt(rand.nextInt(cardRank.length())) + cardSuit.charAt(rand.nextInt(4));
            d5 = parseCard(s5);
            System.out.println(d1.toString() + " " + d2.toString() + " " + d3.toString() + " " + d4.toString() + " " + d5.toString());
        }
        // calculate probability for combinations


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
