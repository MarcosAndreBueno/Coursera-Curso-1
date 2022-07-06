package FindingWords;

import edu.duke.*;

public class compareMostRepeatedWord {

    /* encontra palavra que mais se repetiu*/
    public String compare(FileResource fr, int impressoes, int impressoes2, StorageResource sr) {
        /* transforma o documento inteiro em uma variável String */
        String fullText = fr.asString();
        fullText = fullText.toLowerCase();
        int countMostRepeated = 0;
        int posicaoAtual = 0;
        String palavraMaisRepetida = "";
        int count = 0;
        saveComparedWord saveWord = new saveComparedWord();
        printResults print = new printResults();
        takeActualPosition posicaoAtual00 = new takeActualPosition();
        discoverSymbolInWord thereIsSymbol00 = new discoverSymbolInWord();
        numberOfRepeatsWord wordRepeats00 = new numberOfRepeatsWord();
            /* itera palavra por palavra do documento */
            for (String palavra : fr.words()) {
                /* se a palavra tiver a quantidade (ou mais) de letras que o número que o usuário escolheu */
                if (palavra.length() >= impressoes2) {
                    /* encontra a posição da palavra atual no texto */
                    posicaoAtual = posicaoAtual00.position(fullText, palavra, posicaoAtual);
                    /* exclui vírgulas, ponto final e outros símbolos que não fazem parte da palavra */
                    String palavraCorrigida = thereIsSymbol00.discover(palavra);
                    /* retorna quantas vezes a palavra se repetiu */
                    int wordRepeats = wordRepeats00.repeats(fullText, palavraCorrigida, posicaoAtual);

                    /* Organiza as palavras em ordem das que mais se repetiram */
                    if ((wordRepeats > countMostRepeated) && (palavraCorrigida.length() >= impressoes2)) {
                        /* confere se é a primeira vez que a palavra apareceu */
                        palavraCorrigida = saveWord.save(palavraCorrigida, count, sr);
                            if (!palavraCorrigida.isEmpty()) {
                                palavraMaisRepetida = palavraCorrigida;
                                countMostRepeated = wordRepeats;
                                posicaoAtual = (fullText.indexOf(palavraCorrigida, posicaoAtual) + (palavra.length()));
                            }
                        }
                    } else {
                        posicaoAtual = (fullText.indexOf(palavra, posicaoAtual) + (palavra.length()));
                    }
                }
            /* Printa o resultado */
            print.print(palavraMaisRepetida, countMostRepeated, impressoes);
            saveWord.save(palavraMaisRepetida, impressoes, sr);
            return palavraMaisRepetida;
        }
    }

