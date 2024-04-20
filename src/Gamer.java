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


public class Gamer implements Runnable {
//    Gamer gamer;
    private int teamAScore;
    private int teamBScore;
    private String trump;
    private Card right;
    private Card left;
    private Card[] trick;
    private Player[] players = { new Player("A", 1, null), new Player("B", 2, null),
            new Player("A", 3, null), new Player("B", 4, null) };
    private Card card1, card2, card3, card4, card5;
//    private Card[] hand = { new Card("spade", "ace", 1, "ace_of_spades.jpeg"), new Card("club", "ace", 2, "ace_of_clubs.jpeg"),
//            new Card("heart", "ace", 3, "ace_of_hearts.jpeg"), new Card("diamond", "ace", 4, "ace_of_diamonds.jpeg"),
//            new Card("spade", "king", 5, "king_of_spades.jpeg") };
    private Card[] cards = { new Card("spade", "ace", 1, "ace_of_spades.jpeg"), new Card("club", "ace", 2, "ace_of_clubs.jpeg"),
            new Card("heart", "ace", 3, "ace_of_hearts.jpeg"), new Card("diamond", "ace", 4, "ace_of_diamonds.jpeg"),
            new Card("spade", "king", 5, "king_of_spades.jpeg"), new Card("club", "king", 6, "king_of_clubs.jpeg"),
            new Card("heart", "king", 7, "king_of_hearts.jpeg"), new Card("diamond", "king", 8, "king_of_diamonds.jpeg"),
            new Card("spade", "queen", 9, "queen_of_spades.jpeg"), new Card("club", "queen", 10, "queen_of_clubs.jpeg"),
            new Card("heart", "queen", 11, "queen_of_hearts.jpeg"), new Card("diamond", "queen", 12, "queen_of_diamonds.jpeg"),
            new Card("spade", "jack", 13, "jack_of_spades.jpeg"), new Card("club", "jack", 14, "jack_of_clubs.jpeg"),
            new Card("heart", "jack", 15, "jack_of_hearts.jpeg"), new Card("diamond", "jack", 16, "jack_of_diamonds.jpeg"),
            new Card("spade", "10", 17, "ten_of_spades.jpeg"), new Card("club", "10", 18, "ten_of_clubs.jpeg"),
            new Card("heart", "10", 19, "ten_of_hearts.jpeg"), new Card("diamond", "10", 20, "ten_of_diamonds.jpeg"),
            new Card("spade", "9", 21, "nine_of_spades.jpeg"), new Card("club", "9", 22, "nine_of_clubs.jpeg"),
            new Card("heart", "9", 23, "nine_of_hearts.jpeg"), new Card("diamond", "9", 24, "nine_of_diamonds.jpeg")};

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

        startGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                content.remove(panelWelcome);
//                content.add(panel);
                panelWelcome.setVisible(false);
                panel.setVisible(true);
            }
        });

        JPanel informationBar = new JPanel();
        JLabel trumpLabel;
        content.add(informationBar, BorderLayout.NORTH);


//        do {
            Card card = new Card();
            card.shuffle(cards, 24);
            card.deal(players, cards);
            trump = card.getKitty()[0].getSuit();
            trumpLabel = new JLabel(trump);
            informationBar.add(trumpLabel);
            content.update()


            card1 = players[0].getHand()[0];
            card2 = players[0].getHand()[1];
            card3 = players[0].getHand()[2];
            card4 = players[0].getHand()[3];
            card5 = players[0].getHand()[4];


            try {
                cardOne = new JButton(new ImageIcon(ImageIO.read(new File(card1.getImgTag()))));
                cardTwo = new JButton(new ImageIcon(ImageIO.read(new File(card2.getImgTag()))));
                cardThree = new JButton(new ImageIcon(ImageIO.read(new File(card3.getImgTag()))));
                cardFour = new JButton(new ImageIcon(ImageIO.read(new File(card4.getImgTag()))));
                cardFive = new JButton(new ImageIcon(ImageIO.read(new File(card5.getImgTag()))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


//        panel.add(myPicture);
            panel.add(cardOne);
            panel.add(cardTwo);
            panel.add(cardThree);
            panel.add(cardFour);
            panel.add(cardFive);
            content.add(panel, BorderLayout.PAGE_END);
            if (first) {
                panel.setVisible(false);
            }
//        } while (teamAScore < 10 || teamBScore < 10);



//        cardOne.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                if ()
//            }
//        });




    }
//    public void newGame() {
//        if ()
//    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Gamer());

    }

    public void actionPerformed(ActionEvent e) {

    }
}
