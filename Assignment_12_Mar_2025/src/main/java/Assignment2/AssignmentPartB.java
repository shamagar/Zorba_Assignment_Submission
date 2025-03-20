package Assignment2;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class AssignmentPartB
{
    public static void main(String[] args)
    {

        try
        {
            //Establish the connection
            WriteConnection(); //Method to write back to properties file
            //Connection

            getConnection(); //Establish the connection method
            //Method to create table
            CreateTables();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }




    }
    //method to establish the connection
    public static void WriteConnection() throws IOException
    {
        String filePath = "/Users/shamagar/Desktop/newGit/Batch1017/Zorba_Assignment_Submission/Assignment_12_Mar_2025/src/main/resources/dbConnection.properties";
        //Load the file
        File file = new File(filePath);

        //Convert into byte array
        FileInputStream fileInputStream = new FileInputStream(file);

        //Create Properties Object
        Properties properties = new Properties();
        //Lead the properties file
        properties.load(fileInputStream);
        //Read the content of the properties file
        //String url = properties.getProperty("jdbc:mysql://localhost:3306/JDBCAssignment");
       // String username = properties.getProperty("root");
       // String password = properties.getProperty("Deepanjali");

        // Adding new content with the existing content
        properties.setProperty("url", "jdbc:mysql://localhost:3306/JDBCAssignment");
        properties.setProperty("username", "root");
        properties.setProperty("password", "Deepanjali");
        properties.setProperty("connection","DriverManager.getConnection(url, username, password)");

        //Write back to the file
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        properties.store(fileOutputStream, "Insertion is successful!");
        System.out.println("Insertation done");
    }
    //Another method to establish the connection after reading properties file
    public static Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("/Users/shamagar/Desktop/newGit/Batch1017/Zorba_Assignment_Submission/Assignment_12_Mar_2025/src/main/resources/dbConnection.properties"));
        // loading database driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = properties.getProperty("url");
        String username = properties.getProperty("user");
        String password = properties.getProperty("password");
        //String connection = properties.getProperty("connection");
        //Connection connection = DriverManager.getConnection(url, username, password);
        //return connection;
        return DriverManager.getConnection(url, username, password);
    }

    //Create 2 tables named ‘employee’ (emp_id (pk), emp_name,
    //emp_address, emp_mobile, emp_doj) & ‘Department’(dept_id(pk),
    //dept_name, emp_id (fk))
        public static void CreateTables()
        {
            String employeeTable = "CREATE TABLE IF NOT EXISTS employee (" +
                    "emp_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "emp_name VARCHAR(255), " +
                    "emp_address VARCHAR(255), " +
                    "emp_mobile VARCHAR(20), " +
                    "emp_doj DATE" +
                    ")";

            String departmentTable = "CREATE TABLE IF NOT EXISTS department (" +
                    "dept_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "dept_name VARCHAR(255), " +
                    "emp_id INT, " +
                    "FOREIGN KEY (emp_id) REFERENCES employee(emp_id) ON DELETE CASCADE" +
                    ")";

            try (Connection connection = dbConnection.properties.getConnection();
                 Statement stmt = connection.createStatement())
            {
                stmt.execute(employeeTable);
                stmt.execute(departmentTable);
                System.out.println("Tables Created Successfully.");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

}
