import java.sql.Array;
import java.util.ArrayList;

/**
 * A class that creates tricks, which are the
 * simple rounds in euchre where every player
 * plays one card and the highest card wins.
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Riley TerBush
 * @version April 22, 2024
 */

public class Trick {
    Card firstCardPlayed;
    Card highestCardPlayed;
    String currentWinner;
    Player[] players;
    ArrayList<Card> trickCards;
    static String trump;

    public Trick(Card firstCardPlayed, Card highestCardPlayed, String currentWinner, Player[] players, ArrayList<Card> trickCards) {
        this.firstCardPlayed = firstCardPlayed;
        this.highestCardPlayed = highestCardPlayed;
        this.currentWinner = currentWinner;
        this.players = players;
        this.trickCards = trickCards;
    }

    public String getLeft(String trump) {
        switch (trump) {
            case "heart":
                return "diamond";
            case "diamond":
                return "heart";
            case "club":
                return "spade";
            case "spade":
                return "club";
        }
        return null;
    }

    public Card getFirstCardPlayed() {
        return firstCardPlayed;
    }

    public Card getHighestCardPlayed(String trump) {
        boolean first = true;
        Card highestCard = null;
        String suitMatch = firstCardPlayed.getSuit();
        for (Card card : trickCards) {
            if (first) {
                if (card.getFace().equals("jack")) {
                    if (card.getSuit().equals(trump)) {
                        return card;
                    } else if (card.getSuit().equals(this.getLeft(trump))) {
                        for (Card cards : trickCards) {
                            if (cards.getSuit().equals(trump) && cards.getFace().equals("jack")) {
                                return cards;
                            }
                        }
                        return card;
                    }
                }
                highestCard = card;
                first = false;
                continue;
            }
            if (card.getFace().equals("jack")) {
                if (card.getSuit().equals(trump)) {
                    return card;
                } else if (card.getSuit().equals(this.getLeft(trump))) {
                    for (Card cards : trickCards) {
                        if (card.getSuit().equals(trump) && card.getFace().equals(trump)) {
                            return cards;
                        } else {
                            return card;
                        }
                    }
                }
            }
            if (card.getSuit().equals(trump) && !highestCard.getSuit().equals(trump)) {
                highestCard = card;
            } else if (card.getSuit().equals(highestCard.getSuit()) && card.getNumber() < highestCard.getNumber()) {
                highestCard = card;
            }
        }
        return highestCard;
    }

    public String getCurrentWinner() {
        return currentWinner;
    }

    public void setHighestCardPlayed(Card highestCardPlayed) {
        this.highestCardPlayed = highestCardPlayed;
    }

    public void setCurrentWinner(String currentWinner) {
        this.currentWinner = currentWinner;
    }

    public ArrayList<Card> getTrickCards() {
        return trickCards;
    }

    public void setTrickCards(ArrayList<Card> trickCards) {
        this.trickCards = trickCards;
    }

    public void addTrickCard(Card card) {
        if (this.getTrickCards().isEmpty()) {
            this.firstCardPlayed = card;
            this.highestCardPlayed = card;
        }
        this.trickCards.add(card);
    }

    public void firstPlay() {

    }

    public void followPlay() {

    }

    public void setHighestPlayed() {
        for (Card card : trickCards) {
            if (card.getSuit().equals(trump) && card.getFace().equals("jack")) {
                this.setHighestCardPlayed(card);
            }
            if (card.getSuit().equals(trump) && !this.getHighestCardPlayed(trump).getSuit().equals(trump)) {
                this.setHighestCardPlayed(card);
            }
            if (card.getSuit().equals(this.getFirstCardPlayed().getSuit()) && card.getNumber() > this.getHighestCardPlayed(trump).getNumber() &&
                    !this.getHighestCardPlayed(trump).getSuit().equals(trump)) {
                this.setHighestCardPlayed(card);
            }
//            if (card.getSuit().)
        }
    }

    public void reorderPlayers(int winnerPosition, Player[] players) {
        switch (winnerPosition) {
            case 0:
                break;
            case 1:
                Player temp = players[0];
                players[0] = players[1];
                players[1] = players[2];
                players[2] = players[3];
                players[3] = temp;
                for (int i = 0; i < 4; i++) {
                    players[i].setPosition(i);
                }
                break;
            case 2:
                Player temp2 = players[0];
                Player temp3 = players[1];
                players[0] = players[2];
                players[1] = players[3];
                players[2] = temp2;
                players[3] = temp3;
                for (int i = 0; i < 4; i++) {
                    players[i].setPosition(i);
                }
                break;
            case 3:
                Player temp4 = players[3];
                players[1] = players[0];
                players[2] = players[1];
                players[3] = players[2];
                players[3] = temp4;
                for (int i = 0; i < 4; i++) {
                    players[i].setPosition(i);
                }
                break;
        }
    }


    public static void main(String[] args) {
        Card[] cards = { new Card("club", "jack", 14, "jack_of_clubs.jpeg", false, null),
                new Card("diamond", "jack", 16, "jack_of_diamonds.jpeg", false, null),
                new Card("heart", "king", 7, "king_of_hearts.jpeg", false, null),
                new Card("spade", "queen", 9, "queen_of_spades.jpeg", false, null),
                new Card("spade", "jack", 13, "jack_of_spades.jpeg", false, null)
                };
        ArrayList<Card> trickCards = new ArrayList<>();
        for (Card card : cards) {
            trickCards.add(card);
        }
        Trick trick = new Trick(new Card("club", "jack", 14, "jack_of_clubs.jpeg", false, null),null,null,null,trickCards);
        trump = "spade";
        Card highest = trick.getHighestCardPlayed("spade");
        System.out.println(highest);
    }

}
