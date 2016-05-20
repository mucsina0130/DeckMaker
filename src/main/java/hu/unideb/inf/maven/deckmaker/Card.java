/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.maven.deckmaker;

import java.util.Objects;

/**
 *
 * @author mucsi
 */
public class Card {
    
    private String name;
    private String cost;
    private String attribute;
    private String type;
    private String cardtype;       
    private String description;
    private int attpower;
    private int deffpower;
    private int quantity=0;

    public Card(){};
    public Card(String name, String cost, String type, String cardtype, String description, int deffpower,int attpower ) {
        this.name = name;
        this.cost = cost;
        this.type = type;
        this.cardtype = cardtype;
        this.description = description;
        this.deffpower = deffpower;
        this.attpower = attpower;
        this.quantity = 0;
    }

   

    public String getName() {
        return name;
    }

    public String getCost() {
        return cost;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getType() {
        return type;
    }

    public String getCardtype() {
        return cardtype;
    }

    public String getDescription() {
        return description;
    }

    public int getAttpower() {
        return attpower;
    }

    public int getDeffpower() {
        return deffpower;
    }

    public int getQuantity() {
        return quantity;
    }

    

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAttpower(int attpower) {
        this.attpower = attpower;
    }

    public void setDeffpower(int deffpower) {
        this.deffpower = deffpower;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Card{" + ", name=" + name + ", cost=" + cost + ", attribute=" + attribute + ", type=" + type + ", cardtype=" + cardtype + ", description=" + description + ", attpower=" + String.valueOf(attpower) + ", deffpower=" + String.valueOf(deffpower) + ", quantity=" + String.valueOf(quantity) + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.cost);
        hash = 53 * hash + Objects.hashCode(this.attribute);
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + Objects.hashCode(this.cardtype);
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + this.attpower;
        hash = 53 * hash + this.deffpower;
        hash = 53 * hash + this.quantity;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.attpower != other.attpower) {
            return false;
        }
        if (this.deffpower != other.deffpower) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.cost, other.cost)) {
            return false;
        }
        if (!Objects.equals(this.attribute, other.attribute)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.cardtype, other.cardtype)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    

    

   
    
}
