import java.util.Scanner;

public class ExercicioQuatro {
    public void start(int opcao) {
        TestProgram iniciar = new TestProgram();
        Scanner teclado = new Scanner(System.in);

        if (opcao == 7) {
            System.out.print("Entre com o nome que gostaria de pesquisar: ");
            String nome = teclado.nextLine();
            System.out.print("Entre com o gênero que gostaria de pesquisar (M) ou (F): ");
            String genero = teclado.nextLine();
            iniciar.testAvarageRank(nome, genero);
        }
    }
}