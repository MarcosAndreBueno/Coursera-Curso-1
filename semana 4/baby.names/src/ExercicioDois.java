import java.util.Scanner;

public class ExercicioDois {
    public void start(int opcao) {
        TestProgram iniciar = new TestProgram();
        Scanner teclado = new Scanner(System.in);

        if (opcao == 3) {
            System.out.print("Entre com o ano que gostaria de pesquisar (1880-2014): ");
            int ano = Integer.parseInt(teclado.nextLine());
            System.out.print("Entre com o nome que gostaria de pesquisar: ");
            String nome = teclado.nextLine();
            System.out.print("Entre com o gênero que gostaria de pesquisar (M) ou (F): ");
            String genero = teclado.nextLine();
            iniciar.testRank(ano, nome, genero);
        }
        if (opcao == 4) {
            System.out.print("Entre com o ano que gostaria de pesquisar (1880-2014): ");
            int ano = Integer.parseInt(teclado.nextLine());
            System.out.print("Selecione a colocação no Rank para retornar o nome correpondente ");
            int rank = Integer.parseInt(teclado.nextLine());
            System.out.print("Entre com o gênero que gostaria de pesquisar (M) ou (F): ");
            String genero = teclado.nextLine();
            iniciar.testName(ano, rank, genero);
        }
        else{
            System.out.print("Entre com o ano que gostaria de pesquisar: ");
            int ano = Integer.parseInt(teclado.nextLine());
            System.out.print("Entre com o nome que gostaria de pesquisar: ");
            String nome = teclado.nextLine();
            System.out.print("Entre com o gênero que gostaria de pesquisar (M) ou (F): ");
            String genero = teclado.nextLine();
            System.out.println("Entre com o novo ano (o valor de rank obtido pelo nome anterior " +
                                                      "será buscado nesse novo ano)");
            int novoAno = Integer.parseInt(teclado.nextLine());
            iniciar.testWhatIsNameInYear(ano, nome, genero, novoAno);
        }
    }
}