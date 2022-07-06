
public class Program{
public String findSimpleGene(String dna, int start, int stop) {
        dna = dna.toUpperCase();
        String result = "";
        if (start == -1) // No atg
        {
        return "";
        }

        if (stop == -1) {
        return ""; //no taa
        }
        if ((stop - start) % 3 == 0) //substrin not multiple of 3.
        {
        //substring começa no atg e para um antes do taa + 3.

        }
        return dna.substring(start, stop + 3);
        }

public int count(String a, String b) {
        String result = "";
        int quantidadeFin = 0;
        int indiceIn = 0;
        while (indiceIn != -1) {
        int indiceAt = b.indexOf(a, indiceIn);
        if (indiceAt < 0) {
        break;
        }
        if (indiceAt >= 0) {
        indiceIn = indiceIn + 1;
        quantidadeFin = quantidadeFin + 1;
        }
        }
        return quantidadeFin;
        }

public boolean repeteDuasOuMaisVezes(String a, String b) {
        int quantidade = count(a, b);
        boolean result = false;
        if (quantidade < 2) {
        result = false;
        }
        if (quantidade >= 2) {
        result = true;
        }
        return result;
        }

public String lastPart(String a, String b) {
        String result = "";
        int last = b.indexOf(a);
        int size = b.length();
        int rest = size + 1 - last; //4
        int sobra = 0;
        while (sobra != -1) {
        if (last >= 1) {
        if (rest >= 1) {   // dava pra ter feito assim: String atual = b.substring(last+a.length())
        String atual = b.substring(last - 1, last); //1- n, 2- a, 3- n, 4- a.
        sobra = sobra + 1;
        last = last + 1;
        rest = size - last;
        }
        if (rest <= 0) {
        break;
        }
        }

        if (last == 0) {
        if (rest >= 2) {
        String atual = b.substring(last, last + 1); //0- a 1- n, 2- a, 3- n, 4- a.
        sobra = sobra + 1; // 0, 1, 2, 3 , 4
        last = last + 1; // 0: 1-a, 2-n, 3-a, 4-n
        rest = size - last;
        }
        if (rest == 1) {
        String atual = b.substring(last - 1, last); //4-n: 5-a.
        sobra = sobra + 1;
        last = last + 1; //4-n: 5-a.
        rest = size - last;
        }
        if (rest <= 0) {
        break;
        }
        }
        }
        last = b.indexOf(a);
        if (last < 0) {
        result = b;
        }
        if (last == 0) {
        result = b.substring(last + 1, last + sobra);
        }
        if (last > 0) {
        result = b.substring(last + 1, last + sobra);
        }
        return result;
        }

public void testSimpleGene() {
        System.out.println("Exercício 2 : ");
        String dna = "atggggtttaaataataatag";
        System.out.println("A string é: " + dna);
        int start = dna.indexOf("atg");
        int stop = dna.indexOf("taa", start + 3);
        String gene = findSimpleGene(dna, start, stop);
        System.out.println("O dna é: " + gene);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        //Part 3
        String a = "a";
        String b = "banana";
        boolean repetições = repeteDuasOuMaisVezes(a, b);
        System.out.println("A string " + b + " repete a letra " + a + " mais de 2 vezes?"+" R. " + repetições);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        //Part 4
        String substring = lastPart(a, b);
        System.out.println("A parte correspondente de a em b é : " + substring);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");



        dna = "ttaagtacgtaacttcg";
        start = dna.indexOf("atg");
        stop = dna.indexOf("taa", start + 3);
        gene = findSimpleGene(dna, start, stop);
        System.out.println("O dna é: " + dna);
        System.out.println("A string do gene é: " + gene);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        dna = "actcatacggctgctatctgacgcatgctgactatacgctgcaaatta";
        start = dna.indexOf("atg");
        stop = dna.indexOf("taa", start + 3);
        gene = findSimpleGene(dna, start, stop);
        System.out.println("O dna é: " + dna);
        System.out.println("A string do gene é: " + gene);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        dna = "atatgagatgagatgatgaatgatggatgatgatggattaa";
        start = dna.indexOf("atg");
        stop = dna.indexOf("taa", start + 3);
        gene = findSimpleGene(dna, start, stop);
        System.out.println("O dna é: " + dna);
        System.out.println("A string do gene é: " + gene);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        dna = "cagcgatgcatcgagctagcatacagttaagcatgagccgatgactatgcat";
        start = dna.indexOf("atg");
        stop = dna.indexOf("taa", start + 3);
        gene = findSimpleGene(dna, start, stop);
        System.out.println("O dna é: " + dna);
        System.out.println("A string do gene é: " + gene);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
}