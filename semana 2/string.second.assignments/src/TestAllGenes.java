import edu.duke.*;
import java.io.*;

public class TestAllGenes {
        public String howMany(String a, String dna)
        {
            int startIndex = 0;
            int count = 0;

            a = "taa";
            int currIndex = dna.indexOf(a, startIndex);
            while (currIndex != -1)
            {
                count = count+1;
                currIndex = dna.indexOf(a, currIndex+1);
            }
            System.out.println("O número de ocorrências com " + a + " são : "+count+".");
            a = "tag";
            currIndex = dna.indexOf(a, startIndex);
            count = 0;
            while (currIndex != -1)
            {
                if (currIndex != -1)
                {
                    count = count+1;
                    currIndex = dna.indexOf(a, currIndex+1);
                }
            }
            System.out.println("O número de ocorrências com " + a + " são : "+count + ".");
            a = "tga";
            currIndex = dna.indexOf(a, startIndex);
            count = 0;
            while (currIndex != -1)
            {
                if (currIndex != -1)
                {
                    count = count+1;
                    currIndex = dna.indexOf(a, currIndex+1);
                }
            }
            System.out.println("O número de ocorrências com " + a + " são : "+count+".");
            return "";
        }


        public String findAllGenesMultipleResults(String dna, int where)
        {
            // add um "where" na linha de baixo e de cima.
            int startIndex = dna.indexOf("atg", where);
            if (startIndex == -1)
            {
                return "";
            }

            int taaIndex = findStopCodon(dna,startIndex,"taa");
            int tagIndex = findStopCodon(dna,startIndex,"tag");
            int tgaIndex = findStopCodon(dna,startIndex,"tga");
    /*
    cancelaremos essa linha para agora aprender And e Or.
    int temp = Math.min(taaIndex,tagIndex);
    int minIndex = Math.min(temp, tgaIndex);
    */
            int minIndex = 0;
            if (taaIndex == -1 ||
                    (tgaIndex != -1 && tgaIndex < taaIndex))
            {
                minIndex = tgaIndex;
            }
            else
            {
                minIndex = taaIndex;
            }
            if (minIndex == -1 ||
                    (tagIndex != -1 && tagIndex < minIndex))
            {
                minIndex = tagIndex;
            }

// ou int minIndex = Math.min(taaIndex,Math.min(temp, tgaIndex));
// if (minIndex == dna.length()) cancelando pra aprender o And e Or
            if (minIndex == -1)
            {
                return "";
            }
            return dna.substring(startIndex, minIndex +3);
        }

        public int findStopCodon (String dna, int startIndex, String stopCodon)
        {
            int currIndex = dna.indexOf(stopCodon, startIndex+3);
            while (currIndex != -1)
            {
                int diff = currIndex - startIndex;
                if (diff % 3 == 0)
                {
                    return currIndex;
                }
                else
                {
                    currIndex = dna.indexOf(stopCodon, currIndex+1);
                }
            }
//    return dna.length(); // EXCLUÍREMOS, POIS AGORA USAREMOS -1 COMO RETORNO PARA APRENDER AND E OR
            return -1;
        }

        public void printAllGenes (String dna)
        {
            //esse método corresponde ao método findAllGenesMultipleResults
            int startIndex = 0;
            int count = 0;
            while (true)
            {
                String currentGene = findAllGenesMultipleResults(dna, startIndex);
                if (currentGene.isEmpty()) //método do edu.duke, encontra se a String gene está vazia, ou seja, "";
                {
                    break;
                }
                count = count+1;
                // startIndex abaixa fará o seguinte: pegará a posição do último Gene e encontrara seu tamanho. Esse tamanho dará o início do próximo currentGene.
                startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
            }
            System.out.println("O número de genes no Dna é de : "+count+".");
        }

        public StorageResource getAllGenes(String dna)
        {
            //Guardando os resultados dos genes
            StorageResource geneList = new StorageResource();

            int startIndex = 0;
            int count = 0;
            while (true)
            {
                String currentGene = findAllGenesMultipleResults(dna, startIndex);
                if (currentGene.isEmpty())
                {
                    break;
                }
                geneList.add(currentGene);
                startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
            }
            return geneList;
        }

        public void testOn(String dna)
        {
            System.out.println("Testing getAllGenes on: ");
            StorageResource genes = getAllGenes(dna);
            for (String g : genes.data())
            {
                System.out.println(g);
            }
        }

        public void testAllGenesMultipleResults()
        {
            System.out.println("TEST START: ");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            String dna = "aatgcgtaattaaatgtaagtagatagttga";
            System.out.println("O dna é: " + dna);

            String a = "taa";
            String ocorrências = howMany(a, dna);
            printAllGenes(dna);
            testOn(dna);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            dna = "ttaagtacgtaacttcg";
            System.out.println("O dna é: " + dna);
            ocorrências = howMany(a, dna);
            printAllGenes(dna);
            testOn(dna);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            dna = "actcatacggctgctatctgacgcatgctgactatacgctgcaaatta";
            System.out.println("O dna é: " + dna);
            ocorrências = howMany(a, dna);
            printAllGenes(dna);
            testOn(dna);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            dna = "atatgagatgagatgatgaatgatggatgatgatggattaa";
            System.out.println("O dna é: " + dna);
            ocorrências = howMany(a, dna);
            printAllGenes(dna);
            testOn(dna);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            dna = "cagcgatgcatcgagctagcatacagttaagcatgagccgatgactatgcat";
            System.out.println("O dna é: " + dna);
            ocorrências = howMany(a, dna);
            printAllGenes(dna);
            testOn(dna);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            System.out.println("TEST FINISHED.");
        }
    }
