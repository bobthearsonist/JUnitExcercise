package edu.kennesaw.seclass;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        //Arrays.stream(string.split("")).collect(Collector.)

        return this.solutionReverse(n,padded);
    }

    private String solutionReverse(int n, boolean padded)
    {
        if (string == null) {
            throw new NullPointerException();
        }
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        StringBuffer tmpString = new StringBuffer();
        StringBuffer resultString = new StringBuffer();
        StringBuffer currString = new StringBuffer(string);

        int i;
        for (i = 0; i + n < currString.length(); i+=n) {
            tmpString = tmpString.append(new StringBuffer(currString.substring(i,i+n)).reverse());
        }
        if (padded)
        {
            for (int x = n - (currString.length() - i); x > 0; x--)
                currString.append('X');
        }
        tmpString = tmpString.append(new StringBuffer(currString.substring(i)).reverse());

        return tmpString.toString();
    }

    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
        solutionConvertDigitsToNamesInSubstring(startPosition, endPosition);
    }

    private void solutionConvertDigitsToNamesInSubstring(int startPosition, int endPosition) {
        if (string == null) {
            throw new NullPointerException();
        }
        if ((startPosition > endPosition)) {
            throw new IllegalArgumentException();
        }

        if  (endPosition > string.length() || (startPosition < 1)){
            throw new MyIndexOutOfBoundsException();
        }
        StringBuffer tmpString = new StringBuffer();
        String tmpDigit = new String();
        boolean look_back = false;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if ((i < startPosition - 1) || (i > endPosition - 1)) {
                if(look_back) {
                    look_back = false;
                }
                tmpString.append(ch);
                continue;
            } else {
                if (Character.isDigit(ch)) {
                    switch (ch) {
                        case '0':
                            tmpDigit = "Zero";
                            break;
                        case '1':
                            tmpDigit = "One";
                            break;
                        case '2':
                            tmpDigit = "Two";
                            break;
                        case '3':
                            tmpDigit = "Three";
                            break;
                        case '4':
                            tmpDigit = "Four";
                            break;
                        case '5':
                            tmpDigit = "Five";
                            break;
                        case '6':
                            tmpDigit = "Six";
                            break;
                        case '7':
                            tmpDigit = "Seven";
                            break;
                        case '8':
                            tmpDigit = "Eight";
                            break;
                        case '9':
                            tmpDigit = "Nine";
                            break;
                    }
                    if(look_back)
                        tmpString.append(tmpDigit.toLowerCase());
                    else
                        tmpString.append(tmpDigit);
                    look_back = true;
                } else {
                    if(look_back){
                        look_back = false;}
                    tmpString.append(ch);

                }
            }
        }
        string = tmpString.toString();
    }
}
