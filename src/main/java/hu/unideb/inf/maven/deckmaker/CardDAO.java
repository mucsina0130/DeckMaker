package hu.unideb.inf.maven.deckmaker;

/**
 * This interface method will load data from an xml file.
 */
public interface CardDAO {

    /**
     * This method will sets up the {@code CardList} object from an xml file.
     *
     * @param cardlist the class for represent a {@code Card} list whit the card
     * object.
     */
    public void CardListLoader(CardList cardlist);

}
