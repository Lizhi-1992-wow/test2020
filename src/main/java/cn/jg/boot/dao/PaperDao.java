package cn.jg.boot.dao;

import java.util.List;

import cn.jg.boot.pojo.Paper;
import cn.jg.boot.pojo.PaperQuestions;

public interface PaperDao {
	// ����Ծ�
	public int addPaper(Paper paper);
	
	// ��ѯ�Ծ�id
	public int getPaperId();
	
	// ����Ծ�����
	public int addPaperQuestions(PaperQuestions paperQuestion);
	
	// �����Ծ��ܷ�
	public int calcPaperScore(int p_id);
	
	// �鿴��ǰ��¼�˺ŵ��Ծ�
	public List<Paper> getPapers(int u_id);
}
