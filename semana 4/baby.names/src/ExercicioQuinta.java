import java.util.Scanner;

public class ExercicioQuinta {
    public void start(int opcao) {
        TestProgram iniciar = new TestProgram();
        Scanner teclado = new Scanner(System.in);

        if (opcao == 8) {
            System.out.print("Entre com o ano que gostaria de pesquisar: ");
            int ano = Integer.parseInt(teclado.nextLine());
            System.out.print("Entre com o nome que gostaria de pesquisar: ");
            String nome = teclado.nextLine();
            System.out.print("Entre com o gênero que gostaria de pesquisar (M) ou (F): ");
            String genero = teclado.nextLine();
            iniciar.testHigherRankedNames(ano, nome, genero);
        }
    }
}