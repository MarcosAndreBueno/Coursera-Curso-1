import edu.duke.*;
import java.io.*;

public class TestProgram2 {
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

    public float cgRatio2(String x, int countM)
    {
        int numb = 0;
        String c = "c";
        String g = "g";
        int start = 0;
        int cInd = x.indexOf(c, start);
        int gInd = x.indexOf(g, start);
        int count = 0;
        int tamanhoDna = x.length();
//  countM: para ser usado naqueles maiores que o ratio for maior que 0.(algo).
        while (cInd != -1)
        {
            count = count+1;
            cInd = x.indexOf(c, cInd+1);
        }
        if (cInd == -1 && count != 0)
        {
            float countF = count;
            float tamanhoF = tamanhoDna;
            float cRatio = countF/tamanhoF;
            if (cRatio > 0.35)
            {
                System.out.println("Storage número: "+countM+" (dna: "+x+")");
                System.out.println("O tamanho do dna é: "+tamanhoDna+" e a quantidade de c é: "+count);
                System.out.println(         "O ratio de c é: "+cRatio);
            }
        }
        count = 0;
        while (gInd != -1)
        {
            count = count+1;
            gInd = x.indexOf(g, gInd+1);
        }
        if (cInd == -1 && count != 0)
        {
            float countF = count;
            float tamanhoF = tamanhoDna;
            float gRatio = countF/tamanhoF;
            if (gRatio > 0.35)
            {
                System.out.println("Storage número: "+countM+" (dna: "+x);
                System.out.println("O tamanho do dna é: "+tamanhoDna+" e a quantidade de g é: "+count);
                System.out.println(           "O ratio de g é: "+gRatio);
            }
        }
        return 0;
    }

    public void testRealGenes()
    {
//pergunta 1
        FileResource fr2 = new FileResource("brca1line.fa");
        StorageResource sr2 = new StorageResource();
//        StorageResource sr = processRealGenes(dna);
        String dna = fr2.asString();
        dna.toUpperCase();
        sr2.add(dna);
//pergunta 2
        printAllGenes(dna);
//pergunta 3
        System.out.println("            INICIANDO TESTE COM RATIO MAIOR QUE VALOR DADO");
        System.out.println("");
        int count = 0;
        float cRatio = 0;
        int countM = 0;
        for (String x : sr2.data())
        {
            countM = countM+1;
            cRatio = cgRatio2(x, countM);
        }

    }

    public void testRealGenes2()
    {
        DirectoryResource dr = new DirectoryResource();
        StorageResource sr = new StorageResource();
        int count = 0;
        for (File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            String dna = fr.asString();
            dna.toUpperCase();
            sr.add(dna);
            printAllGenes(dna);
        }
    }

}

