import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class TestProgram {

    //part 1 ---------------------------------------------------------------------------------------
    public CSVRecord coldestHourInFile(CSVParser parser) {
        //start with lesserSoFar as nothing
        CSVRecord lesserSoFar = null;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
            // use method to compare two records
            lesserSoFar = getLesserOfTwo(currentRow, lesserSoFar);
        }
        //The lesserSoFar is the answer
        return lesserSoFar;
    }

    public void testColdestInDay () {
        FileResource fr = new FileResource();
        CSVRecord largest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + largest.get("TemperatureF") +
                " at ");
    }

    public CSVRecord coldestInManyDays() {
        CSVRecord lesserSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            // use method to compare two records
            lesserSoFar = getLesserOfTwo(currentRow, lesserSoFar);
        }
        //The lesserSoFar is the answer
        return lesserSoFar;
    }

    public CSVRecord getLesserOfTwo (CSVRecord currentRow, CSVRecord lesserSoFar) {
        //If lesserSoFar is nothing
        if (lesserSoFar == null) {
            lesserSoFar = currentRow;
        }
        //Otherwise
        else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double lesserTemp = Double.parseDouble(lesserSoFar.get("TemperatureF"));
            //Check if currentRow’s temperature > lesserSoFar’s
            if ((currentTemp < lesserTemp) && (currentTemp != -9999)) {
                //If so update lesserSoFar to currentRow
                lesserSoFar = currentRow;
            }
        }
        return lesserSoFar;
    }

    public void testColdestInManyDays () {
        CSVRecord lesser = coldestInManyDays();
        System.out.println("coldest temperature was " + lesser.get("TemperatureF") +
                " at " + lesser.get("DateUTC"));
    }


    //part 2 ---------------------------------------------------------------------------------------
    public String fileWithColdestTemperature ()
    {
        CSVRecord lesserSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        String fileName = "error";
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            // use method to compare two records
            if (lesserSoFar == null) {
                lesserSoFar = currentRow;
                fileName = f.getName();
            }
            //Otherwise
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double lesserTemp = Double.parseDouble(lesserSoFar.get("TemperatureF"));
                //Check if currentRow’s temperature > lesserSoFar’s
                if ((currentTemp < lesserTemp) && (currentTemp != -9999)) {
                    //If so update lesserSoFar to currentRow
                    lesserSoFar = currentRow;
                    fileName = f.getName();
                }
            }
        }
        //The lesserSoFar is the answer
        return fileName;
    }

    public void testNameFileColdest()
    {
        String fileName = fileWithColdestTemperature();
        System.out.println("File com hora mais fria: "+fileName);
    }


    //part 3 ---------------------------------------------------------------------------------------
    public CSVRecord lesserHumidityHourInFile(CSVParser parser) {
        //start with lesserSoFar as nothing
        CSVRecord lesserSoFar = null;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
            // use method to compare two records
            lesserSoFar = getLesserHumidityOfTwo(currentRow, lesserSoFar);
        }
        //The lesserSoFar is the answer
        return lesserSoFar;
    }

    public CSVRecord getLesserHumidityOfTwo (CSVRecord currentRow, CSVRecord lesserSoFar) {
        //If lesserSoFar is nothing
        if (lesserSoFar == null) {
            lesserSoFar = currentRow;
        }
        //Otherwise
        else {
            double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
            double lesserTemp = Double.parseDouble(lesserSoFar.get("Humidity"));
            if (currentTemp < lesserTemp) {
                //If so update lesserSoFar to currentRow
                lesserSoFar = currentRow;
            }
        }
        return lesserSoFar;
    }

    public CSVRecord LesserHumidityInManyDays() {
        CSVRecord lesserSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = lesserHumidityHourInFile(fr.getCSVParser());
            // use method to compare two records
            lesserSoFar = getLesserHumidityOfTwo(currentRow, lesserSoFar);
        }
        //The lesserSoFar is the answer
        return lesserSoFar;
    }

    public void testlesserHumidityInManyFile ()
    {
        CSVRecord lesser = LesserHumidityInManyDays();
        System.out.println("lesser humidity was " + lesser.get("Humidity") +
                " at "+lesser.get("DateUTC"));
    }

    public String fileWithLesserHumidityTemperature ()
    {
        CSVRecord lesserSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        String fileName = "error";
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = lesserHumidityHourInFile(fr.getCSVParser());
            // use method to compare two records
            if (lesserSoFar == null) {
                lesserSoFar = currentRow;
                fileName = f.getName();
            }
            //Otherwise
            else {
                double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                double lesserTemp = Double.parseDouble(lesserSoFar.get("Humidity"));
                //Check if currentRow’s temperature > lesserSoFar’s
                if ((currentTemp < lesserTemp) && (currentTemp != -9999)) {
                    //If so update lesserSoFar to currentRow
                    lesserSoFar = currentRow;
                    fileName = f.getName();
                }
            }
        }
        //The lesserSoFar is the answer
        return fileName;
    }

    public void testNameFileLesserHumidity()
    {
        String fileName = fileWithLesserHumidityTemperature();
        System.out.println("File com hora menos humida: "+fileName);
    }

    //part 4 ---------------------------------------------------------------------------------------
    public CSVRecord AvarageTemperatureFHourInFile(CSVParser parser) {
        //start with lesserSoFar as nothing
        CSVRecord lesserSoFar = null;
        double finalHumid = 0;
        int count = 0;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
            // use method to compare two records
            double currentHumid = Double.parseDouble(currentRow.get("TemperatureF"));
            finalHumid = currentHumid+finalHumid;
            count = count+1;
        }
        finalHumid = finalHumid/count;
        System.out.println("Avarage humidity: "+finalHumid);
        //The lesserSoFar is the answer
        return lesserSoFar;
    }

    public void testAvarageTemperatureInFile()
    {
        FileResource fr = new FileResource();
        CSVRecord largest = AvarageTemperatureFHourInFile(fr.getCSVParser());
    }


    //part 5 ---------------------------------------------------------------------------------------
    public CSVRecord averageTemperatureWithHighHumidityInFile(CSVParser parser) {
        //start with lesserSoFar as nothing
        CSVRecord lesserSoFar = null;
        double finalHumid = 0;
        int count = 0;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentHum : parser)
        {
            double currentHumD = Double.parseDouble(currentHum.get("Humidity"));
            if (currentHumD >= 80)
            {
                double currentHumid = Double.parseDouble(currentHum.get("TemperatureF"));
                finalHumid = currentHumid+finalHumid;
                count = count+1;
            }
        }
        if (finalHumid == 0)
        {
            System.out.println("Avarage temperaturF when humidity >= 80: "+" No temperatures with that humidity");
        }
        finalHumid = finalHumid/count;
        if (finalHumid >= 1)
        {
            System.out.println("Avarage temperaturF when humidity >= 80: "+finalHumid);
        }
        //The lesserSoFar is the answer
        return lesserSoFar;
    }

    public void testAverageTemperatureWithHighHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVRecord largest = averageTemperatureWithHighHumidityInFile(fr.getCSVParser());
    }
}
