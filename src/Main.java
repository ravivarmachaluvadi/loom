
//https://foojay.io/today/how-to-run-project-loom-from-intellij-idea/
public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Creating object with default constructor
        Employee e1 = new Employee(1001, "Derok", "Dranf");

        // Auto generated getter methods
        System.out.println(e1.id() + " " + e1.firstName()
                + " " + e1.lastName());

        // Auto-generated toString() method
        System.out.println(e1.toString());
        Thread.startVirtualThread(() -> System.out.println("Ravi")).join();
        System.out.println(System.getProperty("java.version"));

    }
}