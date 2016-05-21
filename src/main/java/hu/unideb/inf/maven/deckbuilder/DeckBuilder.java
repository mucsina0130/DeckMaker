package hu.unideb.inf.maven.deckbuilder;

import hu.unideb.inf.maven.deckmaker.Card;
import hu.unideb.inf.maven.deckmaker.Deck;
import hu.unideb.inf.maven.deckmaker.Restriction;
import hu.unideb.inf.maven.deckmaker.ValidityRules;

/**
 *  This interface methods will build the {@code Deck} object from the {@code CardList} object.
 */
public interface DeckBuilder {
    /**
     * This method is for to validate with the {@code ValidityRules} object's data  a new card before it is added to the deck.
     * 
     * @param deck class for represent a deck list whit the {@code Card} object
     * @param newcard class for representing a TCG card
     * @param validity class for representing a list of the rules for building a deck
     * @return true if the card can be added to the deck, false if the card can not be added to the deck
     */
    public boolean addNewCardValidate(Deck<Card> deck, Card newcard, ValidityRules<Restriction> validity);
    /**
     * This method is for to validate the {@code Deck} object with the {@code ValidityRules}.
     * 
     * @param deck class for represent a deck list whit the {@code Card} object
     * @param minquantity class for representing a list of the rules for building a deck
     * @return true if the deck quantity from the {@code Deck} object is equals or greater than the minimum quantity from the {@code ValidityRules} object, false if it is lesser
     */
    public boolean minDeckQuantityValidate(Deck<Card> deck, ValidityRules<Restriction> minquantity);
    /**
     * This method is for to validate the {@code deck} object with the {@code ValidityRules}.
     * 
     * @param deck class for represent a deck list whit the {@code Card} object
     * @param maxquantity class for representing a list of the rules for building a deck
     * @param i is 0 if you do not want to card and just want to decide if the {@code Deck} is valid, or 1 if you want to add a card and decide if the deck is valid
     * @return true if the deck quantity from the {@code Deck} object is equals or lesser than the maximum quantity from the {@code ValidityRules} object, false if it is greater
     */
    public boolean maxDeckQuantityValidate(Deck<Card> deck, ValidityRules<Restriction> maxquantity, int i);
    /**
     * This method will add a {@code Card} object to the {@code Deck} object.
     * 
     * @param deck class for represent a deck list whit the {@code Card} object
     * @param newcard class for representing a TCG card
     * @param maxquantity class for representing a list of the rules for building a deck
     * @return the deck with the {@code Card} object added to the {@code Deck} object
     */
    public Deck addCardToDeck(Deck<Card> deck, Card newcard, ValidityRules<Restriction> maxquantity);
    /**
     * This method will remove a {@code Card} object from the {@code Deck} object.
     * 
     * @param deck class for represent a deck list whit the {@code Card} object
     * @param newcard class for representing a TCG card
     * @return the deck with the {@code Card} object removed from the {@code Deck} object
     */
    public Deck deleteCardFromDeck(Deck<Card> deck, Card newcard);

}
