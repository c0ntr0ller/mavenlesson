package ru.bekandrew.mavenlesson;

/**
 * Created by Bek on 16.10.2015.
 */
public interface UserCommand {
    public void execute(MessageController mc, String args);
}
