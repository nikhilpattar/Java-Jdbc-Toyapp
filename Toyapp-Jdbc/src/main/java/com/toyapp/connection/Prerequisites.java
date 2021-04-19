package com.toyapp.connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Prerequisites 
{

	public Statement getStmt() throws SQLException {
		return ConnectionDAO.getConnection().createStatement();
	}

	public PreparedStatement getPstmt(String query) throws SQLException {
		return ConnectionDAO.getConnection().prepareStatement(query);
	}
}
