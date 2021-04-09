package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

import java.util.ArrayList;
import java.util.List;

// cette classe est déjà implémentée et vous est donnée en guise d'exemple
public class GeneralStore extends OrangeCard {

    public GeneralStore(int value, CardSuit suit) {
        super("General Store", value, suit);
    }

    @Override
    public void playedBy(Player player) {
        super.playedBy(player);
        List<Player> allPlayers = player.getOtherPlayers();
        allPlayers.add(0, player);
        List<Card> drawnCards = new ArrayList<>();
        for (int i = 0; i < allPlayers.size(); i++) {
            drawnCards.add(player.getGame().drawCard());
        }

        for (Player choosingPlayer : allPlayers) {
            Card card = choosingPlayer.chooseCard(
                    "Prenez une carte",
                    drawnCards,
                    true,
                    false
            );
            drawnCards.remove(card);
            choosingPlayer.addToHand(card);
        }
    }
}
