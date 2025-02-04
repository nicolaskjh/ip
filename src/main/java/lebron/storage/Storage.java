package lebron.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lebron.task.Deadline;
import lebron.task.Task;
import lebron.task.TaskList;
import lebron.task.Todo;
import lebron.task.Event;

import lebron.LebronException;

public class Storage {
    private String filePath = "./data/lebron.txt";

    private final String TASK_TODO = "T";
    private final String TASK_DEADLINE = "D";
    private final String TASK_EVENT = "E";

    private final String TASK_DONE = "1";

    public List<Task> loadTasks() throws LebronException {
        File file = new File(this.filePath);
        try {
            Scanner sc = new Scanner(file);
            List<Task> tasks = new ArrayList<>();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                String taskType = parts[0].trim();
                String description = parts[2].trim();

                Task task;
                if (taskType.equals(TASK_TODO)) {
                    task = new Todo(description);
                } else if (taskType.equals(TASK_DEADLINE)) {
                    String deadline = parts[3].trim();
                    task = new Deadline(description, deadline);
                } else {
                    String start = parts[3].trim();
                    String end = parts[4].trim();
                    task = new Event(description, start, end);
                }

                if (parts[1].trim().equals(TASK_DONE)) {
                    task.markDone();
                }

                tasks.add(task);
            }

            return tasks;
        } catch (FileNotFoundException e) {
            throw new LebronException("Unable to find file in path " + this.filePath);
        }
    }

    public void storeTasks(TaskList tasks) {
        try {
            File file = new File(this.filePath);
            FileWriter fw = new FileWriter(file);
            StringBuilder storedTasks = new StringBuilder();

            for (int i = 0; i < tasks.getNumTasks(); i++) {
                Task task = tasks.getTask(i);

                storedTasks.append(task.toDataString());
                if (i < tasks.getNumTasks() - 1) {
                    storedTasks.append("\n");
                }
            }

            fw.write(storedTasks.toString());
            System.out.println("Tasks stored successfully!");
            fw.close();
        } catch (IOException e) {
            String fileDirectory = this.filePath.replace(
                    this.filePath.substring(this.filePath.indexOf("/")), "");
            File file = new File(fileDirectory);

            if (file.mkdir()) {
                storeTasks(tasks);
            } else {
                System.out.println("Unable to create directory " + fileDirectory);
            }
        }
    }
}
