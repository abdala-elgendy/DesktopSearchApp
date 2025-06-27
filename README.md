# DesktopSearchApp

DesktopSearchApp is a simple, multithreaded Java application designed to index and search for words within files located in a specified directory on your computer. The application builds an in-memory word-to-file index, allowing users to quickly search for all files containing a given word.

## Features

- **Directory Indexing**: Recursively scans a chosen directory and indexes all regular files.
- **In-Memory Word Index**: Maps every word found in the files to the files in which they appear.
- **Asynchronous Search**: Searches are performed asynchronously for responsiveness.
- **Multithreaded Indexing and Searching**: Uses Java's `ExecutorService` to allow concurrent indexing and searching.
- **Simple CLI**: Users can search for words interactively in the console.

## How It Works

1. **Indexing**: The application traverses the specified directory, adding every regular file to a thread-safe queue. The `fileIndexer` pulls files from the queue, reads their contents, and splits text into words. Each word is mapped to the file in an index.
2. **Searching**: Users enter search queries in the console. The `searcher` class looks up the word in the index and returns a list of files containing that word.


### Running the Application

1. **Clone or download this repository.**
2. **Edit the directory path** in `desktopSearchApp.java`:
    ```java
    String directoryPath = "F:\\selectedFolder";
    ```
    Replace this with the absolute path to the directory you want to index.

3. **Compile the Java files**:
    ```bash
    javac *.java
    ```

4. **Run the application**:
    ```bash
    java desktopSearchApp
    ```

5. **Use the CLI**:
    - Enter any word to search for files containing that word.
    - Type `exit` to quit the application.

## Key Classes

- `Index`: Maintains a mapping from words (case-insensitive) to a list of files in which they appear.
- `fileQueue`: Thread-safe queue for files to be indexed.
- `fileIndexer`: Consumes files from the queue, reads their contents, and updates the index.
- `searcher`: Provides asynchronous search over the index using a thread pool.
- `desktopSearchApp`: Main class; sets up indexing, handles user search queries, and manages application lifecycle.

## Example

```
Enter a word to search for (type 'exit' to quit):
java
Files containing 'java':
3
```

## Notes

- The search and indexing are case-insensitive.
- Only regular files are indexed (not directories).
- Word splitting uses non-word characters as delimiters (`\\W+`).
- The index is built in memory; searching large directories with very large files may require substantial RAM.

## Customization

- **Thread Pool Size**: Adjust the number of threads in `fileIndexer` and `searcher` to optimize for your hardware.
- **File Types**: Add filtering logic in `Files.walk()` if you only want to index specific file types.

## License

This project is provided as-is for educational purposes.
