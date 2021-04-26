/**
 * Circle Class
 * @author Pouya Mohammadi - CE@AUT Uni ID: 9829039
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Circle extends Shape{

    /**
     * Value of radius
     */
    private double radius;

    /**
     * Constructor of Circle, it take the radius value
     * @param radius will be set
     */
    public Circle(double radius){
        this.radius = radius;
        setHasRadius(true);
    }

    /**
     * Checks if the two circle is equal
     * @param args of the other shape
     * @return true if they are equal, else false
     */
    @Override
    public boolean equals(Double... args){
        ArrayList<Double> radius = new ArrayList<>(Arrays.asList(args));
        return radius.equals(radius.get(0));
    }

    /**
     * Calculate perimeter of shape
     * @return perimeter
     */
    @Override
    public double calculatePerimeter(){
        return radius * 2 * 3.14;
    }

    /**
     * Calculate area of shape
     * @return the area
     */
    @Override
    public double calculateArea(){
        return 3.14 * radius * radius;
    }

    /**
     * prints the information of circle
     * @return radius of circle
     */
    @Override
    public String toString(){
        return "Circle - Raduis: " + radius;
    }

    // Getter
    double getRadius(){
        return radius;
    }

}
