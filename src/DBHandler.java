import java.sql.*;
import java.sql.Date;
import java.util.*;

public class DBHandler {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bankofpune";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Chinmay@MySql03";

    public static Connection dbConnect() throws SQLException {
        // Create and return a database connection
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static void dbClose(Connection conn, Statement statement, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dbExecuteUpdate(String query) {
        Connection conn = null;
        Statement statement = null;
        try {
            conn = dbConnect();
            statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbClose(conn, statement, null);
        }
    }

    public static ResultSet dbExecuteQuery(String query) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            conn = dbConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Note: Do not close ResultSet here, it will be closed by the caller
            //dbClose(conn, statement, null);
        }
        return rs;
    }

    public static boolean validateLogin(String username, String password) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        boolean isValidLogin = false;

        try {
            conn = dbConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM bankaccounts WHERE username='" + username + "'");

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                isValidLogin = password.equals(storedPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbClose(conn, statement, rs);
        }

        return isValidLogin;
    }

    public static int getCustomerIdByLogin(String userName, String password) {
        int customerId = -1;
        String sql = "SELECT CustomerID FROM bankaccounts WHERE username = ? AND password = ?";

        try (Connection connection = dbConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    customerId = resultSet.getInt("CustomerID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerId;
    }
    
    public static ResultSet executeTransactionQuery(Date fromDate, Date toDate, String accountNum) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            conn = dbConnect();

            // Create the base query
            String query = "SELECT * FROM transactions WHERE date BETWEEN ? AND ?";
            List<Object> parameters = new ArrayList<>();
            parameters.add(fromDate);
            parameters.add(toDate);

            // Add a condition to the query based on the account number, if provided
            if (accountNum != null && !accountNum.isEmpty()) {
                query += " AND account_num = ?";
                parameters.add(Integer.parseInt(accountNum));
            }

            preparedStatement = conn.prepareStatement(query);

            // Set parameters
            int index = 1;
            for (Object parameter : parameters) {
                if (parameter instanceof String) {
                    preparedStatement.setString(index, (String) parameter);
                } else if (parameter instanceof Integer) {
                    preparedStatement.setInt(index, (Integer) parameter);
                } else if (parameter instanceof Date) {
                    preparedStatement.setDate(index, (Date) parameter);
                }
                index++;
            }

            rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbClose(conn, preparedStatement, null);
        }
        return rs;
    }

    public static void main(String[] args) {
        // You can test your methods here if needed
    }
}
