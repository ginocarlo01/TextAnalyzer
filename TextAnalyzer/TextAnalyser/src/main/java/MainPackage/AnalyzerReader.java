package MainPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Map;
import java.util.TreeMap;

/**
 * The AnalyzerReader class handles reading and processing text files to generate adjacency lists.
 */
public class AnalyzerReader {

    /**
     * Reads and processes a text file to generate an adjacency list.
     *
     * @param fileName The name of the input text file.
     * @return A Map representing the adjacency list.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public Map<String, String> readFile(String fileName) throws IOException {
        Map<String, String> adjacencyList = new TreeMap<>(); // TreeMap to maintain alphabetical order

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String previousWord = null;

            while ((line = reader.readLine()) != null) {
                // Remove unwanted characters such as punctuation, quotation marks, etc.
                line = line.replaceAll("[^a-zA-Z ]", "");

                // Tokenize the line into words
                String[] words = line.toLowerCase().split("\\s+");

                // Process each word and update the adjacency list
                processWords(adjacencyList, words, previousWord);
            }
        }

        return adjacencyList;
    }

    private void processWords(Map<String, String> adjacencyList, String[] words, String previousWord) {
        for (String word : words) {
            if (!word.isEmpty()) { // Skip empty words
                if (previousWord != null) {
                    // Update the adjacency list to indicate the order of words
                    adjacencyList.putIfAbsent(previousWord, "");
                    String destinations = adjacencyList.get(previousWord);
                    if (!destinations.isEmpty()) {
                        destinations += ", ";
                    }
                    destinations += word;
                    adjacencyList.put(previousWord, destinations);
                }

                previousWord = word;
            }
        }
    }

    private String normalizeWord(String word) {
        // Remove accents and normalize the word
        word = Normalizer.normalize(word, Normalizer.Form.NFD);
        word = word.replaceAll("[^\\p{ASCII}]", "");
        return word;
    }
}
