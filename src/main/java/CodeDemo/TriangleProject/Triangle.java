package CodeDemo.TriangleProject;

import java.util.Arrays;

/** 
 * A class representing a triangle.
 */
public class Triangle {

    /** 
     * The three immutable sides of the triangle.
     */
    private final double side1, side2, side3;

    /** 
     * Backing field for the type of the triangle.
     */
    private TriangleType type;

    /** 
     * Constructs a new instance of the @see {@link Triangle} class.
     * @param side1 The first side of a triangle.
     * @param side2 The second side of a triangle.
     * @param side3 The third side of a triangle.
     */
    private Triangle(double side1, double side2, double side3) 
    {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /** 
     * Validates and creates a new instance of the @see {@link Triangle} class.
     * @param side1 The first side of a triangle.
     * @param side2 The second side of a triangle.
     * @param side3 The third side of a triangle.
     * @return A new instance of the @see {@link Triangle} class.
     */
    public static Triangle Create(double side1, double side2, double side3) 
    {
        double[] sortedSides = new double[] { side1, side2, side3 };
        Arrays.sort(sortedSides);

        double smallestSide = sortedSides[0];
        double middleSide = sortedSides[1];
        double largestSide = sortedSides[2];

        if(Double.isNaN(largestSide))
        throw new IllegalArgumentException("One of the triangle sides is NaN.");

        if(Double.isInfinite(smallestSide) || Double.isInfinite(largestSide))
        throw new IllegalArgumentException("One of the triangle sides is infinite.");

        if(smallestSide <= 0.0)
            throw new IllegalArgumentException("One of the triangle sides is less than or equal to zero.");

        // Validating for triangle inequality
        if(smallestSide + middleSide  < largestSide)
            throw new IllegalArgumentException("The sides do not represent a valid triangle.");

        return new Triangle(side1, side2, side3);
    }

    /** 
    * Gets the @see {@link TriangleType} of the triangle.
    * @return The type of the triangle.
    */
    public TriangleType GetType()
    {
        if (type == null)
        {
            if (side1 == side2 && side2 == side3)
                type = TriangleType.EQUILATERAL;
            else if (side1 == side2 || side2 == side3 || side1 == side3)
                type =  TriangleType.ISOSCELES;
            else
                type =  TriangleType.SCALENE;
        }

        return type;
    }

}