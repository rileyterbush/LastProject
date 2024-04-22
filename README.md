Simplified Euchre

This simplified euchre game includes four classes: Card, Trick, Player, and Gamer.

The Card class initializes the 24 cards needed to play Euchre with their face,
their suit, their number associated with the card's score in comparison to other
cards, a boolean to see if they have been played, a team assignment to determine
the winning team from the winning card, and an image tag that allows the Gamer class
to put the image file into the GUI. The Card method has a shuffle method which reorders
the 24 cards in the deck. It also has a deal method that deals 5 cards to each of four
players in the Player array and deals the remaining four cards into the "kitty," which
is used to determine the trump suit. 

The Player class initializes the four players in the euchre game with their team (A or B),
their "order" or number assignment (for the purposes of this game, the 0 assignment indicates
the human player), and their hand which starts as null and is filled by
the deal method at the start of the game. There is a method to determine whether the player
has to follow suit, which iterates through the player's hand and returns true if any of the 
cards match the first suit played. There is also a method that returns an ArrayList filled
with the player's trump cards, which can also function to get an array of the suit needed
to follow suit for the player if the followSuit method returned true. There is a method
to see if the player holds the right card, or the most powerful card, which would allow
the player to automatically take the trick. 

The Trick class initializes a trick, or the first "round" of cards played. The Trick
constructor takes five parameters: the first card played, whose suit is important for 
scoring the trick, the highest card played which will initially be null, the current winner,
the player array, and the array list of trick cards which will start as empty. The Trick
class has a method that finds the left suit, which returns the suit that is the same color
as the trump suit, which is necessary for scoring. There is also a method to get the 
highest card from the cards played which uses an algorithm based on euchre rules to determine 
the winning card: the jack of the trump suit is highest and the left jack (same-color suit
as trump suit) is second highest. If neither of those cards were played/could be played,
a card that matches the first suit played but is higher than any card before with that
suit becomes the winning card. If a trump card is played, it becomes the winning card
if it is the highest trump played. There is also a method to reorder the players in the
player array which moves the winner of the last trick to the top of the array and re-
arranges the other players to maintain the same order.

The Gamer class is a framework for the game's GUI. It creates a frame for the game that takes
the cards dealt by the Card class into the Players' hands and displays the cards dealt to the
user at the bottom of the screen. The user starts the trick by selecting a card to play. The
trump suite is listed at the top of the screen: this was taken from the first card in the
leftover cards or "kitty" after dealing. The user can use this to make a strategic play: if
they have a high trump card and play it, they may have a high likelihood of winning. After
playing a card, it is no longer the player's turn and they must press the button at the top
of the screen, which completes the bot's plays, until the winner window comes up. This
utilizes the getHighestCard method to return the winning card, which provides the winning team
that played the card. That team wins that trick.
