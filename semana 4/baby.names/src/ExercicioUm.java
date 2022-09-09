import java.util.Scanner;

public class ExercicioUm {
    public void start(int opcao) {
        TestProgram iniciar = new TestProgram();
        Scanner teclado = new Scanner(System.in);

        if (opcao == 1) {
            System.out.print("Entre com a quantidade de nascimentos que gostaria de pesquisar: ");
            int quantidade = Integer.parseInt(teclado.nextLine());
            System.out.println("Selecione o arquivo que gostaria de pesquisar");
            iniciar.printNames(quantidade);
        } else {
            System.out.print("Entre com o ano que gostaria de pesquisar (1880-2014): ");
            int year = Integer.parseInt(teclado.nextLine());
            iniciar.testTotalBirths(year);
        }
    }
}