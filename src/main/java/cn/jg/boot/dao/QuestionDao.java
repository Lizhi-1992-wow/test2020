package cn.jg.boot.dao;

import java.util.List;

import cn.jg.boot.pojo.Question;

public interface QuestionDao {
	// ��ȡ�������
	public List<Question> getQuestionsByRandom(Question q);
}
