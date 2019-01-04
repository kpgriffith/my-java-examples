package kpgriffith.examples.concurrency.seq;

class Runner1 {
  public void startRunning(){
    for(int i=0; i<10; i++){
      System.out.println("Runner1: " + i);
    }
  }
}

class Runner2 {
  public void startRunning(){
    for(int i=0; i<10; i++){
      System.out.println("Runner2: " + i);
    }
  }
}

public class Seq1 {
  public static void main(String[] args){
    long start = System.currentTimeMillis();
    Runner1 runner1 = new Runner1();
    Runner2 runner2 = new Runner2();
    runner1.startRunning();
    runner2.startRunning();
    long stop = System.currentTimeMillis();
    long duration = stop - start;
    System.out.println("Seq1 took " + duration + "ms to execute.");
  }
}
