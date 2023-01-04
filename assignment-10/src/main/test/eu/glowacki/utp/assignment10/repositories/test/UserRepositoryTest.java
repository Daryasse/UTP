package eu.glowacki.utp.assignment10.repositories.test;

import eu.glowacki.utp.assignment10.Exception10;
import eu.glowacki.utp.assignment10.repositories.*;
import org.junit.Assert;
import org.junit.Test;

import eu.glowacki.utp.assignment10.dtos.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public final class UserRepositoryTest extends RepositoryTestBase<UserDTO, IUserRepository, Users> {


	String url = "jdbc:mysql://localhost:3306/utp10";
	String user = "root";
	String password = "Dasha2543";

	@Test
	public void add() throws SQLException {
		UserDTO dto = new UserDTO("login", "password");
		_repository.add(dto);
		Statement statement = _repository.getConnection().createStatement();
		ResultSet userResult = statement.executeQuery("SELECT user_login FROM users");
		Assert.assertEquals(_repository.getCount(), 4);
		userResult.next();
		Assert.assertEquals(userResult.getString(1), "login");
	}

	@Test
	public void update() throws SQLException {
		UserDTO dto = new UserDTO( 1, "name", "password_1");
		_repository.update(dto);
		Statement statement = _repository.getConnection().createStatement();
		ResultSet userResult = statement.executeQuery("SELECT user_login FROM users;");
		userResult.next();
		Assert.assertEquals(_repository.getCount(), 3);
		Assert.assertEquals(userResult.getString(1), "name");

	}
	
	@Test
	public void addOrUpdate() throws SQLException {
		UserDTO dto = new UserDTO("name", "password");
		Statement statement = _repository.getConnection().createStatement();
		_repository.addOrUpdate(dto);
		ResultSet userResult = statement.executeQuery("SELECT user_login FROM utp10.users;");
		userResult.next();
		Assert.assertEquals(userResult.getString(1), "name");
		Assert.assertEquals(_repository.getCount(), 4);
	}

	@Test
	public void delete()  {
		UserDTO dto = new UserDTO( "name", "password");
		_repository.add(dto);
		Assert.assertEquals(_repository.getCount(), 4);
		_repository.delete(dto);
		Assert.assertFalse(_repository.exists(dto));
		Assert.assertEquals(_repository.getCount(), 3);
	}

	@Test
	public void findById() {
		UserDTO dto = new UserDTO(100, "login", "password");
		_repository.add(dto);
		UserDTO temp = _repository.findById(100);
		Assert.assertEquals(temp.getLogin(), "login");
	}
	
	@Test
	public void findByName()  {
		UserDTO udto = new UserDTO( "name", "password");
		_repository.add(udto);
		List<UserDTO> temp = _repository.findByName("name");
		Assert.assertEquals(temp.size(), 1);
	}


	@Override
	protected IUserRepository Create() {
		try {
			_repository = new Users(url, user, password);
			return _repository;
		} catch (Exception e) {
			throw new Exception10();
		}
	}
}