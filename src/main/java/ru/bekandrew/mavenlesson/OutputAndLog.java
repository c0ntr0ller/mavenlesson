package ru.bekandrew.mavenlesson;

import org.apache.log4j.Logger;

/**
 * Created by Bek on 16.10.2015.
 */
public class OutputAndLog {
    private static final Logger L = Logger.getLogger(MessageMain.class);

    public static void loggerMessage(String message){
        L.info(message);
    }

    public static void msgInvalidCommand(String cmdName){
        L.info("Invalid command: " + cmdName);
    }
}
