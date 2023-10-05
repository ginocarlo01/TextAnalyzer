package MainPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * The AnalyzerController class orchestrates the processing of multiple text files.
 * It is responsible for interacting with the AnalyzerReader and AnalyzerWriter.
 */
public class AnalyzerController {
    private ArrayList<String> fileNames = new ArrayList<>();

    /**
     * Constructs an AnalyzerController with a list of file names.
     *
     * @param fileNames A list of file names to process.
     */
    public AnalyzerController(ArrayList<String> fileNames) {
        this.fileNames = fileNames;
    }

    /**
     * Processes the text files, including reading, generating adjacency lists, and writing to CSV files.
     */
    public void processFiles() {
        AnalyzerReader reader = new AnalyzerReader();
        AnalyzerWriter writer = new AnalyzerWriter();

        for (String fileName : fileNames) {
            try {
                // Read and process the file
                Map<String, String> adjacencyList = reader.readFile(fileName);
                System.out.println("Adjacency List for File: " + fileName);
                for (Map.Entry<String, String> entry : adjacencyList.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }

                // Write the adjacency list to a CSV file in the same directory as the input file
                writer.writeAdjacencyList(adjacencyList, fileName);
            } catch (IOException e) {
                System.err.println("Error processing file " + fileName + ": " + e.getMessage());
            }
        }
    }
}
