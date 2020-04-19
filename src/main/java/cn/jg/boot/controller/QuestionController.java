package cn.jg.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import cn.jg.boot.pojo.Question;
import cn.jg.boot.pojo.State;
import cn.jg.boot.service.QuestionService;

@CrossOrigin(origins = {"*", "null"})
@RestController
public class QuestionController {
	@Autowired
	private QuestionService qs;
	
	@PostMapping("/getQuestionsByRandom")
	public Map<String, Object> getQuestionsByRandom(@RequestBody Map<String, Object> param) {
		Question q = new Question();
		State state = new State();
		state.setId((Integer)param.get("stage"));
		q.setState(state);
		List<Question> questions = qs.getQuestionsByRandom(q);
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("status", 0);
		res.put("data", questions);
		res.put("msg", "success");
		return res;
	}
}

