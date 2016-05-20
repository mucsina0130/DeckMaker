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
public class CardList <T extends Card>{
    private List<T> cards = new ArrayList<T>();
    
    public CardList(){};

    public List<T> getCards() {
        return cards;
    }

    public void setCards(List<T> Cards) {
        this.cards = Cards;
    }
    
}
