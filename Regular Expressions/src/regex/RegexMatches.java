package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches
{
	private static String regex;
	private static String input;
	private static String replace;
    private static Pattern pattern;
    private static Matcher matcher;

    public static void main( String args[] ){
       regex = "foo";
       input = "fooooooooooooooooo";
       pattern = Pattern.compile(regex);
       matcher = pattern.matcher(input);

       System.out.println("Current REGEX is: " + regex);
       System.out.println("Current INPUT is: " + input);

       System.out.println("lookingAt(): " + matcher.lookingAt());
       System.out.println("matches(): " + matcher.matches());
       
       regex = "dog";
       input = "The dog says meow. "
       		+ "All dogs say meow.";
       replace = "cat";
       
       pattern = Pattern.compile(regex);
       //get a matcher object
       matcher = pattern.matcher(input);
       input = matcher.replaceAll(replace);
       System.out.println(input);
       
       regex = "a*b";
       input = "aabfooaabfooabfoob";
       replace = "-";
       
       pattern = Pattern.compile(regex);
       matcher = pattern.matcher(input);
       StringBuffer sb = new StringBuffer();
       
       while(matcher.find()) {
    	   matcher.appendReplacement(sb, replace);
       }
       matcher.appendTail(sb);
       
       System.out.println(sb.toString());
       
       regex = "foo";
       input = "foo";
       pattern = Pattern.compile(regex);
       matcher = pattern.matcher(input);

       System.out.println("Current REGEX is: " + regex);
       System.out.println("Current INPUT is: " + input);

       System.out.println("lookingAt(): " + matcher.lookingAt());
       System.out.println("matches(): " + matcher.matches());
   }
    
}