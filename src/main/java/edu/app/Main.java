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

        System.out.println(" write-read-write-read. ");

        VideoLibrary videoLibrary = new VideoLibrary(
                "run title",
                100,
                new String[]{"a", "b", "c", "d"},
                new int[]{5000, 5000, 5000, 5000});

        CollectableSynchronizer colSync = new CollectableSynchronizer(videoLibrary);
        RunnableWriteThread wrt = new RunnableWriteThread(colSync);
        RunnableReadThread rrt = new RunnableReadThread(colSync);

        new Thread(wrt).start();
        new Thread(rrt).start();

        SynchronizedCollectable syncVL = new SynchronizedCollectable(videoLibrary);
    }
}
