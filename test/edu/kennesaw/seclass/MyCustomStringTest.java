package edu.kennesaw.seclass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

/*
Clean Code methodology was used when creating this test file. As a reult you will find no comments, instead the functions have been named in such a manner that they are "self documenting".

I intentionally did not name the functions after the test case. This was to allow modification to the test plan without requeiring modification to compliled code whcih would be required fi a test case changed.
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
    public void testConvertDigitsToNamesInSubstring1() {
        customStringObjectUnderTest.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
        customStringObjectUnderTest.convertDigitsToNamesInSubstring(17, 24);
        assertEquals("H3y, l3t'5 put 5Zerome dOnesixonets in this 5tr1n6!11!!", customStringObjectUnderTest.getString());
    }


    @Test
    public void testConvertDigitsToNamesInSubstring2() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertDigitsToNamesInSubstring3() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertDigitsToNamesInSubstring4() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertDigitsToNamesInSubstring5() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertDigitsToNamesInSubstring6() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertDigitsToNamesInSubstring7() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertDigitsToNamesInSubstring8() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertDigitsToNamesInSubstring9() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertDigitsToNamesInSubstring10() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertDigitsToNamesInSubstring11() {
        fail("Not yet implemented");
    }
}
