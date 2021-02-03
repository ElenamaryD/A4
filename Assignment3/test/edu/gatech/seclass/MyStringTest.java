package edu.gatech.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Junit test class created for use in Georgia Tech CS6300.
 *
 * You should implement your tests in this class.
 */

public class MyStringTest {

    private MyStringInterface mystring;

    @Before
    public void setUp() {
        mystring = new MyString();
    }

    @After
    public void tearDown() {
        mystring = null;
    }

    @Test
    // Description: Instructor-provided test 1
    public void testCountNumbersS1() {
        mystring.setString("My numbers are 11, 96, and thirteen");
        assertEquals(2, mystring.countNumbers());
    }

    @Test
    // Description: <Count numbers in an empty string>
    public void testCountNumbersS2() {
        mystring.setString("");
        assertEquals(0, mystring.countNumbers());
    }

    @Test
    // Description: <Count real numbers as integers>
    public void testCountNumbersS3() {
        mystring.setString("I don't handle real numbers such as 10.4 and 0.5");
        assertEquals(4, mystring.countNumbers());
    }

    @Test
    // Description: <Count numbers inside words>
    public void testCountNumbersS4() {
        mystring.setString("I l0ve 2 pr0gram.");
        assertEquals(3, mystring.countNumbers());
    }

    @Test
    // Description: Instructor-provided test 2
    public void testAddNumberS1() {
        mystring.setString("hello 90, bye 2");
        assertEquals("hello 92, bye 4", mystring.addNumber(2, false));
    }

    @Test
    // Description: <For n=8 and reverse=true>
    public void testAddNumberS2() {
        mystring.setString("hello 90, bye 2");
        assertEquals("hello 89, bye 01", mystring.addNumber(8,true));
    }

    @Test(expected = NullPointerException.class)
    // Description: <Expected exception>
    public void testAddNumberS3() {
        mystring.setString(null);
        assertEquals(NullPointerException.class, mystring.addNumber(2, false));
    }

    @Test(expected = IllegalArgumentException.class)
    // Description: <Check if n is negative and reverse false>
    public void testAddNumberS4() {
        mystring.setString("If n<0 , and the current string is n0t null, r3v3rs3 fals3");
        assertEquals(IllegalArgumentException.class, mystring.addNumber(-2,false));
    }

    @Test(expected = IllegalArgumentException.class)
    // Description: <Check if n is negative and reverse true>
    public void testAddNumberS5() {
        mystring.setString("If n<0 , and the current string is n0t null, r3v3rs3 tru3");
        assertEquals(IllegalArgumentException.class, mystring.addNumber(-4,true));
    }

    @Test
    // Description: <Assert that an object should not be null >
    public void testAddNumberS6() {
        mystring.setString(" ");
        assertNotNull(mystring.addNumber(2,true));
    }

    @Test
    // Description: Instructor-provided test 3
    public void testConvertDigitsToNamesInSubstringS1() {
        mystring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mystring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put szerome donesix1ts in this 5tr1n6, right?", mystring.getString());
    }

    @Test
    // Description: <Test endPosition>
    public void testConvertDigitsToNamesInSubstringS2() {
        mystring.setString("abc416d");
        mystring.convertDigitsToNamesInSubstring(2,7);
        assertEquals("abcfouronesixd", mystring.getString());
    }

    @Test(expected = NullPointerException.class)
    // Description: <Test null>
    public void testConvertDigitsToNamesInSubstringS3() {
        mystring.convertDigitsToNamesInSubstring(2,5);
    }

    @Test(expected = IllegalArgumentException.class)
    // Description: <Test startPosition > endPosition>
    public void testConvertDigitsToNamesInSubstringS4() {
        mystring.setString("wr0ng startP0sition");
        mystring.convertDigitsToNamesInSubstring(6,2);
    }

    @Test(expected = IllegalArgumentException.class)
    // Description: <startPosition < 0 >
    public void testConvertDigitsToNamesInSubstringS5() {
        mystring.setString("startP0siton is < 0");
        mystring.convertDigitsToNamesInSubstring(-12,3);
    }

    @Test(expected = MyIndexOutOfBoundsException.class)
    // Description: <empty string with index out of bounds>
    public void testConvertDigitsToNamesInSubstringS6() {
        mystring.setString("");
        mystring.convertDigitsToNamesInSubstring(0,1);
    }
}

