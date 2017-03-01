package seedu.addressbook.commands;

import java.util.ArrayList;

public class UndoCommand {
	private static ArrayList <String> commandList = new ArrayList<String>();
    public static final String COMMAND_WORD = "undo";
   
	public UndoCommand() {
		checkCommand();
		
	}
	
	public void addCommand(String c){
		commandList.add(c);
	}
	
	private String checkCommand() {
		String feedback = ""; //will find a way to put the feedback into the commandresult
		String lastCommand = commandList.get(commandList.size()-1);
		if(lastCommand.startsWith(AddCommand.COMMAND_WORD)) {
			//delete the person
			return feedback; //something like "undo add John"
		}
		if(lastCommand.startsWith(DeleteCommand.COMMAND_WORD)) {
			//add the person back in
			return feedback;  //"undo delete John"
		}
		
		//one more with an edit command
		if(lastCommand.startsWith(ClearCommand.COMMAND_WORD)) {
			//unclear all 
			return feedback;
		}
		
		//for the rest of the commands like find, list, help dont need to undo
		else{
			feedback = "nothing to undo";
			return feedback; 
		}
	}
	
}
