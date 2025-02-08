package lebron;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lebron.parser.InputParser;

public class InputParserTest {
    @Test
    public void readTodoInput_emptyDescription_exceptionThrown() {
        try {
            assertEquals("[T]", InputParser.readTodoInput("").toString());
        } catch (LebronException e) {
            assertEquals("I need a description for your todo task!" , e.getMessage());
        }
    }

    @Test
    public void readDeleteInput_emptyTaskNumber_exceptionThrown() {
        try {
            assertEquals("", InputParser.readDeleteInput("").toString());
        } catch (LebronException e) {
            assertEquals("I need a task number to delete!", e.getMessage());
        }
    }
}
