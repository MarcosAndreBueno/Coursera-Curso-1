import edu.duke.*;
import java.io.*;

public class TestProgram {


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

    public int findLargestGene(String x, int where)
    {
        // add um "where" na linha de baixo e de cima.
        int startIndex = x.indexOf("atg", where);
        if (startIndex == -1)
        {
            return 0;
        }

        int taaIndex = findStopCodon(x,startIndex,"taa");
        int tagIndex = findStopCodon(x,startIndex,"tag");
        int tgaIndex = findStopCodon(x,startIndex,"tga");
    /*
    cancelaremos essa linha para agora aprender And e Or.
    int temp = Math.min(taaIndex,tagIndex);
    int minIndex = Math.min(temp, tgaIndex);
    */
        int maxIndex = 0;
        if (taaIndex == -1 ||
                (tgaIndex != -1 && tgaIndex > taaIndex))
        {
            maxIndex = tgaIndex;
        }
        else
        {
            maxIndex = taaIndex;
        }
        if (maxIndex == -1 ||
                (tagIndex != -1 && tagIndex > maxIndex))
        {
            maxIndex = tagIndex;
        }

// ou int minIndex = Math.min(taaIndex,Math.min(temp, tgaIndex));
// if (minIndex == dna.length()) cancelando pra aprender o And e Or
        if (maxIndex == -1)
        {
            return 0;
        }
        return maxIndex;
    }

