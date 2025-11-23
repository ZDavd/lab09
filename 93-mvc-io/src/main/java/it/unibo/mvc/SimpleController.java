package it.unibo.mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Simple implementation of the Controller interface.
 */
public final class SimpleController implements Controller {

    private final List<String> history = new ArrayList<>();
    private String nextString;

    @Override
    public void setNextString(final String nexString) {
        Objects.requireNonNull(nexString);
        this.nextString = nexString;
    }

    @Override
    public String getNextString() {
        return this.nextString;
    }

    @Override
    public List<String> getHistory() {
        return Collections.unmodifiableList(history);
    }

    @Override
    public void printString() {
        if (this.nextString == null) {
            throw new IllegalStateException("nextString is not set");
        }
        history.add(nextString);
        System.out.println(nextString); // NOPMD This is just an exercise
    }
}
