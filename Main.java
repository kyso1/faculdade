import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a quantidade de tempo de execução: ");
        int tempoExecucao = scanner.nextInt();

        System.out.print("Digite a quantidade de instruções: ");
        int qtdInstrucoes = scanner.nextInt();

        System.out.print("Digite a quantidade de estágios: ");
        int qtdEstagios = scanner.nextInt();

        ArrayList<String> estagios = new ArrayList<>();
        Map<String, Integer> frequenciasEstagios = new HashMap<>();

        for (int i = 0; i < qtdEstagios; i++) {
            System.out.print("Digite o nome do estágio " + (i + 1) + ": ");
            String estagio = scanner.next();

            System.out.print("Digite a frequência do estágio " + estagio + ": ");
            int frequencia = scanner.nextInt();

            estagios.add(estagio);
            frequenciasEstagios.put(estagio, frequencia);
        }

        for (int i = 0; i < tempoExecucao;i++) {
            for (int j = 0; j < qtdInstrucoes;j++) {
                System.out.print(" X");
            }
        }
    }
}