import java.sql.*;

public class main {
    public static void main(String[] args) {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/utp10", "root", "Dasha2543");

            PreparedStatement statement_groups = c.prepareStatement("select * from users");
            ResultSet resultSet_group = statement_groups.executeQuery();

            System.out.println("---USERS--------------------");

            while(resultSet_group.next()) {
                System.out.println(resultSet_group.getInt("user_id") + "   " + resultSet_group.getString("user_login")
                        + "    " + resultSet_group.getString("user_password"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
