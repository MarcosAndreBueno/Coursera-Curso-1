package FindingWords;

import edu.duke.*;

public class countPalavras {
    /* conta quantas letras e quantas palavras existem no documento */
    public void count(FileResource fr) {
        String fullText = fr.asString();
        int tamanhoTexto = fullText.length() - 1;
        int countPalavras = 0;
            for (String palavra : fr.words()) {
                countPalavras += 1;
                }
        System.out.println("Número de letras   = " + tamanhoTexto);
        System.out.println("Número de palavras = " + countPalavras);
    }
}
