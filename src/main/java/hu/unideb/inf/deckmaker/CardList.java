package hu.unideb.inf.deckmaker;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for represent a {@code Card} list whit the card object.
 *
 * @param <T> the type of the data stored in the Card.
 */
public class CardList<T extends Card> {

    /**
     * An array list with the card object.
     */
    private List<T> cards = new ArrayList<T>();

    /**
     * Constructs a default {@code CardList} object.
     */
    public CardList() {
    }

    ;
    /**
     * Returns a list of cards of this object.
     * 
     * @return a list of cards of this object
     */
    public List<T> getCards() {
        return cards;
    }

    /**
     * Sets the list of the cards of this object.
     *
     * @param Cards the list of the cards of this object
     */
    public void setCards(List<T> Cards) {
        this.cards = Cards;
    }

}
