import edu.duke.*;
import java.io.File;

public class TestProgram {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        // Por algum motivo isso não funciona: int shapeIntOne = (int) length; - ou -: int shapeIntOne = (int) TotalPerim;
        // Acho que eu poderia: int shapeInt = (int) getPerimeter(s); - mas o exercício pede o loop inteiro em integral.
        int totalPoints = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            int adding = +1;
            totalPoints = totalPoints + adding;

        }
        return totalPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        int totalPoints = 0;
        Point prevPt2 = s.getLastPoint();
        for (Point currPt2 : s.getPoints()) {
            int adding = +1;
            totalPoints = totalPoints + adding;

        }

        return totalPerim / totalPoints;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largeDist = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(currDist > largeDist) {
                largeDist = currDist;
            } else {
                if(currDist < largeDist) {
                    largeDist = largeDist;
                }
            }

        }
        return largeDist;

    }

    public double getLargestX(Shape s) {
        // Put code here
        double largest = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            if(currPt.getX() > largest) {
                largest = currPt.getX();
            } else {
                if(currPt.getX() < largest) {
                    largest = largest;
                }
            }
        }
        return largest;

    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double totalPerim = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerimeter = getPerimeter(s);
            if (currPerimeter > totalPerim) {
                totalPerim = currPerimeter;
            } else {
                if (currPerimeter < totalPerim) {
                    totalPerim = totalPerim;
                }
            }

        }
        return totalPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        String name = "Resultados de uma forma apenas: ";
        double length = getPerimeter(s);
        int points = getNumPoints(s);
        double avarage = getAverageLength(s);
        double largest = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println(name);
        System.out.println("perimeter = " + length);
        System.out.println("o número de pontos é = " + points);
        System.out.println("a média da distância é = " + avarage);
        System.out.println("a maior distância é = " + largest);
        System.out.println("o maior valor do eixo x é = " + largestX);
    }

    public void testPerimeterMultipleFiles() {
        // Put code here
        // Tem dois jeitos de resolver. 1 é criar um método duplicado para 2 arquivos:
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        Shape s2 = new Shape(fr);
        String nameFirstMet = "Resultados da primeira forma de se resolver : ";
        String name1 = ("Resultados MÚLTIPLOS: forma 1 : ");
        String name2 = ("Resultados MÚLTIPLOS: forma 2 : ");
        String name3 = "Maneira certa de resolver o exercício";
        double length = getPerimeter(s);
        double length2 = getPerimeter(s2);
        int points = getNumPoints(s);
        int points2 = getNumPoints(s2);
        double avarage = getAverageLength(s);
        double avarage2 = getAverageLength(s2);
        double largest = getLargestSide(s);
        double largest2 = getLargestSide(s2);
        double largestX = getLargestX(s);
        double largestX2 = getLargestX(s2);

        // Maneira certa de resolver o exercício:
        double largestmultperim = getLargestPerimeterMultipleFiles();

        System.out.println(nameFirstMet);
        System.out.println(name1);
        System.out.println("perimeter 1 = " + length);
        System.out.println("Forma 1: o número de pontos é = " + points);
        System.out.println("Forma 1: a média da distância é = " + avarage);
        System.out.println("Forma 1: a maior distância é = " + largest);
        System.out.println("Forma 1: o maior valor do eixo x é = " + largestX);
        System.out.println(name2);
        System.out.println("perimeter 2 = " + length2);
        System.out.println("Forma 2: o número de pontos é = " + points2);
        System.out.println("Forma 2: a média da distância é = " + avarage2);
        System.out.println("Forma 2: a maior distância é = " + largest2 );
        System.out.println("Forma 2: o maior valor do eixo x é = " + largestX2);
        // Printando o resultado da segunda maneira de resolver o exercício:
        System.out.println(name3);
        System.out.println("O maior perímetro dos múltiplos perímetros é = " + largestmultperim);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        String name = ("Resultados forma triangle: ");
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        int periTriangle= getNumPoints(triangle);
        double avarageTriangle = getAverageLength(triangle);
        double largeTriangleDist = getLargestSide(triangle);
        double largeTriangleX = getLargestX(triangle);
        System.out.println("perimeter = " + peri);
        System.out.println("número de pontos = " + periTriangle);
        System.out.println("a média da distância é = " + avarageTriangle);
        System.out.println("a maior distância é = " + largeTriangleDist);
        System.out.println("o maior valor no eixo x é = " + largeTriangleX);
    }

    public void square(){
        //criei para tentar executar o programa.
        Shape square = new Shape();
        String name = ("Resultados forma square : ");
        square.addPoint(new Point(-1, 3));
        square.addPoint(new Point(-1, -1));
        square.addPoint(new Point(4, -1));
        square.addPoint(new Point(1, 3));
        for (Point p : square.getPoints()){
            System.out.println(p);
        }
        double periSquare = getPerimeter(square);
        int pointsSquare = getNumPoints(square);
        double avarageSquare = getAverageLength(square);
        double largeSquareDist = getLargestSide(square);
        double largeSquareX = getLargestX(square);
        System.out.println("perimeter = "+periSquare);
        System.out.println("quantidade de pontos = "+pointsSquare);
        System.out.println("a média da distância é = " + avarageSquare);
        System.out.println("a maior distância é = " + largeSquareDist);
        System.out.println("o maior valor do eixo x é = " + largeSquareX);
    }


    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }
}
