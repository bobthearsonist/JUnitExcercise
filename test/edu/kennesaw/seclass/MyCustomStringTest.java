package edu.kennesaw.seclass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

/*
Clean Code methodology was used when creating this test file. As a result you will find no comments, instead the functions have been named in such a manner that they are "self documenting".

I intentionally did not name the functions after the test case. This was to allow modification to the test plan without requeiring modification to compliled code whcih would be required fi a test case changed.

Note that some of these tests fail. I left them failing intentionally in order to indicate those cases where the code is notmathcing my interpretation of the sopfteware specification form the interface definitions.
 */

public class MyCustomStringTest {

    private MyCustomStringInterface customStringObjectUnderTest;

    @Before
    public void initializeObjectUnderTest() {
        customStringObjectUnderTest = new MyCustomString();
    }

    @After
    public void cleanupObjectUnderTest() {
        customStringObjectUnderTest = null;
    }

    @Test
    public void countNumbersBigBangTest() {
        customStringObjectUnderTest.setString("H3y, l3t'5 put s0me d161ts in this 5tr1n6!11!!");
        assertEquals(9, customStringObjectUnderTest.countNumbers());
    }

    @Test(expected = NullPointerException.class)
    public void countNumbersNullStringException() {
        customStringObjectUnderTest.setString(null);
        customStringObjectUnderTest.countNumbers();
    }

    @Test (expected = IllegalArgumentException.class)
    public void countNumbersEmptyString() {
        customStringObjectUnderTest.setString("");
        customStringObjectUnderTest.countNumbers();
    }

    @Test
    public void countNumbersStringWithNoNumbersOrWhitespace() {
        customStringObjectUnderTest.setString("Thisstringhasnonumbersorwhitespace.");
        Assert.assertEquals(0, customStringObjectUnderTest.countNumbers());
    }

    @Test
    public void countNumbersStringWithNoNumbersAndWhitespace() {
        customStringObjectUnderTest.setString("This string has no \\r\\n number in it.");
        Assert.assertEquals(1, customStringObjectUnderTest.countNumbers());
    }

    @Test
    public void countNumbersStringWithNumbersAndWhitespace() {
        customStringObjectUnderTest.setString("This string has \\r\\n a 1 in it.");
        Assert.assertEquals(1, customStringObjectUnderTest.countNumbers());
    }

    @Test
    public void countNumbersNumberAtEnd() {
        customStringObjectUnderTest.setString("This string ends in a \\r\\n a 1");
        Assert.assertEquals(1, customStringObjectUnderTest.countNumbers());
    }

    @Test
    public void countNumbersNumberAtBeggining() {
        customStringObjectUnderTest.setString("1 this string starts in in a \\r\\n a number.");
        Assert.assertEquals(1, customStringObjectUnderTest.countNumbers());
    }

    private final String PeterPiper = "Peter Piper picked a peck of pickled peppers.";
    @Test
    public void testReverseNCharactersBigBang1() {
        customStringObjectUnderTest.setString(PeterPiper);
        assertEquals("etePiP r repkcipa decep fo kcip delkpep srep.", customStringObjectUnderTest.reverseNCharacters(4, false));
    }

