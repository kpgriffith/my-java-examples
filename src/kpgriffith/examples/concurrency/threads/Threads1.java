package kpgriffith.examples.concurrency.threads;

class Runner1 extends Thread {
  @Override
  public void run() {
    for(int i=0; i<10; i++){
      System.out.println("Runner1: " + i);
    }
  }
}

class Runner2 extends Thread {
  @Override
  public void run() {
    for(int i=0; i<10; i++){
      System.out.println("Runner2: " + i);
    }
  }
}

public class Threads1 {
  public static void main(String[] args){
    long start = System.currentTimeMillis();
    Runner1 runner1 = new Runner1();
    Runner2 runner2 = new Runner2();
    runner1.start();
    runner2.start();
    long stop = System.currentTimeMillis();
    long duration = stop - start;
    System.out.println("Threads1 took " + duration + "ms to execute.");
  }
}
