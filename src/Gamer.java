import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * A class that initializes the euchre game
 * and lays out the cards used to play into
 * a complex GUI.
 *
 * <p>Purdue University -- CS18000 -- Spring 2024</p>
 *
 * @author Riley TerBush
 * @version April 22, 2024
 */


public class Gamer implements Runnable {
//    Gamer gamer;
    private int teamAScore;
    private int teamBScore;
    private int cardsPlayed;
    private String trump;
    private ArrayList<Card> trumpCards;
    private Card right;
    private Card left;
    private int playerIndex;

    private Trick trick = new Trick(null, null, null, null, new ArrayList<Card>());
    private static Player[] players = { new Player("A", 0, null, 0), new Player("B", 1, null, 1),
            new Player("A", 2, null, 2), new Player("B", 3, null, 3) };
    private Card card1, card2, card3, card4, card5;

    private static Card[] cards = { new Card("spade", "ace", 1, "ace_of_spades.jpeg", false, null), new Card("club", "ace", 2, "ace_of_clubs.jpeg", false, null),
        new Card("heart", "ace", 3, "ace_of_hearts.jpeg", false, null), new Card("diamond", "ace", 4, "ace_of_diamonds.jpeg", false, null),
        new Card("spade", "king", 5, "king_of_spades.jpeg", false, null), new Card("club", "king", 6, "king_of_clubs.jpeg", false, null),
        new Card("heart", "king", 7, "king_of_hearts.jpeg", false, null), new Card("diamond", "king", 8, "king_of_diamonds.jpeg", false, null),
        new Card("spade", "queen", 9, "queen_of_spades.jpeg", false, null), new Card("club", "queen", 10, "queen_of_clubs.jpeg", false, null),
        new Card("heart", "queen", 11, "queen_of_hearts.jpeg", false, null), new Card("diamond", "queen", 12, "queen_of_diamonds.jpeg", false, null),
        new Card("spade", "jack", 13, "jack_of_spades.jpeg", false, null), new Card("club", "jack", 14, "jack_of_clubs.jpeg", false, null),
        new Card("heart", "jack", 15, "jack_of_hearts.jpeg", false, null), new Card("diamond", "jack", 16, "jack_of_diamonds.jpeg", false, null),
        new Card("spade", "10", 17, "ten_of_spades.jpeg", false, null), new Card("club", "10", 18, "ten_of_clubs.jpeg", false, null),
        new Card("heart", "10", 19, "ten_of_hearts.jpeg", false, null), new Card("diamond", "10", 20, "ten_of_diamonds.jpeg", false, null),
        new Card("spade", "9", 21, "nine_of_spades.jpeg", false, null), new Card("club", "9", 22, "nine_of_clubs.jpeg", false, null),
        new Card("heart", "9", 23, "nine_of_hearts.jpeg", false, null), new Card("diamond", "9", 24, "nine_of_diamonds.jpeg", false, null)};

    JButton startGameButton;
    JButton botPlayButton;


    // These are the fields for the card in the human user's hand which are displayed across
    // the bottom of the screen
    JButton cardOne;
    JButton cardTwo;
    JButton cardThree;
    JButton cardFour;
    JButton cardFive;
    JLabel teamAScoreLabel;
    JLabel teamBScoreLabel;



    public Gamer() {
    }


    public void run() {
        cardsPlayed = 0;
        playerIndex = 0;
        final int MINIMUM = 600;
        JFrame frame = new JFrame();
        frame.setTitle("Euchre");
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        Game game = new Game();


        teamAScore = 0;
        teamBScore = 0;

        JPanel panelWelcome = new JPanel();
        startGameButton = new JButton("Start the euchre game!");
        panelWelcome.add(startGameButton);
        content.add(panelWelcome);
        panelWelcome.setVisible(true);



        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());


        boolean first = true;

        JPanel informationBar = new JPanel();
        JLabel trumpLabel;
        teamAScoreLabel = new JLabel("Team A: " + teamAScore);
        teamBScoreLabel = new JLabel("Team B: " + teamBScore);
        botPlayButton = new JButton("Get next play");
        informationBar.add(botPlayButton);
        informationBar.add(teamAScoreLabel);
        informationBar.add(teamBScoreLabel);
        content.add(informationBar);
        informationBar.setVisible(true);

