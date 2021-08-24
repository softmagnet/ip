public abstract class Command {
    protected String[] inputTokens;

    /**
     * Checks remaining user input for incomplete commands.
     *
     * @param inputTokens String array from user input.
     * @throws YoyoException.YoyoIncompleteCommandException Thrown if command is incomplete.
     */
    public static void checkCompleteCommand(String[] inputTokens)
            throws YoyoException.YoyoIncompleteCommandException {
        if (inputTokens.length < 2 || inputTokens[1].trim().length() == 0) {
            throw new YoyoException.YoyoIncompleteCommandException(
                    "You have not entered enough information for your command.");
        }
    }

    Command(String[] inputTokens) {
        this.inputTokens = inputTokens;
    }

    public boolean shouldContinueProgram() {
        return true;
    }

    public abstract void execute(TaskList tasks, Storage storage, Ui ui)
            throws YoyoException;

}
