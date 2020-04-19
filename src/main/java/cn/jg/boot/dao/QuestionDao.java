package cn.jg.boot.dao;

import java.util.List;

import cn.jg.boot.pojo.Question;

public interface QuestionDao {
	// 获取随机试题
	public List<Question> getQuestionsByRandom(Question q);
}
