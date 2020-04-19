package cn.jg.boot.pojo;

import java.io.Serializable;

public class PaperQuestions implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int p_id;  // p_id ÊÔ¾í±àºÅ Íâ¼ü
	private int q_id; // q_id ÊÔÌâ±àºÅ Íâ¼ü
	private String selected; // »Ø´ğ
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
}
