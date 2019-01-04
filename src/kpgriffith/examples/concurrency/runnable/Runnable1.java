package kpgriffith.examples.concurrency.runnable;

class Runner1 implements Runnable {
  @Override
  public void run() {
    for(int i=0; i<10; i++){
      System.out.println("Runner1: " + i);
    }
  }
}

class Runner2 implements Runnable {
  @Override
  public void run() {
    for(int i=0; i<10; i++){
      System.out.println("Runner2: " + i);
    }
  }
}

public class Runnable1 {
  public static void main(String[] args){
    long start = System.currentTimeMillis();
    Thread t1 = new Thread(new Runner1());
    Thread t2 = new Thread(new Runner2());
    t1.start();
    t2.start();
    long stop = System.currentTimeMillis();
    long duration = stop - start;
    System.out.println("Runnable1 took " + duration + "ms to execute.");
  }
}
