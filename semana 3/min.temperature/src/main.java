import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        TestProgram iniciar = new TestProgram();
        System.out.println("Digite uma opção: \n"+
                        "opção 1: testColdestInDay (1 file)\n"+
                        "opção 2: testNameFileColdest (Many files)\n"+
                        "opção 3: testColdestInManyDays (Many files)\n"+
                        "opção 4: testAvarageTemperatureInFile (1 file)\n"+
                        "opção 5: testAverageTemperatureWithHighHumidityInFile (1 file)\n"+
                        "opção 6: testNameFileLesserHumidity (Many files)\n"+
                        "opção 7: testlesserHumidityInManyFile (Many files)\n"
                        );
        Scanner teclado = new Scanner(System.in);
        int opcao = Integer.parseInt(teclado.nextLine());

        if (opcao == 1){
            System.out.println("Selecione o arquivo que gostaria de pesquisar");
            iniciar.testColdestInDay();
        }
        if (opcao == 2){
            System.out.println("Selecione os arquivos que gostaria de pesquisar");
            iniciar.testNameFileColdest();
        }
        if (opcao == 3){
            System.out.println("Selecione os arquivos que gostaria de pesquisar");
            iniciar.testColdestInManyDays();
        }
        if (opcao == 4){
            System.out.println("Selecione o arquivo que gostaria de pesquisar");
            iniciar.testAvarageTemperatureInFile();
        }
        if (opcao == 5){
            System.out.println("Selecione o arquivo que gostaria de pesquisar");
            iniciar.testAverageTemperatureWithHighHumidityInFile();
        }
        if (opcao == 6){
            System.out.println("Selecione os arquivos que gostaria de pesquisar");
            iniciar.testNameFileLesserHumidity();
        }
        if (opcao == 7){
            System.out.println("Selecione os arquivos que gostaria de pesquisar");
            iniciar.testlesserHumidityInManyFile();
        }
    }
}
