package DBMS.JDBC_Assingment;

import java.net.ConnectException;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ConnectException, SQLException, ClassNotFoundException {
        SQL_Queries sql_Queries = new SQL_Queries();
        sql_Queries.dbConnection();
        sql_Queries.assignment1();
        sql_Queries.assignment2();
        sql_Queries.assignment3();
        sql_Queries.assignment4();
    }
}