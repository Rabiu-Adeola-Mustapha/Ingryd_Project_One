import java.sql.*;
import java.util.Scanner;

public class ProjectOne {

    public static void main(String[] args) {

        ProjectOne.createTable();
        System.out.println(ProjectOne.populateTable());
    }

    static String url = "jdbc:mysql://localhost:3306/project_one";
    static String userName = "root";
    static String password = "root";

    public static int count;

     //method to create DB connection and Table
    public static void createTable() {
            // creating table with fields
            // name, email, age, location, designation
            try (Connection connection =
                         DriverManager.getConnection("jdbc:mysql://localhost:3306/project_one",
                                 "root", "root");
                 Statement statement = connection.createStatement()) {

                statement.execute("CREATE TABLE IF NOT EXISTS client(name Text NOT NULL , email Text NOT NULL, age Int, location Text NOT NULL, designation Text NOT NULL )" );







            } catch(SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    public static int populateTable(){


        try (Connection connection =
                DriverManager.getConnection(url,userName, password); Scanner scanner = new Scanner(System.in)){

            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO client(name, email, age,location, designation) VALUES(?, ?, ?, ? , ?)");


            for ( count = 0; count <10 ; count ++) {
                // setting name
                System.out.println("PLease Enter Name: ");
                String name = scanner.nextLine();
                insertStatement.setString(1, name);

                // setting email
                System.out.println("PLease enter Email: ");
                String email = scanner.nextLine();
                insertStatement.setString(2, email);

                // setting age
                System.out.println("Please Enter Age: ");
                int age = scanner.nextInt();
                insertStatement.setInt(3, age);
                scanner.nextLine();

                // setting location
                System.out.println("Please Enter Location: ");
                String location = scanner.nextLine();
                insertStatement.setString(4, location);

                // setting designation
                System.out.println("Please Enter Designation: ");
                String designation = scanner.nextLine();
                insertStatement.setString(5, designation);



                insertStatement.execute();


            }



        }catch(SQLException e){
            System.out.println(e.getMessage());

        }


        return count;

    }




}













