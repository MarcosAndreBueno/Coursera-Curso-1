package FindingWords;

public class takeActualPosition{

    public int position(String fullText, String palavra, int posicaoAtual){
            /* encontra a posição da palavra atual no texto */
            posicaoAtual = fullText.indexOf(palavra, posicaoAtual); /* procurar palavra, começando da posiçãoAtual */
            return posicaoAtual;

    }
}
