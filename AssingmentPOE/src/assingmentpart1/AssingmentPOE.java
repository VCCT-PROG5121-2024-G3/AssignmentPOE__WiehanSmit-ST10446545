
package assingmentpart1;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/** 
 *
 * @author WiehanSmit ST10446545@vcconnect.edu.za ST10446545
 */ 
public class AssingmentPOE {


    // Storing task details
    static class Task {
        String name;
        int number;
        String description;
        String developer;
        int duration;
        String id;
        String status;
        
        //----------------------------------------------------------------------
        //Constructor
        Task(String name, int number, String description, String developer, int duration, String status) {
            this.name = name;
            this.number = number;
            this.description = description;
            this.developer = developer;
            this.duration = duration;
            this.status = status;
            this.id = generateTaskID(name, number, developer);
        }
        //----------------------------------------------------------------------
        //Generating custom ID
        private String generateTaskID(String name, int number, String developer) {
            String taskID = name.substring(0, 2).toUpperCase() + ":" + number + ":" + developer.substring(developer.length() - 3).toUpperCase();
            return taskID;
        }
        //----------------------------------------------------------------------
        //Displays the task details after being entered
        public String getTaskDetails() {
            return "Task Status: " + status + "\n" +
                   "Developer Details: " + developer + "\n" +
                   "Task Number: " + number + "\n" +
                   "Task Name: " + name + "\n" +
                   "Task Description: " + description + "\n" +
                   "Task ID: " + id + "\n" +
                   "Task Duration: " + duration + " hours";
        }
    }

