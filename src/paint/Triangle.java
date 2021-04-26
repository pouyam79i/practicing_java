/**
 * Triangle Class
 * @author Pouya Mohammadi - CE@AUT Uni ID: 9829039
 */

public class Triangle extends Polygon{

    /**
     * Constructor of Triangle
     * @param args contains intput values
     */
    public Triangle (Double... args){
        super(args);
        if(args.length > 3)
            System.out.println("Only the first three sides will be adjusted!");
        if(args.length < 3) {
            System.out.println("You must add more sides \n Number of sides must be 3");
            while (getSides().size() < 3)
                addSide(1);
        }
    }

    /**
     * Checks if it is equilateral
     * @return true if it is isEquilateral
     */
    public boolean isEquilateral(){
        return getSides().get(0).equals(getSides().get(1))
                &&
                getSides().get(0).equals(getSides().get(2));
    }

    /**
     * Calculates the area
     * @return area
     */
    @Override
    public double calculateArea(){
        double area = 0;
        // Heron's formula
        area = calculatePerimeter() / 2;
        area *= calculatePerimeter() / 2 - getSides().get(0);
        area *= calculatePerimeter() / 2 - getSides().get(1);
        area *= calculatePerimeter() / 2 - getSides().get(2);
        area = Math.sqrt(area);
        return area;
    }

}
