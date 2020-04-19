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
		// ���¼���, �׶���ǰ�˻�ȡ
		q.setQ_level(1);
		randomList = dao.getQuestionsByRandom(q);
		this.doRandom(resultList, randomList, 3);
		// �м�
		q.setQ_level(2);
		randomList = dao.getQuestionsByRandom(q);
		this.doRandom(resultList, randomList, 2);
		// �߼�
		q.setQ_level(3);
		randomList = dao.getQuestionsByRandom(q);
		this.doRandom(resultList, randomList, 2);
		
		return resultList;
	}
	
	// ������ɶ�Ӧ���⣬����1,���շ��ؽ��������2,�����Χ������3������
	public void doRandom(List<Question> resultList, List<Question> randomList, int count) {
		Map<Integer, Question> map = new HashMap<Integer, Question>();  // ��ȥ��
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
