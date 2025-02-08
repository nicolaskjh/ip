package lebron.task;

import java.util.ArrayList;
import java.util.List;

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
     * @param taskNumber Task number
     * @return Task at the specified index
     */
    public Task getTask(int taskNumber) {
        return this.tasks.get(taskNumber);
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
     * @param taskNumber Task number to be removed
     */
    public void removeTask(int taskNumber) {
        this.tasks.remove(taskNumber);
        this.numTasks--;
    }

    /**
     * Marks a task in the task list as done
     *
     * @param taskNumber Task number to be marked
     */
    public void markDone(int taskNumber) {
        tasks.get(taskNumber).markDone();
    }

    /**
     * Unmarks a task in the task list as done
     *
     * @param taskNumber Task number to be unmarked
     */
    public void unmarkDone(int taskNumber) {
        tasks.get(taskNumber).unmarkDone();
    }

    /**
     * Filters tasks containing specified keyword
     *
     * @param keyword Keyword to check for
     * @return A string representation of the list of tasks filtered
     */
    public String filterTasks(String keyword) {
        StringBuilder tasks = new StringBuilder();

        for (int i = 0; i < this.numTasks; i++) {
            if (this.tasks.get(i).getDescription().contains(keyword)) {
                if (!tasks.isEmpty()) {
                    tasks.append("\n");
                }

                tasks.append(String.format("%d. ", i + 1));
                tasks.append(this.tasks.get(i).toString());
            }
        }

        return tasks.toString();
    }

    /**
     * Returns the list of tasks currently stored in the task list
     *
     * @return List of tasks currently stored in the task list
     */
    @Override
    public String toString() {
        StringBuilder tasks = new StringBuilder();

        for (int i = 0; i < this.numTasks; i++) {
            tasks.append(String.format("%d. ", i + 1));
            tasks.append(this.tasks.get(i).toString());
            if (i != this.numTasks - 1) {
                tasks.append("\n");
            }
        }

        return tasks.toString();
    }
}
