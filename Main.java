/* Create a program which prints first 10 number using fixed thread pool of size 5. 
Execute them using Executor. Describe the behaviour of executor Framework */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Task class to be executed
class Task implements Runnable {
  public void run() {
    try {
      for (int i = 1; i <= 10; i++) {
        System.out.println(i);
      }

    }

    catch (Exception e) {
      e.printStackTrace();
    }
  }
}

public class Main {
  // Maximum number of threads in thread pool
  static final int MAX_T = 5;

  public static void main(String[] args) {
    // creates a tasks
    Runnable r1 = new Task();

    // creates a thread pool with MAX_T no. of threads as the fixed pool size
    ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

    // passes the Task objects to the pool to execute
    pool.execute(r1);

    pool.shutdown();
  }
}
