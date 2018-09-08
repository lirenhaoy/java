package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	public boolean login(String name,String psd);//登录功能
	public boolean register(User user);//注册功能
	public List<User> getUserAll();//查询所有
	public boolean delect(int id);//删除某个学生
	public boolean update(int id,String name,String psd,String home);//修改
}
