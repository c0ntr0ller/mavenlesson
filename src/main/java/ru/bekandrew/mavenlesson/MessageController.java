package ru.bekandrew.mavenlesson;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Bek on 15.10.2015.
 */
public class MessageController implements GuestBookController {
    private static Connection conn;
    private Statement stmnt;
    private PreparedStatement ps;

    public MessageController(){
        try {
            conn = DriverManager.getConnection("jdbc:h2:mem:mydatabase");
        }
        catch (SQLException e){
            OutputAndLog.loggerMessage("database connection error");
        }

        try {
            stmnt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmnt.execute("create table messages(id int AUTO_INCREMENT, postDate timestamp DEFAULT CURRENT_TIMESTAMP(), message varchar(120))");
        }
        catch (SQLException e){
            OutputAndLog.loggerMessage("create table 'messages' failed");
        }

        try {
            ps = conn.prepareStatement("insert into messages(message) values (?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void addRecord(String message) {
        try {
            ps.setString(1, message);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Record> getRecords() {
        List<Record> lr = new ArrayList<>();
        try(ResultSet rs = stmnt.executeQuery("select id, postDate, message from messages")) {
            while(!rs.isLast()){
                rs.next();
                lr.add(new Record(rs.getInt(1), rs.getTimestamp(2), rs.getString(3)));
            }
            rs.close();
            System.out.println("lr size " + lr.size());
        } catch (SQLException e) {
            OutputAndLog.loggerMessage("Cannot get messages");
        }
        finally {
            return lr;
        }
    }

    public void PrintRecords(){
        PrintRecords(getRecords());
    }

    public void PrintRecords(List<Record> list){
        MessageFormat formatDateTime = new MessageFormat("{0, date, yyyy/MM/dd hh:mm:ss}");
        for(Record r: list){
            OutputAndLog.loggerMessage("ID: " + r.getId());
            OutputAndLog.loggerMessage("date/time: " + formatDateTime.format(new Object[]{r.getPostDate()}));
            OutputAndLog.loggerMessage("message: " + r.getMessage());
        }
    }
}
