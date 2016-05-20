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
public class Restriction {
    private String name;
    private double maxnumber_of_piece;
    
    
    public Restriction(){};
    
    
    public Restriction(String name, double maxnumber_of_piece) {
        this.name = name;
        this.maxnumber_of_piece = maxnumber_of_piece;
    }

    public String getName() {
        return name;
    }

    public double getMaxnumber_of_piece() {
        return maxnumber_of_piece;
    }

    public void setName(String name) {
        this.name = name;
    }

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
