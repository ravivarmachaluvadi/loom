package demo.java;

public class OfVirtual {
    public static void main(String[] args) throws InterruptedException {
        Thread.startVirtualThread(() -> System.out.println("startVirtualThread"));
        Thread.startVirtualThread(OfVirtual::m2);
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        }
        ).start();

        m1();
        System.out.println("1  =================");
    }
    public static void m1(){

        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        }).start();
                System.out.println("2    =================");
    }
    public static void m2(){
        System.out.println("Virtual");
    }
}
