package RecursiveTaskFibonacci;


import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        MyTask myTask = new MyTask(20);
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        long c = System.currentTimeMillis();
        System.out.println(pool.invoke(myTask));
        System.out.println(System.currentTimeMillis() - c);
    }
}