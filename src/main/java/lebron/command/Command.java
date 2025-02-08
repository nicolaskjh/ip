package lebron.command;

import lebron.task.TaskList;

/**
 * Abstract class representing the commands given by the user
 */
public abstract class Command {
    /**
     * Returns the response given by the chatbot upon execution of the command
     *
     * @param taskList Task list containing the tasks added by the user
     * @return Response given by the chatbot upon successful execution of the command
     */
    public abstract String getResponse(TaskList taskList);

    /**
     * Returns whether the command given by the user is an exit command
     *
     * @return A boolean representing whether the command is an exit command
     */
    public boolean isExit() {
        return false;
    }
}
