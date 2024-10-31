import java.io.File;
import java.util.List;
import java.util.concurrent.*;

public class searcher {
    private final Index index;
    private final ExecutorService searchExecutor;

    public searcher(Index index) {
        this.index = index;
        // Create a fixed thread pool for search queries
        this.searchExecutor = Executors.newFixedThreadPool(4); // Adjust the pool size as needed
    }

    public Future<List<File>> searchAsync(String query) {
        // Submit the search task to the executor and return a Future
        return searchExecutor.submit(() -> index.search(query));
    }

    public void shutdown() {
        searchExecutor.shutdown();
    }
}
