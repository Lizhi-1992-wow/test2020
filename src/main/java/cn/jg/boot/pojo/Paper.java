package cn.jg.boot.pojo;

import java.io.Serializable;
import java.util.List;

public class Paper implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private User user; // u_id 用户 外键
	private State state; // s_id 阶段 外键
	private String p_name; // 试卷名  uid+时间戳+阶段
	private String start_time; // 开始时间
	private String end_time; // 结束时间
	private int all_score; // 总分
	private String mark; // 说明
	private List<PaperQuestions> paper_question; // 试卷试题
	
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
