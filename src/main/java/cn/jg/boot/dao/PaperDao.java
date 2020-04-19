package cn.jg.boot.dao;

import java.util.List;

import cn.jg.boot.pojo.Paper;
import cn.jg.boot.pojo.PaperQuestions;

public interface PaperDao {
	// 添加试卷
	public int addPaper(Paper paper);
	
	// 查询试卷id
	public int getPaperId();
	
	// 添加试卷试题
	public int addPaperQuestions(PaperQuestions paperQuestion);
	
	// 计算试卷总分
	public int calcPaperScore(int p_id);
	
	// 查看当前登录账号的试卷
	public List<Paper> getPapers(int u_id);
}
