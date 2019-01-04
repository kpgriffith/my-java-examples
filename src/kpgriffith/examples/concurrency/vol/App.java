package kpgriffith.examples.concurrency.vol;

class Worker implements Runnable {

  public boolean isTerminated() {
    return isTerminated;
  }

  public void setTerminated(boolean terminated) {
    isTerminated = terminated;
  }

  private volatile boolean isTerminated = false;

  @Override
  public void run() {
    while(!isTerminated){
      System.out.println("Hello from Worker class!");
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class App {

  public static void main(String[] args){
    Worker worker = new Worker();
    Thread t1 = new Thread(worker);
    t1.start();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    worker.setTerminated(true);
    System.out.println("Finished...");
  }

}
