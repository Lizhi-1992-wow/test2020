package cn.jg.boot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jg.boot.dao.UserDao;
import cn.jg.boot.pojo.User;

@Service("userService")
public class UserService {
	@Autowired
	private UserDao dao;
	
	public Map<String, Object> login(User user, int isAdmin) {
		User u = dao.login(user);
		Map<String, Object> map = new HashMap<String, Object>();
		if (u == null) {
			if (isAdmin == 1) {
				map.put("status", 3);
				map.put("msg", "您还不是管理员，或者账号密码错误");
			} else {
				map.put("status", 1);
				map.put("msg", "账号或密码错误");
			}
		} else {
			map.put("status", 0);
			map.put("msg", "success");
		}
		map.put("data", u);
		map.put("menu", isAdmin);
		return map;
	}
	
	public int register(User user) {
		return dao.register(user);
	}
}
