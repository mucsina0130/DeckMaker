/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeckBuilderTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import hu.unideb.inf.deckbuilder.DeckBuilder;
import hu.unideb.inf.deckbuilder.DeckBuilderImpl;
import hu.unideb.inf.deckmaker.Card;
import hu.unideb.inf.deckmaker.CardList;
import hu.unideb.inf.deckmaker.Deck;
import hu.unideb.inf.deckmaker.Restriction;
import hu.unideb.inf.deckmaker.ValidityRules;
/**
 *
 * @author mucsi
 */
public class DeckBuilderTest {

    /**
     * Test of addNewCardValidate method when the new card is within the limit, of class DeckBuilder.
     */
	@Test
	public void testAddNewCardValidateWithinTheLimit() {
       Deck testDeck = new Deck(0);
       Card testCard = new Card("Testcard", "10", "virtual", "original", "its a test card", 10, 10);
       ValidityRules testRules = new ValidityRules();
       testRules.setBasic_quantity_restriction(3);
       testRules.setMaxdecksize(40);
       testRules.setMindecksize(30);
       DeckBuilder builder = new DeckBuilderImpl();
       builder.addCardToDeck(testDeck, testCard, testRules);
		assertEquals(true,builder.addNewCardValidate(testDeck, testCard, testRules));
	}
    /**
     * Test of addNewCardValidate method when the new card is within of the individual limit, of class DeckBuilder.
     */
	@Test
	public void testAddNewCardValidateWithinTheIndividualRestrictionListLimit() {
       Deck testDeck = new Deck(0);
       Card testCard = new Card("Testcard", "10", "virtual", "original", "its a test card", 10, 10);
       ArrayList<Restriction> restrictionList = new ArrayList<Restriction>();
       restrictionList.add(new Restriction("Testcard", 1));
       ValidityRules testRules = new ValidityRules();
       testRules.setBasic_quantity_restriction(3);
       testRules.setRestrictions(restrictionList);
       testRules.setMaxdecksize(40);
       testRules.setMindecksize(30);
       DeckBuilder builder = new DeckBuilderImpl();
		assertEquals(true,builder.addNewCardValidate(testDeck, testCard, testRules));
	}
    /**
     * Test of addNewCardValidate method when the new card is outside of the individual limit, of class DeckBuilder.
     */
	@Test
	public void testAddNewCardValidateOutsideTheIndividualRestrictionListLimit() {
       Deck testDeck = new Deck(0);
       Card testCard = new Card("Testcard", "10", "virtual", "original", "its a test card", 10, 10);
       ArrayList<Restriction> restrictionList = new ArrayList<Restriction>();
       restrictionList.add(new Restriction("Testcard", 1));
       ValidityRules testRules = new ValidityRules();
       testRules.setBasic_quantity_restriction(3);
       testRules.setRestrictions(restrictionList);
       testRules.setMaxdecksize(40);
       testRules.setMindecksize(30);
       DeckBuilder builder = new DeckBuilderImpl();
       builder.addCardToDeck(testDeck, testCard, testRules);
		assertEquals(false,builder.addNewCardValidate(testDeck, testCard, testRules));
	}
	/**
     * Test of minDeckQuantityValidate method, of class DeckBuilder.
     */
    @Test
    public void testMinDeckQuantityValidate() {
        Deck testDeck = new Deck(29);
        ValidityRules testRules = new ValidityRules();
        testRules.setBasic_quantity_restriction(3);
        testRules.setMaxdecksize(40);
        testRules.setMindecksize(30);
        DeckBuilder builder = new DeckBuilderImpl();
        assertEquals(false,builder.minDeckQuantityValidate(testDeck, testRules));
    }

    /**
     * Test of maxDeckQuantityValidate method when the maximum quantity is not reached, of class DeckBuilder.
     */
    @Test
    public void testAboveDeckQuantityValidate() {
        Deck testDeck = new Deck(39);
        ValidityRules testRules = new ValidityRules();
        testRules.setBasic_quantity_restriction(3);
        testRules.setMaxdecksize(40);
        testRules.setMindecksize(30);
        DeckBuilder builder = new DeckBuilderImpl();
        assertEquals(true,builder.maxDeckQuantityValidate(testDeck, testRules, 1));
    }
    /**
     * Test of maxDeckQuantityValidate method when the deck quantity is above then it should, of class DeckBuilder.
     */
    @Test
    public void testAboveMaxDeckQuantityValidate() {
        Deck testDeck = new Deck(40);
        ValidityRules testRules = new ValidityRules();
        testRules.setBasic_quantity_restriction(3);
        testRules.setMaxdecksize(31);
        testRules.setMindecksize(30);
        DeckBuilder builder = new DeckBuilderImpl();
        assertEquals(false,builder.maxDeckQuantityValidate(testDeck, testRules, 1));
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
        assertEquals(true,builder.addCardToDeck(testDeck, testCard, testRules).getDeckquantity()==1 );
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
        assertEquals(true,builder.deleteCardFromDeck(testDeck, testCard).getDeckquantity()==2 );
    }

}
