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
import java.util.ArrayList;


public class Gamer implements Runnable {
//    Gamer gamer;
    private int teamAScore;
    private int teamBScore;
    private String trump;
    private ArrayList<Card> trumpCards;
    private Card right;
    private Card left;
//    private Card[] trick;

    private Trick trick;
    private static Player[] players = { new Player("A", 0, null), new Player("B", 1, null),
            new Player("A", 2, null), new Player("B", 3, null) };
    private Card card1, card2, card3, card4, card5;
//    private Card[] hand = { new Card("spade", "ace", 1, "ace_of_spades.jpeg"), new Card("club", "ace", 2, "ace_of_clubs.jpeg"),
//            new Card("heart", "ace", 3, "ace_of_hearts.jpeg"), new Card("diamond", "ace", 4, "ace_of_diamonds.jpeg"),
//            new Card("spade", "king", 5, "king_of_spades.jpeg") };
    private Card[] cards = { new Card("spade", "ace", 1, "ace_of_spades.jpeg", false), new Card("club", "ace", 2, "ace_of_clubs.jpeg", false),
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

    JButton startGameButton;
//    Container content;
//    JPanel panelWelcome;
//    JPanel panel;


    public Gamer() {
    }


    public void run() {

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

//        frame.addMouseListener(game);

//        new Timer(1000, game).start();

        JPanel panelWelcome = new JPanel();
        startGameButton = new JButton("Start the euchre game!");
        panelWelcome.add(startGameButton);
        content.add(panelWelcome);



        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
//        BufferedImage myPicture = null;
//        BufferedImage myPicture2 = null;
//        BufferedImage myPicture3 = null;
//        BufferedImage myPicture4 = null;
//        BufferedImage myPicture5 = null;
//        try {
//            myPicture = ImageIO.read(new File("ace_of_spades.jpeg"));
//            myPicture2 = ImageIO.read(new File("ace_of_hearts.jpeg"));
//            myPicture3 = ImageIO.read(new File("ace_of_clubs.jpeg"));
//            myPicture4 = ImageIO.read(new File("ace_of_diamonds.jpeg"));
//            myPicture5 = ImageIO.read(new File("jack_of_spades.jpeg"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        JButton cardOne;
        JButton cardTwo;
        JButton cardThree;
        JButton cardFour;
        JButton cardFive;

        boolean first = true;

        JPanel informationBar = new JPanel();
        JLabel trumpLabel;
        informationBar.setVisible(false);

        startGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                content.remove(panelWelcome);
//                content.add(panel);
                panelWelcome.setVisible(false);
                panel.setVisible(true);
                informationBar.setVisible(true);
            }
        });


//        content.add(informationBar, BorderLayout.NORTH);


//        do {
            Card card = new Card();
//            card.shuffle(cards, 24);
//            card.deal(players, cards);
//            trump = card.getKitty()[0].getSuit();
//            trumpLabel = new JLabel(trump + "s is trump");
//            informationBar.add(trumpLabel);
//            content.add(informationBar, BorderLayout.NORTH);
//
//
//            card1 = players[0].getHand()[0];
//            card2 = players[0].getHand()[1];
//            card3 = players[0].getHand()[2];
//            card4 = players[0].getHand()[3];
//            card5 = players[0].getHand()[4];
//
//
//            try {
//                cardOne = new JButton(new ImageIcon(ImageIO.read(new File(card1.getImgTag()))));
//                cardTwo = new JButton(new ImageIcon(ImageIO.read(new File(card2.getImgTag()))));
//                cardThree = new JButton(new ImageIcon(ImageIO.read(new File(card3.getImgTag()))));
//                cardFour = new JButton(new ImageIcon(ImageIO.read(new File(card4.getImgTag()))));
//                cardFive = new JButton(new ImageIcon(ImageIO.read(new File(card5.getImgTag()))));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//
////        panel.add(myPicture);
//            panel.add(cardOne);
//            panel.add(cardTwo);
//            panel.add(cardThree);
//            panel.add(cardFour);
//            panel.add(cardFive);
//            content.add(panel, BorderLayout.PAGE_END);
//            if (first) {
//                panel.setVisible(false);
//            }
////        } while (teamAScore < 10 || teamBScore < 10);
//
//
//


