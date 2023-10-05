package MainPackage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AnalyzerReader {
    public Map<String, String> readFile(String fileName) throws IOException {
        Map<String, String> adjacencyList = new TreeMap<>(); // TreeMap to maintain alphabetical order

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String previousWord = null;

            while ((line = reader.readLine()) != null) {
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
            // Remove punctuation and accents from the word
            word = normalizeWord(word);

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

    private String normalizeWord(String word) {
        // Remove accents and normalize the word
        word = Normalizer.normalize(word, Normalizer.Form.NFD);
        word = word.replaceAll("[^\\p{ASCII}]", "");
        return word;
    }
}