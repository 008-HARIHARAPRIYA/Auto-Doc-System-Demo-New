# Task Management System

This project is a console-based Task Management System developed in Java. It allows users to manage their tasks through a simple interactive menu, providing functionalities such as adding new tasks, viewing, updating, deleting, searching, and exporting them.

## Features

Based on the provided code, the Task Management System offers the following features:

*   **Add New Task:** Create a new task by providing a title, description, due date (in `DD-MM-YYYY` format), and selecting a priority level (HIGH, MEDIUM, LOW).
*   **View All Tasks:** Display a list of all tasks currently in the system, showing their ID, title, description, due date, priority, status (COMPLETED/PENDING), and creation date.
*   **View Tasks by Priority:** Filter and display tasks based on a selected priority level (HIGH, MEDIUM, or LOW).
*   **Mark Task as Complete:** Change the status of an existing task to 'COMPLETED' by entering its ID.
*   **Delete Task:** Remove a task from the system permanently by entering its ID.
*   **Search Tasks:** Find tasks by entering a keyword that matches either the task's title or description (case-insensitive).
*   **View Statistics:** See an overview of tasks, including the total number of tasks, completed tasks, pending tasks, overdue tasks, and counts for each priority level (HIGH, MEDIUM, LOW). Overdue tasks are determined relative to the current date.
*   **Export Tasks to CSV:** Generate a CSV file containing all tasks with their details. The file is named `tasks_export_YYYY-MM-DD.csv` and includes headers: `ID,Title,Description,Due Date,Priority,Status,Created Date`. Titles and descriptions are escaped for proper CSV formatting.
*   **Exit:** Terminate the application.

## Technology Stack

*   **Language:** Java
*   **Core Libraries:**
    *   `java.time`: For date handling (`LocalDate`, `DateTimeFormatter`).
    *   `java.util`: For data structures (`ArrayList`, `Scanner`).
    *   `java.io`: For file output (`PrintWriter`).

## File Structure Overview

This project consists of a single Java file:

```
.
└── TaskManagementSystem.java
```

## How to Run/Compile

To compile and run this Java console application, follow these steps:

1.  **Save the code:** Save the provided Java code as `TaskManagementSystem.java` in a directory of your choice.
2.  **Open Terminal/Command Prompt:** Navigate to the directory where you saved the file.
3.  **Compile:** Use the Java compiler (`javac`) to compile the source file:
    ```bash
    javac TaskManagementSystem.java
    ```
    This will generate `TaskManagementSystem.class`, `Task.class`, and `Priority.class` files in the same directory.
4.  **Run:** Execute the compiled Java program using the Java Virtual Machine (`java`):
    ```bash
    java TaskManagementSystem
    ```
5.  **Interact:** The application will start and display a menu in the console. Follow the on-screen prompts to interact with the Task Management System.

## Code Highlights and Important Components

### `TaskManagementSystem.java`
This is the main class that orchestrates the entire application.

*   **`main` method:** The entry point of the program, it initializes the system, displays the interactive menu, and handles user input to navigate through different task management operations.
*   **`tasks` (Static `List<Task>`):** An `ArrayList` used to store all `Task` objects in memory. Tasks are not persisted beyond the application's runtime unless exported.
*   **`scanner` (Static `Scanner`):** Used for reading user input from the console.
*   **Menu-driven interface:** The `displayMenu()` method presents options, and a `switch` statement in `main` dispatches to specific methods based on user choice.
*   **Task Management Methods:** Contains methods for each menu option (e.g., `addTask()`, `viewAllTasks()`, `markTaskComplete()`, `deleteTask()`, `searchTasks()`, `viewStatistics()`, `exportTasksToCSV()`).
*   **Helper Methods:** Includes utility methods like `findTaskById()`, `parseDate()` for date string conversion, `getIntInput()` for robust integer input, and `escapeCSV()` for preparing strings for CSV output.
*   **CSV Export Logic:** The `exportTasksToCSV()` method demonstrates writing structured data to a file in CSV format, including a header row and basic handling for special characters within data fields.

### `Task` Class
This class represents a single task entity within the system.

*   **Attributes:**
    *   `id` (int): Unique identifier for the task.
    *   `title` (String): The name of the task.
    *   `description` (String): Detailed explanation of the task.
    *   `dueDate` (LocalDate): The date by which the task should be completed.
    *   `priority` (Priority enum): The urgency level of the task.
    *   `completed` (boolean): Indicates whether the task is finished or not.
    *   `createdDate` (LocalDate): The date when the task was created.
*   **Constructor:** Initializes a new task with its ID, title, description, due date, and priority. Sets `completed` to `false` and `createdDate` to the current date.
*   **`markComplete()` method:** Changes the task's `completed` status to `true`.
*   **Getters:** Provides methods to access all task attributes.
*   **`toString()` method:** Overridden to provide a formatted string representation of the task, including its ID, title, description, formatted due date, priority, status, and creation date.

### `Priority` Enum
This enum defines the possible priority levels for a task.

*   **Levels:** `HIGH`, `MEDIUM`, `LOW`.
*   **`fromInt()` method:** A static helper method to convert an integer input (1 for HIGH, 2 for MEDIUM, 3 for LOW) into the corresponding `Priority` enum value. Defaults to `MEDIUM` if an invalid choice is provided.

## Usage Examples

Upon running the application, you will be presented with a menu:

```
========================================
   TASK MANAGEMENT
========================================

========================================
1. Add New Task
2. View All Tasks
3. View Tasks by Priority
4. Mark Task as Complete
5. Delete Task
6. Search Tasks
7. View Statistics
8. Export Tasks to CSV
9. Exit
========================================
Enter your choice:
```

You can interact by entering the number corresponding to your desired action:

1.  **To add a task:** Enter `1`. You will then be prompted for the task's title, description, due date (e.g., `25-12-2023`), and priority.
    ```
    Enter your choice: 1

    --- Add New Task ---
    Task Title: Plan Holiday
    Task Description: Research destinations and book flights.
    Due Date (DD-MM-YYYY): 15-11-2023

    Priority Levels:
    1. HIGH
    2. MEDIUM
    3. LOW
    Select Priority: 1

    Task added successfully!
    ```
2.  **To view all tasks:** Enter `2`.
    ```
    Enter your choice: 2

    --- All Tasks ---
    ID: 1
    Title: Plan Holiday
    Description: Research destinations and book flights.
    Due Date: 15-11-2023
    Priority: HIGH
    Status: [PENDING]
    Created: 01-11-2023
    ----------------------------------------
    ```
3.  **To export tasks to CSV:** Enter `8`. A file named `tasks_export_YYYY-MM-DD.csv` will be created in the same directory as the executable, containing all current tasks.
    ```
    Enter your choice: 8

    --- Export Tasks to CSV ---

    Tasks exported successfully!
    File: tasks_export_2023-11-01.csv
    Total tasks exported: 1
    ```
    The content of `tasks_export_2023-11-01.csv` would look similar to:
    ```csv
    ID,Title,Description,Due Date,Priority,Status,Created Date
    "1","Plan Holiday","Research destinations and book flights.","15-11-2023","HIGH","PENDING","01-11-2023"
    ```
4.  **To exit the system:** Enter `9`.