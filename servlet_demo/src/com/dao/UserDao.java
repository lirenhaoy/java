package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	public boolean login(String name,String psd);//��¼����
	public boolean register(User user);//ע�Ṧ��
	public List<User> getUserAll();//��ѯ����
	public boolean delect(int id);//ɾ��ĳ��ѧ��
	public boolean update(int id,String name,String psd,String home);//�޸�
}
