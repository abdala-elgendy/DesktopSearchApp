//package com.desktopsearch;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class fileQueue {
    private final BlockingQueue<File> queue = new LinkedBlockingQueue<>();

    public void addFile(File file) throws InterruptedException {
        queue.put(file);
    }

    public File takeFile() throws InterruptedException {
        return queue.take();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
