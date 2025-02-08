package lebron.command;

import lebron.task.TaskList;

/**
 * Represents a ListCommand to list all tasks
 */
public class ListCommand extends Command {
    /**
     * Returns a list of tasks currently stored by the chatbot
     *
     * @param taskList Task list containing the tasks added by the user
     * @return List of tasks currently stored by the chatbot
     */
    @Override
    public String getResponse(TaskList taskList) {
        if (taskList.getNumTasks() == 0) {
            return "You currently have no tasks!";
        } else {
            return "You currently have " + taskList.getNumTasks() + " tasks:\n"
                    + taskList.toString();
        }
    }
}
