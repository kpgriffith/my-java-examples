package kpgriffith.examples.concurrency.lists;

public class Main {

  public static void main(String[] argv){

    Controller controller = new Controller();
    try {
      controller.processIt();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
