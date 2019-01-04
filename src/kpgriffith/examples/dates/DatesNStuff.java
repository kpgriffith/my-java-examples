package kpgriffith.examples.dates;

import java.sql.Timestamp;
import java.util.Date;

public class DatesNStuff {

  public static void main(String[] args) {

    Timestamp ts = Timestamp.valueOf("2017-11-01 12:01:00");
    System.out.println("nanos is: " + ts.getNanos());
    System.out.println("Time is: " + ts.getTime());

    Timestamp now = new Timestamp(System.currentTimeMillis());

    System.out.println("now is: " + now);
    System.out.println("now is: " + now.getTime());

    Date date = new Date();

    System.out.println("date string is: " + date.toString());
    System.out.println("date long is: " + date.getTime());

    java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());

    System.out.println("sql date string is: " + sqlDate.toString());
    System.out.println("sql date long is: " + sqlDate.getTime());

  }

}
