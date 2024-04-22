import java.sql.Array;
import java.util.ArrayList;

public class Player {

    private String team;
    private int order;
    private Card[] hand;
    private String trump;
    private Trick trick;
    private ArrayList<Card> trumpCards;

    private Player[] players;
//    private Player[] players = { new Player("A", 0, null), new Player("B", 1, null),
//            new Player("A", 2, null), new Player("B", 3, null) };

    public Player(String team, int order, Card[] hand) {
        this.team = team;
        this.order = order;
        this.hand = null;
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

    public void setTeam(String team) {
        this.team = team;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
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
                players[0] = players[3];
                players[1] = players[4];
                players[2] = temp2;
                players[3] = temp3;
                break;
            case 3:
                Player temp4 = players[3];
                players[1] = players[0];
                players[2] = players[1];
                players[3] = players[2];
                players[3] = temp4;
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

    public boolean followSuit() {
        for (Card card : this.getHand()) {
            if (card.getSuit().equals(trump)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Card> getTrump() {
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



//    public static void main(String[] args) {
//        Player player = new Player();
//        players.reorderPlayers()
//    }
}
