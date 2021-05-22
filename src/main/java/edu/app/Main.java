package edu.app;

import edu.*;
import edu.threads.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        AudioLibrary audioLibrary = new AudioLibrary(
                "title",
                200,
                new String[]{"a", "b", "c", "d"},
                new int[]{5000, 5000, 5000, 5000});

        WriteThread writeThread = new WriteThread(audioLibrary);
        ReadThread readThread = new ReadThread(audioLibrary);
        writeThread.start();
        readThread.start();
    }
}
