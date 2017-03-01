package seedu.addressbook.commands;

import seedu.addressbook.common.Utils;

public class SuggestCommand extends Command {
    private final String userCommandText;
    
    public SuggestCommand(String userCommandText) {
        this.userCommandText = userCommandText;
    }
    
    @Override
    public CommandResult execute() {
        //look for command word that closes match userCommandText first word
        String[] splittedUserCommand = userCommandText.split("\\s+");
        Command mostRelatedCommand = new HelpCommand(); int distance = 100;
        Command[] allCommandTypes = new Command[Command.COMMAND_TYPES_ALL];
        for (int i = 0; i < 9; i++) {
            if (i == 0) allCommandTypes[i] = new AddCommand(null);
            else if (i == 1) allCommandTypes[i] = new ClearCommand();
            else if (i == 2) allCommandTypes[i] = new DeleteCommand(0);
            else if (i == 3) allCommandTypes[i] = new ExitCommand();
            else if (i == 4) allCommandTypes[i] = new FindCommand(null);
            else if (i == 5) allCommandTypes[i] = new HelpCommand();
            else if (i == 6) allCommandTypes[i] = new ListCommand();
            else if (i == 7) allCommandTypes[i] = new ViewAllCommand(0);
            else if (i == 8) allCommandTypes[i] = new ViewCommand(0);
        }
        for (int i = 0; i < 9; i++) {
            int difference = Utils.levenshteinDistance(allCommandTypes[i].COMMAND_WORD,splittedUserCommand[0]);
            if (difference < distance) {
                mostRelatedCommand = allCommandTypes[i]; distance = difference; 
            }
        }
        return new CommandResult("Do you mean " + mostRelatedCommand.COMMAND_WORD + "?\n"
                + mostRelatedCommand.COMMAND_USAGE);
    }
}
