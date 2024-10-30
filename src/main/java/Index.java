import java.io.File;
import java.util.*;

public class Index {
    private final Map<String, List<File>> indexMap = new HashMap<>();

    public void addToIndex(String word, File file) {
        indexMap.computeIfAbsent(word.toLowerCase(), k -> new ArrayList<>()).add(file);
    }

    public List<File> search(String word) {
        return indexMap.getOrDefault(word.toLowerCase(), Collections.emptyList());
    }
}
