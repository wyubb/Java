package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDatabaseDAO {
	public Connection getConnection();
	 public void releaseConnection() throws SQLException;
	 public ResultSet getResultSet(String querySQL) throws SQLException, ClassNotFoundException;
	 public void executeSQL(String SQL) throws SQLException, ClassNotFoundException;
}
