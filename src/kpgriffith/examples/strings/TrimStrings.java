package kpgriffith.examples.strings;

public class TrimStrings {

  public static void main(String[] args) {

    String str = new String("   hello   ");

    System.out.println("String is: ```" + str + "```");

    String strTrim = str.trim();

    System.out.println("Original String is: ```" + str + "```");

    System.out.println("Trimmed String is: ```" + strTrim + "```");

  }

}
