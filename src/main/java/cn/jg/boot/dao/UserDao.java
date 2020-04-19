package cn.jg.boot.dao;

import cn.jg.boot.pojo.User;

public interface UserDao {
	// µÇÂ¼
	public User login(User user);
	
	// ×¢²á
	public int register(User user);
}
