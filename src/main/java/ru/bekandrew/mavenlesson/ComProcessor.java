package ru.bekandrew.mavenlesson;

import org.apache.log4j.Logger;
import org.h2.command.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bek on 16.10.2015.
 */
public class ComProcessor {
    private Map<String, UserCommand> cmds;
    private MessageController mc = new MessageController();

    ComProcessor(){
        cmds = new HashMap();
        cmds.put("ADD", new AddCmd());
        cmds.put("LIST", new ListCmd());
        OutputAndLog.loggerMessage("support commands ADD <message> and LIST");
    }

    public void proceedCommand(String incmd){
        String[] args = incmd.split(" ");
        if (!args[0].equals("#") && !args[0].isEmpty()) {

            UserCommand c = cmds.get(args[0]);

            if (c == null) {
                OutputAndLog.msgInvalidCommand(args[0]);
            } else {
                String message = null;
                int messageStart = incmd.indexOf(" ");

                if ((messageStart > 0) && (incmd.length() > messageStart)){
                    message = incmd.substring(messageStart + 1);
                }

                c.execute(mc, message);
            }
        }
    }
}

class AddCmd implements UserCommand{

    @Override
    public void execute(MessageController mc, String message) {
        if (!message.isEmpty()) {
            mc.addRecord(message);
        }

    }
}

class ListCmd implements UserCommand{
    @Override
    public void execute(MessageController mc, String message) {
        mc.PrintRecords();
    }
}

