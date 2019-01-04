package kpgriffith.examples.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractNumbers {

  public static void main(String[] args) {
    Pattern p = Pattern.compile("^-?(\\d+\\.?)+");
    Matcher m = p.matcher("4.56 Gb");

    while(m.find()){
      System.out.println("string is " + m.group());
    }

  }

}
