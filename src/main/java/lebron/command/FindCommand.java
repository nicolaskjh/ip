package lebron.command;

import lebron.task.TaskList;

/**
 * Represents a FindCommand to list all tasks
 */
public class FindCommand extends Command {
    private String keyword;

    /**
     * Constructor for FindCommand
     *
     * @param keyword Keyword to filter tasks by
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Returns a list of tasks with the given keyword
     *
     * @param taskList Task list containing the tasks added by the user
     * @return List of tasks currently stored by the chatbot
     */
    @Override
    public String getResponse(TaskList taskList) {
        if (taskList.filterTasks(this.keyword).isEmpty()) {
            return "No tasks found containing the given keyword!";
        } else {
            return "Here are the tasks that contain the keyword " + this.keyword + ":\n"
                    + taskList.filterTasks(this.keyword);
        }
    }
}