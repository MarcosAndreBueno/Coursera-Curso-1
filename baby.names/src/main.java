import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println(
        "                       BEM VINDO!!!\n"+
        "   Este programa itera um arquivo csv com nome de recém nascidos nos EUA entre 1880 e 2014, trabalha os dados e devolve os resultados.\n" +
        "   As funções conseguem rankear os nomes que mais foram registrados para recém nascidos.\n" +
        "   Também consegue retornar o nome que estaria num rank específico, entre outras coisas\n" +
        "   ATENÇÃO: Algumas funções pedem para inserir arquivos, que se encontram em csv_babynames");

        System.out.println("===============================================================================");
        System.out.println("Breve explicação das opções que o usuário pode escolher:\n" +
        "___Opção1: printNames: print uma quantidade escolhida de nomes, separada por gênero e quantidade de repetições\n"+
        "___Opção2: testTotalBirths: print o total de nascimentos em um ano escolhido\n" +
        "___Opção3: testRank: print do rank de um nome na lista\n" +
        "___Opção4: testName: print do nome em um dado rank e ano\n" +
        "___Opção5: testWhatIsNameInYear: retorna rank de um nome em um dado ano, e com este rank busca " +
                                          "qual seria o nome em um outro ano. \n" +
        "___Opção6: testYearOfHighestRank: Faz o mesmo que a opção 3, porém pesquisa em vários documentos\n" +
        "___Opção7: testAvarageRank: Faz o mesmo que a opção 4, porém pesquisa em vários documetos\n" +
        "___Opção8: testHigherRankedNames: print da quantidade de recém nascidos em 1 ou " +
                                           "vários anos com um determinado nome\n" +
        "       Agora é sua vez, escolha uma opção!             ");
        System.out.println("===============================================================================");

        TestProgram iniciar = new TestProgram();
        Scanner teclado = new Scanner(System.in);
        int opcao = Integer.parseInt(teclado.nextLine());

        if ((opcao == 1) || (opcao == 2)) {
            ExercicioUm executar1 = new ExercicioUm();
            executar1.start(opcao);
        }
        if ((opcao == 3) || (opcao == 4) || (opcao == 5)){
            ExercicioDois executar2 = new ExercicioDois();
            executar2.start(opcao);
        }
        if (opcao == 6){
            ExercicioTres executar3 = new ExercicioTres();
            executar3.start(opcao);
        }
        if (opcao == 7){
            ExercicioQuatro executar4 = new ExercicioQuatro();
            executar4.start(opcao);
        }
        if (opcao == 8){
            ExercicioQuinta executar5 = new ExercicioQuinta();
            executar5.start(opcao);
        }
    }
}
