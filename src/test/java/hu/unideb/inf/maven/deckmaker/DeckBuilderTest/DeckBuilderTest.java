/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeckBuilderTest;

import hu.unideb.inf.maven.deckbuilder.DeckBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import hu.unideb.inf.maven.*;
import hu.unideb.inf.maven.deckbuilder.DeckBuilderImpl;
import hu.unideb.inf.maven.deckmaker.Card;
import hu.unideb.inf.maven.deckmaker.CardList;
import hu.unideb.inf.maven.deckmaker.Deck;
import hu.unideb.inf.maven.deckmaker.ValidityRules;
/**
 *
 * @author mucsi
 */
public class DeckBuilderTest {
    
    public DeckBuilderTest() {
    }

    /**
     * Test of addNewCardValidate method, of class DeckBuilder.
     */
    @Test
    public void testAddNewCardValidate() {
        Deck testDeck = new Deck(0);
         Card testCard = new Card("Testcard", "10", "virtual", "original", "its a test card", 10, 10);
        ValidityRules testRules = new ValidityRules();
        testRules.setBasic_quantity_restriction(3);
        testRules.setMaxdecksize(30);
        testRules.setMindecksize(40);
        DeckBuilder builder = new DeckBuilderImpl();
        builder.addCardToDeck(testDeck, testCard, testRules);
        assertEquals(builder.addNewCardValidate(testDeck, testCard, testRules), true);
    }

    /**
     * Test of minDeckQuantityValidate method, of class DeckBuilder.
     */
    @Test
    public void testMinDeckQuantityValidate() {
        Deck testDeck = new Deck(29);
        ValidityRules testRules = new ValidityRules();
        testRules.setBasic_quantity_restriction(3);
        testRules.setMaxdecksize(30);
        testRules.setMindecksize(40);
        DeckBuilder builder = new DeckBuilderImpl();
        assertEquals(builder.minDeckQuantityValidate(testDeck, testRules), false);
    }

    /**
     * Test of maxDeckQuantityValidate method, of class DeckBuilder.
     */
    @Test
    public void testMaxDeckQuantityValidate() {
        Deck testDeck = new Deck(30);
        ValidityRules testRules = new ValidityRules();
        testRules.setBasic_quantity_restriction(3);
        testRules.setMaxdecksize(30);
        testRules.setMindecksize(40);
        DeckBuilder builder = new DeckBuilderImpl();
        assertEquals(builder.maxDeckQuantityValidate(testDeck, testRules, 1), true);
    }

    /**
     * Test of addCardToDeck method, of class DeckBuilder.
     */
    @Test
    public void testAddCardToDeck() {
        Deck testDeck = new Deck(0);
        Card testCard = new Card("Testcard", "10", "virtual", "original", "its a test card", 10, 10);
        ValidityRules testRules = new ValidityRules();
        testRules.setBasic_quantity_restriction(3);
        testRules.setMaxdecksize(30);
        testRules.setMindecksize(40);
        DeckBuilder builder = new DeckBuilderImpl();
        assertEquals(builder.addCardToDeck(testDeck, testCard, testRules).getDeckquantity()==1,true );
    }

    /**
     * Test of deleteCardFromDeck method, of class DeckBuilder.
     */
    @Test
    public void testDeleteCardFromDeck() {
        Deck testDeck = new Deck(2);
        Card testCard = new Card("Testcard", "10", "virtual", "original", "its a test card", 10, 10);
        ValidityRules testRules = new ValidityRules();
        testRules.setBasic_quantity_restriction(3);
        testRules.setMaxdecksize(30);
        testRules.setMindecksize(40);
        DeckBuilder builder = new DeckBuilderImpl();
        builder.addCardToDeck(testDeck, testCard, testRules);
        assertEquals(builder.deleteCardFromDeck(testDeck, testCard).getDeckquantity()==2,true );
    }

    
    
}
