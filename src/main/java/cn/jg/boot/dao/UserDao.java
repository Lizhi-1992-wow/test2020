package cn.jg.boot.dao;

import cn.jg.boot.pojo.User;

public interface UserDao {
	// ��¼
	public User login(User user);
	
	// ע��
	public int register(User user);
}
