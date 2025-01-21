package task;

import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

public class TaskList {
    private List<Task> tasks;
    private int numTasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
        this.numTasks = 0;
    }

    public Task getTask(int idx) {
        return this.tasks.get(idx);
    }

    public int getNumTasks() {
        return this.numTasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
        this.numTasks++;
    }

    public void removeTask(int idx) {
        this.tasks.remove(idx);
        this.numTasks--;
    }

    public void markDone(int idx) {
        tasks.get(idx).markDone();
    }

    public void unmarkDone(int idx) {
        tasks.get(idx).unmarkDone();
    }

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
