package com.assemble.vo;

import java.util.List;

public class BoardVO {
	private int board_no;
	private String board_title;
	private String board_writer;
	private String board_cont;
	private int board_type;
	private String board_image;
	private int board_hit;
	private String board_date;
	private int board_replycnt;
	private int board_category;
	
	
	// 페이징 관련변수
	private int startrow;
	private int endrow;
	
	private String find_field;
	private String find_name;
	
	
	
	public String getFind_field() {
		return find_field;
	}
	public void setFind_field(String find_field) {
		this.find_field = find_field;
	}
	public String getFind_name() {
		return find_name;
	}
	public void setFind_name(String find_name) {
		this.find_name = find_name;
	}
	public int getStartrow() {
		return startrow;
	}
	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}
	public int getEndrow() {
		return endrow;
	}
	public void setEndrow(int endrow) {
		this.endrow = endrow;
	}
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_cont() {
		return board_cont;
	}
	public void setBoard_cont(String board_cont) {
		this.board_cont = board_cont;
	}
	public int getBoard_type() {
		return board_type;
	}
	public void setBoard_type(int board_type) {
		this.board_type = board_type;
	}
	public String getBoard_image() {
		return board_image;
	}
	public void setBoard_image(String board_image) {
		this.board_image = board_image;
	}
	public int getBoard_hit() {
		return board_hit;
	}
	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date.substring(0,10);
	}
	public int getBoard_replycnt() {
		return board_replycnt;
	}
	public void setBoard_replycnt(int board_replycnt) {
		this.board_replycnt = board_replycnt;
	}
	public int getBoard_category() {
		return board_category;
	}
	public void setBoard_category(int category) {
		this.board_category = category;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	
	
	
}
