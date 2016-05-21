package hu.unideb.inf.maven.deckmaker;

import java.util.Objects;

/**
 * Class for representing the rules for building a deck.
 */
public class Restriction {

    /**
     * The name of the object.
     */
    private String name;
    /**
     * The maximum number of pieces of this object.
     */
    private double maxnumber_of_piece;

    /**
     * Constructs a default {@code Restriction} object.
     */
    public Restriction() {
    }

    ;
    
    /**
     * Construct a {@code Restriction} object with a name and a maximum number of pieces specified.
     * 
     * @param name the name of the object
     * @param maxnumber_of_piece the maximum number of pieces of this object
     */
    public Restriction(String name, double maxnumber_of_piece) {
        this.name = name;
        this.maxnumber_of_piece = maxnumber_of_piece;
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
     * Returns maximum number of pieces of this object.
     *
     * @return maximum number of pieces of this object
     */
    public double getMaxnumber_of_piece() {
        return maxnumber_of_piece;
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
     * Sets the maximum number of pieces of this object.
     *
     * @param maxnumber_of_piece the maximum number of pieces of this object
     */
    public void setMaxnumber_of_piece(double maxnumber_of_piece) {
        this.maxnumber_of_piece = maxnumber_of_piece;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.name);
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.maxnumber_of_piece) ^ (Double.doubleToLongBits(this.maxnumber_of_piece) >>> 32));
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
        final Restriction other = (Restriction) obj;
        if (Double.doubleToLongBits(this.maxnumber_of_piece) != Double.doubleToLongBits(other.maxnumber_of_piece)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Restriction{" + "name=" + name + ", maxnumber_of_piece=" + maxnumber_of_piece + '}';
    }

}
