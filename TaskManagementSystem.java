import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TaskManagementSystem {
    private static List<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   TASK MANAGEMENT");
        System.out.println("========================================\n");

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewAllTasks();
                    break;
                case 3:
                    viewTasksByPriority();
                    break;
                case 4:
                    markTaskComplete();
                    break;
                case 5:
                    deleteTask();
                    break;
                case 6:
                    searchTasks();
                    break;
                case 7:
                    viewStatistics();
                    break;
                case 8:
                    running = false;
                    System.out.println("\nThank you for using Task Management System!");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("========================================");
        System.out.println("1. Add New Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. View Tasks by Priority");
        System.out.println("4. Mark Task as Complete");
        System.out.println("5. Delete Task");
        System.out.println("6. Search Tasks");
        System.out.println("7. View Statistics");
        System.out.println("8. Exit");
        System.out.println("========================================");
    }

    private static void addTask() {
        System.out.println("\n--- Add New Task ---");

        scanner.nextLine();
        System.out.print("Task Title: ");
        String title = scanner.nextLine();

        System.out.print("Task Description: ");
        String description = scanner.nextLine();

        System.out.print("Due Date (DD-MM-YYYY): ");
        LocalDate dueDate = parseDate(scanner.nextLine());

        System.out.println("\nPriority Levels:");
        System.out.println("1. HIGH");
        System.out.println("2. MEDIUM");
        System.out.println("3. LOW");
        Priority priority = Priority.fromInt(getIntInput("Select Priority: "));

        tasks.add(new Task(nextId++, title, description, dueDate, priority));
        System.out.println("\nTask added successfully!\n");
    }

    private static void viewAllTasks() {
        System.out.println("\n--- All Tasks ---");
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.\n");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
            System.out.println("----------------------------------------");
        }
        System.out.println();
    }

    private static void viewTasksByPriority() {
        System.out.println("\n--- Filter by Priority ---");
        System.out.println("1. HIGH");
        System.out.println("2. MEDIUM");
        System.out.println("3. LOW");
        Priority priority = Priority.fromInt(getIntInput("Select Priority: "));

        boolean found = false;
        for (Task task : tasks) {
            if (task.getPriority() == priority) {
                System.out.println(task);
                System.out.println("----------------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found with " + priority + " priority.\n");
        }
    }

    private static void markTaskComplete() {
        viewAllTasks();
        int id = getIntInput("Enter Task ID to mark complete: ");
        Task task = findTaskById(id);
        if (task != null) {
            task.markComplete();
            System.out.println("\nTask marked as complete!\n");
        } else {
            System.out.println("\nTask not found.\n");
        }
    }

    private static void deleteTask() {
        viewAllTasks();
        int id = getIntInput("Enter Task ID to delete: ");
        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
            System.out.println("\nTask deleted successfully!\n");
        } else {
            System.out.println("\nTask not found.\n");
        }
    }

    private static void searchTasks() {
        scanner.nextLine();
        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Task task : tasks) {
            if (task.getTitle().toLowerCase().contains(keyword) ||
                task.getDescription().toLowerCase().contains(keyword)) {
                System.out.println(task);
                System.out.println("----------------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching tasks found.\n");
        }
    }

    private static void viewStatistics() {
        int total = tasks.size(), completed = 0, overdue = 0;
        LocalDate today = LocalDate.now();

        for (Task task : tasks) {
            if (task.isCompleted()) completed++;
            else if (task.getDueDate().isBefore(today)) overdue++;
        }

        System.out.println("\n--- Statistics ---");
        System.out.println("Total Tasks: " + total);
        System.out.println("Completed: " + completed);
        System.out.println("Pending: " + (total - completed));
        System.out.println("Overdue: " + overdue + "\n");
    }

    private static Task findTaskById(int id) {
        for (Task task : tasks)
            if (task.getId() == id) return task;
        return null;
    }

    private static LocalDate parseDate(String date) {
        try {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (Exception e) {
            System.out.println("Invalid date format. Using today's date.");
            return LocalDate.now();
        }
    }

    private static int getIntInput(String msg) {
        System.out.print(msg);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Invalid input. " + msg);
        }
        return scanner.nextInt();
    }
}

class Task {
    private int id;
    private String title, description;
    private LocalDate dueDate, createdDate;
    private Priority priority;
    private boolean completed;

    public Task(int id, String title, String description, LocalDate dueDate, Priority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.createdDate = LocalDate.now();
    }

    public void markComplete() { completed = true; }
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDate getDueDate() { return dueDate; }
    public Priority getPriority() { return priority; }
    public boolean isCompleted() { return completed; }

    @Override
    public String toString() {
        return String.format(
            "ID: %d\nTitle: %s\nDescription: %s\nDue: %s\nPriority: %s\nStatus: %s\nCreated: %s",
            id, title, description,
            dueDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
            priority,
            completed ? "COMPLETED" : "PENDING",
            createdDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        );
    }
}

enum Priority {
    HIGH, MEDIUM, LOW;
    public static Priority fromInt(int i) {
        return i == 1 ? HIGH : i == 3 ? LOW : MEDIUM;
    }
}
