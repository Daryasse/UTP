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

public class Groups extends Base<GroupDTO> implements IGroupRepository {
    private static final String tableGroups = "groups_g";
    private static final String columnGroupId = "group_id";
    private static final String columnGroupName = "group_name";
    private static final String columnGroupDescription = "group_description";

    public Groups(String url, String user, String password) throws SQLException {
        super(url, user, password);
    }

    public Groups(Connection connection) {
        super(connection);
    }


    @Override
    public void add(GroupDTO dto) {
        try {
            Connection connection = getConnection();
            String statement = "insert into " + tableGroups + " ( " + columnGroupId + " , " + columnGroupName +
                    " , " + columnGroupDescription + " ) " + "values ( ?, ?, ?);";

            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, dto.getId());
            preparedStatement.setString(2, dto.getName());
            preparedStatement.setString(3, dto.getDescription());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new Exception10();
        }
    }

    @Override
    public void update(GroupDTO dto) {
        try {
            Connection connection = getConnection();
            String statement = "UPDATE " + tableGroups +
                    " SET " + columnGroupName + " = ?, " +
                    columnGroupDescription + " = ? " +
                    " WHERE " + columnGroupId + " = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, dto.getName());
            preparedStatement.setString(2, dto.getDescription());
            preparedStatement.setInt(3, dto.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new Exception10();
        }

    }

    @Override
    public void delete(GroupDTO dto) {
        try {

            String statement = "DELETE FROM " + tableGroups +
                    " WHERE " + columnGroupId + " = ?;";
            PreparedStatement preparedStatement = getConnection().prepareStatement(statement);
            preparedStatement.setInt(1, dto.getId());
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception10();
        }
    }

    @Override
    public GroupDTO findById(int id) {
        try {
            GroupDTO group = null;
            Connection connection = getConnection();
            String statement = "SELECT " + columnGroupId +
                    ", " + columnGroupName + ", " + columnGroupDescription +
                    " FROM " + tableGroups + " WHERE " + columnGroupId + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int groupId = resultSet.getInt(1);
                String groupName = resultSet.getString(2);
                String groupDescription = resultSet.getString(3);
                group = new GroupDTO(groupId, groupName, groupDescription);
            }
            return group;
        } catch (SQLException e) {
            throw new Exception10();
        }
    }

    @Override
    protected String getTableName() {
        return tableGroups;
    }

    protected String getColumnGroupName() {
        return columnGroupId;
    }

    public List<UserDTO> usersGroups(GroupDTO dto) throws Exception {
        List<UserDTO> usersInGroup = new LinkedList<>();
        try {
            String statement = "select u.user_id, u.user_login , u.user_password from users u left join user_group ug on u.user_id = ug.user_id  where ug.group_id = ?;";
            PreparedStatement preparedStatement = prepareStatement(statement);
            preparedStatement.setInt(1, dto.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(preparedStatement.toString());
            while (resultSet.next()) {
                int user_id = resultSet.getInt(1);
                String user_login = resultSet.getString(2);
                String user_description = resultSet.getString(3);
                UserDTO user = new UserDTO(user_id, user_login, user_description);
                usersInGroup.add(user);
            }
            return usersInGroup;
        } catch (SQLException e) {
            throw new Exception10();
        }
    }

    @Override
    public List<GroupDTO> findByName(String name) {
        try {
            List<GroupDTO> group_list = new LinkedList<>();
            String statement = "select " + columnGroupId + ", " + columnGroupName + ",  " + columnGroupDescription +
                    " from " + tableGroups + " where " + columnGroupName + " like ? ;";

            PreparedStatement searchByName = getConnection().prepareStatement(statement);
            searchByName.setString(1, name);
            ResultSet resultSet = searchByName.executeQuery();
            while (resultSet.next()) {
                int group_id = resultSet.getInt(1);
                String groupName = resultSet.getString(2);
                String groupDescription = resultSet.getString(3);
                GroupDTO group = new GroupDTO(group_id, groupName, groupDescription);
                group_list.add(group);
            }
            return group_list;

        } catch (SQLException e) {
            throw new Exception10();
        }
    }

}