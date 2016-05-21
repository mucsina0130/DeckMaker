/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.maven.deckbuilder;

import hu.unideb.inf.maven.deckbuilder.DeckBuilder;
import hu.unideb.inf.maven.deckmaker.Card;
import hu.unideb.inf.maven.deckmaker.CardDAOImpl;
import hu.unideb.inf.maven.deckmaker.Deck;
import hu.unideb.inf.maven.deckmaker.Restriction;
import hu.unideb.inf.maven.deckmaker.ValidityRules;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mucsi
 */
public class DeckBuilderImpl implements DeckBuilder{
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CardDAOImpl.class);
    @Override
    public boolean addNewCardValidate(Deck<Card> deck, Card newcard, ValidityRules<Restriction> validity) {
       boolean flag=true;
       boolean isrestricted=false;
        Restriction restr = new Restriction();
        for(int j=0;j<validity.getRestrictions().size();j++)
        {
            if(validity.getRestrictions().get(j).getName().equals(newcard.getName()))
            {
                restr=validity.getRestrictions().get(j);
                isrestricted=true;
                logger.info("Card is restricted:",restr.getMaxnumber_of_piece());
            }
        }

        if(isrestricted)
        {
            for(int i=0;i<deck.getDeck().size();i++)
                {   
                    if(deck.getDeck().get(i).getName().equals(restr.getName())&&deck.getDeck().get(i).getQuantity()>=restr.getMaxnumber_of_piece())
                    {
                        return false;

                    }
                    else
                        flag=true;
                }
        }
        else
        {
           for(int i=0;i<deck.getDeck().size();i++)
                {   
                    if(deck.getDeck().get(i).getName().equals(newcard.getName())&&deck.getDeck().get(i).getQuantity()==validity.getBasic_quantity_restriction())
                    {
                        return false;

                    }
                    else
                        flag=true;
                } 
        }
        
        
    return flag;
    }

    @Override
    public boolean minDeckQuantityValidate(Deck<Card> deck, ValidityRules<Restriction> minquantity) {
        int quantity=0;
        for(int i=0;i<deck.getDeck().size();i++)
        {
            quantity+=deck.getDeck().get(i).getQuantity();
        }
        if(quantity<minquantity.getMindecksize())
        {
            logger.info("Too little card in the deck!");
            return false;
        }
        else {
            logger.info("Enought card in the deck!");
            return true;
        }
    }

    @Override
    public boolean maxDeckQuantityValidate(Deck<Card> deck, ValidityRules<Restriction> maxquantity, int i) {
        int quantity=0;
        for(int j=0;j<deck.getDeck().size();j++)
        {
            quantity+=deck.getDeck().get(j).getQuantity();
        }
        if(quantity+i>maxquantity.getMaxdecksize())
        {
            logger.info("Too much card in the deck!");
            return false;
        }
        else {
            logger.info("Still has some space in the deck!");
            return true;
        }
    }

    @Override
    public Deck addCardToDeck(Deck<Card> deck, Card newcard, ValidityRules<Restriction> maxquantity) {
        boolean cardindeck = false;
        int i=0;
               
        for(i=0;i<deck.getDeck().size();i++)
               {
                   if(deck.getDeck().get(i).getName().equals(newcard.getName()))
                   {
                       cardindeck=true;
                       break;
                   }
               }
               if(cardindeck)
               {
                    deck.setDeckquantity((int) (deck.getDeckquantity()+1));
                    //System.out.println("Deck quantity: " + deck.getDeckquantity());
                    deck.getDeck().get(i).setQuantity((int) (deck.getDeck().get(i).getQuantity()+1));
                    logger.info("Card added to deck:",deck.getDeck().get(i).getName());
                    return deck;     
               }
               else
               {
                   deck.getDeck().add(newcard);
                   deck.getDeck().get(deck.getDeck().size()-1).setQuantity(1);
                   deck.setDeckquantity((int) (deck.getDeckquantity()+1));
                   //System.out.println("Deck quantity: " + deck.getDeckquantity());
                   logger.info("Card added to deck:",deck.getDeck().get(i).getName());
                   return deck;
               }

    }

    @Override
    public Deck deleteCardFromDeck(Deck<Card> deck, Card newcard) {
        int i=0;
        String name = newcard.getName();
        boolean cardindeck=false;
        for(i=0;i<deck.getDeck().size();i++)
               {
                   if(deck.getDeck().get(i).getName().equals(newcard.getName()))
                   {
                       cardindeck=true;
                       break;
                   }
               }
               if(cardindeck)
               {
                   if(deck.getDeck().get(i).getQuantity()==1)
                   {
                       deck.getDeck().remove(i);
                       deck.setDeckquantity((int) (deck.getDeckquantity()-1));
                   }
                   else 
                   {
                       deck.getDeck().get(i).setQuantity((int) (deck.getDeck().get(i).getQuantity()-1));
                       deck.setDeckquantity((int) (deck.getDeckquantity()-1));
                   }
                         
               }
        logger.info("Card removed from deck:",name);
               return deck;
    }
    
}
