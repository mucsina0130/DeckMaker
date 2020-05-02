package hu.unideb.inf.deckmaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class for representing a list of the rules for building a deck.
 *
 * @param <T> the type of the data stored in the Restriction.
 */
public class ValidityRules<T extends Restriction> {

    /**
     * The minimum number of pieces of this object.
     */
    private double mindecksize;
    /**
     * The maximum number of pieces of this object.
     */
    private double maxdecksize;
    /**
     * The basic quantity of a {@code Card} object.
     */
    private double basic_quantity_restriction;
    /**
     * An array list with the {@code Restrictions} object.
     */
    private List<T> restrictions = new ArrayList<T>();

    /**
     * Constructs a default {@code ValidityRules} object.
     */
    public ValidityRules() {
    }

    ;
    /**
     * Returns the minimum number of pieces of this object.
     * 
     * @return minimum number of pieces of this object
     */
    public double getMindecksize() {
        return mindecksize;
    }

    /**
     * Returns the maximum number of pieces of this object.
     *
     * @return maximum number of pieces of this object
     */
    public double getMaxdecksize() {
        return maxdecksize;
    }

    /**
     * Returns the basic quantity of a {@code Card} object.
     *
     * @return the basic quantity of a {@code Card} object
     */
    public double getBasic_quantity_restriction() {
        return basic_quantity_restriction;
    }

    /**
     * Returns an array list with the {@code Restrictions} object.
     *
     * @return an array list with the {@code Restrictions} object
     */
    public List<T> getRestrictions() {
        return restrictions;
    }

    /**
     * Sets the minimum number of pieces of this object.
     *
     * @param mindecksize the minimum number of pieces of this object
     */
    public void setMindecksize(double mindecksize) {
        this.mindecksize = mindecksize;
    }

    /**
     * Sets the maximum number of pieces of this object.
     *
     * @param maxdecksize the maximum number of pieces of this object
     */
    public void setMaxdecksize(double maxdecksize) {
        this.maxdecksize = maxdecksize;
    }

    /**
     * Sets the basic quantity of a {@code Card} object.
     *
     * @param basic_quantity_restriction the basic quantity of a {@code Card}
     * object
     */
    public void setBasic_quantity_restriction(double basic_quantity_restriction) {
        this.basic_quantity_restriction = basic_quantity_restriction;
    }

    /**
     * Sets an array list with the {@code Restrictions} object.
     *
     * @param restrictions an array list with the {@code Restrictions} object
     */
    public void setRestrictions(List<T> restrictions) {
        this.restrictions = restrictions;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.mindecksize) ^ (Double.doubleToLongBits(this.mindecksize) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.maxdecksize) ^ (Double.doubleToLongBits(this.maxdecksize) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.basic_quantity_restriction) ^ (Double.doubleToLongBits(this.basic_quantity_restriction) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.restrictions);
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
        final ValidityRules<?> other = (ValidityRules<?>) obj;
        if (Double.doubleToLongBits(this.mindecksize) != Double.doubleToLongBits(other.mindecksize)) {
            return false;
        }
        if (Double.doubleToLongBits(this.maxdecksize) != Double.doubleToLongBits(other.maxdecksize)) {
            return false;
        }
        if (Double.doubleToLongBits(this.basic_quantity_restriction) != Double.doubleToLongBits(other.basic_quantity_restriction)) {
            return false;
        }
        if (!Objects.equals(this.restrictions, other.restrictions)) {
            return false;
        }
        return true;
    }

}
