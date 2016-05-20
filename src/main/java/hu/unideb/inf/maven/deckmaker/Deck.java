/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.maven.deckmaker;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mucsi
 * @param <T> the type of the data stored in the Card.
 */
public class Deck <T extends Card>{
    private List<T> deck = new ArrayList<T>();
    private int deckquantity;
    
    public Deck(int deckquantity){
        setDeckquantity(deckquantity);
    };

    public List<T> getDeck() {
        return deck;
    }

    public int getDeckquantity() {
        return deckquantity;
    }

    public void setDeck(List<T> deck) {
        this.deck = deck;
    }

    public void setDeckquantity(int deckquantity) {
        this.deckquantity = deckquantity;
    }

    @Override
    public String toString() {
        return "Deck{" + "deck=" + deck + ", deckquantity=" + deckquantity + '}';
    }

    
    
    
}
