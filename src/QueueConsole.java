import java.util.Scanner;

public class QueueConsole {
    Queue list = new Queue();
    boolean active = true;

    public static void main(String[] args) {
        new QueueConsole().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (active) {
            clearConsole();
            displayQueue();
            System.out.println("Choose an option: 1. Insert 2. Remove 3. Count 4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter patient name:");
                    String name = scanner.next();
                    insert(new Patient(name, (int) (Math.random() * 100)));
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    System.out.println("Count: " + list.count());
                    break;
                case 4:
                    active = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private void insert(Patient patient) {
        list.insertInBack(patient);
        System.out.println("Inserted: " + patient.getInfo());
    }

    private void remove() {
        if (list.nonEmptyList()) {
            System.out.println("Removed: " + list.removeFirst());
        } else {
            System.out.println("List is empty!");
        }
    }

    private void displayQueue() {
        System.out.println("Current Queue:");
        System.out.println(list.display());
    }

    private void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}