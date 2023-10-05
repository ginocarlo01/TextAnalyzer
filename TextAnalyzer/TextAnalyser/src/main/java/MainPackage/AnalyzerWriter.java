package MainPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * The AnalyzerWriter class handles writing the adjacency list to a CSV file.
 */
public class AnalyzerWriter {

    /**
     * Writes the adjacency list to a CSV file in the same directory as the input file.
     *
     * @param adjacencyList The adjacency list to be written.
     * @param inputFilePath The path of the input file.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public void writeAdjacencyList(Map<String, String> adjacencyList, String inputFilePath) throws IOException {
        // Get the directory and base name of the input file
        File inputFile = new File(inputFilePath);
        File parentDirectory = inputFile.getParentFile();
        String baseName = inputFile.getName();
        int dotIndex = baseName.lastIndexOf('.');

        // Check if the input file has an extension
        if (dotIndex >= 0) {
            baseName = baseName.substring(0, dotIndex);
        }

        // Construct the output file name with a .csv extension in the same directory
        String outputFileName = new File(parentDirectory, baseName + ".csv").getAbsolutePath();

        try (FileWriter writer = new FileWriter(outputFileName)) {
            for (Map.Entry<String, String> entry : adjacencyList.entrySet()) {
                String node = entry.getKey();
                String destinations = entry.getValue();

                // Write the node and its destinations to the CSV file
                writer.write(node + ": " + destinations + "\n");
            }
        }
    }
}
