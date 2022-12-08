package com.spring.customerdata.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomRepository {

	@Autowired
	DataSource ds;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	RoleRepository roleRepository;

	public String getCustomers() throws SQLException {
		
		String resultString = "";
		String sql = "select * from customer";
		String sqlRole = "select * from role where id = ?";
		
		Connection conn = ds.getConnection(); 
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			resultString = resultString  + "# ID:" + rs.getInt(1);
			resultString = resultString  + " Name:" + rs.getString(2);
			resultString = resultString  + " Email:" + rs.getString(3);
			
			PreparedStatement stmt1 = conn.prepareStatement(sqlRole);
			stmt1.setInt(1, rs.getInt(4));			
			ResultSet ros = stmt1.executeQuery();
			//ResultSet ros = stmt1.getResultSet();
			
			if(ros.next()) {
				resultString = resultString  + " Role Id:" + ros.getString(2);
				resultString = resultString  + " Delivery Charge:" + ros.getString(3) + "\n";
			}
			
			
		}
		return resultString;
	}
	
}
