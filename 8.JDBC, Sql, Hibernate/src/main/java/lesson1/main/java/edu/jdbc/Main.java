package lesson1.main.java.edu.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public final class Main {

    public static void main(String[] args) throws Exception {

        Class.forName("org.h2.Driver");

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            String basePath = "C:/Users/Gia/IdeaProjects/JavaRushTasks/8.JDBC, Sql, Hibernate/src/main/java/lesson1/main/resources";

            connection = DriverManager.getConnection("jdbc:h2:mem:sample;INIT=RUNSCRIPT FROM '"
                    + basePath + "/create.sql'\\;RUNSCRIPT FROM '"
                    + basePath + "/fill.sql'", "sa", "");

            statement = connection.createStatement();

            statement.execute("INSERT INTO PERSON VALUES (null, 'Test')");

            rs = statement.executeQuery("SELECT * FROM PERSON");

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                System.out.println(id + " - id, " + name);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            if (rs != null) {
                rs.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }
}
