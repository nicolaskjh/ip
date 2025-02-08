package lebron.command;

import lebron.task.TaskList;

/**
 * Represents an ExitCommand to exit the chatbot
 */
public class ExitCommand extends Command {
    /**
     * Returns the response given upon exiting the chatbot
     *
     * @param taskList Task list containing the tasks added by the user
     * @return Response given by the chatbot upon exiting the chatbot
     */
    @Override
    public String getResponse(TaskList taskList) {
        return "Hope to see you again soon! meow";
    }

    /**
     * Returns true to indicate the command is an ExitCommand
     *
     * @return True to indicate this command is an ExitCommand
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
