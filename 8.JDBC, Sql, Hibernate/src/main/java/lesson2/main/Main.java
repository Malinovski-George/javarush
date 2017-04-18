package lesson2.main;

import java.sql.*;

/**
 * Created by Gia on 12.04.2017.
 */
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtable?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        Connection conn;

        try {
            // Driver driver = new FabricMySQLDriver();
            // DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            /* int res =   statement.executeUpdate("update animal set anim_name = 'Duck' where id = 2;");
            statement.addBatch("insert into animal(anim_name, anim_desc) values ('batch1','desc')");
            statement.addBatch("insert into animal(anim_name, anim_desc) values ('batch2','desc')");
            statement.addBatch("insert into animal(anim_name, anim_desc) values ('batch3','desc')");
            statement.executeBatch();
            System.out.println(res);
            conn.commit();
            statement.clearBatch();*/

            int age = 5;
            final String INSERT_NEW = "insert into users (name, mail, age) values (?,?,?)";
            PreparedStatement preparedStatement = null;
            preparedStatement = conn.prepareStatement(INSERT_NEW);

            for (int i = 0; i < 10; i++) {
                preparedStatement.setString(1, "name_user" + i);
                preparedStatement.setString(2, "true");
                preparedStatement.setInt(3, age + i);

            /*  preparedStatement.setDate(5, new Date(Calendar.getInstance().getTimeInMillis()));
            try {
                preparedStatement.setBlob(6, new FileInputStream("1.jpg"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }*/
                preparedStatement.executeUpdate();

                ResultSet rs = null;
                rs = statement.executeQuery("SELECT * FROM users");

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    System.out.println(id + " - id, " + name);
                }

            }
            if (!conn.isClosed()) {
                System.out.println("УРА!! Соединение с БД установлено!!");
            }
            conn.close();

            if (conn.isClosed()) {
                System.out.println("Соединение с БД закрыто...");
            }
        } catch (SQLException e) {
            System.out.println("ошибка загрузки");
        }
    }
}
