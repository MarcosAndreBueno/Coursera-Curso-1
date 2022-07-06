import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import edu.duke.DirectoryResource;

//---------------------------------------------------------------------------------------------
//  Exercício 1:-------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------
public class TestProgram {
    public void printNames (int quantidade) {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= quantidade) {
                System.out.println("Name " + rec.get(0) +
                        " Gender " + rec.get(1) +
                        " Num Born " + rec.get(2));
            }
        }
    }

    public int totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
            }
            else {
                totalGirls += numBorn;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
        return 0;
    }

    public void testTotalBirths (int year) {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource("csv_babynames/us_babynames_by_year/yob"+year+".csv");
        totalBirths(fr);
    }

//---------------------------------------------------------------------------------------------
//  Exercício 2:-------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------
    public int getRank(int year, String name, String gender) //transformado de void para int, para dar return para o método whatIsNameInYear
    {
        FileResource fr = new FileResource("csv_babynames/us_babynames_by_year/yob"+year+".csv");
        int count = 0;
        String toString = fr.asString();
        int thereIs = toString.indexOf(name);
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender))
            {
                count += 1;
                if (rec.get(0).equals(name) && rec.get(1).equals(gender)) {
                    {
                        return count;
                    }
                }
            }
        }
        if (thereIs < 0)
        {
            System.out.println("NAME NOT FOUND");
        }
        return 0;
    }

    public String getName(int year, int rank, String gender) //transformado de void para int, para dar return para o método whatIsNameInYear
    {
        FileResource fr = new FileResource("csv_babynames/us_babynames_by_year/yob"+year+".csv");
        int countCSV = 0;
        int count = 0;
        String actualGender = "";
        for (CSVRecord rec : fr.getCSVParser(false)) {
            actualGender = rec.get(1);
            if (actualGender.equals(gender))
            {
                countCSV += 1;
            }
        }
        if (rank > countCSV)
        {
            System.out.println("Rank is off limits");
        }
        for (CSVRecord rec : fr.getCSVParser(false)) {
            actualGender = rec.get(1);
            if (actualGender.equals(gender))
            {
                count += 1;
                if ((count == rank) && gender.equals(gender))
                {
                    String name = rec.get(0);
                    return name;
                }
            }
        }
        return "";
    }

    public void testRank(int year, String name, String gender)
    {
        int count = getRank(year, name, gender);
        System.out.println(name+" is the "+count+"º "+gender+" most popular name of the year "+year);
    }

    public void testName(int year, int rank, String gender)
    {
        String name = getName(year, rank, gender);
        System.out.println("The "+rank+"º "+gender+" most popular name of the year "+year+" is: "+name);
    }

    public void testWhatIsNameInYear(int year, String name, String gender, int newYear)
    {
        int count = getRank(year, name, gender);
        String newName = getName(newYear, count, gender);
        System.out.println(name+" born in "+year+" would be "+newName+" if was born in "+newYear);
    }

//---------------------------------------------------------------------------------------------
//  Exercício 3:-------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------

    public int getYearOfHighestRank(FileResource fr, int year, String name, String gender) //transformado de void para int, para dar return para o método whatIsNameInYear
    {
        int count = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender))
            {
                count += 1;
                if (rec.get(0).equals(name) && rec.get(1).equals(gender)) {
                    {
                        return count;
                    }
                }
            }
        }
        return 0;
    }

    public int getLesserYear (String name, String gender)
    {
        DirectoryResource dr = new DirectoryResource();
        int lesserYearSoFar = 0;
        int finalResult = 0;
        int year = 0;
        for (File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            int currentResult = getYearOfHighestRank(fr, year, name, gender);
            lesserYearSoFar = getLesserOfTwo(currentResult, lesserYearSoFar);
        }
        return lesserYearSoFar;
    }

    public String getLesserYearFile (String name, String gender)
    {
        DirectoryResource dr = new DirectoryResource();
        int lesserYearSoFar = 0;
        int year = 0;
        int toCheck1 = 0;
        int toCheck2 = 0;
        String fileName = "";
        for (File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            int currentResult = getYearOfHighestRank(fr, year, name, gender);
            toCheck1 = currentResult;
            toCheck2 = lesserYearSoFar;
            lesserYearSoFar = getLesserOfTwo(currentResult, lesserYearSoFar);
            if ((toCheck1 < toCheck2) || (toCheck2 ==0))
            {
                fileName = f.getName();
            }
        }
        return fileName;
    }

    public int getLesserOfTwo(int currentResult, int lesserYearSoFar)
    {
        if (lesserYearSoFar == 0) {
            lesserYearSoFar = currentResult;
        }
        if (currentResult < lesserYearSoFar)
        {
            //If so update lesserSoFar to currentRow
            lesserYearSoFar = currentResult;
        }
        return lesserYearSoFar;
    }

    public void testYearOfHighestRank (String name, String gender)
    {
        int rank = getLesserYear(name, gender);
        String fileName = getLesserYearFile(name, gender);
        System.out.println("O file onde "+name+" possuí maior rank ("+rank+"º) é: "+fileName);
    }

//---------------------------------------------------------------------------------------------
//  Exercício 4:-------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------

    public double getAvarageRank (String name, String gender)
    {
        DirectoryResource dr = new DirectoryResource();
        int finalRank = 0;
        double count = 0;
        double avarage = 0;
        for (File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            double currentResult = getRank2(fr, name, gender);
            finalRank += currentResult;
            if (currentResult > 0)
            {
                count += 1;
                avarage = finalRank/count;
            }
        }
        return avarage;
    }

    public int getRank2(FileResource fr, String name, String gender) //cópia do getRank modificado para trazer média
    {
        int count = 0;
        String toString = fr.asString();
        int thereIs = toString.indexOf(name);
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender))
            {
                count += 1;
                if (rec.get(0).equals(name) && rec.get(1).equals(gender)) {
                    {
                        return count;
                    }
                }
            }
        }
        if (thereIs < 0)
        {
            return -1;
        }
        return -1;
    }

    public void testAvarageRank(String name, String gender)
    {
        double count = getAvarageRank(name, gender);
        System.out.println("The avarage rank of the name "+name+" is: "+count);
    }

//---------------------------------------------------------------------------------------------
//  Exercício 5:-------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------

    public int totalBirthsOfHighers (FileResource fr, String name, String gender)
    { //método só um pouco modificado para procurar em nome e gênero específicos.
        int totalBirths = 0;
        int totalBorn = 0;
        int numBorn = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            numBorn = Integer.parseInt(rec.get(2));
            totalBirths = numBorn;
            if (rec.get(0).equals(name) && (rec.get(1).equals(gender)))
            {
                return totalBirths;
            }
        }
        return -1;
    }

    public int getTotalBirthsRankedHigher (String name, String gender)
    {
        DirectoryResource dr = new DirectoryResource();
        int count = 0;
        int currentValue = 0;
        int higher = 0;
        int totalBirths = 0;
        for (File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            currentValue = totalBirthsOfHighers(fr, name, gender);
            for (CSVRecord rec : fr.getCSVParser(false))
            {
                int numBorn = Integer.parseInt(rec.get(2));
                if ((numBorn > currentValue) && (rec.get(1).equals(gender)))
                {
                    totalBirths += numBorn;
                }
            }
        }
        return totalBirths;
    }

    public void testHigherRankedNames(int year, String name, String gender)
    {
        int total = getTotalBirthsRankedHigher(name, gender);
        System.out.println("O total de nascimentos acima ao rank de "+name+" são: "+total);
    }

}