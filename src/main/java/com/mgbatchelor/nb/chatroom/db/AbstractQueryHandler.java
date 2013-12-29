package com.mgbatchelor.nb.chatroom.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mgbatchelor.nb.chatroom.exception.DatabaseException;
import com.mgbatchelor.nb.chatroom.services.ConnectionFactory;

/**
 * Handle basic selection of data from the database.
 * 
 * @author michaelbatchelor
 * 
 */
public abstract class AbstractQueryHandler {

	public void select(String query, Object... objects)
			throws DatabaseException {
		Connection c = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		try {
			ps = c.prepareStatement(query);
			for (int i = 1; i <= objects.length; i++) {
				ps.setObject(i, objects[i - 1]);
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				next(rs);
			}
		} catch (SQLException e) {
			throw new DatabaseException("Could not execute query.", e);
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					System.err.println("Could not close Prepared Statement.");
					e.printStackTrace();
				}
			if (c != null)
				try {
					c.close();
				} catch (SQLException e) {
					System.err.println("Could not close connection.");
					e.printStackTrace();
				}
		}
	}

	public abstract void next(ResultSet rs) throws SQLException;

}