//        do {
//            Trick trick1 = new Trick(null, 23, null);
//            trick1.reorderPlayers(1);
//        } while ()

        // The game:
//        for (int i = 0; i < 10; i++) {
//        public void deal() {
//
//        }
            Gamer gamer = new Gamer();
            card.shuffle(cards, 24);
            card.deal(players, cards);
            trump = card.getKitty()[0].getSuit();
            trumpLabel = new JLabel(trump + "s is trump");
//            System.out.println(trump);

            card1 = players[0].getHand()[0];
            card2 = players[0].getHand()[1];
            card3 = players[0].getHand()[2];
            card4 = players[0].getHand()[3];
            card5 = players[0].getHand()[4];
            if (first) {
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
//                content.add(panel, BorderLayout.SOUTH);

                informationBar.add(trumpLabel);
                content.add(informationBar, BorderLayout.NORTH);
//                String[] options = {}
//                int cardPlayed = JOptionPane.showInputDialog()
//            }

            if (first) {
                panel.setVisible(true);
            }
            first = false;

            JPanel trickPanel = new JPanel();
            trickPanel.setLayout(new GridLayout());
            trickPanel.setVisible(true);
            content.add(trickPanel, BorderLayout.CENTER);

                cardOne.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
//                        if (card1.)
                        cardOne.setVisible(false);
                        trickPanel.add(cardOne);
                        trickPanel.repaint();
                        cardOne.setVisible(true);
                        trick.addTrickCard(card1);


                    }
                });

                cardTwo.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        cardTwo.setVisible(false);
                        trickPanel.add(cardTwo);
                        trickPanel.repaint();
                        cardTwo.setVisible(true);
                        trick.addTrickCard(card2);

                    }
                });

                cardThree.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        cardThree.setVisible(false);
                        trickPanel.add(cardThree);
                        trickPanel.repaint();
                        cardThree.setVisible(true);
                        trick.addTrickCard(card3);

                    }
                });

                cardFour.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        cardFour.setVisible(false);
                        trickPanel.add(cardFour);
                        trickPanel.repaint();
                        cardFour.setVisible(true);
                        trick.addTrickCard(card4);

                    }
                });

                cardFive.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        cardFive.setVisible(false);
                        trickPanel.add(cardFive);
                        trickPanel.repaint();
                        cardFive.setVisible(true);
                        trick.addTrickCard(card5);

                    }
                });


//            for (int j = 0; j < 5; j++) {
//                Trick trick = new Trick(null, null, null, players, null);
//                trick.reorderPlayers(1);
//
//                for (Player player : players) {
//                    Card play = null;
//                    if (player.getOrder() == 1) {
//
//                    } else {
//                        Card[] cards = player.getHand();
//                        card.botPlay(cards, trick.getHighestCardPlayed());
//                        if (trick.getFirstCardPlayed() == null) {
//                            if (player.hasRight()) {
//                                trick.addTrickCard()
//                            }
////                            if (player.followSuit()) {
////
////                            }
//                        } else {
////                            trick.addTrickCard(card.botPlay(cards, trick.getHighestCardPlayed()));
//                            Card cardPlay = gamer.botPlay(cards, trick.getHighestCardPlayed());
//                            try {
//                                trickPanel.add(new JLabel(new ImageIcon(ImageIO.read(new File(card5.getImgTag())))));
//                            } catch (IOException e) {
//                                throw new RuntimeException(e);
//
//                            }
//                        }
//                    }
//                }
//            }


        }

    }
//    public void newGame() {
//        if ()
//    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Gamer());

    }

    public void actionPerformed(ActionEvent e) {

    }

//    public Card botPlay(Card[] cards) {
//        for ()
//    }

    public Card botPlay(Card[] cards, Card highestCard) {
        boolean hasThatSuit;
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

}
