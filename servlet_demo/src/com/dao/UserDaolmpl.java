package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;
import com.util.Conn;

public class UserDaolmpl implements UserDao {
	String sql = null;
	
	public boolean login(String name, String psd) {
		boolean f = false;
		
		try {
			Conn.init();
			sql = "select * from user where name='"+name+"' and psd='"+psd+"'";
			ResultSet rs = Conn.selectSql(sql);
			while(rs.next())
			{
				if(rs.getString("name").equals(name)&&rs.getString("psd").equals(psd)) {
					f = true;
				}
			}
			Conn.closeConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return f;
	}

	
	public boolean register(User user) {
		boolean f = false;
		Conn.init();
		sql = "insert into user(name,psd,home) " +
				"values('"+user.getName()+"','"+user.getPsd()+"','"+user.getHome()+"')";
		int i = Conn.addUpdDel(sql);
		if(i>0) {
			f = true;
		}
		Conn.closeConn();
		return f;
	}

	public List<User> getUserAll() {
		User user = new User();
		ArrayList<User> list = new ArrayList<User>();
				try {
					Conn.init();
					sql = "select * from user";
					ResultSet rs = Conn.selectSql(sql);
					while(rs.next())
					{
						user = new User();
						user.setId(rs.getInt("id"));
						user.setName(rs.getString("name"));
						user.setPsd(rs.getString("psd"));
						user.setHome(rs.getString("home"));
						list.add(user);
					}
					Conn.closeConn();
					return list;
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				return null;
	}

	@Override
	public boolean delect(int id) {
		boolean f = false;
		Conn.init();
		sql = "delete from user where id = "+id;
		int rs = Conn.addUpdDel(sql);
		if(rs>0)
		{
			f = true;
		}
		Conn.closeConn();
		return f;
	}

	public boolean update(int id, String name, String psd, String home) {
		
		boolean f = false;
		sql  ="update user set name ='"+name
				+"' , psd = '"+psd
				+"' , home ='"+home
				+"' where id = "+id;
		Conn.init();
		int i = Conn.addUpdDel(sql);
		if(i>0)
		{
			f = true;
		}
		Conn.closeConn();
		return f;
	}

}
