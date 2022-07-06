import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        TestProgram iniciar = new TestProgram();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite uma opção: \n" +
                            "Opção 1: testHottestInDay \n"+
                            "Opção 2: testHottestInManyDays \n"
                            );
        int opcao = Integer.parseInt(teclado.nextLine());

        if (opcao == 1) {
            iniciar.testHottestInDay();
        }
        if (opcao == 2) {
            iniciar.testHottestInManyDays();
        }
    }
}
