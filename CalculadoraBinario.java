import java.util.Scanner;

public class CalculadoraBinario{
    // metodo para converter uma representação binária em um array de inteiros
    private static int[] binaryStringToIntArray(String binaryString) {
        int length = binaryString.length();
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            // converte cada caractere para um número inteiro e armazena no array
            result[i] = Character.getNumericValue(binaryString.charAt(i));
        }

        return result;
    }
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int a[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; 
        System.out.print("Digite o numero do multiplicador: ");
        String multi = Integer.toBinaryString(Integer.parseInt(scan.next()));
        System.out.print("Digite o numero do multiplicando: ");
        String multipl = Integer.toBinaryString(Integer.parseInt(scan.next()));
        System.out.println("Multiplicador em binario: "+multi);
        System.out.println("Multiplicando em binario: "+multipl);        
        int[] m = binaryStringToIntArray(multi);
        int[] q = binaryStringToIntArray(multipl);
        int carry_out = 0;
        int aux_a[] = new int[a.length];
        int aux_q[] = new int[q.length];
        int n = 15;
        int cOut = 0;

        for (int i = n; i >= 0; i--) {
            System.out.println("Counter " + i);

            for (int j = 0; j < a.length; j++) {
                aux_a[j] = a[j];
                aux_q[j] = q[j];
            }
            System.out.println("Q0: " + q[q.length - 1]);
            System.out.println("C: " + cOut);

            System.out.print("A: ");
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
            System.out.print("Q: ");
            for (int j = 0; j < a.length; j++) {
                System.out.print(q[j] + " ");
            }
            System.out.println();
            System.out.print("M: ");
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[j] + " ");
            }

            System.out.println();
            if(q[q.length - 1] == 1){
                
                for(int j = n - 1; j >= 0; j--){
                    if(m[j] == 0 && aux_a[j] == 0 && carry_out == 1){
                        a[j] = 1;
                        carry_out = 0;
                    }
                    if(m[j] == 0 && aux_a[j] == 1 && carry_out == 1){
                        a[j] = 0;
                        carry_out = 1;
                    }
                    if(m[j] == 0 && aux_a[j] == 1 && carry_out == 0){
                        a[j] = 1;
                    }
                    if(m[j] == 1 && aux_a[j] == 0 && carry_out == 1){
                        a[j] = 0;
                        carry_out = 1;
                    }
                    if(m[j] == 1 && aux_a[j] == 0 && carry_out == 0){
                        a[j] = 1;
                    }
                    if(m[j] == 1 && aux_a[j] == 1 && carry_out == 1){
                        a[j] = 1;
                        carry_out = 1;
                    }
                    if(m[j] == 1 && aux_a[j] == 1 && carry_out == 0){
                        a[j] = 0;
                        carry_out = 1;
                    }
                }
            }

            for(int j=0; j<a.length; j++){
                aux_a[j] = a[j];
                aux_q[j] = q[j];
            }

            int cont = 0;

            for(int k = 0; k < a.length + q.length; k++){
                if(k == 0){
                    a[k] = carry_out;
                    carry_out = 0;
                }else{
                    if(k < a.length){
                        a[k] = aux_a[k - 1];
                    }
                    if(k == a.length){
                        q[cont] = aux_a[a.length - 1];
                        cont++;
                    }
                    if(k > a.length){
                        q[cont] = aux_q[cont - 1];
                        cont++;
                    }
                }
            }
            System.out.println("Etapa " + i);
            
        }

        int resultado[] = new int[a.length + q.length];
        int cont_aux = 0;
        for(int i = 0; i < resultado.length; i++){
            if(i < a.length){
                resultado[i] = a[i];
            }else{
                resultado[i] = q[cont_aux++];
            }
            System.out.print(resultado[i] + " ");
        }
        scan.close();
    }
}