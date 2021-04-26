/**
 * Polygon Class
 * @author Pouya Mohammadi - CE@AUT Uni ID: 9829039
 */

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Polygon extends Shape{

    /**
     * List of sides value
     */
    private ArrayList<Double> sides;

    /**
     * Constructor of Polygon
     */
    public Polygon(Double... args){
        sides = new ArrayList<Double>(Arrays.asList(args));
        setHasRadius(false);
    }

    /**
     * Adds a new side to the polygon
     * @param newSide will be added
     */
    public void addSide(double newSide){
        sides.add(newSide);
    }

    /**
     * Checks if two polygon is identical
     * @param args contains the sides
     * @return true if they are identical
     */
    @Override
    public boolean equals(Double... args){
        if(this.sides.size() == 0)
            return false;
        ArrayList<Double> sides = new ArrayList<Double>(Arrays.asList(args));
        if(this.sides.size() != sides.size())
            return false;
        int numberOfEqualSides = 0;
        ArrayList<Integer> indexOfB = new ArrayList<Integer>();
        for(Double sideA : this.sides){
            int index = 0;
            for(Double sideB : sides){
               if(sideB.equals(sideA))
                   if(!indexOfB.contains(index)){
                       numberOfEqualSides++;
                       indexOfB.add(index);
                       break;
                   }
               index++;
            }
        }
        return this.sides.size() == numberOfEqualSides;
    }

    /**
     * Calculate perimeter of polygon
     * @return perimeter
     */
    @Override
    public double calculatePerimeter(){
        double perimeter = 0;
        for(Double side : sides)
            perimeter += side;
        return perimeter;
    }

    /**
     * prints the information of polygon
     * @return the sides value
     */
    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        if(sides.size() == 3)
            output = new StringBuilder("Triangle - ");
        else if(sides.size() == 4)
            output = new StringBuilder("Rectangle - ");
        else if(sides.size() >= 5)
            output = new StringBuilder("Polygon - ");
        for (int index = 0; index < sides.size(); index++){
            output.append("side").append(index).append(": ").append(sides.get(index)).append(" ");
        }
        return output.toString();
    }

    // Getter
    public ArrayList<Double> getSides() {
        return sides;
    }

}
