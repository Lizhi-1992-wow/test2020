package cn.jg.boot.pojo;

import java.io.Serializable;
import java.util.List;

public class Paper implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private User user; // u_id �û� ���
	private State state; // s_id �׶� ���
	private String p_name; // �Ծ���  uid+ʱ���+�׶�
	private String start_time; // ��ʼʱ��
	private String end_time; // ����ʱ��
	private int all_score; // �ܷ�
	private String mark; // ˵��
	private List<PaperQuestions> paper_question; // �Ծ�����
	
	public List<PaperQuestions> getPaper_question() {
		return paper_question;
	}
	public void setPaper_question(List<PaperQuestions> paper_question) {
		this.paper_question = paper_question;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public int getAll_score() {
		return all_score;
	}
	public void setAll_score(int all_score) {
		this.all_score = all_score;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
}
