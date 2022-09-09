import java.util.Scanner;

public class ExercicioQuinta {
    public void start(int opcao) {
        TestProgram iniciar = new TestProgram();
        Scanner teclado = new Scanner(System.in);

        if (opcao == 8) {
            System.out.print("Entre com o nome que gostaria de pesquisar: ");
            String nome = teclado.nextLine();
            System.out.print("Entre com o gênero que gostaria de pesquisar (M) ou (F): ");
            String genero = teclado.nextLine();
            System.out.println("Selecione os arquivos que gostaria de pesquisar");
            iniciar.testHigherRankedNames(nome, genero);
        }
    }
}