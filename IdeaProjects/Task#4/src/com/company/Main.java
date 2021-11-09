package com.company;

import com.company.HomeTask.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class Main {
    public static void main(String[] args) {
	DataBase db = new DataBase();
        try {
            db.isConnected();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC драйвер отсутствует");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL");
        }
    }
}
