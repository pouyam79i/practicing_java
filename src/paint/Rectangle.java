/**
 * Rectangle Class
 * @author Pouya Mohammadi - CE@AUT Uni ID: 9829039
 */

public class Rectangle extends Polygon{

    /**
     * Constructor of Rectangle
     * @param args contains sides
     */
    public Rectangle (Double... args){
        super(args);
        if(args.length > 4)
            System.out.println("Only the first for sides will be adjusted!");
        if(args.length < 3) {
            System.out.println("You must add more sides \n Number of sides must be 4");
            while (getSides().size() < 4)
                addSide(1);
        }
    }

    /**
     * Checks if it is square
     * @return true if it is square
     */
    public boolean isSquare(){
        if(getSides().get(0).equals(getSides().get(1)))
            if(getSides().get(2).equals(getSides().get(3)))
                if(getSides().get(1).equals(getSides().get(2)))
                    return true;
        return false;
    }

    /**
     * Calculate area
     * @return area
     */
    @Override
    public double calculateArea(){
        if(isSquare())
            return Math.pow(getSides().get(0), 2);
        if(!getSides().get(0).equals(getSides().get(1)))
            return getSides().get(0) * getSides().get(1);
        else if(!getSides().get(0).equals(getSides().get(2)))
            return getSides().get(0) * getSides().get(2);
        else
            return getSides().get(0) * getSides().get(3);
    }

}
