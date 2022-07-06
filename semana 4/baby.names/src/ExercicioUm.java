import java.util.Scanner;

public class ExercicioUm {
    public void start(int opcao) {
        TestProgram iniciar = new TestProgram();
        Scanner teclado = new Scanner(System.in);

        if (opcao == 1) {
            System.out.print("Entre com a quantidade de nascimentos que gostaria de pesquisar: ");
            int quantidade = Integer.parseInt(teclado.nextLine());
            iniciar.printNames(quantidade);
        } else {
            System.out.print("Entre com o ano que gostaria de pesquisar: ");
            int year = Integer.parseInt(teclado.nextLine());
            iniciar.testTotalBirths(year);
        }
    }
}