package ru.bekandrew.mavenlesson;

import java.util.Scanner;

/**
 * Created by Bek on 15.10.2015.
 */
public class MessageMain {

    //Connection
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        ComProcessor cp = new ComProcessor();

        if (scanner != null) {
            while (scanner.hasNext()) {
                String strCommand = scanner.nextLine();

                if (strCommand.equals("EXIT")) {
                    break;
                }
                else{
                    cp.proceedCommand(strCommand);
                }
            }
        }
    }
}
