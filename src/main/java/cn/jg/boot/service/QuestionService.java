package cn.jg.boot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jg.boot.dao.QuestionDao;
import cn.jg.boot.pojo.Question;

@Service("questionService")
public class QuestionService {
	@Autowired
	private QuestionDao dao;
	
	public List<Question> getQuestionsByRandom(Question q) {
		List<Question> resultList = new ArrayList<Question>();
		List<Question> randomList = null;
		// 更新级别, 阶段由前端获取
		q.setQ_level(1);
		randomList = dao.getQuestionsByRandom(q);
		this.doRandom(resultList, randomList, 3);
		// 中级
		q.setQ_level(2);
		randomList = dao.getQuestionsByRandom(q);
		this.doRandom(resultList, randomList, 2);
		// 高级
		q.setQ_level(3);
		randomList = dao.getQuestionsByRandom(q);
		this.doRandom(resultList, randomList, 2);
		
		return resultList;
	}
	
	// 随机生成对应的题，参数1,最终返回结果，参数2,随机范围，参数3，题数
	public void doRandom(List<Question> resultList, List<Question> randomList, int count) {
		Map<Integer, Question> map = new HashMap<Integer, Question>();  // 做去重
		Random rd = new Random();
		int index = rd.nextInt(randomList.size());
		do {
			Question q = randomList.get(index);
			int k = q.getId();
			map.put(k, q);
			index = rd.nextInt(randomList.size());
		} while (map.size() < count);
		
		for (Integer key : map.keySet()) {  
			resultList.add(map.get(key));
		}
	}
}
