package edu.kennesaw.seclass;

import java.io.CharArrayReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by mperry on 1/22/18.
 */
public class MyCustomString implements MyCustomStringInterface {

    private String string;
    private static final Pattern numbers = Pattern.compile("[0-9]+");

    public MyCustomString()
    {
        string = null;
    }

    @Override
    public String getString() {
        return string;
    }

    @Override
    public void setString(String string) {
        this.string = string;
    }

    @Override
    public int countNumbers() {
        Matcher matcher = numbers.matcher(this.string);
        return matcher.groupCount();
    }

    @Override
    public String reverseNCharacters(int n, boolean padded) {

        //for(int i = 0; i<= string.length()/n; i+=n)
        //string = string.substring(i,i+n) + new StringBuilder(this.string.substring(i,i+n)).reverse().append(this.string.substring(n+1)).toString();
        //return string;

        Arrays.stream(string.split("")).collect(Collector.)
    }

    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {

    }
}
