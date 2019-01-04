package kpgriffith.examples.concurrency.lists;

public class Worker extends Thread {

  Controller controller;

  public Worker(Controller controller){
    this.controller = controller;
  }

  @Override
  public void run() {

    Integer myNumber;
    do {
      myNumber = controller.getNextNumber();
      System.out.println("Thread " + Thread.currentThread() + " with number " + myNumber);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } while(myNumber != null);

    System.out.println("Thread " + Thread.currentThread() + " - all numbers are done, exiting.");

  }

}
