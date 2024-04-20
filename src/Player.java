public class Player {

    private String team;
    private int order;
    private Card[] hand;

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
}
