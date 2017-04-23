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
            statement.execute("drop table if exists test.Departments");
            statement.execute("drop table if exists test.Positions");
            createTables(statement);
            insertSomething(statement);
            createDependence(statement);
            printAll(statement);
            updateDB(statement);

            insertRandom(statement);

            preparedStatement = conn.prepareStatement("SELECT * FROM employees WHERE NAME LIKE ? ORDER BY ID");
            printAllAsPartOfName(preparedStatement, "ов");

           /* updateSomething(statement);
            printAll(statement);
            */

            deleteSomethingById(statement, 5);
            printAndSortAlias(statement);

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

    private static void createDependence(Statement statement) throws SQLException {

        statement.execute("ALTER TABLE Employees ADD CONSTRAINT FK_Employees_PositionID\n" +
                "FOREIGN KEY(PositionID) REFERENCES Positions(ID)");


        statement.execute("ALTER TABLE Employees ADD CONSTRAINT FK_Employees_DepartmentID\n" +
                "FOREIGN KEY(DepartmentID) REFERENCES Departments(ID)\n");


        statement.executeUpdate("UPDATE Employees e\n" +
                "SET\n" +
                "  PositionID=(SELECT ID FROM Positions WHERE Name=e.Position),\n" +
                "  DepartmentID=(SELECT ID FROM Departments WHERE Name=e.Department)\n"
        );
        //  statement.execute();

    }

    private static void printAndSortAlias(Statement statement) throws SQLException {

        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT\n" +
                    "CONCAT(IFNULL(LastName,''),' ',IFNULL(FirstName,''),' ',IFNULL(MiddleName,'')) FullName,\n" +
                    "HireDate AS 'Дата приема',\n" +
                    "  -- слово AS не обязательно\n" +
                    "    Salary ZP\n" +
                    "    FROM Employees");


            /*SELECT ID,Name,Salary
            FROM Employees
            WHERE PositionID<>3 AND/OR PositionID<>4
            */

           /* SELECT ID,Name,Salary
            FROM Employees
            WHERE Salary BETWEEN 2000 AND 3000 -- у кого ЗП в диапазоне 2000-3000
            AND DepartmentID=3
            */

           /* SELECT
                    ID,Name,Salary,

                    CASE
            WHEN Salary>=3000 THEN 'ЗП >= 3000'
            WHEN Salary>=2000 THEN '2000 <= ЗП < 3000'
            ELSE 'ЗП < 2000'
            END SalaryTypeWithELSE,

                    CASE
            WHEN Salary>=3000 THEN 'ЗП >= 3000'
            WHEN Salary>=2000 THEN '2000 <= ЗП < 3000'
            END SalaryTypeWithoutELSE

            FROM Employees
            */

            /*SELECT
                    ID,Name,Salary,DepartmentID,
            -- для наглядности выведем процент в виде строки
            CASE DepartmentID -- проверяемое значение
            WHEN 2 THEN '10%' -- 10% от ЗП выдать Бухгалтерам
            WHEN 3 THEN '15%' -- 15% от ЗП выдать ИТ-шникам
            ELSE '5%' -- всем остальным по 5%
                    END NewYearBonusPercent,

                    -- построим выражение с использованием CASE, чтобы увидеть сумму бонуса
            Salary/100*
                    CASE DepartmentID
            WHEN 2 THEN 10 -- 10% от ЗП выдать Бухгалтерам
            WHEN 3 THEN 15 -- 15% от ЗП выдать ИТ-шникам
            ELSE 5 -- всем остальным по 5%
                    END BonusAmount

            FROM Employees
            */

           /* IF(Salary>=2500,'ЗП >= 2500','ЗП < 2500') DemoIIF
            */

            /*SELECT
            'столбец информации' Info,
                    COUNT(*) ,
            COUNT(DISTINCT DepartmentID) AS 'Число уникальных отделов',
                    COUNT(DISTINCT PositionID) AS 'Число уникальных должностей',
                    COUNT(BonusPercent) AS 'Кол-во сотрудников у которых указан % бонуса',
                    MAX(BonusPercent) AS 'Максимальный процент бонуса',
                    MIN(BonusPercent) AS 'Минимальный процент бонуса',
                    SUM(Salary/100*BonusPercent) AS 'Сумма всех бонусов',
                    AVG(Salary/100*BonusPercent) AS 'Средний размер бонуса',
                    AVG(Salary) AS 'Средний размер ЗП'
            FROM Employees
            */


            /*SELECT
            'Строка константа' Const1, -- константа в виде строки
            1 Const2, -- константа в виде числа

                    -- выражение с использованием полей участвуещих в группировке
            CONCAT('Отдел № ',DepartmentID) ConstAndGroupField,
                    CONCAT('Отдел № ',DepartmentID,', Должность № ',PositionID) ConstAndGroupFields,

                    DepartmentID, -- поле из списка полей участвующих в группировке
            -- PositionID, -- поле учавствующее в группировке, не обязательно дублировать здесь

            COUNT(*) EmplCount, -- кол-во строк в каждой группе

            -- остальные поля можно использовать только с агрегатными функциями: COUNT, SUM, MIN, MAX, …
            SUM(Salary) SalaryAmount,
                    MIN(ID) MinID
            FROM Employees
            GROUP BY DepartmentID,PositionID -- группировка по полям DepartmentID,PositionID
            */



          /*
           здесьобъединяем таблицу с собой показываем сотр с сотрудником принятым на работу после него
           SELECT
            e1.ID EmpID1,
            e1.Name EmpName1,
            e2.ID EmpID2,
            e2.Name EmpName2
            FROM Employees e1
            LEFT JOIN Employees e2 ON e1.ID=e2.ID+1*/


           /* SELECT dep.ID,dep.Name,emp.ID,emp.Name
            FROM Employees emp

                    JOIN
            (
                    SELECT MAX(ID) MaxEmployeeID
            FROM Employees
            GROUP BY DepartmentID
            ) lastEmp
            ON emp.ID=lastEmp.MaxEmployeeID

            RIGHT JOIN Departments dep ON emp.DepartmentID=dep.ID -- все данные Departments

            */

            while (rs.next()) {
                String nameFull = rs.getString("FullName");
                Date date = rs.getDate("Дата приема");
                String salary = rs.getString("ZP");

                System.out.println("FullName: " + nameFull + ", date: " + date + ", Salary: " + salary);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }

    private static void insertRandom(Statement statement) throws SQLException {

        statement.execute("INSERT into Employees(Name,Email) VALUES(N'Сергеев С.С.','s.sergeev@test.tt');");
        statement.execute("INSERT into Employees(Name,Email,PositionID,DepartmentID,Salary)\n" +
                "VALUES(N'Александров А.А.','a.alexandrov@test.tt',NULL,NULL,2000)");

    }

    private static void createTables(Statement statement) throws SQLException {
        statement.execute("use test");
        statement.execute("CREATE TABLE Positions(\n" +
                "  ID int UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "  Name varchar(30) NOT NULL\n" +
                ")");
        statement.execute("CREATE TABLE Departments(\n" +
                "  ID int UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "  Name nvarchar(30) NOT NULL\n" +
                ")");

        String sttm = "CREATE TABLE IF NOT EXISTS test.employees (" +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "name VARCHAR(45) NOT NULL, " +
                "email VARCHAR(45) NULL UNIQUE, " +
                "PositionID int, " +
                "DepartmentID int, " +
                "HireDate DATETIME NOT NULL DEFAULT now(), " +
                "ManagerID int, " +
                " Position nvarchar(30)," +
                "Department nvarchar(30)," +
                "PRIMARY KEY (id))";

        statement.execute(sttm);
        System.out.println("таблица создана");
    }

    private static void insertSomething(Statement statement) throws SQLException {

        statement.execute("INSERT into Employees (Name,Email,PositionID,DepartmentID,Position,Department) VALUES\n" +
                "(N'Иванов И.И.','i.ivanov@test.tt',2,1,'Директор','Администрация'),\n" +
                "(N'Петров П.П.','p.petrov@test.tt',3,3,'Программист','ИТ'),\n" +
                "(N'Сидоров С.С.','s.sidorov@test.tt',1,2,'Бухгалтер',N'Бухгалтерия'),\n" +
                "(N'Андреев А.А.','a.andreev@test.tt',4,3,'Старший программист',N'ИТ');");

        statement.execute("INSERT INTO  Positions(Name)\n" +
                "                SELECT DISTINCT Position\n" +
                "        FROM Employees\n" +
                "        WHERE Position IS NOT NULL -- отбрасываем записи у которых позиция не указана");

        statement.execute("INSERT INTO Departments(Name)\n" +
                "                SELECT DISTINCT Department\n" +
                "        FROM Employees\n" +
                "        WHERE Department IS NOT NULL");


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


    private static void updateDB(Statement statement) throws SQLException {
        statement.executeUpdate("ALTER TABLE Employees ADD" +
                "  (LastName varchar(30), -- фамилия\n" +
                "  FirstName varchar(30), -- имя\n" +
                "  MiddleName varchar(30), -- отчество\n" +
                "  Salary float, -- и конечно же ЗП в каких-то УЕ\n" +
                "  BonusPercent float)");

        statement.addBatch("UPDATE employees\n" +
                "SET \n" +
                "LastName=N'Иванов',FirstName=N'Иван',MiddleName=N'Иванович',\n" +
                "Salary=5000,BonusPercent= 50\n" +
                "WHERE ID=1; -- Иванов И.И.");

        statement.addBatch("UPDATE employees\n" +
                "SET\n" +
                "  LastName=N'Петров',FirstName=N'Петр',MiddleName=N'Петрович',\n" +
                "  Salary=1500,BonusPercent= 15\n" +
                "WHERE ID=2;");

        statement.addBatch("UPDATE Employees\n" +
                "SET\n" +
                "  LastName=N'Сидоров',FirstName=N'Сидор',MiddleName=NULL,\n" +
                "  Salary=2500,BonusPercent=NULL\n" +
                "WHERE ID=3;");

        statement.addBatch("UPDATE Employees\n" +
                "SET\n" +
                "  LastName=N'Андреев',FirstName=N'Андрей',MiddleName=NULL,\n" +
                "  Salary=2000,BonusPercent= 30\n" +
                "WHERE ID=4; ");
        statement.executeBatch();
    }


    private static void deleteSomethingById(Statement statement, int id) throws SQLException {
        System.out.println("Delete all person who id = " + id);
        int rowsDeleted = statement.executeUpdate("DELETE FROM employees WHERE id = " + id + ";");
        System.out.printf("%d rows deleted.\n", rowsDeleted);
        System.out.println("---------result----------");
    }

}
