package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * @param nexString the string to be printed
     */
    void setNextString(String nexString);

    /**
     * @return the string to be printed
     */
    String getNextString();

    /**
     * @return the history of printed strings
     */
    List<String> getHistory();

    /**
     * Print the current string.
     */
    void printString();
}
