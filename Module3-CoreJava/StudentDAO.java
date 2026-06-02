import java.sql.*;

public class StudentDAO {

    public static void main(String[] args) {

        try {

            Connection con =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "root",
                    "password"
                );

            String query =
                "INSERT INTO student VALUES(101,'John')";

            Statement st =
                con.createStatement();

            st.executeUpdate(query);

            System.out.println(
                "Record Inserted");

            con.close();

        } catch(Exception e) {

            System.out.println(e);
        }
    }
}