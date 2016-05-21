package hu.unideb.inf.maven.deckmaker;

import java.util.Objects;

/**
 * Class for representing a TCG card.
 */
public class Card {

    /**
     * The name of the card.
     */
    private String name;
    /**
     * The cost of the card.
     */
    private String cost;
    /**
     * The attribute of the card.
     */
    private String attribute;
    /**
     * The type of the card.
     */
    private String type;
    /**
     * The second type of the card.
     */
    private String cardtype;
    /**
     * The description of the card.
     */
    private String description;
    /**
     * The attack power of the card.
     */
    private int attpower;
    /**
     * The defense power of the card.
     */
    private int deffpower;
    /**
     * The quantity of the card in the deck. The default quantity is 0.
     */
    private int quantity = 0;

    /**
     * Constructs a default {@code Card} object.
     */
    public Card() {
    }

    ;
    
    /**
     * Constructs a {@code Card} object with specified name, cost, type, second type,
     * description, defense power and attack power.
     * @param name the name of the card
     * @param cost the cost of the card
     * @param type the type of the card
     * @param cardtype the second type of the card
     * @param description the description of the card
     * @param deffpower the defense power of the card
     * @param attpower the attack power of the card
     */
    public Card(String name, String cost, String type, String cardtype, String description, int deffpower, int attpower) {
        this.name = name;
        this.cost = cost;
        this.type = type;
        this.cardtype = cardtype;
        this.description = description;
        this.deffpower = deffpower;
        this.attpower = attpower;
        this.quantity = 0;
    }

    /**
     * Returns the name of this object.
     *
     * @return the name of this object
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the cost of this object.
     *
     * @return the cost of this object
     */
    public String getCost() {
        return cost;
    }

    /**
     * Returns the attribute of this object.
     *
     * @return the attribute of this object
     */
    public String getAttribute() {
        return attribute;
    }

    /**
     * Returns the type of this object.
     *
     * @return the type of this object
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the second type of this object.
     *
     * @return the second type of this object
     */
    public String getCardtype() {
        return cardtype;
    }

    /**
     * Returns the description of this object.
     *
     * @return the description of this object
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the of attack power this object.
     *
     * @return the of attack power this object
     */
    public int getAttpower() {
        return attpower;
    }

    /**
     * Returns the defense power of this object.
     *
     * @return the defense power of this object
     */
    public int getDeffpower() {
        return deffpower;
    }

    /**
     * Returns the quantity of this object.
     *
     * @return the quantity of this object
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the name of this object.
     *
     * @param name the name of this object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the cost of this object.
     *
     * @param cost the cost of this object
     */
    public void setCost(String cost) {
        this.cost = cost;
    }

    /**
     * Sets the attribute of this object.
     *
     * @param attribute the attribute of this object
     */
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    /**
     * Sets the type of this object.
     *
     * @param type the type of this object
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the second type of this object.
     *
     * @param cardtype  the second type of this object
     */
    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    /**
     * Sets the description of this object.
     *
     * @param description the description of this object
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the attack power of this object.
     *
     * @param attpower the name of this object
     */
    public void setAttpower(int attpower) {
        this.attpower = attpower;
    }

    /**
     * Sets the defense power of this object.
     *
     * @param deffpower the defense power of this object
     */
    public void setDeffpower(int deffpower) {
        this.deffpower = deffpower;
    }

    /**
     * Sets the quantity of this object.
     *
     * @param quantity the name of this object
     */
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
