package BigLesson.java;

import java.sql.*;

public final class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtable?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        testPlan(conn);
    }

    static void testPlan(Connection conn) throws SQLException {
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try {
            statement = conn.createStatement();
            System.out.println("Start of test plan.");
            statement.execute("drop table if exists test.employees");
            createTables(statement);
            insertSomething(statement);
            printAll(statement);

            preparedStatement = conn.prepareStatement("SELECT * FROM employees WHERE NAME LIKE ? ORDER BY ID");
            printAllAsPartOfName(preparedStatement, "ов");

           /* updateSomething(statement);
            printAll(statement);
*/
            deleteSomethingById(statement, 2);
            printAll(statement);

        } finally {
            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
    }

    private static void createTables(Statement statement) throws SQLException {
        // String sttm =  "CREATE TABLE Positions(ID int IDENTITY(1,1) NOT NULL CONSTRAINT PK_Positions PRIMARY KEY, Name nvarchar(30) NOT NULL";

        String sttm = "CREATE TABLE IF NOT EXISTS test.employees (" +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "name VARCHAR(45) NOT NULL, " +
                "email VARCHAR(45) NULL UNIQUE, " +
                "PositionID VARCHAR(45) NULL, " +
                "DepartmentID VARCHAR(45) NULL, " +
                "HireDate DATETIME NOT NULL DEFAULT now(), " +
                "PRIMARY KEY (id)) ";

        statement.execute(sttm);
        statement.execute("use test");

        System.out.println("таблица создана");
    }

    private static void insertSomething(Statement statement) throws SQLException {

        statement.execute("INSERT into Employees (Name,Email,PositionID,DepartmentID) VALUES\n" +
                "(N'Иванов И.И.','i.ivanov@test.tt',2,1),\n" +
                "(N'Петров П.П.','p.petrov@test.tt',3,3),\n" +
                "(N'Сидоров С.С.','s.sidorov@test.tt',1,2),\n" +
                "(N'Андреев А.А.','a.andreev@test.tt',4,3);");

        System.out.println("данные добавлены, инициализация прошла успешно");
    }

    private static void printAll(Statement statement) throws SQLException {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT * FROM employees ORDER BY ID");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                System.out.println(id + ": " + name);
            }
            System.out.println();
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }

    private static void printAllAsPartOfName(PreparedStatement statement, String partOfName) throws SQLException {
        ResultSet rs = null;
        try {
            String request = "%" + partOfName + "%";
            statement.setString(1, request);
            rs = statement.executeQuery();

            System.out.println("Persons whose name contains " + request + ":");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                System.out.println(id + ": " + name);
            }
            System.out.println();
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }

    /*private static void updateSomething(Statement statement) throws SQLException {
        System.out.println("Change all ** to *");
        int rowsUpdated = statement.executeUpdate("UPDATE employees SET NAME='***' WHERE NAME='***';");
        System.out.printf("%d rows updated.\n" , rowsUpdated);
    }*/

    private static void deleteSomethingById(Statement statement, int id) throws SQLException {
        System.out.println("Delete all person who id = " + id);
        int rowsDeleted = statement.executeUpdate("DELETE FROM employees WHERE id = " + id + ";");
        System.out.printf("%d rows deleted.\n" , rowsDeleted);
        System.out.println("---------result----------");
    }




}
