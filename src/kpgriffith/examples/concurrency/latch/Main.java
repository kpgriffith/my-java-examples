package kpgriffith.examples.concurrency.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args){
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    CountDownLatch latch = new CountDownLatch(5);
    for(int i=0;i<5;i++){
      executorService.execute(new Worker(i+1, latch));
    }

    try {
      latch.await();  // make sure all the executors or workers are done with their job
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("All the prereqs are done!!");
    executorService.shutdown();
  }

}

class Worker implements Runnable {

  private int id;
  private CountDownLatch countDownLatch;

  public Worker(int id, CountDownLatch countDownLatch){
    this.id = id;
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    doWork();
    countDownLatch.countDown();
  }

  private void doWork() {
    System.out.println("Thread with id: " + this.id + " starts working...");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
