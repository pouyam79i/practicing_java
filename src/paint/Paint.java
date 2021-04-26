/**
 * Paint Class
 * @author Pouya Mohammadi - CE@AUT Uni ID: 9829039
 */

import java.util.ArrayList;

public class Paint {

    /**
     * List of shapes
     */
    private ArrayList<Shape> shapes;

    /**
     * Constructor of Paint
     */
    public Paint(){
        shapes = new ArrayList<Shape>();
    }

    /**
     * Add a shape to the list of shapes
     * @param shape will be added
     */
    public void addShape(Shape shape){
        shapes.add(shape);
    }

    /**
     * Prints the perimeter and area by announcing kind of shape
     */
    public void drawAll(){
        for(Shape shape : shapes){
            if(shape.getHasRadius())
                System.out.print("Circle - ");
            else {
                System.out.print("Polygon - ");
            }
            System.out.println("perimeter: " + String.format("%.2f", shape.calculatePerimeter()) +
                    " area: " + String.format("%.2f", shape.calculateArea()));
        }
    }

    /**
     * Prints the shape information
     * It prints whatever the toString() method produces!
     */
    public void printAll(){
        for(Shape shape : shapes)
            System.out.println(shape);
    }

}
