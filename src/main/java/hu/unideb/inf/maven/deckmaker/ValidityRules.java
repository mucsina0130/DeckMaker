/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.maven.deckmaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mucsi
 * @param <T> the type of the data stored in the Restriction.
 */
public class ValidityRules <T extends Restriction> {
    private double mindecksize;
    private double maxdecksize;
    private double basic_quantity_restriction;
    private List<T> restrictions = new ArrayList<T>();

    public ValidityRules(){};

    public double getMindecksize() {
        return mindecksize;
    }

    public double getMaxdecksize() {
        return maxdecksize;
    }

    public double getBasic_quantity_restriction() {
        return basic_quantity_restriction;
    }

    public List<T> getRestrictions() {
        return restrictions;
    }

    public void setMindecksize(double mindecksize) {
        this.mindecksize = mindecksize;
    }

    public void setMaxdecksize(double maxdecksize) {
        this.maxdecksize = maxdecksize;
    }

    public void setBasic_quantity_restriction(double basic_quantity_restriction) {
        this.basic_quantity_restriction = basic_quantity_restriction;
    }

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
