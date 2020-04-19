package cn.jg.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.jg.boot.pojo.Paper;
import cn.jg.boot.pojo.PaperQuestions;
import cn.jg.boot.pojo.Question;
import cn.jg.boot.pojo.State;
import cn.jg.boot.pojo.User;
import cn.jg.boot.service.PaperService;

@CrossOrigin(origins = {"*", "null"})
@RestController
public class PaperController {
	@Autowired
	private PaperService ps;
	
	@PostMapping("/test") // 测试Map接收实体类 
	public List<Question> getQuestionsByRandom2(@RequestBody Map<String, Object> paper) {
		System.out.println(paper.get("start_time"));
		List<Question> a = (List<Question>)paper.get("paper_question");
		System.out.println(a.size());
		return null; // qs.getQuestionsByRandom(q);
	}
	
	// 保存试卷
	@PostMapping("/addPaper")
	public Map<String, Object> getQuestionsByRandom(@RequestBody Paper paper) {
		State state = new State();
		state.setId(1);
		User user = new User();
		user.setId(1);
		paper.setState(state);
		paper.setUser(user);
		
		String result = ps.addPaper(paper);
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", 0);
		res.put("msg", "success");
		res.put("data", result);

		return res;
	}
	
	// 查看当前用户的试卷
	@GetMapping("/getPapers")
	public List<Paper> getPapers(HttpServletRequest req) {
		int u_id = Integer.parseInt(req.getParameter("u_id"));
		List<Paper> papers = ps.getPapers(u_id);
		return papers;
	}
}
