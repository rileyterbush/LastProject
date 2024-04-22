import java.util.ArrayList;

public class Trick {
    Card firstCardPlayed;
    Card highestCardPlayed;
    String currentWinner;
    Player[] players;
    ArrayList<Card> trickCards;
    String trump;

    public Trick(Card firstCardPlayed, Card highestCardPlayed, String currentWinner, Player[] players, ArrayList<Card> trickCards) {
        this.firstCardPlayed = firstCardPlayed;
        this.highestCardPlayed = highestCardPlayed;
        this.currentWinner = currentWinner;
        this.players = players;
        this.trickCards = trickCards;
    }

    public Card getFirstCardPlayed() {
        return firstCardPlayed;
    }

    public Card getHighestCardPlayed() {
        return highestCardPlayed;
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
            if (card.getSuit().equals(trump) && !this.getHighestCardPlayed().getSuit().equals(trump)) {
                this.setHighestCardPlayed(card);
            }
            if (card.getSuit().equals(this.getFirstCardPlayed().getSuit()) && card.getNumber() > this.getHighestCardPlayed().getNumber() &&
                    !this.getHighestCardPlayed().getSuit().equals(trump)) {
                this.setHighestCardPlayed(card);
            }
//            if (card.getSuit().)
        }
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

//    public Card botPlays() {
//        if (firstCardPlayed == null) {
//            for (this.getHand)
//        }
//    }

//    public Card botFollows()

}
