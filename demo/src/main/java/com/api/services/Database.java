package com.api.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.api.models.Login;
import com.api.models.User;
import com.mysql.jdbc.Driver;

//@Service
public class Database {

	Connection con;
	Statement st;
	public Database()
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
	//	System.out.println("1");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "admin", "admin123");
	//	System.out.println("2");
		st=con.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error");
			System.exit(1);
		}
	}
	
	public void add(User user)
	{
	//	System.out.println("hello");
		//System.exit(1);
		String sql="insert into db(username,password,firstname,lastname,email,phone) values('"+
		user.getUsername()+"','"+user.getPassword()+"','"+user.getFirstname()+
		"','"+user.getLastname()+"','"+user.getEmail()+"','"+user.getPhone()+"')";
		try {
		st.executeUpdate(sql);
		st.close();
		con.close();
		
		System.out.println("done");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean getAuthentic(Login login)
	{
		String sql="select * from db where email='"+login.getEmail()+"' "
				+ "and password='"+login.getPassword()+"'";
		ResultSet rt=null;
		try {
		rt=st.executeQuery(sql);
		if(rt.next())
		{
			return true;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
}
/*
create table

create table db(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,username varchar(20),password varchar(20),
		firstname varchar(20),lastname varchar(20),
		email varchar(30),phone varchar(20));
*/