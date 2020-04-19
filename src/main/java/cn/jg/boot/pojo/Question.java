package cn.jg.boot.pojo;

import java.io.Serializable;

public class Question implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String q_name;
	private State state; // s_id 阶段 外键
	private int q_level; // 级别  1，2，3
	private int score; // 分值
	private String A;
	private String B;
	private String C;
	private String D;
	private String answer; // 答案
	private String mark; // 作死列
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQ_name() {
		return q_name;
	}
	public void setQ_name(String q_name) {
		this.q_name = q_name;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public int getQ_level() {
		return q_level;
	}
	public void setQ_level(int q_level) {
		this.q_level = q_level;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getA() {
		return A;
	}
	public void setA(String a) {
		this.A = a;
	}
	public String getB() {
		return B;
	}
	public void setB(String b) {
		this.B = b;
	}
	public String getC() {
		return C;
	}
	public void setC(String c) {
		this.C = c;
	}
	public String getD() {
		return D;
	}
	public void setD(String d) {
		this.D = d;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
}
