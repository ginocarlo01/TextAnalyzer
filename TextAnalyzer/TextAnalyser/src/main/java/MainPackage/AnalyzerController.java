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
     * Processes the text files, including reading and generating adjacency lists.
     */
    public void processFiles() {
        AnalyzerReader reader = new AnalyzerReader();
        AnalyzerWriter writer = new AnalyzerWriter();

        for (String fileName : fileNames) {
            try {
                // Read and process the file
                Map<String, String> adjacencyList = reader.readFile(fileName);

                // Process the adjacency list and write the results
                //writer.writeAdjacencyList(adjacencyList, fileName + ".csv");
            } catch (IOException e) {
                System.err.println("Error processing file " + fileName + ": " + e.getMessage());
            }
        }
    }
}
