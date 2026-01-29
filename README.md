# Task Management System

This project implements a console-based Task Management System in Java. It allows users to manage tasks through an interactive menu, including adding, viewing, updating, deleting, searching, and exporting tasks. All task data is stored in memory for the duration of the application's execution.

## Features

The system provides the following functionalities:

*   **Add New Task**: Create a new task by providing a title, description, due date (in `DD-MM-YYYY` format), and selecting a priority level (HIGH, MEDIUM, LOW).
*   **View All Tasks**: Display a comprehensive list of all tasks currently in the system, showing their ID, title, description, due date, priority, completion status, and creation date.
*   **View Tasks by Priority**: Filter and display tasks based on a user-selected priority level (HIGH, MEDIUM, LOW).
*   **Mark Task as Complete**: Change the status of an existing task to 'COMPLETED' by entering its unique ID.
*   **Delete Task**: Remove a task from the system by specifying its unique ID.
*   **Search Tasks**: Find tasks that contain a specific keyword within their title or description (case-insensitive search).
*   **View Statistics**: Generate and display summary statistics about tasks, including total tasks, completed tasks, pending tasks, overdue tasks, and counts for each priority level.
*   **Export Tasks to CSV**: Save all current tasks to a Comma Separated Values (CSV) file. The filename is dynamically generated (e.g., `tasks_export_YYYY-MM-DD.csv`). The export includes task ID, title, description, due date, priority, status, and creation date, with basic escaping for title and description fields.
*   **Exit**: Terminate the application.

## Technology Stack

*   **Language**: Java
*   **Core Libraries**:
    *   `java.time`: For handling dates (e.g., `LocalDate`, `DateTimeFormatter`).
    *   `java.util`: For data structures (`ArrayList`, `List`) and user input (`Scanner`).
    *   `java.io`: For file operations (`PrintWriter` for CSV export).

## File Structure Overview

The project consists of a single Java source file:

```
.
└── TaskManagementSystem.java
```

*   `TaskManagementSystem.java`: Contains the main application logic, the `Task` class definition, and the `Priority` enum.

## How to Run/Compile

To compile and run this Java application, you need a Java Development Kit (JDK) installed on your system.

1.  **Compile the source file:**
    Navigate to the directory containing `TaskManagementSystem.java` in your terminal or command prompt and run:
    ```bash
    javac TaskManagementSystem.java
    ```
2.  **Run the application:**
    After successful compilation, execute the compiled class file:
    ```bash
    java TaskManagementSystem
    ```

## Code Highlights and Important Components

### `TaskManagementSystem.java`

This is the main class that orchestrates the application.

*   **`main(String[] args)` method**: The entry point of the application. It initializes the system, displays a welcome message, and manages the main application loop, presenting the menu and handling user choices.
*   **`tasks` (static `List<Task>`)**: An `ArrayList` that serves as the in-memory database to store all `Task` objects.
*   **`scanner` (static `Scanner`)**: Used to read user input from the console.
*   **`nextId` (static `int`)**: A counter that provides unique IDs for newly created tasks.
*   **Menu-driven Interface**: The `displayMenu()` method presents available options, and a `switch` statement in `main` dispatches to the corresponding private methods based on user input.
*   **Input Handling**:
    *   `getIntInput(String prompt)`: A utility method to safely read integer input from the user, including basic validation for non-integer inputs.
    *   `parseDate(String dateStr)`: Converts a date string (expected format `DD-MM-YYYY`) into a `LocalDate` object, defaulting to today's date if parsing fails.
*   **Task Management Operations**: Methods like `addTask()`, `viewAllTasks()`, `markTaskComplete()`, `deleteTask()`, `searchTasks()`, `viewStatistics()`, and `exportTasksToCSV()` encapsulate the core business logic.
*   **`exportTasksToCSV()`**: Handles writing task data to a `.csv` file. It constructs the CSV header and then iterates through the `tasks` list to write each task's details.
*   **`escapeCSV(String value)`**: A helper method used during CSV export to escape double quotes within string values by replacing them with two double quotes, preventing CSV formatting issues.
*   **`findTaskById(int id)`**: A utility method to locate a `Task` object within the `tasks` list using its ID.

### `Task` class

This class represents a single task object within the system.

*   **Attributes**:
    *   `id` (`int`): Unique identifier for the task.
    *   `title` (`String`): The task's title.
    *   `description` (`String`): A detailed description of the task.
    *   `dueDate` (`LocalDate`): The date by which the task is due.
    *   `priority` (`Priority` enum): The priority level of the task.
    *   `completed` (`boolean`): Indicates whether the task is completed (`true`) or pending (`false`).
    *   `createdDate` (`LocalDate`): The date when the task was created.
*   **Constructor**: Initializes a new `Task` instance with provided title, description, due date, and priority. `completed` is set to `false`, and `createdDate` is set to the current date.
*   **`markComplete()`**: A public method to update the task's `completed` status to `true`.
*   **Getters**: Provides public methods to access all private attributes of a task.
*   **`toString()`**: Overrides the default `toString()` method to provide a well-formatted, human-readable string representation of the task, including its status and dates.

### `Priority` enum

This enum defines the possible priority levels for tasks.

*   **Values**: `HIGH`, `MEDIUM`, `LOW`.
*   **`fromInt(int choice)` (static method)**: A utility method to convert an integer input (1 for HIGH, 2 for MEDIUM, 3 for LOW) into its corresponding `Priority` enum value. Defaults to `MEDIUM` if an invalid choice is provided.

## Usage Examples

Once compiled and run, the application will present an interactive command-line menu.

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

### 1. Add a New Task

To add a task, enter `1` at the main menu.

```
Enter your choice: 1

--- Add New Task ---
Task Title: Prepare project presentation
Task Description: Gather slides, finalize report, practice delivery.
Due Date (DD-MM-YYYY): 25-03-2024

Priority Levels:
1. HIGH
2. MEDIUM
3. LOW
Select Priority: 1

Task added successfully!
```

### 2. View All Tasks

To view all tasks, enter `2` at the main menu.

```
Enter your choice: 2

--- All Tasks ---
ID: 1
Title: Prepare project presentation
Description: Gather slides, finalize report, practice delivery.
Due Date: 25-03-2024
Priority: HIGH
Status: [PENDING]
Created: 10-03-2024
----------------------------------------
```

### 3. Export Tasks to CSV

To export tasks, enter `8` at the main menu.

```
Enter your choice: 8

--- Export Tasks to CSV ---

Tasks exported successfully!
File: tasks_export_2024-03-10.csv
Total tasks exported: 1
```

This will create a `tasks_export_YYYY-MM-DD.csv` file in the same directory where the application was run, containing the task data.

### 4. Exiting the Application

To exit the application, enter `9` at the main menu.

```
Enter your choice: 9

Thank you for using Task Management System!
```