    public int findStopCodon (String x, int startIndex, String stopCodon)
    {
        int currIndex = x.indexOf(stopCodon, startIndex+3);
        int tamanhoAtual = 0;
        int tamanhoAntigo = 0;
        int tamanhoFinal = 0;
        while (currIndex != -1)
        {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0)
            {
                tamanhoAtual = diff;
                tamanhoFinal = Math.max(tamanhoAtual, tamanhoAntigo);
                tamanhoAntigo = diff;
                currIndex = x.indexOf(stopCodon, currIndex+1);
            }
            else
            {
                currIndex = x.indexOf(stopCodon, currIndex+1);
            }
        }
//    return dna.length(); // EXCLUÍREMOS, POIS AGORA USAREMOS -1 COMO RETORNO PARA APRENDER AND E OR
        return tamanhoFinal;
    }

    public int findLongestGene (String x)
    {
        //esse método corresponde ao método findAllGenesMultipleResults
        int startIndex = 0;
        int count = 0;
        int tamanhoAtual = 0;
        int tamanhoAntigo = 0;
        int tamanhoFinal = 0;
        int dna = x.length();
        while (true)
        {
            int currentGene = findLargestGene(x, startIndex);
            if (currentGene == -1) //método do edu.duke, encontra se a String gene está vazia, ou seja, "";
            {
                break;
            }
            // startIndex abaixa fará o seguinte: pegará a posição do último Gene e encontrara seu tamanho. Esse tamanho dará o início do próximo currentGene.
            return currentGene;
        }
        return 0;
    }


    public int cgRatio(String dna)
    {
        int numb = 0;
        String c = "c";
        String g = "g";
        int start = 0;
        int cInd = dna.indexOf(c, start);
        int gInd = dna.indexOf(g, start);
        int count = 0;
        int tamanhoDna = dna.length();
        while (cInd != -1)
        {
            count = count+1;
            cInd = dna.indexOf(c, cInd+1);
        }
        if (cInd == -1 && count != 0)
        {
            float countF = count;
            float tamanhoF = tamanhoDna;
            float cRatio = countF/tamanhoF;
            System.out.println("A quantidade de c é: "+countF+" e o número de letras no dna é: "+tamanhoF);
            System.out.println("O ratio de c em dna é: "+cRatio+".");
        }
        count = 0;
        while (gInd != -1)
        {
            count = count+1;
            gInd = dna.indexOf(g, gInd+1);
        }
        if (cInd == -1 && count != 0)
        {
            float countF = count;
            float tamanhoF = tamanhoDna;
            float gRatio = countF/tamanhoF;
            System.out.println("A quantidade de g é: "+countF+" e o número de letras no dna é: "+tamanhoF);
            System.out.println("O ratio de g em dna é: "+gRatio+".");
        }
        return 0;
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
                System.out.println("Storage número: "+countM+" (dna: "+x+")");
                System.out.println("O tamanho do dna é: "+tamanhoDna+" e a quantidade de g é: "+count);
                System.out.println(           "O ratio de g é: "+gRatio);
            }
        }
        return 0;
    }

    public int cRatioOfGene(String y, int countM)
    {
        int numb = 0;
        String c = "c";
        int start = 0;
        int cInd = y.indexOf(c, start);
        int count = 0;
        int tamanhoDna = y.length();
//  countM: para ser usado naqueles maiores que o ratio for maior que 0.(algo).
        while (cInd != -1)
        {
            count = count+1;
            cInd = y.indexOf(c, cInd+1);
        }
        if (cInd == -1 && count != 0)
        {
            float countF = count;
            float tamanhoF = tamanhoDna;
            float cRatio = countF/tamanhoF;
            if (cRatio > 0.35)
            {
                return +1;
            }
        }
        return 0;
    }

    public int gRatioOfGene(String y, int countM)
    {
        int numb = 0;
        String g = "g";
        int start = 0;
        int gInd = y.indexOf(g, start);
        int count = 0;
        int tamanhoDna = y.length();
        while (gInd != -1)
        {
            count = count+1;
            gInd = y.indexOf(g, gInd+1);
        }
        if (gInd == -1 && count != 0)
        {
            float countF = count;
            float tamanhoF = tamanhoDna;
            float gRatio = countF/tamanhoF;
            if (gRatio > 0.35)
            {
                return +1;
            }
        }
        return 0;
    }


    public int countCTG(String dna)
    {
        int numb = 0;
        String c = "ctg";
        int start = 0;
        int cInd = dna.indexOf(c, start);
        int count = 0;
        int tamanhoDna = dna.length();
        if (cInd == -1)
        {
            System.out.println("nao ha ctg aqui");
        }
        while (cInd != -1)
        {
            count = count+1;
            cInd = dna.indexOf(c, cInd+1);
        }
        if (cInd == -1 && count != 0)
        {
            float countF = count;
            float tamanhoF = tamanhoDna;
            float cRatio = countF/tamanhoF;
            System.out.println("A quantidade de ctg é: "+countF+" e o número de letras no dna é: "+tamanhoF);
            System.out.println("O ratio de ctg em dna é: "+cRatio+".");
        }
        return 0;
    }

    public void testRealGenes()
    {
        FileResource fr2 = new FileResource("brca1line.fa");
        StorageResource sr2 = new StorageResource();
//        StorageResource sr = processRealGenes(dna);
        String dna = fr2.asString();
        dna = dna.toLowerCase();
        sr2.add(dna);
        processRealGenes(sr2);
    }

    public void testRealGenes2()
    {
        DirectoryResource dr = new DirectoryResource();
        StorageResource sr = new StorageResource();
        for (File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            String s = fr.asString();
            s = s.toLowerCase();
            sr.add(s);
            processRealGenes(sr);
        }
    }

    public int printAllGenes (String dna)
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
        return count;
    }

    public String findAllGenesMultipleResults(String dna, int where)
    {
        // add um "where" na linha de baixo e de cima.
        int startIndex = dna.indexOf("atg", where);
        if (startIndex == -1)
        {
            return "";
        }

        int taaIndex = findStopCodon2(dna,startIndex,"taa");
        int tagIndex = findStopCodon2(dna,startIndex,"tag");
        int tgaIndex = findStopCodon2(dna,startIndex,"tga");
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

    public int findStopCodon2 (String dna, int startIndex, String stopCodon)
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

    public StorageResource processRealGenes(StorageResource sr)
    {
        System.out.println("");
        System.out.println("---------!!!!!!!!!TESTANDO O PROCESS GENES---------------!!!!!!!!!");
        System.out.println("------------------------------------------------------------------");
        int count = 0;

        for (String x : sr.data())
        {
            int tamanho = x.length();
            count = count+1;
            if (tamanho > 9)
            {
                System.out.println("Storage número: "+count+": Dna maior que 9 letras:"+x);
                System.out.println("");
            }

        }
        System.out.println("CONFERINDO QUAL TEM O MAIOR GENE:");
        int tamanhoAtual = 0;
        int tamanhoAntigo = 0;
        int tamanhoFin = 0;
        int countL = 0;
        int contador = 0;
        for (String x : sr.data())
        {
            int tamanho = findLongestGene(x);
            tamanhoAtual = tamanho;
            tamanhoFin = Math.max(tamanhoAtual, tamanhoAntigo);
            countL = countL+1;
            if (tamanhoAtual > tamanhoAntigo)
            {
                contador = countL;
            }
            tamanhoAntigo = tamanhoAtual;
        }
        tamanhoFin = tamanhoFin + 3;
        System.out.println("Storage número: "+contador+": contém o maior GENE.");
        System.out.println("O GENE desse Storage contém "+tamanhoFin+" letras.");


        System.out.println("");
        System.out.println("            INICIANDO TESTE QUANDIDADE DE DNA COM RATIO MAIOR QUE 0.35");
        System.out.println("");
        count = 0;
        float cRatio = 0;
        int countM = 0;
        for (String x : sr.data())
        {
            countM = countM+1;
            cRatio = cgRatio2(x, countM);
        }

        System.out.println("");
        System.out.println("            INICIANDO TESTE QUANTIDADE DE GENES");
        System.out.println("");
        count = 0;
        contador = 0;
        int start = 0;
        for (String x : sr.data())
        {
            count = printAllGenes(x);
            contador = contador+count;
        }
        System.out.println("A quantidade de genes no DNA é de: "+contador);

        System.out.println("");
        System.out.println("    INICIANDO TESTE QUANTIDADE DE GENES COM RATIO C MAIOR QUE 0.35");
        System.out.println("");
        count = 0;
        contador = 0;
        for (String x : sr.data())
        {
            String currentGene = findAllGenesMultipleResults(x, start);
            int valor = currentGene.length();
            while (valor > 3)
            {
                if (currentGene.isEmpty()) //método do edu.duke, encontra se a String gene está vazia, ou seja, "";
                {
                    break;
                }
                count = cRatioOfGene(currentGene, 0);
                contador = contador+count;
                start = x.indexOf(currentGene, start) + currentGene.length();
                currentGene = findAllGenesMultipleResults(x, start);
                valor = currentGene.length();
            }
        }
        System.out.println(         "A quantidade de gene com C Ratio maior que 0.35 são: "+contador);

        System.out.println("");
        System.out.println("    INICIANDO TESTE QUANTIDADE DE GENES COM RATIO G MAIOR QUE 0.35");
        System.out.println("");
        count = 0;
        contador = 0;
        for (String x : sr.data())
        {
            String currentGene = findAllGenesMultipleResults(x, start);
            int valor = currentGene.length();
            while (valor > 3)
            {
                if (currentGene.isEmpty()) //método do edu.duke, encontra se a String gene está vazia, ou seja, "";
                {
                    break;
                }
                count = gRatioOfGene(currentGene, 0);
                contador = contador+count;
                start = x.indexOf(currentGene, start) + currentGene.length();
                currentGene = findAllGenesMultipleResults(x, start);
                valor = currentGene.length();
            }
        }
        System.out.println(         "A quantidade de gene com G Ratio maior que 0.35 são: "+contador);


        System.out.println("------------------------------------------------------------------");
        System.out.println("----------!!!!!!!!!FINALIZANDO PROCESS GENES-------------!!!!!!!!!");
        return sr;
    }

    public void processGenesAlreadyCreatedFiles()
    {
        System.out.println("");
        System.out.println("---------!!!!!!!!!TESTANDO O PROCESS GENES---------------!!!!!!!!!");

        StorageResource sr = new StorageResource();

        //          0  3  6  9  v  v  v  v  v  v  v
        String a = "atgtttggg";
        //          0  3  6  9  v  v  v  v  v  v  v
        String b = "atgtttgggaaataa";
        //          0  3  6  9  v  v  v  v  v  v  v
        String c = "atgtttgggaaatttgggtag";
        //          0  3  6  9  v  v  v  v  v  v  v
        String d = "atgtttgggaaatttgggtttgggaaataa";
        //          0  3  6  9  v  v  v  v  v  v  v
        String e = "atgttt";
        //          0  3  6  9  v  v  v  v  v  v  v
        String f = "atgtttgggaaattttagaaaatgtttgggtaa";
        //          0  3  6  9  v  v  v  v  v  v  v
        String g = "atgtttgggaaatttgggaaatttgggaaatag";

        sr.add(a);
        sr.add(b);
        sr.add(c);
        sr.add(d);
        sr.add(e);
        sr.add(f);
        sr.add(g);

        int count = 0;
        for (String x : sr.data())
        {
            int tamanho = x.length();
            count = count+1;
            if (tamanho > 9)
            {
                System.out.println("Storage número: "+count+": Dna maior que 9 letras:"+x);
                System.out.println("");
            }

        }
        System.out.println("CONFERINDO QUAL TEM A MAIOR QUANTIDADE DE GENES:");
        int tamanhoAtual = 0;
        int tamanhoAntigo = 0;
        int tamanhoFin = 0;
        int countL = 0;
        int contador = 0;
        for (String x : sr.data())
        {
            int tamanho = findLongestGene(x);
            tamanhoAtual = tamanho;
            tamanhoFin = Math.max(tamanhoAtual, tamanhoAntigo);
            countL = countL+1;
            if (tamanhoAtual > tamanhoAntigo)
            {
                contador = countL;
            }
            tamanhoAntigo = tamanho;
        }
        tamanhoFin = tamanhoFin + 3;
        System.out.println("Storage número: "+contador+": contém o maior GENEs.");
        System.out.println("O GENE desse Storage contém "+tamanhoFin+" letras.");


        System.out.println("");
        System.out.println("            INICIANDO TESTE COM RATIO MAIOR QUE VALOR DADO");
        System.out.println("");
        count = 0;
        float cRatio = 0;
        int countM = 0;
        for (String x : sr.data())
        {
            countM = countM+1;
            cRatio = cgRatio2(x, countM);
        }
        System.out.println("");
        System.out.println("            INICIANDO TESTE COM RATIO MAIOR QUE VALOR DADO");
        System.out.println("");
        for (String x : sr.data())
        {
            printAllGenes(x);
        }

        System.out.println("----------!!!!!!!!!FINALIZANDO PROCESS GENES-------------!!!!!!!!!");
    }
}

