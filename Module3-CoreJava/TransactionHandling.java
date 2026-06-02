import java.sql.*;

public class TransactionHandling {

    public static void main(String[] args) {

        try {

            Connection con =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "root",
                    "password"
                );

            con.setAutoCommit(false);

            Statement st =
                con.createStatement();

            st.executeUpdate(
                "INSERT INTO student VALUES(1,'A')");

            st.executeUpdate(
                "INSERT INTO student VALUES(2,'B')");

            con.commit();

            System.out.println(
                "Transaction Successful");

            con.close();

        } catch(Exception e) {

            System.out.println(e);
        }
    }
}