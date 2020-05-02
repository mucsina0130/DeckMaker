/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.deckmaker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author mucsi
 */
public class CardDAOImpl implements CardDAO{
    
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CardDAOImpl.class);

    @Override
    public void CardListLoader(CardList cardlist) {
        try {
            logger.warn("ValidityRules.xml must not be null!");
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("database/CardList.xml");
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document doc = builder.parse(is);
            doc.getDocumentElement().normalize();
            //System.out.println("Gyökér: "+doc.getDocumentElement().getNodeName());
            NodeList nodeLista= doc.getElementsByTagName("card");
            
            int i;
            for(i=0;i<nodeLista.getLength();i++){
                Node node =nodeLista.item(i);
                if (node.getNodeType()==Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    Card card =new Card();
                    card.setName(elem.getElementsByTagName("name").item(0).getTextContent());
                    card.setCost(elem.getElementsByTagName("cost").item(0).getTextContent());
                    card.setAttribute(elem.getElementsByTagName("attribute").item(0).getTextContent());
                    card.setType(elem.getElementsByTagName("type").item(0).getTextContent());
                    card.setCardtype(elem.getElementsByTagName("cardtype").item(0).getTextContent());
                    card.setDescription(elem.getElementsByTagName("description").item(0).getTextContent());
                    card.setAttpower(Integer.parseInt(elem.getElementsByTagName("attpower").item(0).getTextContent()));
                    card.setDeffpower(Integer.parseInt(elem.getElementsByTagName("deffpower").item(0).getTextContent()));
                    cardlist.getCards().add(card);
                    logger.info("Card loaded:",card.getName());
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            logger.error("Exception caught", ex);
        } 
    }

    
    
}