        if (players[playerIndex].getOrder() == 0) {
            botPlayButton.setEnabled(false);
        } else {
            botPlayButton.setEnabled(true);
        }

        Card card = new Card();


        startGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelWelcome.setVisible(false);
                panel.setVisible(true);
                informationBar.setVisible(true);
            }
        });

        Gamer gamer = new Gamer();
        card.shuffle(cards, 24);
        card.deal(players, cards);
        trump = card.getKitty()[0].getSuit();
        trumpLabel = new JLabel(trump + "s is trump");


        card1 = players[0].getHand()[0];
        card2 = players[0].getHand()[1];
        card3 = players[0].getHand()[2];
        card4 = players[0].getHand()[3];
        card5 = players[0].getHand()[4];
//        if (first) {
        try {
            cardOne = new JButton(new ImageIcon(ImageIO.read(new File(card1.getImgTag()))));
            cardTwo = new JButton(new ImageIcon(ImageIO.read(new File(card2.getImgTag()))));
            cardThree = new JButton(new ImageIcon(ImageIO.read(new File(card3.getImgTag()))));
            cardFour = new JButton(new ImageIcon(ImageIO.read(new File(card4.getImgTag()))));
            cardFive = new JButton(new ImageIcon(ImageIO.read(new File(card5.getImgTag()))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        panel.add(cardOne);
        panel.add(cardTwo);
        panel.add(cardThree);
        panel.add(cardFour);
        panel.add(cardFive);
        frame.add(panel, BorderLayout.SOUTH);
        frame.repaint();
//        }

        informationBar.add(trumpLabel);
        content.add(informationBar, BorderLayout.NORTH);

        if (first) {
            panel.setVisible(true);
        }
        first = false;

        JPanel trickPanel = new JPanel();
        trickPanel.setLayout(new GridLayout());
        trickPanel.setVisible(true);
        content.add(trickPanel, BorderLayout.CENTER);

        if (players[playerIndex].getOrder() != 0) {
            cardOne.setEnabled(false);
            cardTwo.setEnabled(false);
            cardThree.setEnabled(false);
            cardFour.setEnabled(false);
            cardFive.setEnabled(false);
        }



        cardOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardOne.setVisible(false);
                trickPanel.add(cardOne);
                trickPanel.repaint();
                cardOne.setVisible(true);
                trick.addTrickCard(card1);
                card1.setPlayed(true);
                cardsPlayed++;
                if (playerIndex < 3) {
                    playerIndex++;
                } else {
                    playerIndex = 0;
                }

                cardOne.setEnabled(false);
                cardTwo.setEnabled(false);
                cardThree.setEnabled(false);
                cardFour.setEnabled(false);
                cardFive.setEnabled(false);
                botPlayButton.setEnabled(true);
                if (trick.getTrickCards().size() == 4) {
                    for (Card card : trick.getTrickCards()) {
                        System.out.println(card.toString());
                    }
                    Card winningCard = trick.getHighestCardPlayed(trump);
                    Player winningPlayer = winningCard.getPlayer();
                    String winningTeam = winningPlayer.getTeam();
                    JOptionPane.showMessageDialog(null, "The winner is " + winningTeam + " with "
                            + winningCard.toString() + " played by Player" + winningPlayer.getOrder());
                    if (winningTeam.equals("A")) {
                        teamAScore++;
                        teamAScoreLabel = new JLabel("Team A Score: " + teamAScore);
                        teamAScoreLabel.revalidate();
                        teamAScoreLabel.repaint();
                    } else {
                        teamBScore++;
                        teamBScoreLabel = new JLabel("Team B Score: " + teamBScore);
                        teamBScoreLabel.revalidate();
                        teamBScoreLabel.repaint();
                    }

                    if (cardsPlayed == 5) {
                        if (teamBScore > teamAScore) {
                            JOptionPane.showMessageDialog(null, "The winner is Team B. Thank you for playing!");
                        } else {
                            JOptionPane.showMessageDialog(null, "The winner is Team A. Thank you for playing!");
                        }
                    }

                    trick.reorderPlayers(winningPlayer.getPosition(), players);
                    for (Player player : players) {
                        System.out.println(player.getOrder());
                    }
                    trick.setTrickCards(new ArrayList<Card>());
                    trickPanel.removeAll();
                    trickPanel.revalidate();
                    trickPanel.repaint();

                    if (players[0].getOrder() == 0) {
                        cardOne.setEnabled(true);
                        cardTwo.setEnabled(true);
                        cardThree.setEnabled(true);
                        cardFour.setEnabled(true);
                        cardFive.setEnabled(true);
                        botPlayButton.setEnabled(false);
                    } else {
                        cardOne.setEnabled(false);
                        cardTwo.setEnabled(false);
                        cardThree.setEnabled(false);
                        cardFour.setEnabled(false);
                        cardFive.setEnabled(false);
                        botPlayButton.setEnabled(true);
                    }
                }
            }
        });

        cardTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardTwo.setVisible(false);
                trickPanel.add(cardTwo);
                trickPanel.repaint();
                cardTwo.setVisible(true);
                trick.addTrickCard(card2);
                card2.setPlayed(true);
                cardsPlayed++;
                if (playerIndex < 3) {
                    playerIndex++;
                } else {
                    playerIndex = 0;
                }
                cardOne.setEnabled(false);
                cardTwo.setEnabled(false);
                cardThree.setEnabled(false);
                cardFour.setEnabled(false);
                cardFive.setEnabled(false);
                botPlayButton.setEnabled(true);
                if (trick.getTrickCards().size() == 4) {
                    for (Card card : trick.getTrickCards()) {
                        System.out.println(card.toString());
                    }
                    Card winningCard = trick.getHighestCardPlayed(trump);
                    Player winningPlayer = winningCard.getPlayer();
                    String winningTeam = winningPlayer.getTeam();
                    JOptionPane.showMessageDialog(null, "The winner is " + winningTeam + " with "
                            + winningCard.toString() + " played by Player" + winningPlayer.getOrder());
                    if (winningTeam.equals("A")) {
                        teamAScore++;
                        teamAScoreLabel = new JLabel("Team A Score: " + teamAScore);
                        teamAScoreLabel.revalidate();
                        teamAScoreLabel.repaint();
                    } else {
                        teamBScore++;
                        teamBScoreLabel = new JLabel("Team B Score: " + teamBScore);
                        teamBScoreLabel.revalidate();
                        teamBScoreLabel.repaint();
                    }

                    if (cardsPlayed == 5) {
                        if (teamBScore > teamAScore) {
                            JOptionPane.showMessageDialog(null, "The winner is Team B. Thank you for playing!");
                        } else {
                            JOptionPane.showMessageDialog(null, "The winner is Team A. Thank you for playing!");
                        }
                    }

                    trick.reorderPlayers(winningPlayer.getOrder(), players);
                    for (Player player : players) {
                        System.out.println(player.getOrder());
                    }
                    trick.setTrickCards(new ArrayList<Card>());
                    trickPanel.removeAll();
                    trickPanel.revalidate();
                    trickPanel.repaint();

                    if (players[0].getOrder() == 0) {
                        cardOne.setEnabled(true);
                        cardTwo.setEnabled(true);
                        cardThree.setEnabled(true);
                        cardFour.setEnabled(true);
                        cardFive.setEnabled(true);
                        botPlayButton.setEnabled(false);
                    } else {
                        cardOne.setEnabled(false);
                        cardTwo.setEnabled(false);
                        cardThree.setEnabled(false);
                        cardFour.setEnabled(false);
                        cardFive.setEnabled(false);
                        botPlayButton.setEnabled(true);
                    }
                }

            }
        });

        cardThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardThree.setVisible(false);
                trickPanel.add(cardThree);
                trickPanel.repaint();
                cardThree.setVisible(true);
                trick.addTrickCard(card3);
                card3.setPlayed(true);
                cardsPlayed++;
                if (playerIndex < 3) {
                    playerIndex++;
                } else {
                    playerIndex = 0;
                }
                cardOne.setEnabled(false);
                cardTwo.setEnabled(false);
                cardThree.setEnabled(false);
                cardFour.setEnabled(false);
                cardFive.setEnabled(false);
                botPlayButton.setEnabled(true);
                if (trick.getTrickCards().size() == 4) {
                    for (Card card : trick.getTrickCards()) {
                        System.out.println(card.toString());
                    }
                    Card winningCard = trick.getHighestCardPlayed(trump);
                    Player winningPlayer = winningCard.getPlayer();
                    String winningTeam = winningPlayer.getTeam();
                    JOptionPane.showMessageDialog(null, "The winner is " + winningTeam + " with "
                            + winningCard.toString() + " played by Player" + winningPlayer.getOrder());
                    if (winningTeam.equals("A")) {
                        teamAScore++;
                        teamAScoreLabel = new JLabel("Team A Score: " + teamAScore);
                        teamAScoreLabel.revalidate();
                        teamAScoreLabel.repaint();
                    } else {
                        teamBScore++;
                        teamBScoreLabel = new JLabel("Team B Score: " + teamBScore);
                        teamBScoreLabel.revalidate();
                        teamBScoreLabel.repaint();
                    }

                    if (cardsPlayed == 5) {
                        if (teamBScore > teamAScore) {
                            JOptionPane.showMessageDialog(null, "The winner is Team B. Thank you for playing!");
                        } else {
                            JOptionPane.showMessageDialog(null, "The winner is Team A. Thank you for playing!");
                        }
                    }

                    trick.reorderPlayers(winningPlayer.getOrder(), players);
                    for (Player player : players) {
                        System.out.println(player.getOrder());
                    }
                    trick.setTrickCards(new ArrayList<Card>());
                    trickPanel.removeAll();
                    trickPanel.revalidate();
                    trickPanel.repaint();

                    if (players[0].getOrder() == 0) {
                        cardOne.setEnabled(true);
                        cardTwo.setEnabled(true);
                        cardThree.setEnabled(true);
                        cardFour.setEnabled(true);
                        cardFive.setEnabled(true);
                        botPlayButton.setEnabled(false);
                    } else {
                        cardOne.setEnabled(false);
                        cardTwo.setEnabled(false);
                        cardThree.setEnabled(false);
                        cardFour.setEnabled(false);
                        cardFive.setEnabled(false);
                        botPlayButton.setEnabled(true);
                    }
                }
            }
        });

        cardFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardFour.setVisible(false);
                trickPanel.add(cardFour);
                trickPanel.repaint();
                cardFour.setVisible(true);
                trick.addTrickCard(card4);
                card4.setPlayed(true);
                cardsPlayed++;
                if (playerIndex < 3) {
                    playerIndex++;
                } else {
                    playerIndex = 0;
                }
                cardOne.setEnabled(false);
                cardTwo.setEnabled(false);
                cardThree.setEnabled(false);
                cardFour.setEnabled(false);
                cardFive.setEnabled(false);
                botPlayButton.setEnabled(true);
                if (trick.getTrickCards().size() == 4) {
                    for (Card card : trick.getTrickCards()) {
                        System.out.println(card.toString());
                    }
                    Card winningCard = trick.getHighestCardPlayed(trump);
                    Player winningPlayer = winningCard.getPlayer();
                    String winningTeam = winningPlayer.getTeam();
                    JOptionPane.showMessageDialog(null, "The winner is " + winningTeam + " with "
                            + winningCard.toString() + " played by Player" + winningPlayer.getOrder());
                    if (winningTeam.equals("A")) {
                        teamAScore++;
                        teamAScoreLabel = new JLabel("Team A Score: " + teamAScore);
                        teamAScoreLabel.revalidate();
                        teamAScoreLabel.repaint();
                    } else {
                        teamBScore++;
                        teamBScoreLabel = new JLabel("Team B Score: " + teamBScore);
                        teamBScoreLabel.revalidate();
                        teamBScoreLabel.repaint();
                    }

                    if (cardsPlayed == 5) {
                        if (teamBScore > teamAScore) {
                            JOptionPane.showMessageDialog(null, "The winner is Team B. Thank you for playing!");
                        } else {
                            JOptionPane.showMessageDialog(null, "The winner is Team A. Thank you for playing!");
                        }
                    }

                    trick.reorderPlayers(winningPlayer.getOrder(), players);
                    for (Player player : players) {
                        System.out.println(player.getOrder());
                    }
                    trick.setTrickCards(new ArrayList<Card>());
                    trickPanel.removeAll();
                    trickPanel.revalidate();
                    trickPanel.repaint();

                    if (players[0].getOrder() == 0) {
                        cardOne.setEnabled(true);
                        cardTwo.setEnabled(true);
                        cardThree.setEnabled(true);
                        cardFour.setEnabled(true);
                        cardFive.setEnabled(true);
                        botPlayButton.setEnabled(false);
                    } else {
                        cardOne.setEnabled(false);
                        cardTwo.setEnabled(false);
                        cardThree.setEnabled(false);
                        cardFour.setEnabled(false);
                        cardFive.setEnabled(false);
                        botPlayButton.setEnabled(true);
                    }
                }

            }
        });

        cardFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardFive.setVisible(false);
                trickPanel.add(cardFive);
                trickPanel.repaint();
                cardFive.setVisible(true);
                trick.addTrickCard(card5);
                card5.setPlayed(true);
                cardsPlayed++;
                if (playerIndex < 3) {
                    playerIndex++;
                } else {
                    playerIndex = 0;
                }
                cardOne.setEnabled(false);
                cardTwo.setEnabled(false);
                cardThree.setEnabled(false);
                cardFour.setEnabled(false);
                cardFive.setEnabled(false);
                botPlayButton.setEnabled(true);
                if (trick.getTrickCards().size() == 4) {
                    for (Card card : trick.getTrickCards()) {
                        System.out.println(card.toString());
                    }
                    Card winningCard = trick.getHighestCardPlayed(trump);
                    Player winningPlayer = winningCard.getPlayer();
                    String winningTeam = winningPlayer.getTeam();
                    JOptionPane.showMessageDialog(null, "The winner is " + winningTeam + " with "
                            + winningCard.toString() + " played by Player" + winningPlayer.getOrder());
                    if (winningTeam.equals("A")) {
                        teamAScore++;
                        teamAScoreLabel = new JLabel("Team A Score: " + teamAScore);
                        teamAScoreLabel.revalidate();
                        teamAScoreLabel.repaint();
                    } else {
                        teamBScore++;
                        teamBScoreLabel = new JLabel("Team B Score: " + teamBScore);
                        teamBScoreLabel.revalidate();
                        teamBScoreLabel.repaint();
                    }
                    if (cardsPlayed == 5) {
                        if (teamBScore > teamAScore) {
                            JOptionPane.showMessageDialog(null, "The winner is Team B. Thank you for playing!");
                        } else {
                            JOptionPane.showMessageDialog(null, "The winner is Team A. Thank you for playing!");
                        }
                    }
                    trick.reorderPlayers(winningPlayer.getOrder(), players);
                    for (Player player : players) {
                        System.out.println(player.getOrder());
                    }
                    trick.setTrickCards(new ArrayList<Card>());
                    trickPanel.removeAll();
                    trickPanel.revalidate();
                    trickPanel.repaint();

                    if (players[0].getOrder() == 0) {
                        cardOne.setEnabled(true);
                        cardTwo.setEnabled(true);
                        cardThree.setEnabled(true);
                        cardFour.setEnabled(true);
                        cardFive.setEnabled(true);
                        botPlayButton.setEnabled(false);
                    } else {
                        cardOne.setEnabled(false);
                        cardTwo.setEnabled(false);
                        cardThree.setEnabled(false);
                        cardFour.setEnabled(false);
                        cardFive.setEnabled(false);
                        botPlayButton.setEnabled(true);
                    }
                }

            }
        });

        botPlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Card> playableCards = new ArrayList<>();
                for (Card card : players[playerIndex].getHand()) {
                    if (!card.isPlayed()) {
                        playableCards.add(card);
                    }
                }
                Card play;
                Random rand = new Random();
                if (playableCards.isEmpty()) {
                    play = players[playerIndex].getHand()[0];
                } else {
                    int r = rand.nextInt(playableCards.size());
                    play = playableCards.get(r);
                }
                play.setPlayed(true);
                JButton playedCard = null;
                try {
                    playedCard = new JButton(new ImageIcon(ImageIO.read(new File(play.getImgTag()))));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                trickPanel.add(playedCard);
                trick.addTrickCard(play);
                trickPanel.revalidate();
                trickPanel.repaint();
                content.repaint();
                playedCard.setVisible(true);
                if (playerIndex < 3) {
                    playerIndex++;
                } else {
                    playerIndex = 0;
                }
                if (players[playerIndex].getOrder() == 0) {
                    cardOne.setEnabled(true);
                    cardTwo.setEnabled(true);
                    cardThree.setEnabled(true);
                    cardFour.setEnabled(true);
                    cardFive.setEnabled(true);
                    botPlayButton.setEnabled(true);
                    playerIndex = 0;
                }
                content.repaint();
                if (trick.getTrickCards().size() == 4) {
                    for (Card card : trick.getTrickCards()) {
                        System.out.println(card.toString());
                    }
                    Card winningCard = trick.getHighestCardPlayed(trump);
                    Player winningPlayer = winningCard.getPlayer();
                    String winningTeam = winningPlayer.getTeam();
                    JOptionPane.showMessageDialog(null, "The winner is " + winningTeam + " with "
                            + winningCard.toString() + " played by Player" + winningPlayer.getOrder());
                    if (winningTeam.equals("A")) {
                        teamAScore++;
                        teamAScoreLabel = new JLabel("Team A Score: " + teamAScore);
                        teamAScoreLabel.revalidate();
                        teamAScoreLabel.repaint();
                    } else {
                        teamBScore++;
                        teamBScoreLabel = new JLabel("Team B Score: " + teamBScore);
                        teamBScoreLabel.revalidate();
                        teamBScoreLabel.repaint();
                    }

                    trick.reorderPlayers(winningPlayer.getOrder(), players);
                    for (Player player : players) {
                        System.out.println(player.getOrder());
                    }
                    trick.setTrickCards(new ArrayList<Card>());
                    trickPanel.removeAll();
                    trickPanel.revalidate();
                    trickPanel.repaint();

                    if (players[0].getOrder() == 0) {
                        cardOne.setEnabled(true);
                        cardTwo.setEnabled(true);
                        cardThree.setEnabled(true);
                        cardFour.setEnabled(true);
                        cardFive.setEnabled(true);
                        botPlayButton.setEnabled(false);
                    } else {
                        cardOne.setEnabled(false);
                        cardTwo.setEnabled(false);
                        cardThree.setEnabled(false);
                        cardFour.setEnabled(false);
                        cardFive.setEnabled(false);
                        botPlayButton.setEnabled(true);
                    }
                }
            }
        });


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Gamer());
    }

    public void actionPerformed(ActionEvent e) {

    }



