package FindingWords;

public class discoverSymbolInWord {
    /* exclui vírgulas, ponto final e outros símbolos que não fazem parte da palavra */
    public String discover(String palavra) {
        int count = 0;
        int tamanhoPalavra = palavra.length();

        for (int i = 0; i < palavra.length(); i++) {
            String letraExcecao = palavra.substring(i,i+1);
            if (!Character.isDigit(palavra.charAt(i))
                    && !Character.isLetter(palavra.charAt(i))
                    && !Character.isWhitespace(palavra.charAt(i))
                    && !letraExcecao.equals("-")) {
                count++;
            }

            if (count > 0) {
                int posicaoSymbol = tamanhoPalavra - i;
                if (posicaoSymbol == 1) {
                    palavra = palavra.substring(0, i);
                    return palavra;
                }
                if (posicaoSymbol > 1) {
                    palavra = palavra.substring(i + 1);
                    return palavra;
                }
            }
        }
        return palavra;
    }
}


