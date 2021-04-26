/**
 * Shape Class
 * @author Pouya Mohammadi - CE@AUT Uni ID: 9829039
 */

abstract public class Shape {

    /**
     * If the shape has a radius it means it is a circle,
     * if not, it means it is a polygon
     */
    private boolean hasRadius;

    /**
     * Constructor of Shape
     */
    public Shape(){}

    /**
     * if there is no kind of shape(Circle or Polygon), returns 0
     * @return 0
     */
    abstract public double calculatePerimeter();

    /**
     * if there is no kind of shape(Circle or Polygon), returns 0
     * @return 0
     */
    abstract public double calculateArea();

    /**
     * if there is no kind of shape(Circle or Polygon), returns false
     * @return false
     */
    abstract public boolean equals(Double... args);

    /**
     * if there is no kind of shape(Circle or Polygon), returns "Empty shape"
     * @return "Empty shape"
     */
    @Override
    public String toString(){
        return "Empty shape";
    }

    // Getter
    public boolean getHasRadius() {
        return hasRadius;
    }
    // Setter
    public void setHasRadius(Boolean hasRadius) {
        this.hasRadius = hasRadius;
    }

}
