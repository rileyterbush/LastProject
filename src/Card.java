import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Card {
    private String suit;
    private String face;
    private int number;
    private String imgTag;
    private boolean played;
    private ArrayList<Card> trump;
//    private int deckOrder;
    private static Card[] kitty;
//    private Card[] cards = {new Card("spade", "ace", 1, 0), new Card("club", "ace", 2, 1),
//            new Card("heart", "ace", 3, 2), new Card("diamond", "ace", 4, 3),
//            new Card("spade", "king", 5, 4), new Card("club", "king", 6, 5),
//            new Card("heart", "king", 7, 6), new Card("diamond", "king", 8, 7),
//            new Card("spade", "queen", 9, 8), new Card("club", "queen", 10, 9),
//            new Card("heart", "queen", 11, 10), new Card("diamond", "queen", 12, 11),
//            new Card("spade", "jack", 13, 12), new Card("club", "jack", 14, 13),
//            new Card("heart", "jack", 15, 14), new Card("diamond", "jack", 16, 15),
//            new Card("spade", "10", 17, 16), new Card("club", "10", 18, 17),
//            new Card("heart", "10", 19, 18), new Card("diamond", "10", 20, 19),
//            new Card("spade", "9", 21, 20), new Card("club", "9", 22, 21),
//            new Card("heart", "9", 23, 22), new Card("diamond", "9", 24, 23),};

    private static Card[] cards = { new Card("spade", "ace", 1, "ace_of_spades.jpeg", false), new Card("club", "ace", 2, "ace_of_clubs.jpeg", false),
            new Card("heart", "ace", 3, "ace_of_hearts.jpeg", false), new Card("diamond", "ace", 4, "ace_of_diamonds.jpeg", false),
            new Card("spade", "king", 5, "king_of_spades.jpeg", false), new Card("club", "king", 6, "king_of_clubs.jpeg", false),
            new Card("heart", "king", 7, "king_of_hearts.jpeg", false), new Card("diamond", "king", 8, "king_of_diamonds.jpeg", false),
            new Card("spade", "queen", 9, "queen_of_spades.jpeg", false), new Card("club", "queen", 10, "queen_of_clubs.jpeg", false),
            new Card("heart", "queen", 11, "queen_of_hearts.jpeg", false), new Card("diamond", "queen", 12, "queen_of_diamonds.jpeg", false),
            new Card("spade", "jack", 13, "jack_of_spades.jpeg", false), new Card("club", "jack", 14, "jack_of_clubs.jpeg", false),
            new Card("heart", "jack", 15, "jack_of_hearts.jpeg", false), new Card("diamond", "jack", 16, "jack_of_diamonds.jpeg", false),
            new Card("spade", "10", 17, "ten_of_spades.jpeg", false), new Card("club", "10", 18, "ten_of_clubs.jpeg", false),
            new Card("heart", "10", 19, "ten_of_hearts.jpeg", false), new Card("diamond", "10", 20, "ten_of_diamonds.jpeg", false),
            new Card("spade", "9", 21, "nine_of_spades.jpeg", false), new Card("club", "9", 22, "nine_of_clubs.jpeg", false),
            new Card("heart", "9", 23, "nine_of_hearts.jpeg", false), new Card("diamond", "9", 24, "nine_of_diamonds.jpeg", false)};

    private static Player[] players = { new Player("A", 1, null), new Player("B", 2, null),
            new Player("A", 3, null), new Player("B", 3, null)};


    public Card() {
    }
    public Card(String suit, String face, int number, String imgTag, boolean played) {
        this.suit = suit;
        this.face = face;
        this.number = number;
        this.imgTag = imgTag;
        this.played = played;
    }

    public String getSuit() {
        return suit;
    }

    public String getFace() {
        return face;
    }
    public int getNumber() {
        return number;
    }


    public Card[] getKitty() {
        return kitty;
    }

    public String getImgTag() {
        return imgTag;
    }


    public void setKitty(Card[] kitty) {
        this.kitty = kitty;
    }

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public static void shuffle(Card[] card, int n) {

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            // Random for remaining positions.
            int r = i + rand.nextInt(24 - i);

            //swapping the elements
            Card temp = card[r];
            card[r] = card[i];
            card[i] = temp;

        }
    }

    public void deal(Player[] players, Card[] cards) {
        Queue<Card> cardQueue = new LinkedList<Card>();
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    Card[] player1Cards = new Card[5];
                    for (int j = 0; j < 5; j++) {
                        player1Cards[j] = cards[j];
                    }
                    players[0].setHand(player1Cards);
                    break;
                case 1:
                    Card[] player2Cards = new Card[5];
                    for (int j = 5; j < 10; j++) {
                        player2Cards[j - 5] = cards[j];
                    }
                    players[1].setHand(player2Cards);
                    break;
                case 2:
                    Card[] player3Cards = new Card[5];
                    for (int j = 10; j < 15; j++) {
                        player3Cards[j - 10] = cards[j];
                    }
                    players[2].setHand(player3Cards);
                    break;
                case 3:
                    Card[] player4Cards = new Card[5];
                    for (int j = 15; j < 20; j++) {
                        player4Cards[j - 15] = cards[j];
                    }
                    players[3].setHand(player4Cards);
                    break;

            }
        }

        Card[] kitty = new Card[4];
        for (int i = 20; i < 24; i++) {
            kitty[i - 20] = cards[i];
        }
        Card.kitty = kitty;
    }

    public String toString(Card[] cards) {
        String cardOrder = "";
        for (Card card: cards) {
            cardOrder = cardOrder.concat(card.getNumber() + " " + card.getSuit() + " " + card.getFace() + "\n");
        }
        return cardOrder;
    }

    public Card getHighestCard(Card[] cards) {
        boolean first = true;
        Card previousCard;
        Card highestCard = null;
        for (Card card : cards) {
            if (first) {
                highestCard = card;
            }
            if (!first && card.getNumber() > highestCard.getNumber()) {
                highestCard = card;
            }
//            previousCard = card;
        }
        return highestCard;
    }

    public Card botPlay(Card[] cards, Card highestCard) {
        boolean hasThatSuit;
        for (Card card : cards) {
            if (card.getSuit().equals(highestCard.getSuit()) && card.getNumber() > highestCard.getNumber()) {
                return card;
            }
            if (card.getSuit().equals(highestCard.getSuit())) {
                hasThatSuit = true;
            }
        }
        if (!highestCard.getSuit().equals(trump)) {
            Card lowestTrump = null;
            boolean first = true;
            for (Card card : trump) {
                if (first) {
                    lowestTrump = card;
                }
                if (!first && card.getNumber() < lowestTrump.getNumber()) {
                    lowestTrump = card;
                }
                first = false;
            }
            return lowestTrump;
        }
        boolean first = true;
        Card lowestCard = null;
        for (Card card : trump) {
            if (first) {
                lowestCard = card;
            }
            if (!first && card.getNumber() < lowestCard.getNumber()) {
                lowestCard = card;
            }
            first = false;
        }
        return lowestCard;
    }



    public static void main(String[] args) {
        Card card = new Card();
        card.shuffle(cards, 24);
        card.deal(players, cards);
        for (Player player : players) {
            System.out.println("Hand:");
            System.out.println(card.toString(player.getHand()));
        }
        System.out.println(card.toString(kitty));
    }

}
