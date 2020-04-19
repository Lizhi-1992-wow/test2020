package cn.jg.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.jg.boot.pojo.User;
import cn.jg.boot.service.UserService;

@CrossOrigin(origins = {"*", "null"})
@RestController
public class UserController {
	@Autowired
	private UserService us;
	
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody Map<String, String> param) {
		User u = new User();
		u.setU_id(param.get("uid"));
		u.setU_pwd(param.get("pwd"));
		u.setIs_admin(Integer.parseInt(param.get("admin")));
		Map<String, Object> res = null;
		if (param.get("admin").equals("1")) {
			res = us.login(u, 1);
		} else {
			res = us.login(u, 0);
		}
		return res;
	}
	
	@PostMapping("/register")
	public Map<String, Object> register(@RequestBody Map<String, String> param) {
		User u = new User();
		u.setU_id(param.get("uid"));
		u.setU_name(param.get("uname"));
		u.setU_pwd(param.get("pwd"));
		int result = us.register(u);
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", "0");
		res.put("msg", "success");
		res.put("data", result);
		return res;
	}
}
