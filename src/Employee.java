public record Employee(int id, String firstName, String lastName, int age) {
    public Employee {
        if (age < 18) {
            throw new IllegalArgumentException(
                    "You cannot hire a minor person as employee");
        }
    }
}