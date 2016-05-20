/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.maven.deckbuilder;

import hu.unideb.inf.maven.deckmaker.Card;
import hu.unideb.inf.maven.deckmaker.Deck;
import hu.unideb.inf.maven.deckmaker.Restriction;
import hu.unideb.inf.maven.deckmaker.ValidityRules;

/**
 *
 * @author mucsi
 */
public interface DeckBuilder {
    
    public boolean addNewCardValidate( Deck<Card> deck, Card newcard,ValidityRules<Restriction> validity);
    
    public boolean minDeckQuantityValidate(Deck<Card> deck, ValidityRules<Restriction> minquantity);
    
    public boolean maxDeckQuantityValidate(Deck<Card> deck, ValidityRules<Restriction> maxquantity,int i);
    
    public Deck addCardToDeck(Deck<Card> deck, Card newcard,ValidityRules<Restriction> maxquantity);
    
    public Deck deleteCardFromDeck(Deck<Card> deck, Card newcard);
    
    
}
