package cn.jg.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.jg.boot.dao.PaperDao;
import cn.jg.boot.pojo.Paper;
import cn.jg.boot.pojo.PaperQuestions;

@Service("paperService")
public class PaperService {
	@Autowired
	private PaperDao dao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public String addPaper(Paper paper) {
		// ����Ծ�
		int add_paper_res = this.newPaper(paper);
		// ��ȡ�Ծ���
		int p_id = this.getPaperId();
		// �����������
		List<PaperQuestions> q = paper.getPaper_question();
		boolean add_questions_res =  this.addQuestionsByBatch(q, p_id);
//		System.out.println(p_id);
		// �����Ծ��ܷ�
		int calc_res = this.calcPaperScore(p_id);
		// �жϽ��ͬʱ����
		if (add_questions_res && add_paper_res == 1 && calc_res == 1) {
			return "success";
		} else {			
			return "failed";
		}
	}
	
	// ����Ծ�
	@Transactional(propagation = Propagation.REQUIRED)
	public int newPaper(Paper paper) {
		return dao.addPaper(paper);
	}
	
	// ��ѯ�Ծ�id
	@Transactional(propagation = Propagation.REQUIRED)
	public int getPaperId() {
		return dao.getPaperId();
	}
	
	// ���������
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addQuestionsByBatch(List<PaperQuestions> questions, int pId) {
		int count = 0;
		for (int i = 0; i < questions.size(); i++) {
			questions.get(i).setP_id(pId);
			int res = dao.addPaperQuestions(questions.get(i));
			if (res == 1) {
				count++;
			}
		}
		if (count == questions.size()) {
			return true;
		} else {
			return false;
		}
	}
	
	// �����ܷ�
	@Transactional(propagation = Propagation.REQUIRED)
	public int calcPaperScore(int p_id) {
		return dao.calcPaperScore(p_id);
	}
	
	
	// �鿴��ǰ��¼�û�����ʷ�Ծ�
	public List<Paper> getPapers(int u_id) {
		return dao.getPapers(u_id);
	}
}










