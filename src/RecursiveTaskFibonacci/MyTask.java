package RecursiveTaskFibonacci;

import java.util.concurrent.RecursiveTask;

public class MyTask extends RecursiveTask<Integer> {
    private int bound;

    public MyTask(int bound) {
        this.bound = bound;
    }

    public int fibonacci(int bound) {
        if (bound == 1) return 1;
        if (bound == 0) return 0;
        int start = fibonacci(bound - 1);
        return start + fibonacci(bound - 2);
    }

    @Override
    protected Integer compute() {
        if (bound < 10) return fibonacci(bound);
        else {
            System.out.println(Thread.currentThread().getName());
            MyTask myTask = new MyTask(bound - 1);
            MyTask myTask1 = new MyTask(bound - 2);
            invokeAll(myTask, myTask1);
            return myTask.join() + myTask1.join();
        }

    }
}
