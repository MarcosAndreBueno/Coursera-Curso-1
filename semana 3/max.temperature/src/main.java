import edu.duke.FileResource;

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
            System.out.println("Selecione o arquivo que gostaria de pesquisar");
            iniciar.testHottestInDay();

        }
        if (opcao == 2) {
            System.out.println("Selecione os arquivos que gostaria de pesquisar");
            iniciar.testHottestInManyDays();
        }
    }
}
