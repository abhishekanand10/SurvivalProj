package com.sapient.pm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.sapient.pm.db.MySQLConnectionFactory;

public class RepositoryImplementation  {

	private Connection connection;
	
	public RepositoryImplementation() throws SQLException {
		// TODO Auto-generated constructor stub
		MySQLConnectionFactory factory=new MySQLConnectionFactory();
		connection =factory.getConnection();
	}
		
	public ResultSet getData(String choice) throws SQLException {
		
		System.out.println(choice);
		String sql;
		PreparedStatement query;
		int ch=Integer.parseInt(choice);
		if(choice.equals("4")) {
			 sql="select * from ets_schema.orderbook";
			 query=connection.prepareStatement(sql);
				
		}
		else
		{sql="select * from ets_schema.orderbook where status=?";
		
		query=connection.prepareStatement(sql);
		query.setInt(1, ch);
		}
		
		
		ResultSet set=query.executeQuery();
		return set;
	}
	
	public boolean putData()
	{
				
		return false;
	}

}
