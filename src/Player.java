import java.sql.Array;
import java.util.ArrayList;

/**
 * A class that creates Player objects. There are
 * four players, and their "order" numbers will
 * always be 0,1,2,3, where player 0 is the human
 * player.
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Riley TerBush
 * @version April 22, 2024
 */

public class Player {

    private String team;
    private int order;
    private Card[] hand;
    private int position;
    private String trump;
    private Trick trick;
    private ArrayList<Card> trumpCards;

//    private Player[] players;
    private static Player[] players = { new Player("A", 0, null, 0), new Player("B", 1, null, 1),
            new Player("A", 2, null, 2), new Player("B", 3, null, 3) };

    public Player(String team, int order, Card[] hand, int position) {
        this.team = team;
        this.order = order;
        this.hand = null;
        this.position = position;
    }

    public Player() {

    }

    public String getTeam() {
        return team;
    }

    public int getOrder() {
        return order;
    }

    public Card[] getHand() {
        return hand;
    }

    public int getPosition() {
        return position;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void reorderPlayers(int winner) {
        switch (winner) {
            case 0:
                break;
            case 1:
                Player temp = players[0];
                players[0] = players[1];
                players[1] = players[2];
                players[2] = players[3];
                players[3] = temp;
                break;
            case 2:
                Player temp2 = players[0];
                Player temp3 = players[1];
                players[0] = players[2];
                players[1] = players[3];
                players[2] = temp2;
                players[3] = temp3;
                break;
            case 3:
                Player temp4 = players[3];
                players[3] = players[2];
                players[2] = players[1];
                players[1] = players[0];
                players[0] = temp4;
                break;
        }
    }

//    public Card[] playableCards() {
//        ArrayList<Card> playableCards = new ArrayList<>();
//        for (Card card : this.getHand()) {
//            if (card.getSuit().equals(trump)) {
//                playableCards.add(Card)
//            }
//        }
//    }

    public boolean followSuit(String suit) {
        for (Card card : this.getHand()) {
            if (card.getSuit().equals(suit)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Card> getTrump(String trump) {
        ArrayList<Card> trumpList = new ArrayList<>();
        for (Card card : hand) {
            if (card.getSuit().equals(trump)) {
                trumpList.add(card);
            }
        }
        return trumpList;
    }

    public boolean hasRight() {
        for (Card card: hand) {
            if (card.getSuit().equals(trump) && card.getFace().equals("jack")) {
                return true;
            }
        }
        return false;
    }

//    public int getCurrentPlayer() {
//        return
//    }

    public void playerIncrement() {

    }

//    public Card botPlay(Card[] cards, Card highestCard) {
//        boolean hasThatSuit;
//        for (Card card : cards) {
//            if (card.getSuit().equals(highestCard.getSuit()) && card.getNumber() > highestCard.getNumber()) {
//                return card;
//            }
//            if (card.getSuit().equals(highestCard.getSuit())) {
//                hasThatSuit = true;
//            }
//        }
//        if (!highestCard.getSuit().equals(trump)) {
//            Card lowestTrump = null;
//            boolean first = true;
//            for (Card card : trumpCards) {
//                if (first) {
//                    lowestTrump = card;
//                }
//                if (!first && card.getNumber() < lowestTrump.getNumber()) {
//                    lowestTrump = card;
//                }
//                first = false;
//            }
//            return lowestTrump;
//        }
//        boolean first = true;
//        Card lowestCard = null;
//        for (Card card : trumpCards) {
//            if (first) {
//                lowestCard = card;
//            }
//            if (!first && card.getNumber() < lowestCard.getNumber()) {
//                lowestCard = card;
//            }
//            first = false;
//        }
//        return lowestCard;
//    }



    public static void main(String[] args) {
        Player player = new Player();

        player.reorderPlayers(0);
        for (Player player1 : players) {
            System.out.println(player1.getPosition());
        }
    }
}
