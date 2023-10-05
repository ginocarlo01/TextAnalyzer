package MainPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The TextAnalyzer program is designed to preprocess text files, generating adjacency lists for text analysis.
 * This program is developed by Gino Grippo - 248301
 */
public class AnalyzerStart {
    public static void main(String[] args) {
        try {
            // Create a list of file names from command line arguments
            ArrayList<String> fileNames = new ArrayList<>(List.of(args));

            // Display the file names
            for (String fileName : fileNames) {
                System.out.println(fileName);
            }

            // Create an AnalyzerController with the list of file names
            AnalyzerController controller = new AnalyzerController(fileNames);

            // Process the files
            controller.processFiles();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
