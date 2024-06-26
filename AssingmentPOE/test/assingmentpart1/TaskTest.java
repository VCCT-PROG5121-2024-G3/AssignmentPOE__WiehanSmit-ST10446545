/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package assingmentpart1;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wieha
 */
public class TaskTest {
    
    public TaskTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
    public void testCheckTaskDescription() {
        System.out.println("checkTaskDescription");
        Task instance = new Task("Test Task", 0, "Short description", "Developer", 5, "To Do");
        boolean expResult = true;
        boolean result = instance.checkTaskDescription();
        assertEquals(expResult, result);
        Task longDescriptionTask = new Task("Test Task", 1, "This description is more than 50 "
                + "characters long and be able to fail the check.", "Developer", 5, "To Do");
        expResult = false;
        result = longDescriptionTask.checkTaskDescription();
        assertEquals(expResult, result);
    }
    //--------------------------------------------------------------------------
    /**
     * Test of createTaskID method, of class Task.
     */
     @Test
    public void testCreateTaskID() {
        System.out.println("createTaskID");
        Task instance = new Task("Login Feature", 0, "Login to authenticate"
                + " users", "Robyn Harrison", 8, "To Do");
        String expResult = "LO:0:SON";
        String result = instance.createTaskID();
        assertEquals(expResult, result);
    
    }
    //--------------------------------------------------------------------------
    /**
     * Test of printTaskDetails method, of class Task.
     */
    @Test
   public void testPrintTaskDetails() {
        System.out.println("printTaskDetails");
        Task instance = new Task("Login Feature", 0, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        String expResult = "Task Name: Login Feature\n" +
                           "Task Number: 0\n" +
                           "Task Description: Create Login to authenticate users\n" +
                           "Developer: Robyn Harrison\n" +
                           "Duration: 8 hours\n" +
                           "Task ID: LO:0:SON\n" +
                           "Status: To Do"; // Expected task details
        String result = instance.printTaskDetails();
        assertEquals(expResult, result);
        
    }
    //--------------------------------------------------------------------------
    /**
     * Test of returnTotalHours method, of class Task.
     */
    @Test
    public void testReturnTotalHours() {
        System.out.println("returnTotalHours");
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task 1", 0, "Description 1",
                "Dev A", 10, "To Do"));
        tasks.add(new Task("Task 2", 1, "Description 2",
                "Dev B", 15, "Doing"));
        int expResult = 25;
        int result = Task.returnTotalHours(tasks);
        assertEquals(expResult, result);
        
    }
    
}
//---------------------------- End of File -------------------------------------