//    public static void main(String[] args) {
//        Gamer gamer = new Gamer();
//        Card card = new Card();
//        card.shuffle(cards, 24);
//        card.deal(players, cards);
//        Card[] cards = { new Card("spade", "ace", 1, "ace_of_spades.jpeg", false),
//                new Card("heart", "ace", 3, "ace_of_hearts.jpeg", false),
//                new Card("heart", "king", 7, "king_of_hearts.jpeg", false),
//                new Card("spade", "queen", 9, "queen_of_spades.jpeg", false) };
//        Card cardPlayed = gamer.botPlay(cards, new Card("spade", "10", 17, "ten_of_spades.jpeg", false), "spades");
//        System.out.println(card.toString(new Card[]{cardPlayed}));
//    }
    public Card botPlay(Card[] cards, Card highestCard, String trump) {
        boolean hasThatSuit;
        trumpCards = players[playerIndex].getTrump(trump);
        for (Card card : cards) {
            if (card.getSuit().equals(highestCard.getSuit()) && card.getNumber() > highestCard.getNumber()) {
                trick.addTrickCard(card);
                trick.setHighestCardPlayed(card);
                return card;
            }
            if (card.getSuit().equals(highestCard.getSuit())) {
                hasThatSuit = true;
            }
        }
        if (!highestCard.getSuit().equals(trump)) {
            Card lowestTrump = null;
            boolean first = true;
            for (Card card : trumpCards) {
                if (first) {
                    lowestTrump = card;
                }
                if (!first && card.getNumber() < lowestTrump.getNumber()) {
                    lowestTrump = card;
                }
                first = false;
            }
            trick.addTrickCard(lowestTrump);
            trick.setHighestCardPlayed(lowestTrump);
            return lowestTrump;
        }
        boolean first = true;
        Card lowestCard = null;
        for (Card card : trumpCards) {
            if (first) {
                lowestCard = card;
            }
            if (!first && card.getNumber() < lowestCard.getNumber()) {
                lowestCard = card;
            }
            first = false;
        }
        trick.addTrickCard(lowestCard);
        return lowestCard;
    }

    public void increment() {
        if (playerIndex < 4) {
            playerIndex++;
        } else {
            playerIndex = 0;
        }
    }

    public String getTeam(int playerNumber) {
        switch (playerNumber) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "A";
            case 3:
                return "B";
        }
        return null;
    }



}
