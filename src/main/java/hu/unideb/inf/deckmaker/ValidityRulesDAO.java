package hu.unideb.inf.deckmaker;

/**
 * This interface method will load data from an xml file.
 */
public interface ValidityRulesDAO {

    /**
     * This method will sets up the {@code ValidityRules} object from an xml
     * file.
     *
     * @param rules class for representing a list of the rules for building a
     * deck
     */
    public void restrictionsLoader(ValidityRules rules);
}
