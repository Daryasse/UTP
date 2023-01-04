package eu.glowacki.utp.assignment10.repositories;

import eu.glowacki.utp.assignment10.Exception10;
import eu.glowacki.utp.assignment10.dtos.DTOBase;

import java.sql.*;

public abstract class Base <TEntity extends DTOBase> implements IRepository<TEntity> {
    private Connection _connection;

    protected Base (String url, String user, String password) throws SQLException {
        _connection = DriverManager.getConnection(url, user, password);
        _connection.setAutoCommit(false);
    }

    protected Base(Connection connection) {
        _connection = connection;
    }

    public Connection getConnection(){
        return _connection;
    }


    public boolean exists(TEntity dto){
        boolean exists = false;
        if(dto.hasExistingId()){
            TEntity savedEntity  = findById(dto.getId());
            exists = savedEntity != null;
        }
        return exists;
    }

    public void addOrUpdate(TEntity dto) {
        if(exists(dto)){
            update(dto);
        }else{
            add(dto);
        }
    }

    public void beginTransaction() {
        try{
            Connection connection = getConnection();
            connection.setAutoCommit(false);
        }catch(SQLException ex){
            throw new Exception10();
        }
    }

    public void commitTransaction() {
        try {
            Connection connection = getConnection();
            connection.commit();
        } catch (SQLException e) {
            throw new Exception10();
        }
    }

    public void rollbackTransaction() {
        try {
            Connection connection = getConnection();
            connection.rollback();
        } catch (SQLException e) {
            throw new Exception10();
        }
    }

    public PreparedStatement prepareStatement(String statement) throws Exception {
        Connection connection = getConnection();
        try {
            return connection.prepareStatement(statement);
        } catch (SQLException e){
            throw new Exception(e);
        }
    }

    protected abstract String getTableName();

    public int getCount(){
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(1) FROM "+ getTableName());
            ResultSet resultSet = statement.executeQuery();
            resultSet.getRow();
            if(resultSet.next()){
                int counter = resultSet.getInt(1);
                return counter;
            }else {
                throw new Exception10();
            }
        } catch (SQLException e) {
            throw new Exception10();
        }
    }
}
