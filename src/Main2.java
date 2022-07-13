import java.util.concurrent.CountDownLatch;
public class Main2 {
    private static int MAX=10;
    private static CountDownLatch latch=new CountDownLatch(MAX);
    public static void main(String[] args) throws InterruptedException {
        long beg = System.currentTimeMillis();

        for (int i = 0; i < MAX; i++) {
            int finalI = i;
            //new Thread(() -> printVal(finalI)).start();
            Thread.startVirtualThread(() -> printVal(finalI));
        }

        latch.await();

        System.out.println("Done");
        long end = System.currentTimeMillis();
        System.out.println(end-beg);
    }
    private static void printVal(int value) {
        System.out.println("Printing : "+value+"---"+Thread.currentThread());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Printed : "+value+"---"+Thread.currentThread());
        latch.countDown();
    }
}
