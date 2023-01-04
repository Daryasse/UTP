package eu.glowacki.utp.assignment10.repositories.test;

import eu.glowacki.utp.assignment10.repositories.Groups;
import org.junit.Assert;
import org.junit.Test;

import eu.glowacki.utp.assignment10.Exception10;
import eu.glowacki.utp.assignment10.dtos.GroupDTO;
import eu.glowacki.utp.assignment10.repositories.IGroupRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GroupRepositoryTest extends RepositoryTestBase<GroupDTO, IGroupRepository, Groups> {

    String url = "jdbc:mysql://localhost:3306/utp10";
    String user = "root";
    String password = "Dasha2543";

    @Test
    public void add() throws SQLException {
            GroupDTO dto = new GroupDTO("name", "description");
            _repository.add(dto);
            Statement statement = _repository.getConnection().createStatement();
            ResultSet groupResult = statement.executeQuery("SELECT group_name FROM utp10.groups_g");
            System.out.println(groupResult);
            Assert.assertEquals(_repository.getCount(), 5);
            groupResult.next();
            Assert.assertEquals(groupResult.getString(1), "name");

    }

    @Test
    public void update() throws SQLException {

            GroupDTO dto = new GroupDTO(1,"name", "description");
            _repository.update(dto);
            Statement statement = _repository.getConnection().createStatement();

            ResultSet groupResult = statement.executeQuery("SELECT group_name FROM utp10.groups_g");
            groupResult.next();
            Assert.assertEquals(groupResult.getString(1), "name");
            Assert.assertEquals(_repository.getCount(), 4);


    }

    @Test
    public void addOrUpdate() throws SQLException {

            GroupDTO dto = new GroupDTO("name", "description");
            Statement statement = _repository.getConnection().createStatement();
            _repository.addOrUpdate(dto);
            ResultSet groupResult = statement.executeQuery("SELECT group_name FROM utp10.groups_g");
            groupResult.next();

            Assert.assertEquals(groupResult.getString(1), "name");
            Assert.assertEquals(_repository.getCount(), 5);

    }

    @Test
    public void delete() {
        GroupDTO dto = new GroupDTO(5, "name", "description");
        _repository.add(dto);
        Assert.assertEquals(_repository.getCount(), 5);
        _repository.delete(dto);

        Assert.assertEquals(_repository.getCount(), 4);
    }

    @Test
    public void findById() {
        GroupDTO dto = new GroupDTO(6,"name", "description");
        _repository.add(dto);
        GroupDTO temp = _repository.findById(6);
        Assert.assertEquals(temp.getName(), "name");

    }

    @Test
    public void findByName()  {
        GroupDTO dto = new GroupDTO(6, "name", "description");
        _repository.add(dto);
        List<GroupDTO> l = _repository.findByName("name");
        Assert.assertEquals(l.size(), 1);
    }

    @Override
    protected IGroupRepository Create() {
        try {
            _repository = new Groups(url, user, password);
            return _repository;
        } catch (java.lang.Exception e) {
            throw new Exception10();
        }
    }
}