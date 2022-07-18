
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        List<Future<Integer>> list=new ArrayList<>();
        // ExecutorService executorService1 = Executors.newFixedThreadPool(10);

        Instant start = Instant.now();

        for (int value = 1; value < 101; value++) {
            int finalValue = value;
            list.add(executorService.submit(() -> {
                System.out.println("Printing " + finalValue + " " + Thread.currentThread());
                int theVal = 0;
                try {
                    sleep(5000);
                    theVal = getSame(finalValue);
                } catch (InterruptedException e) {
                    System.out.println("Virtual Thread Execution Exception");
                }
                System.out.println("Printing " + theVal + " " + Thread.currentThread());
                return theVal;
            }));
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toSeconds());

        list.forEach(integerFuture -> {
            try {
                System.out.println(integerFuture.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

    }

    private static int getSame(int finalValue) {

        return finalValue;
    }
}
