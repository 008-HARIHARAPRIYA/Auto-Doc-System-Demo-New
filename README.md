# Task Management System

This is a simple command-line interface (CLI) application developed in Java for managing tasks. It allows users to add new tasks, view existing ones, filter by priority, mark tasks as complete, delete tasks, search for tasks, and view overall statistics.

## Features

Based on the provided code, the Task Management System supports the following functionalities:

*   **Add New Task:** Create a task by providing a title, description, due date (DD-MM-YYYY format), and priority level (HIGH, MEDIUM, LOW).
*   **View All Tasks:** Display a list of all tasks, showing their ID, title, description, due date, priority, status (COMPLETED/PENDING), and creation date.
*   **View Tasks by Priority:** Filter and display tasks based on a selected priority level (HIGH, MEDIUM, or LOW).
*   **Mark Task as Complete:** Change the status of a specific task to "COMPLETED" using its ID.
*   **Delete Task:** Remove a task from the system using its ID.
*   **Search Tasks:** Find tasks whose title or description contains a specified keyword (case-insensitive).
*   **View Statistics:** Display an overview of task metrics, including total tasks, completed tasks, pending tasks, and overdue tasks.
*   **Interactive Menu:** A user-friendly menu guides the interaction with the system.

## Technology Stack

*   **Language:** Java
    *   `java.time` package for handling dates (LocalDate, DateTimeFormatter).
    *   `java.util` package for collections (ArrayList, List) and input processing (Scanner).

## File Structure Overview

The project consists of a single Java source file:

```
.
└── TaskManagementSystem.java
```

This file contains:
*   `TaskManagementSystem` class: The main application logic, including the `main` method, menu display, task operations, and utility functions.
*   `Task` class: A data model representing a single task, holding its attributes and methods to manage its state.
*   `Priority` enum: Defines the possible priority levels for tasks.

## How to Compile and Run

To compile and run this Java application, you will need a Java Development Kit (JDK) installed on your system.

1.  **Save the code:** Save the provided Java code into a file named `TaskManagementSystem.java`.

2.  **Compile:** Open a terminal or command prompt, navigate to the directory where you saved the file, and compile the Java code:
    ```bash
    javac TaskManagementSystem.java
    ```

3.  **Run:** After successful compilation, run the application using:
    ```bash
    java TaskManagementSystem
    ```

The application will then start in your terminal, displaying the main menu.

## Code Highlights and Important Components

### `TaskManagementSystem.java`

This file encapsulates the entire application logic.

*   **`main` method:** The entry point of the application, responsible for the main loop, displaying the menu, and handling user input to call appropriate task management functions.
*   **`tasks` (static `List<Task>`):** An `ArrayList` used to store all `Task` objects in memory.
*   **`scanner` (static `Scanner`):** Manages user input from the console.
*   **`nextId` (static `int`):** Automatically assigns a unique ID to each new task.
*   **`addTask()`:** Prompts the user for task details (title, description, due date, priority) and creates a new `Task` instance.
*   **`viewAllTasks()`:** Iterates through the `tasks` list and prints the `toString()` representation of each task.
*   **`viewTasksByPriority()`:** Filters tasks based on user-selected priority and displays them.
*   **`markTaskComplete()`:** Locates a task by ID and sets its `completed` status to `true`.
*   **`deleteTask()`:** Locates a task by ID and removes it from the `tasks` list.
*   **`searchTasks()`:** Searches for tasks where the title or description contains a user-specified keyword.
*   **`viewStatistics()`:** Calculates and presents the total, completed, pending, and overdue task counts.
*   **Helper methods:**
    *   `findTaskById(int id)`: Searches the `tasks` list for a task matching the given ID.
    *   `parseDate(String date)`: Parses a date string in "DD-MM-YYYY" format into a `LocalDate` object, handling invalid formats by defaulting to the current date.
    *   `getIntInput(String msg)`: Utility for robust integer input, prompting the user until valid integer input is received.

### `Task` Class

The `Task` class is a data model that represents a single task within the system.

*   **Attributes:**
    *   `id` (int): Unique identifier for the task.
    *   `title` (String): Short title of the task.
    *   `description` (String): Detailed description of the task.
    *   `dueDate` (LocalDate): The date by which the task should be completed.
    *   `createdDate` (LocalDate): The date when the task was created (automatically set to `LocalDate.now()` upon creation).
    *   `priority` (Priority enum): The priority level of the task.
    *   `completed` (boolean): Flag indicating whether the task is complete (default `false`).
*   **Constructor:** Initializes a new task with the provided details and sets `createdDate` to the current date.
*   **`markComplete()`:** A simple setter method to change the `completed` status to `true`.
*   **Getters:** Provides access to all private attributes of the task.
*   **`toString()`:** Overrides the default `Object.toString()` method to provide a formatted, human-readable string representation of the task's details.

### `Priority` Enum

The `Priority` enum defines the available priority levels for tasks.

*   **Levels:** `HIGH`, `MEDIUM`, `LOW`.
*   **`fromInt(int i)`:** A static factory method that converts an integer input (1 for HIGH, 2 for MEDIUM, 3 for LOW) into the corresponding `Priority` enum value. Defaults to `MEDIUM` if the input is not 1 or 3.

## Usage Example

After running the `TaskManagementSystem`, you will see a menu similar to this:

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
8. Exit
========================================
Enter your choice:
```

Here's an example interaction flow:

1.  **Add a new task:**
    ```
    Enter your choice: 1

    --- Add New Task ---
    Task Title: Buy groceries
    Task Description: Milk, eggs, bread, cheese
    Due Date (DD-MM-YYYY): 15-03-2024

    Priority Levels:
    1. HIGH
    2. MEDIUM
    3. LOW
    Select Priority: 1

    Task added successfully!
    ```

2.  **Add another task:**
    ```
    Enter your choice: 1

    --- Add New Task ---
    Task Title: Prepare presentation
    Task Description: Review slides for Q2
    Due Date (DD-MM-YYYY): 20-03-2024

    Priority Levels:
    1. HIGH
    2. MEDIUM
    3. LOW
    Select Priority: 2

    Task added successfully!
    ```

3.  **View all tasks:**
    ```
    Enter your choice: 2

    --- All Tasks ---
    ID: 1
    Title: Buy groceries
    Description: Milk, eggs, bread, cheese
    Due: 15-03-2024
    Priority: HIGH
    Status: PENDING
    Created: 10-03-2024
    ----------------------------------------
    ID: 2
    Title: Prepare presentation
    Description: Review slides for Q2
    Due: 20-03-2024
    Priority: MEDIUM
    Status: PENDING
    Created: 10-03-2024
    ----------------------------------------
    ```

4.  **Mark "Buy groceries" as complete (Task ID 1):**
    ```
    Enter your choice: 4

    --- All Tasks ---
    ID: 1
    Title: Buy groceries
    Description: Milk, eggs, bread, cheese
    Due: 15-03-2024
    Priority: HIGH
    Status: PENDING
    Created: 10-03-2024
    ----------------------------------------
    ID: 2
    Title: Prepare presentation
    Description: Review slides for Q2
    Due: 20-03-2024
    Priority: MEDIUM
    Status: PENDING
    Created: 10-03-2024
    ----------------------------------------
    Enter Task ID to mark complete: 1

    Task marked as complete!
    ```

5.  **View statistics:**
    ```
    Enter your choice: 7

    --- Statistics ---
    Total Tasks: 2
    Completed: 1
    Pending: 1
    Overdue: 0
    ```

6.  **Exit the application:**
    ```
    Enter your choice: 8

    Thank you for using Task Management System!
    ```