package CodeDemo.TriangleProject;

import java.util.InputMismatchException;
import java.util.Scanner; 

/** 
 * A command-line program to determine the type of a triangle.
 */
public final class App {

    /** 
     * The main method of the command-line program.
     * @param args The command-line arguments.
     */
    public static void main(String[] args)
    {
        double side1;
        double side2;
        double side3;

        System.out.println("\nThis program will determine the type of a triangle based on the lengths of the sides.\n"); 

        try(Scanner sc = new Scanner(System.in))
        {
            System.out.println("Enter the length of the first side: "); 
            side1 = sc.nextDouble();
    
            System.out.println("Enter the length of the  second side: "); 
            side2 = sc.nextDouble();
    
            System.out.println("Enter the length of the  third side: "); 
            side3 = sc.nextDouble();
        }
        catch(InputMismatchException e){
            System.out.println("\nError message: The input is not valid.");
            return;
        }

        Triangle tri;
        try
        {
            tri = Triangle.Create(side1, side2, side3);
        }
        catch(IllegalArgumentException e){
            System.out.println("\nError message: " + e.getMessage());
            return;
        }

        TriangleType typeOfTri =  tri.GetType();
        System.out.println("\nThe type of the triangle is " + typeOfTri + ".");
    }
}
