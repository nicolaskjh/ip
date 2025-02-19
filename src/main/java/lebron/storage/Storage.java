package lebron.storage;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lebron.LebronException;
import lebron.parser.DateParser;
import lebron.task.Deadline;
import lebron.task.Event;
import lebron.task.Task;
import lebron.task.TaskList;
import lebron.task.TaskPriority;
import lebron.task.Todo;

/**
 * Represents a storage class to load and store tasks from a text file
 */
public class Storage {
    private final String filePath;

    /**
     * Constructor for Storage
     *
     * @param filePath Filepath to load and store tasks from
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads the tasks from the text file into LeBron chatbot
     *
     * @return A list of tasks read from the text file
     * @throws LebronException If the file does not exist from the given filepath
     */
    public List<Task> loadTasks() throws LebronException {
        File file = new File(this.filePath);
        try {
            Scanner sc = new Scanner(file);
            List<Task> tasks = new ArrayList<>();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");

                String taskType = parts[0].trim();

                String priority = parts[2].trim();
                TaskPriority taskPriority;
                if (priority.equals("l")) {
                    taskPriority = TaskPriority.LOW;
                } else if (priority.equals("m")) {
                    taskPriority = TaskPriority.MEDIUM;
                } else {
                    taskPriority = TaskPriority.HIGH;
                }

                String description = parts[3].trim();

                Task task;
                if (taskType.equals("T")) {
                    task = new Todo(description, taskPriority);
                } else if (taskType.equals("D")) {
                    LocalDate deadline = DateParser.parseDate(parts[4].trim());
                    task = new Deadline(description, taskPriority, deadline);
                } else {
                    LocalDateTime start = DateParser.parseDateTime(parts[4].trim());
                    LocalDateTime end = DateParser.parseDateTime(parts[5].trim());
                    task = new Event(description, taskPriority, start, end);
                }

                if (parts[1].trim().equals("1")) {
                    task.markDone();
                }

                tasks.add(task);
            }

            return tasks;
        } catch (FileNotFoundException e) {
            throw new LebronException("Unable to find file in path " + this.filePath);
        }
    }

    /**
     * Stores the tasks into the text file given from the filepath
     *
     * @param tasks A list of tasks to be stored
     */
    public void storeTasks(TaskList tasks) throws IOException {
        File file = new File(this.filePath);
        file.getParentFile().mkdirs();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.filePath));
            for (int i = 0; i < tasks.getNumTasks(); i++) {
                bw.write(tasks.getTask(i).toDataString());
                if (i < tasks.getNumTasks() - 1) {
                    bw.newLine();
                }
            }
        } catch (IOException) {
            System.err.println("Unable to write to file " + this.filePath);
        }
    }
}
