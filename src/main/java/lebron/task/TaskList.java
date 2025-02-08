package lebron.task;

import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

/**
 * Represents a TaskList to store tasks added by the user
 */
public class TaskList {
    private List<Task> tasks;
    private int numTasks;

    /**
     * Constructor for TaskList
     */
    public TaskList() {
        this.tasks = new ArrayList<Task>();
        this.numTasks = 0;
    }

    /**
     * Constructor for Tasklist
     *
     * @param tasks List of tasks to load into the task list
     */
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
        this.numTasks = tasks.size();
    }

    /**
     * Returns the task specified by the task number
     *
     * @param idx Task number
     * @return Task at the specified index
     */
    public Task getTask(int idx) {
        return this.tasks.get(idx);
    }

    /**
     * Returns the number of tasks currently stored in the task list
     *
     * @return Number of tasks currently stored in the task list
     */
    public int getNumTasks() {
        return this.numTasks;
    }

    /**
     * Adds a task into the task list
     *
     * @param task Task to be added in the task list
     */
    public void addTask(Task task) {
        this.tasks.add(task);
        this.numTasks++;
    }

    /**
     * Removes a task from the task list
     *
     * @param idx Task number to be removed
     */
    public void removeTask(int idx) {
        this.tasks.remove(idx);
        this.numTasks--;
    }

    /**
     * Marks a task in the task list as done
     *
     * @param idx Task number to be marked
     */
    public void markDone(int idx) {
        tasks.get(idx).markDone();
    }

    /**
     * Unmarks a task in the task list as done
     *
     * @param idx Task number to be unmarked
     */
    public void unmarkDone(int idx) {
        tasks.get(idx).unmarkDone();
    }

    /**
     * Returns the list of tasks currently stored in the task list
     *
     * @return List of tasks currently stored in the task list
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < this.numTasks; i++) {
            res.append(String.format("%d. ", i + 1));
            res.append(this.tasks.get(i).toString());
            if (i != this.numTasks - 1) {
                res.append("\n");
            }
        }

        return res.toString();
    }
}
