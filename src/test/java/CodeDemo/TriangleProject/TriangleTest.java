package CodeDemo.TriangleProject;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;;

/**
 * Junit test for @see {@link Triangle} class.
 */
class TriangleTest {
    /**
     * Testing the method @see {@link Triangle#Create(double, double, double)} throws the expected error message.
     * @param side1 The first side of a triangle.
     * @param side2 The second side of a triangle.
     * @param side3 The third side of a triangle.
     * @param expectedErrorMsg The expected error message.
     */
    @ParameterizedTest
    @CsvSource
        ({
            "5.0, 1.0, NaN, 'One of the triangle sides is NaN.'",
            "Infinity, 1.0, 6.0, 'One of the triangle sides is infinite.'",
            "5.0, 1.0, -Infinity, 'One of the triangle sides is infinite.'",
            "1.0, -1.0, 1.0, 'One of the triangle sides is less than or equal to zero.'",
            "0.0, 1.0, 1.0, 'One of the triangle sides is less than or equal to zero.'",
            "0.0, 0.0, 0.0, 'One of the triangle sides is less than or equal to zero.'",
            "1.0, 2.0, 4.0, 'The sides do not represent a valid triangle.'",
        })
    public void CreateTriangleErrorTest(double side1, double side2, double side3, String expectedErrorMsg) 
    {
        Exception exception = assertThrows(
            IllegalArgumentException.class, 
            () -> { Triangle.Create(side1, side2, side3); });

        String actualErrorMsg = exception.getMessage();
        assertEquals(expectedErrorMsg, actualErrorMsg);
    }

    /**
     * Testing the method @see {@link Triangle#GetType()} returns the expected type.
     * @param side1 The first side of a triangle.
     * @param side2 The second side of a triangle.
     * @param side3 The third side of a triangle.
     * @param expectedType The expected type.
     */
    @ParameterizedTest
    @CsvSource
        ({
            "5.0, 5.0, 5.0, EQUILATERAL",
            "3.0, 1.5, 1.5, ISOSCELES",
            "1.5, 1.5, 3.0, ISOSCELES",
            "1.5, 3.0, 1.5, ISOSCELES",
            "1.0, 2.0, 3.0, SCALENE",
            "1.9999, 2.0, 3.0, SCALENE",
        })
    public void GetTypeTest(double side1, double side2, double side3, TriangleType expectedType)
    {
        Triangle triangle = Triangle.Create(side1, side2, side3);
        TriangleType actualType = triangle.GetType();

        assertEquals(expectedType, actualType);
    }
}
