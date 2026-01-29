# Task Management System

A command-line interface (CLI) application for managing tasks, built using Java. This system allows users to add, view, update, delete, search for, and get statistics on their tasks, providing a simple yet functional way to organize daily responsibilities.

## Features

The Task Management System offers the following functionalities:

*   **Add New Task:** Create a new task with a title, description, due date, and priority level (High, Medium, Low).
*   **View All Tasks:** Display a comprehensive list of all tasks currently in the system, including their ID, title, description, due date, priority, status (Completed/Pending), and creation date.
*   **View Tasks by Priority:** Filter and display tasks based on their assigned priority level.
*   **Mark Task as Complete:** Change the status of a specific task to "Completed" using its ID.
*   **Delete Task:** Remove a task from the system entirely by its ID.
*   **Search Tasks:** Find tasks by searching for keywords within their title or description.
*   **View Statistics:** Get an overview of task progress, including total tasks, completed tasks, pending tasks, overdue tasks, and a breakdown by priority level.
*   **Exit Application:** Gracefully shut down the application.

## Technology Stack

*   **Language:** Java
*   **Core Libraries:**
    *   `java.time` for date and time handling (e.g., `LocalDate`, `DateTimeFormatter`).
    *   `java.util` for data structures and utilities (e.g., `ArrayList`, `Scanner`).

## File Structure Overview

The project consists of a single Java file containing all necessary classes:

```
TaskManagementSystem.java
```

This file defines three main components:
*   `TaskManagementSystem`: The main application class that handles user interaction, menu display, and orchestrates task operations.
*   `Task`: A class representing a single task entity with its attributes and methods.
*   `Priority`: An enum defining the various priority levels a task can have.

## How to Run/Compile

To compile and run this Java console application, follow these steps:

1.  **Save the code:** Save the provided Java code into a file named `TaskManagementSystem.java`.
2.  **Open a terminal or command prompt.**
3.  **Navigate to the directory** where you saved `TaskManagementSystem.java`.
4.  **Compile the Java code:**
    ```bash
    javac TaskManagementSystem.java
    ```
5.  **Run the application:**
    ```bash
    java TaskManagementSystem
    ```

The application will then start, displaying the main menu in your console.

## Code Highlights and Important Components

### `TaskManagementSystem` Class

This is the entry point of the application and manages the overall flow.

*   **`main(String[] args)`**: Initializes the application, displays the welcome message, and enters the main loop for user interaction.
*   **`displayMenu()`**: Prints the main menu options to the console.
*   **`addTask()`**: Prompts the user for task details (title, description, due date, priority) and creates a new `Task` object. Date parsing is handled with error fallback.
*   **`viewAllTasks()`**: Iterates through the `tasks` list and prints each task's details.
*   **`viewTasksByPriority()`**: Allows filtering tasks by a selected priority level.
*   **`markTaskComplete()`**: Finds a task by ID and sets its `completed` status to `true`.
*   **`deleteTask()`**: Finds a task by ID and removes it from the `tasks` list.
*   **`searchTasks()`**: Takes a keyword and searches for it in task titles and descriptions (case-insensitive).
*   **`viewStatistics()`**: Calculates and displays counts for total, completed, pending, overdue tasks, and a breakdown by priority. It uses `LocalDate.now()` to determine overdue tasks.
*   **`findTaskById(int id)`**: A utility method to locate a `Task` object by its unique ID.
*   **`parseDate(String dateStr)`**: Handles parsing date strings in "DD-MM-YYYY" format, defaulting to today's date on invalid input.
*   **`getIntInput(String prompt)`**: A utility method to safely get integer input from the user, handling non-integer inputs.

### `Task` Class

This class represents the blueprint for a task.

*   **Attributes**:
    *   `id` (int): Unique identifier for the task.
    *   `title` (String): Short title of the task.
    *   `description` (String): Detailed description of the task.
    *   `dueDate` (LocalDate): The date the task is due.
    *   `priority` (Priority enum): The priority level of the task.
    *   `completed` (boolean): Flag indicating if the task is completed.
    *   `createdDate` (LocalDate): The date the task was created.
*   **Constructor**: Initializes a new task with provided details, setting `completed` to `false` and `createdDate` to the current date.
*   **`markComplete()`**: Sets the `completed` attribute to `true`.
*   **`toString()`**: Overridden method to provide a well-formatted string representation of the task's details, including its status (✓ COMPLETED / ⏳ PENDING).
*   **Getters**: Provides access to all private attributes.

### `Priority` Enum

Defines the possible priority levels for tasks.

*   **Levels**: `HIGH`, `MEDIUM`, `LOW`.
*   **`fromInt(int choice)`**: A static utility method to convert an integer choice (1 for HIGH, 2 for MEDIUM, 3 for LOW) into the corresponding `Priority` enum value, defaulting to `MEDIUM` for invalid inputs.

## Usage Examples

Once the application is running, you will be presented with the main menu:

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

1.  **Adding a Task:**
    *   Enter `1` and press Enter.
    *   Follow the prompts to enter the task title, description, due date (e.g., `15-08-2023`), and select a priority (e.g., `1` for HIGH).

2.  **Viewing All Tasks:**
    *   Enter `2` and press Enter.
    *   The system will list all tasks currently stored.

3.  **Marking a Task Complete:**
    *   Enter `4` and press Enter.
    *   If tasks exist, they will be listed. Enter the `ID` of the task you wish to mark complete.

4.  **Viewing Statistics:**
    *   Enter `7` and press Enter.
    *   The system will display a summary of task counts by status and priority.

To exit the application, enter `8`.