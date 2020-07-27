package CodeDemo.TriangleProject;

/** 
* The types of a triangle.
*/
public enum TriangleType 
{ 
    /** 
    * The type of a triangle with all sides of equal size. 
    * Notice this type is a special case of the type @see {@link TriangleType#ISOSCELES}.
    */
    EQUILATERAL,
    
    /**
    * The type of a triangle with only two of the sides of equal size.
    */
    ISOSCELES,
    
    /** 
    * The type of a triangle with all sides of different sizes.s
    */
    SCALENE,
}
