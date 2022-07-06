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
            iniciar.testColdestInDay();
        }
        if (opcao == 2){
            iniciar.testNameFileColdest();
        }
        if (opcao == 3){
            iniciar.testColdestInManyDays();
        }
        if (opcao == 4){
            iniciar.testAvarageTemperatureInFile();
        }
        if (opcao == 5){
            iniciar.testAverageTemperatureWithHighHumidityInFile();
        }
        if (opcao == 6){
            iniciar.testNameFileLesserHumidity();
        }
        if (opcao == 7){
            iniciar.testlesserHumidityInManyFile();
        }
    }
}
