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
public class ValidityRulesImplDAO implements ValidityRulesDAO{
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CardDAOImpl.class);
    
    @Override
    public void RestrictionsLoader(ValidityRules rules) {
        try {
            logger.warn("ValidityRules.xml must not be null!");
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("database/ValidityRules.xml");
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document doc = builder.parse(is);
            doc.getDocumentElement().normalize();
            
            
            //System.out.println("Gyökér: "+doc.getDocumentElement().getNodeName());
            NodeList nodeLista = doc.getElementsByTagName("restriction");
            NodeList minsize = doc.getElementsByTagName("mindecksize");
            rules.setMindecksize(Double.parseDouble(minsize.item(0).getTextContent()));
            NodeList maxsize = doc.getElementsByTagName("maxdecksize");
            rules.setMaxdecksize(Double.parseDouble(maxsize.item(0).getTextContent()));
            NodeList basicq = doc.getElementsByTagName("basic_quantity_restriction");
            rules.setBasic_quantity_restriction(Double.parseDouble(basicq.item(0).getTextContent()));
            //System.out.println("Mindeck: "+ n.item(0).getTextContent());
            //System.out.println("Mindeck: "+ rules.getMindecksize()); 
            
            int i;
            for(i=0;i<nodeLista.getLength();i++){
                Node node =nodeLista.item(i);
                if (node.getNodeType()==Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                Restriction restriction = new Restriction(elem.getElementsByTagName("name").item(0).getTextContent(), Double.parseDouble(elem.getElementsByTagName("maxnumber_of_piece").item(0).getTextContent()));
                rules.getRestrictions().add(restriction);
                logger.info("Restriction loaded:",restriction.getName());
                }
            }
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            logger.error("Exception caught", ex);
        }
    }
    
}