    //--------------------------------------------------------------------------
    // Main method
    public static void main(String[] args) {
        // Declarations
        String username = "";
        String password = "";
        String firstName = "";
        String lastName = "";
        ArrayList<Task> tasks = new ArrayList<>();
        //----------------------------------------------------------------------
        // Option to create account or to Login
        while (true) {
            String choice = JOptionPane.showInputDialog(null, "Press (1)"
                    + " to create an account or Press (2) to Login:");
            if (choice.equals("1")) 
            {
                //--------------------------------------------------------------
                // Account Creation
                // User input for the Username
                while (true) {
                    username = JOptionPane.showInputDialog(null, "Please enter "
                            + "a username:\n(Username contains an underscore"
                            + " and is no more than 5 characters long)");
                    //----------------------------------------------------------
                    // Validate username
                    if (username != null && username.length() <= 5 && username.contains("_")) {
                        JOptionPane.showMessageDialog(null, "Username successfully captured");
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Username is not correctly formatted, "
                                + "\nplease ensure that your username contains"
                                + " an underscore and is no more than 5 characters in length");
                    }
                }
                //--------------------------------------------------------------
                // User input for the password
                while (true) {
                    password = JOptionPane.showInputDialog(null, "Please enter a password:\n(must be 8 characters long, "
                            + "contain a capital letter, a number, and a special character)");
                    // Validate password
                    if (PasswordValidator.isValid(password)) {
                        JOptionPane.showMessageDialog(null, "Password successfully captured!");
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Password is not correctly formatted, "
                                + "\n please ensure that the password contains at "
                                + "least 8 characters, a capital letter, a number and a special character");
                    }
                }
                //--------------------------------------------------------------
                // User input for the Firstname and Lastname
                firstName = JOptionPane.showInputDialog(null, "Please enter your First Name:");
                lastName = JOptionPane.showInputDialog(null, "Please enter your Last Name:");
                //--------------------------------------------------------------
                // Account created
                JOptionPane.showMessageDialog(null, "Account created successfully!\nUsername: " + username + "\nPassword: " + password + "\nFirst Name: " + firstName + "\nLast Name: " + lastName);
            } else if (choice.equals("2")) {
                //--------------------------------------------------------------
                // Login
                if (!username.isEmpty() && !password.isEmpty()) {
                    String enteredUsername = JOptionPane.showInputDialog(null, "Enter your username:");
                    String enteredPassword = JOptionPane.showInputDialog(null, "Enter your password:");

                    if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
                        JOptionPane.showMessageDialog(null, "Login successful! \nWelcome, " + firstName + " " + lastName + " it is great to see you again");
                        defineNumberOfTasks(tasks);
                        showPostLoginMenu(tasks);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You need to create an account first!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice. Please enter 1 or 2.");
            }
        }
    }

    //--------------------------------------------------------------------------
    //Defines the amount of tasks
    private static void defineNumberOfTasks(ArrayList<Task> tasks) {
        String input = JOptionPane.showInputDialog(null, "Enter the amount of taks you wish to add:");
        int numberOfTasks;
        try {
            numberOfTasks = Integer.parseInt(input);
        } catch (NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(null, "Invalid number. Please enter a valid number.");
            return;
        }
        for (int i = 0; i < numberOfTasks; i++) {
            addTask(tasks, i);
        }
        int totalDuration = calculateTotalDuration(tasks);
        JOptionPane.showMessageDialog(null, "All tasks added successfully!\nTotal duration: " + totalDuration + " hours");
    }

    //--------------------------------------------------------------------------
    // Method that adds single tasks
    private static void addTask(ArrayList<Task> tasks, int taskNumber) {
        String taskName = JOptionPane.showInputDialog(null, "Enter the task name:");
        String taskDescription;
        //----------------------------------------------------------------------
        //method to make sure the user doesnt pass 50 characters
        while (true) {
            taskDescription = JOptionPane.showInputDialog(null, "Enter the task"
                    + " description (less than 50 characters):");
            if (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task"
                        + " description of less than 50 characters");
            } else {
                JOptionPane.showMessageDialog(null, "Task successfully captured");
                break;
            }
        }
        //----------------------------------------------------------------------
        //Developers Name
        String developer = JOptionPane.showInputDialog(null, "Enter the developer's first and last name:");
        //----------------------------------------------------------------------
        //Task duration
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the task duration(Hours):"));
        //----------------------------------------------------------------------
        //Task status
        String[] statusOptions = {"To Do", "Done", "Doing"};
        String taskStatus = (String) JOptionPane.showInputDialog(null, "Select the task status:", "Task Status",
                JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);
        //----------------------------------------------------------------------
        //Constructor
        Task task = new Task(taskName, taskNumber, taskDescription, developer, taskDuration, taskStatus);
        tasks.add(task);
        //----------------------------------------------------------------------
        // Displays task in full
        JOptionPane.showMessageDialog(null, "Task successfully captured\n" + task.getTaskDetails());
    }

    //--------------------------------------------------------------------------
    // Method to calculate the total duration of all tasks
    private static int calculateTotalDuration(ArrayList<Task> tasks) {
        int totalDuration = 0;
        for (Task task : tasks) {
            totalDuration += task.duration;
        }
        return totalDuration;
    }

    //--------------------------------------------------------------------------
    //Post-Login menu
    private static void showPostLoginMenu(ArrayList<Task> tasks) {
        while (true) {
            String menuChoice = JOptionPane.showInputDialog(null, "Welcome to EasyKanban\n"
                    + "1) Add tasks\n"
                    + "2) Show report\n"
                    + "3) Display specific reports\n"
                    + "4) Search tasks\n"
                    + "5) Delete a task\n"
                    + "6) Quit");

            switch (menuChoice) {
                case "1":
                    addTask(tasks, tasks.size());
                    break;
                case "2":
                    showReport(tasks);
                    break;
                case "3":
                    displaySpecificReports(tasks);
                    break;
                case "4":
                    searchTasks(tasks);
                    break;
                case "5":
                    deleteTask(tasks);
                    break;
                case "6":
                    JOptionPane.showMessageDialog(null, "Logging Out");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid number. Please enter 1, 2, 3, 4, 5, or 6.");
                    break;
            }
        }
    }

    //--------------------------------------------------------------------------
    // Method to show report
    private static void showReport(ArrayList<Task> tasks) {
        StringBuilder report = new StringBuilder();
        for (Task task : tasks) {
            report.append(task.getTaskDetails()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }

    //--------------------------------------------------------------------------
    // Method to display specific reports
    private static void displaySpecificReports(ArrayList<Task> tasks) {
        String menuChoice = JOptionPane.showInputDialog(null, "Select the report to display:\n"
                + "1) Developers, Task Names, and Task Duration for tasks with status 'Done'\n"
                + "2) Developer and Duration of the task with the longest duration");

        switch (menuChoice) {
            case "1":
                displayDoneTasks(tasks);
                break;
            case "2":
                displayLongestTask(tasks);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid number. Please enter 1 or 2.");
                break;
        }
    }

    //--------------------------------------------------------------------------
    // Method to display tasks with status 'Done'
    private static void displayDoneTasks(ArrayList<Task> tasks) {
        StringBuilder report = new StringBuilder();
        for (Task task : tasks) {
            if ("Done".equalsIgnoreCase(task.status)) {
                report.append("Developer: ").append(task.developer)
                      .append(", Task Name: ").append(task.name)
                      .append(", Task Duration: ").append(task.duration).append(" hours\n");
            }
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }

    //--------------------------------------------------------------------------
    // Method to display the task with the longest duration
    private static void displayLongestTask(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }
        Task longestTask = tasks.get(0);
        for (Task task : tasks) {
            if (task.duration > longestTask.duration) {
                longestTask = task;
            }
        }
        JOptionPane.showMessageDialog(null, "Developer: " + longestTask.developer + ", Task Duration: " + longestTask.duration + " hours");
    }

    //--------------------------------------------------------------------------
    // Method to search for tasks
    private static void searchTasks(ArrayList<Task> tasks) {
        String searchChoice = JOptionPane.showInputDialog(null, "Search tasks by:\n"
                + "1) Task Name\n"
                + "2) Developer");

        switch (searchChoice) {
            case "1":
                searchTaskByName(tasks);
                break;
            case "2":
                searchTasksByDeveloper(tasks);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid number. Please enter 1 or 2.");
                break;
        }
    }

    //--------------------------------------------------------------------------
    // Method to search for a task if the name of the task is entered
    private static void searchTaskByName(ArrayList<Task> tasks) {
        String taskName = JOptionPane.showInputDialog(null, "Enter the task name to search:");
        for (Task task : tasks) {
            if (task.name.equalsIgnoreCase(taskName)) {
                JOptionPane.showMessageDialog(null, "Task Name: " + task.name + "\nDeveloper: " + task.developer + "\nTask Status: " + task.status);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    //--------------------------------------------------------------------------
    // Method to search for a task if a developers name is entered
    private static void searchTasksByDeveloper(ArrayList<Task> tasks) {
        String developerName = JOptionPane.showInputDialog(null, "Enter the developer name to search:");
        StringBuilder result = new StringBuilder();
        for (Task task : tasks) {
            if (task.developer.equalsIgnoreCase(developerName)) {
                result.append("Task Name: ").append(task.name).append(", Task Status: ").append(task.status).append("\n");
            }
        }
        if (result.length() == 0) {
            JOptionPane.showMessageDialog(null, "No tasks found for the developer.");
        } else {
            JOptionPane.showMessageDialog(null, result.toString());
        }
    }

    //--------------------------------------------------------------------------
    // Method that deletes task if the name of the task is entered
    private static void deleteTask(ArrayList<Task> tasks) {
        String taskName = JOptionPane.showInputDialog(null, "Enter the task name to delete:");
        for (Task task : tasks) {
            if (task.name.equalsIgnoreCase(taskName)) {
                tasks.remove(task);
                JOptionPane.showMessageDialog(null, "Task deleted successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }
}
 
//---------------------------- End of File -------------------------------------
