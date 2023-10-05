package MainPackage;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class AnalyzerStart {
    public static void main(String[] args) {
        try {

            ArrayList<String> nomesArquivos = new ArrayList<>(Arrays.asList(args));

            for(String nomeArquivo : nomesArquivos){
                System.out.println(nomeArquivo);
            }

            AnalyzerController controller = new AnalyzerController(nomesArquivos);

            controller.processarArquivos();


        } catch (Exception e) {
            System.err.println("Ocorreu um erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
