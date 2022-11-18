import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


// javac --enable-preview --release 19 Main2.java
//java --enable-preview Main2
public class Main2 {
    private static int MAX = 10;
    private static CountDownLatch latch = new CountDownLatch(MAX);

    public static void main(String[] args) throws InterruptedException {
        /*ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newVirtualThreadPerTaskExecutor();
        threadPoolExecutor.setCorePoolSize(1);
        threadPoolExecutor.setMaximumPoolSize(1);*/
        long beg = System.currentTimeMillis();

        List<Integer> list = List.of(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9);

        for (int i = 0; i < list.size(); i++) {
            int finalI = i;
            //new Thread(() -> printVal(list.get(finalI), finalI)).start();
            Thread.startVirtualThread(() -> printVal(list.get(finalI), finalI));
        }
        latch.await();
        System.out.println("Done");
        long end = System.currentTimeMillis();
        System.out.println(end - beg);
    }

    private static void printVal(int value, int index) {
        System.out.println("start : " + value + ", index : " + index + ", ThreadName:  " + Thread.currentThread());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end : " + value + ", index : " + index + ", ThreadName:  " + Thread.currentThread());
        latch.countDown();
    }
}
