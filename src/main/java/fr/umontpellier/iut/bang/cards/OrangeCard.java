package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

public abstract class OrangeCard extends Card {
    public OrangeCard(String name, int value, CardSuit suit) {
        super(name, value, suit);
    }

    @Override
    public boolean canPlayFromHand(Player player) {
        return true;
    }

    @Override
    public void playedBy(Player player) {
        player.discard(this);
    }
}
