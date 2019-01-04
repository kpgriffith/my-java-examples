package kpgriffith.examples.concurrency.synchronizedBlocks;

public class Main {

  private static int counter1 = 0;
  private static int counter2 = 0;

  // benefit is performance when using synchronized blocks like this instead of locks on the class.
  private static Object lock1 = new Object();
  private static Object lock2 = new Object();

  public static void add(){
    synchronized (lock1) {
      counter1++;
    }
  }

  public static void addAgain(){
    synchronized (lock2) {
      counter2++;
    }
  }

  public static void compute(){
    for(int i=0; i<100; i++){
      add();
      addAgain();
    }
  }

  public static void main(String[] args){
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        compute();
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        compute();
      }
    });

    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Count1=" + counter1 + "; Count2=" + counter2);

  }

}
