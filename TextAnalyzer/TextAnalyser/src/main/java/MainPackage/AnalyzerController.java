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
        ArrayList<String> outputFiles = new ArrayList<>();

        for (String fileName : fileNames) {
            try {
                // Read and process the file
                Map<String, String> adjacencyList = reader.readFile(fileName);

                // Construct the output file name based on the input file name
                String outputFileName = getOutputFileName(fileName);

                // Write the adjacency list to a CSV file in the same directory as the input file
                writer.writeAdjacencyList(adjacencyList, outputFileName);

                // Store the name of the new output file
                outputFiles.add(outputFileName);
            } catch (IOException e) {
                System.err.println("Error processing file " + fileName + ": " + e.getMessage());
            }
        }

        // Print the names of the new files created
        System.out.println("New files created:");
        for (String outputFile : outputFiles) {
            System.out.println(outputFile);
        }
    }

    /**
     * Constructs the output file name based on the input file name.
     *
     * @param inputFileName The input file name.
     * @return The output file name.
     */
    private String getOutputFileName(String inputFileName) {
        // Extract the file name without extension
        String baseName = inputFileName.substring(0, inputFileName.lastIndexOf('.'));
        // Construct the output file name with a .csv extension
        return baseName + ".csv";
    }
}
