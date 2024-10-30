import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class fileIndexer {
    private final fileQueue fileQueue;
    private final Index index;
    private final ExecutorService executorService;

    public fileIndexer(fileQueue fileQueue, Index index) {
        this.fileQueue = fileQueue;
        this.index = index;
        this.executorService = Executors.newFixedThreadPool(2);
    }

    public fileIndexer(fileQueue fileQueue, Index index, ExecutorService executorService) {
        this.fileQueue = fileQueue;
        this.index = index;
        this.executorService = executorService;
    }

    public void startIndexing() {
        executorService.submit(() -> {
            try {
                while (true) {
                    File file = fileQueue.takeFile();
                    indexFile(file);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    private void indexFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.split("\\W+")) {
                    index.addToIndex(word, file);
                }
            }
            System.out.println("Indexed: " + file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        executorService.shutdownNow();
    }
}
