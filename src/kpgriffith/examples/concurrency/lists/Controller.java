package kpgriffith.examples.concurrency.lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Controller {

  Iterator<Integer> listIterator;

  public Controller(){

  }

  public void processIt() throws InterruptedException {

    List<Integer> myList = new ArrayList<>();
    myList.add(Integer.valueOf(1));
    myList.add(Integer.valueOf(2));
    myList.add(Integer.valueOf(3));
    myList.add(Integer.valueOf(4));
    myList.add(Integer.valueOf(5));
    myList.add(Integer.valueOf(6));
    myList.add(Integer.valueOf(7));
    myList.add(Integer.valueOf(8));
    myList.add(Integer.valueOf(9));
    myList.add(Integer.valueOf(10));
    myList.add(Integer.valueOf(11));
    myList.add(Integer.valueOf(12));
    myList.add(Integer.valueOf(13));
    myList.add(Integer.valueOf(14));
    myList.add(Integer.valueOf(15));
    myList.add(Integer.valueOf(16));
    myList.add(Integer.valueOf(17));
    myList.add(Integer.valueOf(18));
    myList.add(Integer.valueOf(19));
    myList.add(Integer.valueOf(20));

    listIterator = myList.iterator();

    ExecutorService executor = Executors.newFixedThreadPool(5);
    Runnable worker;
    for(int i=0; i<5; i++) {
      worker = new Worker(this);
      executor.execute(worker);
    }
    executor.shutdown();
    try {
      executor.awaitTermination(100, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      System.out.println("InterruptedException waiting for all threads to terminate!!!");
    }
  }

  public synchronized Integer getNextNumber(){
    if(listIterator.hasNext()){
      return listIterator.next();
    } else {
      return null;
    }
  }
}
