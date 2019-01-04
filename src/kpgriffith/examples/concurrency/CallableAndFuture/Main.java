package kpgriffith.examples.concurrency.CallableAndFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Processor implements Callable<String> {

  private int id;

  public Processor(int id){
    this.id = id;
  }

  @Override
  public String call() throws Exception {
    Thread.sleep(1000);
    return "id:"+id;
  }
}

public class Main {

  public static void main(String[] args){

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    List<Future<String>> futures = new ArrayList<>();

    // create 5 tasks
    for(int i=0;i<5;i++){
      Future<String> future = executorService.submit(new Processor(i+1));
      futures.add(future);
    }

    for(Future<String> future : futures){
      try {
        System.out.println(future.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }

    executorService.shutdown();
  }

}
