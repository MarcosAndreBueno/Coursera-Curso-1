package FindingWords;

public class numberOfRepeatsWord {
    /* retorna quantas vezes a palavra se repetiu */
    public int repeats(String fullText, String palavra, int posicaoAtual) {
        int tamanhoPalavra = palavra.length();
        int count = 0;

        while (true) {
            if (palavra.length() <= 1) {
                break;
            }
            int procurandoPalavra = fullText.indexOf(palavra, posicaoAtual);
            if (procurandoPalavra != -1) {
                {
                    count += 1;
                    posicaoAtual = procurandoPalavra + tamanhoPalavra;
                }
            }
            if (procurandoPalavra == -1) {
                break;
            }
        }
        return count;
    }
}