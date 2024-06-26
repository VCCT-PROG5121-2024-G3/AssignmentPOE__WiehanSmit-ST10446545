
package assingmentpart1;
import java.util.ArrayList;
/**
 *
 * @author WiehanSmit ST10446545@vcconnect.edu.za ST10446545
 */
class Task 
{
    //Declarations
    String name;
    private int number;
    private String description;
    String developer;
    int duration;
    String status;
    //--------------------------------------------------------------------------
    //Constructor
    Task(String name, int number, String description, String developer, int duration, String status) {
        this.name = name;
        this.number = number;
        this.description = description;
        this.developer = developer;
        this.duration = duration;
        this.status = status;
    }
    //--------------------------------------------------------------------------
    //Checks the description length
    boolean checkTaskDescription() {
        return description.length() <= 50;
    }
    //--------------------------------------------------------------------------
    //Creates and returns taskID
    String createTaskID() {
        String taskID = name.substring(0, 2).toUpperCase() + ":" + number + ":" + developer.substring(developer.length() - 3).toUpperCase();
        return taskID;
    }
    //--------------------------------------------------------------------------
    //Displays task in full detail
    String printTaskDetails() {
        String taskID = createTaskID();
        return "Task Name: " + name + "\n" +
                "Task Number: " + number + "\n" +
                "Task Description: " + description + "\n" +
                "Developer: " + developer + "\n" +
                "Duration: " + duration + " hours\n" +
                "Task ID: " + taskID + "\n" +
                "Status: " + status;
    }
    //--------------------------------------------------------------------------
    //Returns the total combined hours of every entered tasks
    static int returnTotalHours(ArrayList<Task> tasks) {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.duration;
        }
        return totalHours;
    }

    boolean getTaskDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
//---------------------------- End of File -------------------------------------