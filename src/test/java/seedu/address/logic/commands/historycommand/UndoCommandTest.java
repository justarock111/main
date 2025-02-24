package seedu.address.logic.commands.historycommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.AlfredException;
import seedu.address.logic.commands.CommandResult;
import seedu.address.stub.ModelManagerStub;

class UndoCommandTest {
    private ModelManagerStub modelStub;

    @BeforeEach
    void setUp() {
        modelStub = new ModelManagerStub();
    }

    @Test
    void execute_success() throws AlfredException {
        CommandResult commandResult = new UndoCommand(1).execute(modelStub);

        assertEquals(String.format(UndoCommand.MESSAGE_SUCCESS, 1), commandResult.getFeedbackToUser());
        assertEquals(null, commandResult.getCommandType());
    }

    @Test
    void equals_success() throws AlfredException {
        UndoCommand orig = new UndoCommand(1);
        UndoCommand other = new UndoCommand(1);
        assertEquals(orig, orig);
        assertEquals(orig, other);
    }
}
