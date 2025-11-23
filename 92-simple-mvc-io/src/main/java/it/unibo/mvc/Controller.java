package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {
    private File currentFile;

    /**
     *  Constructor.
     */
    public Controller() {

        currentFile = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "output.txt");
    }

    void setCurrentFile(final File newFile) {
        this.currentFile = newFile;
    }

    File getCurrentFile() {
        return this.currentFile;
    }

    String getCurrentPath() {
        return currentFile.getPath();
    }

    void writeString(final String payload) throws IOException {
        try (PrintStream stream = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            stream.println(payload);
        }
    }
}
