package kpgriffith.examples.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args){
    // fixed is how many threads that are available for the number of jobs submitted
//    ExecutorService executorService = Executors.newFixedThreadPool(5);

    // with cached, the os helps determine how many threads to do.  this is a better option for the system.
    ExecutorService executorService = Executors.newCachedThreadPool();

    for(int i=0;i<5;i++){
      executorService.submit(new Worker());
    }
  }

}

class Worker implements Runnable {

  @Override
  public void run() {
    for(int i=0;i<10; i++){
      System.out.println(i);
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}