
package hu.unideb.inf.maven.deckmaker;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for represent a deck list whit the {@code Card} object.
 *
 * @param <T> the type of the data stored in the Card.
 */
public class Deck<T extends Card> {

    /**
     * An array list with the {@code Card} object.
     */
    private List<T> deck = new ArrayList<T>();
    /**
     * The quantity of the deck.
     */
    private int deckquantity;

    /**
     * Constructs a {@code Deck} object with the specified deck quantity.
     * 
     * @param deckquantity the quantity of the deck
     */
    public Deck(int deckquantity) {
        setDeckquantity(deckquantity);
    }

    ;
    /**
     * Returns a list of this {@code Card} object.
     * 
     * @return a {@code Deck} list of this {@code Card} object
     */
    public List<T> getDeck() {
        return deck;
    }

    /**
     * Returns the quantity of this object.
     *
     * @return the quantity of this object
     */
    public int getDeckquantity() {
        return deckquantity;
    }

    /**
     * Sets the list of the {@code Card} of this object.
     *
     * @param deck  the list of the {@code Card} of this object
     */
    public void setDeck(List<T> deck) {
        this.deck = deck;
    }

    /**
     * Sets the quantity of this object.
     *
     * @param deckquantity the quantity of this object
     */
    public void setDeckquantity(int deckquantity) {
        this.deckquantity = deckquantity;
    }

    @Override
    public String toString() {
        return "Deck{" + "deck=" + deck + ", deckquantity=" + deckquantity + '}';
    }

}
