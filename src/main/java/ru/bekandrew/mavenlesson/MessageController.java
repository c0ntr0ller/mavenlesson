package ru.bekandrew.mavenlesson;

import javax.activation.MailcapCommandMap;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bek on 15.10.2015.
 */
public class MessageController implements GuestBookControler{
    private static Connection conn;
    private Statement stmnt;
    private PreparedStatement ps;

    public MessageController(){
        try {
            conn = DriverManager.getConnection("jdbc:h2:mem:mydatabase");
        }
        catch (SQLException e){
            MessageMain.loggerMessage("Database connection error");
        }

        try {
            stmnt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps = conn.prepareStatement("insert into test(id, name) values (?,?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmnt.execute("create table messages(id int, postDate timestamp, message varchar(120))");
        }
        catch (SQLException e){
            MessageMain.loggerMessage("create table messages failed");
        }
    }

    @Override
    public void addRecord(String message) {
        try {
            ps.setInt(1, 2);
            ps.setString(2, "t2");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Record> getRecords() {
        List<Record> lr = new ArrayList<>();
        try(ResultSet rs = stmnt.executeQuery("select id, postDate, message from messages")) {
            rs.first();
            {
                lr.add(new Record(rs.getInt(1), rs.getTimestamp(2), rs.getString(3)));
            }while(!rs.isLast());

        } catch (SQLException e) {
            MessageMain.loggerMessage("Cannot get messages");
        }
        finally {
            return lr;
        }
    }

    public void PrintRecords(List<Record> list){

    }
}
