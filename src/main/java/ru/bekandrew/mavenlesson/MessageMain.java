package ru.bekandrew.mavenlesson;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by Bek on 15.10.2015.
 */
public class MessageMain {
    private static final Logger L = Logger.getLogger(MessageMain.class);

    //Connection
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        if (scanner != null) {
            while (scanner.hasNext()) {
                String strCommand = scanner.nextLine();
                if (strCommand.equals("EXIT")) {
                    break;
                }
            }
        }

//
//            Statement stmnt = conn.createStatement()){
//            stmnt.execute("create table test(id int, postDate timestamp, message varchar(120))");
//            L.info("mesage table created");
//            int inserted = stmnt.executeUpdate("insert into test(id, name) values (1, 't1')");
//            L.info("insert " + inserted + " rows");
//            PreparedStatement ps = conn.prepareStatement("insert into test(id, name) values (?,?)");
//            ps.setInt(1, 2);
//            ps.setString(2, "t2");
//            inserted = ps.executeUpdate();
//            L.info("insert " + inserted + " rows");

    }

    public static void loggerMessage(String message){
        L.info(message);
    }
}
