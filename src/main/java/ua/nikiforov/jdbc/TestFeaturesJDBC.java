package ua.nikiforov.jdbc;

import java.sql.*;

/**
 * @author Sergey Nikiforov
 */
public class TestFeaturesJDBC {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        new Thread(() -> {
            try (Connection connection = DriverManager.getConnection("jdbc:h2:C:/Users/call911/db/h2/test")) {
                try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    ResultSet resultSet = statement.executeQuery("SELECT one, two FROM test_table");
                    while (resultSet.next()) {
                        String one = resultSet.getString("one");
                        int two = resultSet.getInt("two");
                        if (one.equals("Second") && resultSet.getConcurrency() == ResultSet.CONCUR_UPDATABLE) {
                            resultSet.updateInt("two", two + 11);
                            resultSet.updateRow();
                            System.out.println("The next row was updated.");
                        }
                        System.out.println(one + " - " + two);
                    }
//                    statement.getConnection().commit();
                    resultSet.beforeFirst();
                    Thread.sleep(1500);

                    System.out.println("\n\nAfter 5 sec:");
                    while (resultSet.next()) {
                        String one = resultSet.getString("one");
                        int two = resultSet.getInt("two");
                        System.out.println(one + " - " + two);
                    }
                } catch (SQLException | InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try (Connection connection = DriverManager.getConnection("jdbc:h2:C:/Users/call911/db/h2/test")) {
                try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.CLOSE_CURSORS_AT_COMMIT)) {
                    int updateIndex = statement.executeUpdate("UPDATE test_table SET two=456 WHERE one='Second'");
                    System.out.println("Update complete with result code: " + updateIndex);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                connection.commit();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        })/*.start()*/;
    }

    private static void firstTypeSelect(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ResultSet resultSet = statement.executeQuery("SELECT one, two FROM tbl1");
            while (resultSet.next()) {
                String one = resultSet.getString("one");
                int two = resultSet.getInt("two");
                System.out.println(one + " - " + two);
            }
        }
    }
}