    @Test
    public void testReverseNCharactersBigBang2() {
        customStringObjectUnderTest.setString(PeterPiper);
        assertEquals("etePiP r repkcipa decep fo kcip delkpep srepXXX.", customStringObjectUnderTest.reverseNCharacters(4, true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void reverseNCharactersNegativeNStringNotNull() {
        customStringObjectUnderTest.setString(PeterPiper);
        customStringObjectUnderTest.reverseNCharacters(-1,true);
    }

    @Test(expected = NullPointerException.class)
    public void reverseNCharactersNegativeNStringNull() {
        customStringObjectUnderTest.setString(null);
        customStringObjectUnderTest.reverseNCharacters(-1,true);
    }

    @Test
    public void reverseNCharactersIntMaxN() {
        customStringObjectUnderTest.setString(PeterPiper);
        customStringObjectUnderTest.reverseNCharacters(Integer.MAX_VALUE,true);
    }

    @Test(expected = NullPointerException.class)
    public void reverseNCharactersNullStringNValid() {
        customStringObjectUnderTest.setString(null);
        customStringObjectUnderTest.reverseNCharacters(Integer.MAX_VALUE,true);
    }

    @Test
    public void reverseNCharactersEmptyString() {
        customStringObjectUnderTest.setString(PeterPiper);
        assertEquals("", customStringObjectUnderTest.reverseNCharacters(Integer.MAX_VALUE, true));
    }

    @Test
    public void reverseNCharactersNGreaterThan0() {
        customStringObjectUnderTest.setString("");
        assertEquals("", customStringObjectUnderTest.reverseNCharacters(4, false));
    }

    @Test
    public void reverseNCharactersNZeroString1() {
        customStringObjectUnderTest.setString("1");
        assertEquals("1", customStringObjectUnderTest.reverseNCharacters(0, false));
    }

    @Test
    public void reverseNCharactersNGreaterThanString() {
        customStringObjectUnderTest.setString(PeterPiper);
        assertEquals(new StringBuilder(PeterPiper).reverse().toString(), customStringObjectUnderTest.reverseNCharacters(PeterPiper.length()+1, false));
    }

    @Test
    public void reverseNCharactersNLessThanStringPadded() {
        customStringObjectUnderTest.setString("test");
        assertEquals("setXXt", customStringObjectUnderTest.reverseNCharacters(new String("test").length()-1, true));
    }

    @Test
    public void reverseNCharactersNLessThanString() {
        customStringObjectUnderTest.setString("test");
        assertEquals("sett", customStringObjectUnderTest.reverseNCharacters(new String("test").length()-1, false));
    }

    @Test
    public void convertDigitsToNamesInSubstringBigBang1() {
        customStringObjectUnderTest.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
        customStringObjectUnderTest.convertDigitsToNamesInSubstring(17, 24);
        assertEquals("H3y, l3t'5 put 5Zerome dOnesixonets in this 5tr1n6!11!!", customStringObjectUnderTest.getString());
    }

    @Test (expected = NullPointerException.class)
    public void convertDigitsToNamesInSubstringNullString() {
        customStringObjectUnderTest.setString(null);
        customStringObjectUnderTest.convertDigitsToNamesInSubstring(0, 0);
    }

    @Test (expected = MyIndexOutOfBoundsException.class)
    public void convertDigitsToNamesInSubstringStartPositionLessThan1() {
        customStringObjectUnderTest.setString("");
        customStringObjectUnderTest.convertDigitsToNamesInSubstring(0, 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void convertDigitsToNamesInSubstringEndPositionLessThanStartPosition() {
        customStringObjectUnderTest.setString("  ");
        customStringObjectUnderTest.convertDigitsToNamesInSubstring(2, 1);
    }

    @Test (expected = MyIndexOutOfBoundsException.class)
    public void convertDigitsToNamesInSubstringEndPositionEqualToStartPosition() {
        customStringObjectUnderTest.setString("  ");
        customStringObjectUnderTest.convertDigitsToNamesInSubstring(2, 2);
    }

    @Test (expected = MyIndexOutOfBoundsException.class)
    public void convertDigitsToNamesInSubstringEndPositionGreaterThanString() {
        customStringObjectUnderTest.setString(" ");
        customStringObjectUnderTest.convertDigitsToNamesInSubstring(1, 2);
    }

    @Test
    public void convertDigitsToNamesInSubstringNoNumbersInTheStringStartAt1() {
        customStringObjectUnderTest.setString("This is a string with no numbers.");
        customStringObjectUnderTest.convertDigitsToNamesInSubstring(1, 6);
    }

    @Test(expected = MyIndexOutOfBoundsException.class)
    public void convertDigitsToNamesInSubstringEmptyStringStartAndStop1()  {
        customStringObjectUnderTest.setString("");
        customStringObjectUnderTest.convertDigitsToNamesInSubstring(1, 1);
    }

    @Test(expected = MyIndexOutOfBoundsException.class)
    public void convertDigitsToNamesInSubstringEmptyString()  {
        customStringObjectUnderTest.setString("");
        customStringObjectUnderTest.convertDigitsToNamesInSubstring(1, 2);
    }

    @Test
    public void convertDigitsToNamesInSubstringOneNumber() {
        customStringObjectUnderTest.setString("10");
        customStringObjectUnderTest.convertDigitsToNamesInSubstring(1, 2);
        assertEquals("Onezero",customStringObjectUnderTest.getString());
    }

    @Test
    public void convertDigitsToNamesInSubstringTwoNumbers() {
        customStringObjectUnderTest.setString("10 10");
        customStringObjectUnderTest.convertDigitsToNamesInSubstring(1, customStringObjectUnderTest.getString().length());
        assertEquals("Onezero Onezero",customStringObjectUnderTest.getString());
    }
}
