import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;
    private int numTasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
        this.numTasks = 0;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
        this.numTasks++;
        System.out.println("--------------------------------------");
        System.out.println("Got it, I've added this task:");
        System.out.println(task.toString());
        System.out.println("You now have " + this.numTasks + " task(s) in the list.");
        System.out.println("--------------------------------------");
    }

    public void markTaskDone(int id) {
        Task task = this.tasks.get(id - 1);
        task.markDone();
        System.out.println("--------------------------------------");
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task.toString());
        System.out.println("--------------------------------------");
    }

    public void markTaskNotDone(int id) {
        Task task = this.tasks.get(id - 1);
        task.markNotDone();
        System.out.println("--------------------------------------");
        System.out.println("OK, I've marked this task as not done:");
        System.out.println(task.toString());
        System.out.println("--------------------------------------");
    }

    public void listTasks() {
        System.out.println("--------------------------------------");
        for (int i = 1; i <= this.tasks.size(); i++) {
            System.out.println(i + ". " + this.tasks.get(i - 1).toString());
        }
        System.out.println("--------------------------------------");
    }
}
