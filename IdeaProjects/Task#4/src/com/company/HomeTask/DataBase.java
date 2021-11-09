package com.company.HomeTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private final String HOST = "localhost";
    private  final String PORT = "3306";
    private  final String DB_NAME = "Task#4";
    private  final String LOGIN = "admin";
    private  final String PASS = "0";
    private Connection dbconn = null;

    public Connection getDBConnection() throws ClassNotFoundException, SQLException {
        String strConn = "jdbc:mysql://"+HOST+":"+PORT+"/"+DB_NAME;
        Class.forName("com.mysql.jdbc.Driver");
        //dbconn = DriverManager.getConnection(strConn, LOGIN, PASS);
        dbconn = DriverManager.getConnection(strConn, LOGIN, PASS);

        return dbconn;
    }
    public void isConnected()throws ClassNotFoundException, SQLException{
        dbconn = getDBConnection();
        System.out.println(dbconn.isValid(1000));
    }
    public void createTableItems(String DB_NAME) throws ClassNotFoundException,SQLException
    {
        String sql = "CREATE TABLE  IF NOT EXIST items"
                + "(ID INT AUTO-INCREMETNT," +
                "TITLE VARCHAR(50), PRICE VARCHAR(36)"+
                "CATEGORY VARCHAR(50)"+
                "PRIMARY KEY (ID)"+
                "ENGINE=MYISAM";
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
    }
    public  void createTableUsers(String DB_NAME) throws  ClassNotFoundException, SQLException {
        String sql = "CREATE TABLE  IF NOT EXIST users"
            + "(ID INT AUTO-INCREMENT PRIMARY KEY,"+
        "LOGIN VARCHAR(50), PASS VARCHAR(36)"+
                "ENGINE = MYISAM";
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
    }
    public void createTableOrders (String DB_NAME) throws ClassNotFoundException,SQLException {
        String sql = "CREATE TABLE  IF NOT EXIST 'orders'"
        +("USER_ID INT(20), USERNAME VARCHAR (20), " +
                " ITEM_ID INT(20), ITEM_TITLE VARCHAR(20)");
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
    }
    public void findByUserName (String DB_NAME) throws  ClassNotFoundException, SQLException
    {
        String sql = "SELECT id,login" +
                "FROM Users " +
                "WHERE login = 'jhonn'";
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
    }
    public void findByCategory (String DB_NAME) throws  ClassNotFoundException, SQLException
    {
        String sql = "SELECT category, title" +
                "FROM items" +
                "WHERE category = 'hats '";
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
    }
    public void insertInToOrders (String DB_NAME) throws  ClassNotFoundException, SQLException
    {
        String sql = "SELECT * INTO 'orders' FROM 'items', 'users'" +
                " WHERE category = 'hats', login = 'jhonn'";
        Statement statement = getDBConnection().createStatement();
        statement.executeUpdate(sql);
    }

}
