package eu.glowacki.utp.assignment10.repositories;

import eu.glowacki.utp.assignment10.Exception10;
import eu.glowacki.utp.assignment10.dtos.GroupDTO;
import eu.glowacki.utp.assignment10.dtos.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Users extends Base<UserDTO> implements IUserRepository {

    private static String tableUser = "users";
    private static String columnUserId = "user_id";
    private static String columnUserLogin = "user_login";
    private static String columnUserPassword = "user_password";


    public Users(String url, String user, String password) throws SQLException {
        super(url, user, password);
    }

    public Users(Connection connection) {
        super(connection);
    }


    public void add(UserDTO dto) {
        try {
            String statement = "INSERT INTO " + tableUser + " (" + columnUserId + ", "
                    + columnUserLogin + ", " + columnUserPassword + ") "
                    + "VALUES (? , ?, ?)";
            PreparedStatement preparedStatement = getConnection().prepareStatement(statement);
            preparedStatement.setInt(1, dto.getId());
            preparedStatement.setString(2, dto.getLogin());
            preparedStatement.setString(3, dto.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception10();
        }
    }

    public void update(UserDTO dto) {
        try {
            String statement = "UPDATE " + tableUser + " SET " + columnUserLogin + " = ?, "
                    + columnUserPassword +  " = ? WHERE "
                    + columnUserId + " LIKE ?";
            PreparedStatement preparedStatement = prepareStatement(statement);
            preparedStatement.setString(1, dto.getLogin() );
            preparedStatement.setString(2, dto.getPassword());
            preparedStatement.setInt(3, dto.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception10();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(UserDTO dto) {
        try {
            String statement = "DELETE FROM " + tableUser + " WHERE " + columnUserId + " = ?";
            PreparedStatement preparedStatement = getConnection().prepareStatement(statement);
            preparedStatement.setInt(1, dto.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception10();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public UserDTO findById(int id) {
        try {
            UserDTO user = null;
            String statement = "SELECT " + columnUserId + ", " + columnUserLogin + ",  " + columnUserPassword +
                    " FROM " + tableUser + " WHERE " + columnUserId  + " = ? ;";
            PreparedStatement preparedStatement = getConnection().prepareStatement(statement);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int user_id = resultSet.getInt(1);
                String user_login = resultSet.getString(2);
                String user_password = resultSet.getString(3);
                user = new UserDTO(user_id, user_login, user_password);
            }
            return user;

        }catch(SQLException e) {
            throw new Exception10();
        }
    }

    public List<UserDTO> findByName(String username) {
        try {
            List<UserDTO> usersList = new LinkedList<UserDTO>();
            String statement = "SELECT " + columnUserId + ", " + columnUserLogin + ", " + columnUserPassword +
                    " FROM " + tableUser + " WHERE " + columnUserLogin + " LIKE ? ;";
            PreparedStatement preparedStatement = getConnection().prepareStatement(statement);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt(1);
                String userlogin = resultSet.getString(2);
                String password = resultSet.getString(3);
                UserDTO user = new UserDTO(userId, userlogin, password);
                usersList.add(user);
            }
            return usersList;
        } catch (SQLException e) {
            throw new Exception10();
        }
    }

    public List<GroupDTO> usersGroups(UserDTO dto) {
        List<GroupDTO> usersInGroup = new LinkedList<GroupDTO>();
        try {
            Connection connection = getConnection();
            String statement = "SELECT g.group_id , g.group_name, g.description FROM utp10.groups g " +
                    "left join groups_users gu ON g.group_id = gu.group_id  WHERE gu.user_id LIKE ?;";
            // String statement = "SELECT g.group_id , g.group_name, g.description FROM \"Group\" AS g;";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, dto.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int group_id = resultSet.getInt(1);
                String group_name = resultSet.getString(2);
                String description = resultSet.getString(3);
                GroupDTO group = new GroupDTO(group_id, group_name, description);
                usersInGroup.add(group);
            }
        } catch (SQLException e) {
            throw new Exception10();
        }
        return usersInGroup;
    }

    @Override
    protected String getTableName() {
        return tableUser;
    }
}
