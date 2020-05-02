package hu.unideb.inf.fxmlcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import hu.unideb.inf.deckbuilder.DeckBuilder;
import hu.unideb.inf.deckbuilder.DeckBuilderImpl;
import hu.unideb.inf.deckmaker.*;
import java.io.IOException;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mucsi
 */
public class DeckMakerController implements Initializable {

    @FXML
    Label addCardResult;
    @FXML
    Label removeCardResult;
    @FXML
    Label name;
    @FXML
    Label cost;
    @FXML
    Label attribute;
    @FXML
    Label cardType;
    @FXML
    Label type;
    @FXML
    Label description;
    @FXML
    Label attPower;
    @FXML
    Label deffPower;
    @FXML
    Label deckQuantity;
    @FXML
    Label cardInDeck;
    @FXML
    Label validityResult;
   
    @FXML
    private ListView<String> cardListView;
    @FXML
    private ListView<String> deckListView;
    ObservableList<String> deckListData = FXCollections.observableArrayList();
    String cardName;
    public Deck deck = new Deck(0) ;
    public CardList list = new CardList() ;
    public Card newCard = new Card();
    public ValidityRules rules = new ValidityRules();
    public int quantity;
    DeckBuilder builder = new DeckBuilderImpl();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CardDAO cardLoader = new CardDAOImpl();
        ValidityRulesDAO validityLoader = new ValidityRulesImplDAO();
        cardLoader.CardListLoader(list);
        validityLoader.RestrictionsLoader(rules);
        ObservableList<String> cardlistdata = FXCollections.observableArrayList();
        int i;
        name.setText("");
                cost.setText("");
                attribute.setText("");
                cardType.setText("");
                type.setText("");
                description.setText("");
                attPower.setText("");
                deffPower.setText("");
                cardInDeck.setText("");
        for(i=0;i<list.getCards().size();i++)
        {   
            
            Card tempcard = (Card) list.getCards().get(i);
            cardlistdata.addAll(tempcard.getName());
        }
        cardListView.setItems(cardlistdata);
                
    }

    public void handleAddCardAction(ActionEvent event)
    {
         int i=0;
        cardName = cardListView.getSelectionModel().getSelectedItem();
        if (cardName != null)
        {
            for(i=0;i<list.getCards().size();i++)
            {
               newCard=(Card) list.getCards().get(i);
               if(newCard.getName().equals(cardName))
               {
                   break;
               }
            }
            if(builder.maxDeckQuantityValidate(deck, rules, quantity))
            {
                if(builder.addNewCardValidate(deck, newCard, rules))
                {
                    builder.addCardToDeck(deck, newCard, rules);
                    Card tempcard = new Card();
                    for(i=0;i<deck.getDeck().size();i++)
                    {
                        tempcard = (Card) deck.getDeck().get(i);
                        if (tempcard.getName().equals(cardName)) {
                            break;
                        }
                    }
                    if(tempcard.getQuantity()==1)
                    {
                        deckListData.add(cardName);
                    }
                    addCardResult.setText("Card added to deck!");
                    deckQuantity.setText("Deck Quantity: " + deck.getDeckquantity());
                } 
                else
                {
                    addCardResult.setText("You can not add more from this card");
                    //System.out.println("You can not add more from this card");
                }
                    
            }
            else
            {
                addCardResult.setText("You have reached your maximum deck capacity");
                //System.out.println("You have reached your maximum deck capacity");
            }
            
            deckListView.setItems(deckListData);
            cardListView.getSelectionModel().clearSelection();
            name.setText("");
                cost.setText("");
                attribute.setText("");
                cardType.setText("");
                type.setText("");
                description.setText("");
                attPower.setText("");
                deffPower.setText("");
                cardInDeck.setText("");
            
        }
    }
    
    public void handleRemoveCardAction(ActionEvent event)
    {
        int i=0;
        cardName = deckListView.getSelectionModel().getSelectedItem();
        if (cardName != null)
        {
            for(i=0;i<deck.getDeck().size();i++)
            {
               newCard=(Card) deck.getDeck().get(i);
               if(newCard.getName().equals(cardName))
               {
                   if(newCard.getQuantity()==1)
                       deckListData.remove(cardName);
                   break;
               } 
            }
            builder.deleteCardFromDeck(deck, newCard);
            removeCardResult.setText("Card removed from deck!");
            deckQuantity.setText("Deck Quantity: " + deck.getDeckquantity());
            deckListView.getSelectionModel().clearSelection();
                name.setText("");
                cost.setText("");
                attribute.setText("");
                cardType.setText("");
                type.setText("");
                description.setText("");
                attPower.setText("");
                deffPower.setText("");
                cardInDeck.setText("");
                
            
        }
    }
    public void handleShowCard(ActionEvent event){
        cardName = deckListView.getSelectionModel().getSelectedItem();
        if (cardName != null)
        {   
            Card tempcard=new Card();
            for(int j=0;j<deck.getDeck().size();j++)
                    {
                        tempcard = (Card) deck.getDeck().get(j);
                        if (tempcard.getName().equals(cardName)) {
                            break;
                        }
                    }
                name.setText(tempcard.getName());
                cost.setText(tempcard.getCost());
                attribute.setText(tempcard.getAttribute());
                cardType.setText(tempcard.getCardtype());
                type.setText(tempcard.getType());
                description.setText(tempcard.getDescription());
                attPower.setText(String.valueOf(tempcard.getAttpower()));
                deffPower.setText(String.valueOf(tempcard.getDeffpower()));
                cardInDeck.setText(String.valueOf("Card in deck: " + tempcard.getQuantity()));
                deckListView.getSelectionModel().clearSelection();
        
        }
        else{
            cardName = cardListView.getSelectionModel().getSelectedItem();
            if(cardName!=null)
            {int quantity=0;
            Card tempcard=new Card();
            for(int j=0;j<deck.getDeck().size();j++)
                    {
                        tempcard = (Card) deck.getDeck().get(j);
                        if (tempcard.getName().equals(cardName)) {
                            quantity=tempcard.getQuantity();
                            break;
                        }
                    }
            for(int j=0;j<list.getCards().size();j++)
                    {
                        tempcard = (Card) list.getCards().get(j);
                        if (tempcard.getName().equals(cardName)) {
                            break;
                        }
                    }
                name.setText(tempcard.getName());
                cost.setText(tempcard.getCost());
                attribute.setText(tempcard.getAttribute());
                cardType.setText(tempcard.getCardtype());
                type.setText(tempcard.getType());
                description.setText(tempcard.getDescription());
                attPower.setText(String.valueOf(tempcard.getAttpower()));
                deffPower.setText(String.valueOf(tempcard.getDeffpower()));
                cardInDeck.setText(String.valueOf("Card in deck: " + quantity));
                cardListView.getSelectionModel().clearSelection();
            }
        } 
    }
    
    public void handleValidateAction(ActionEvent event){
    
        if(builder.minDeckQuantityValidate(deck, rules))
            validityResult.setText("Deck is valid!");
        else validityResult.setText("Not enought card in deck.");
    }
    
}
