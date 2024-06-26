package assingmentpart1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class AssingmentPOETest {

    private ArrayList<AssingmentPOE.Task> tasks;

    public AssingmentPOETest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tasks = new ArrayList<>();
        tasks.add(new AssingmentPOE.Task("Mike Smith", 1, "Create Login", "Mike Smith", 5, "To Do"));
        tasks.add(new AssingmentPOE.Task("Edward Harrington", 2, "Create Add Features", "Edward Harrington", 8, "Doing"));
        tasks.add(new AssingmentPOE.Task("Samantha Paulson", 3, "Create Reports", "Samantha Paulson", 2, "Done"));
        tasks.add(new AssingmentPOE.Task("Glenda Oberholzer", 4, "Add Arrays", "Glenda Oberholzer", 11, "To Do"));
    }

    @After
    public void tearDown() {
    }
     /**
     * Test of checkDeveloperArray method, of class AssingmentPOE.
     */
    @Test
    public void testCheckDeveloperArray() {
        System.out.println("checkDeveloperArray");
        assertEquals("Mike Smith", tasks.get(0).developer);
        assertEquals("Edward Harrington", tasks.get(1).developer);
        assertEquals("Samantha Paulson", tasks.get(2).developer);
        assertEquals("Glenda Oberholzer", tasks.get(3).developer);
    }
    /**
     * Test of displayLongestTask method, of class AssingmentPOE.
     */
    @Test
    public void testDisplayLongestTask() {
        System.out.println("displayLongestTask");
        AssingmentPOE.Task longestTask = tasks.get(0);
        for (AssingmentPOE.Task task : tasks) {
            if (task.duration > longestTask.duration) {
                longestTask = task;
            }
        }
        assertEquals("Glenda Oberholzer", longestTask.developer);
        assertEquals(11, longestTask.duration);
    }
      /**
     * Test of searchTaskByName method, of class AssingmentPOE.
     */
    @Test
    public void testSearchTaskByName() {
        System.out.println("searchTaskByName");
        AssingmentPOE.Task result = null;
        for (AssingmentPOE.Task task : tasks) {
            if (task.name.equalsIgnoreCase("Create Login")) {
                result = task;
                break;
            }
        }
        assertNotNull(result);
        assertEquals("Mike Smith", result.developer);
        assertEquals("Create Login", result.name);
    }
    /**
     * Test of searchTasksByDeveloper method, of class AssingmentPOE.
     */
    @Test
    public void testSearchTasksByDeveloper() {
        System.out.println("searchTasksByDeveloper");
        ArrayList<AssingmentPOE.Task> result = new ArrayList<>();
        for (AssingmentPOE.Task task : tasks) {
            if (task.developer.equalsIgnoreCase("Samantha Paulson")) {
                result.add(task);
            }
        }
        assertEquals(1, result.size());
        assertEquals("Create Reports", result.get(0).name);
    }
    /**
     * Test of deleteTask method, of class AssingmentPOE.
     */
    @Test
    public void testDeleteTask() {
        System.out.println("deleteTask");
        AssingmentPOE.Task taskToRemove = null;
        for (AssingmentPOE.Task task : tasks) {
            if (task.name.equalsIgnoreCase("Create Reports")) {
                taskToRemove = task;
                break;
            }
        }
        assertNotNull(taskToRemove);
        tasks.remove(taskToRemove);
        for (AssingmentPOE.Task task : tasks) {
            assertNotEquals("Create Reports", task.name);
        }
    }
    /**
     * Test of showReport method, of class AssingmentPOE.
     */
    @Test
    public void testShowReport() {
        System.out.println("showReport");
        StringBuilder report = new StringBuilder();
        for (AssingmentPOE.Task task : tasks) {
            report.append(task.getTaskDetails()).append("\n\n");
        }
        String reportString = report.toString();
        assertNotNull(reportString);
        assertTrue(reportString.contains("Mike Smith"));
        assertTrue(reportString.contains("Edward Harrington"));
        assertTrue(reportString.contains("Samantha Paulson"));
        assertTrue(reportString.contains("Glenda Oberholzer"));
    }
    /**
     * Test of displayDoneTasks method, of class AssingmentPOE.
     */
    @Test
    public void testDisplayDoneTasks() {
        System.out.println("displayDoneTasks");
        ArrayList<AssingmentPOE.Task> doneTasks = new ArrayList<>();
        for (AssingmentPOE.Task task : tasks) {
            if ("Done".equalsIgnoreCase(task.status)) {
                doneTasks.add(task);
            }
        }
        assertEquals(1, doneTasks.size());
        assertEquals("Create Reports", doneTasks.get(0).name);
        assertEquals("Samantha Paulson", doneTasks.get(0));
    }
}
