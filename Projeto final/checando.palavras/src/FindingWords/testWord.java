package FindingWords;

import edu.duke.*;

import java.util.*;

public class testWord {
    public static void main(String[] args) {

        System.out.println("------------------------------------------------");
        System.out.println("Start");

        FileResource fr = new FileResource();

        countPalavras palavras00 = new countPalavras();
        palavras00.count(fr);

        Scanner sn = new Scanner(System.in);
        System.out.println("Escolha a quantidade de palavras que quer rankear: ");
        String teclado = sn.nextLine();
        System.out.println("Escolha a quantidade de letras nas palavras (a busca será por palavras com quantidade maior ou igual a de letras escolhidas): ");
        String teclado2 = sn.nextLine();
        System.out.println("Rankeando as palavras mais usadas...");
        int impressoes = Integer.parseInt(teclado);
        int impressoes2 = Integer.parseInt(teclado2);

        compareMostRepeatedWord compare = new compareMostRepeatedWord();
        StorageResource sr = new StorageResource();
        for (int i = 1; i <= impressoes; i++) {
            String palavraAnterior = compare.compare(fr, i,impressoes2, sr);
            sr.add(palavraAnterior);
        }


        System.out.println("Test finished");
        System.out.println("------------------------------------------------");
    }
}