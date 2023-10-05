package MainPackage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Main <input_file>");
            System.exit(1);
        }

        String fileName = args[0];
        AnalyzerReader reader = new AnalyzerReader();

        try {
            Map<String, String> adjacencyList = reader.readAndProcessFile(fileName);

            for (Map.Entry<String, String> entry : adjacencyList.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
