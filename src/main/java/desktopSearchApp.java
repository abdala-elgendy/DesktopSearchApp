import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class desktopSearchApp {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
       fileQueue fileQueue = new fileQueue();
        Index index = new Index();
        fileIndexer fileIndexer = new fileIndexer(fileQueue, index);
       searcher searcher = new searcher(index);

        // Start indexing in a separate thread
        fileIndexer.startIndexing();

        // Directory to index (replace with your path)
        String directoryPath = "F:\\selectedFolder";

        try {
            Files.walk(Paths.get(directoryPath)).filter(Files::isRegularFile).forEach(filePath -> {
                try {
                    fileQueue.addFile(filePath.toFile());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

Thread.sleep(1000);
        // Allow user to search
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word to search for (type 'exit' to quit):");

        while (true) {
            String query = scanner.nextLine();
            if (query.equalsIgnoreCase("exit")) {
                break;
            }

            Future<List<File>> results = searcher.searchAsync(query);
            if (results.get().isEmpty()) {
                System.out.println("No results found for: " + query);
            } else {
                System.out.println("Files containing '" + query + "':");
                System.out.println(results.get().size());
//                for (File file : results) {
//                    System.out.println(" - " + file.getAbsolutePath());
//                }
            }
        }

        // Shut down indexing
        fileIndexer.shutdown();
        scanner.close();
    }
}
