package lebron.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
                String description = parts[2].trim();

                Task task;
                if (taskType.equals("T")) {
                    task = new Todo(description);
                } else if (taskType.equals("D")) {
                    LocalDate deadline = DateParser.parseDate(parts[3].trim());
                    task = new Deadline(description, deadline);
                } else {
                    LocalDateTime start = DateParser.parseDateTime(parts[3].trim());
                    LocalDateTime end = DateParser.parseDateTime(parts[4].trim());
                    task = new Event(description, start, end);
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
            fw.close();
        } catch (IOException e) {
            String fileDirectory = this.filePath.replace(
                    this.filePath.substring(this.filePath.indexOf("/")), "");
            File file = new File(fileDirectory);

            if (file.mkdir()) {
                storeTasks(tasks);
            }
        }
    }
}
