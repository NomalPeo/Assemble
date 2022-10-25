package com.assemble.vo;

import lombok.Getter;
import lombok.Setter;

public class WebtoonVO {
	private int webtoon_no;
	private String webtoon_title;
	private String webtoon_writer;
	private String webtoon_cont;
	private String webtoon_platform;
	private int webtoon_complete;
	private String webtoon_tag1;
	private String webtoon_tag2;
	private String webtoon_thumbnail;
	private String webtoon_image1;
	private String webtoon_image2;
	private String webtoon_image3;

	// 페이지 관련변수
	private int startrow; // 시작행 번호
	private int endrow; // 끝행번호

	// 검색필드와 검색어
	private String find_field;
	private String find_name;
	public int getWebtoon_no() {
		return webtoon_no;
	}
	public void setWebtoon_no(int webtoon_no) {
		this.webtoon_no = webtoon_no;
	}
	public String getWebtoon_title() {
		return webtoon_title;
	}
	public void setWebtoon_title(String webtoon_title) {
		this.webtoon_title = webtoon_title;
	}
	public String getWebtoon_writer() {
		return webtoon_writer;
	}
	public void setWebtoon_writer(String webtoon_writer) {
		this.webtoon_writer = webtoon_writer;
	}
	public String getWebtoon_cont() {
		return webtoon_cont;
	}
	public void setWebtoon_cont(String webtoon_cont) {
		this.webtoon_cont = webtoon_cont;
	}
	public String getWebtoon_platform() {
		return webtoon_platform;
	}
	public void setWebtoon_platform(String webtoon_platform) {
		this.webtoon_platform = webtoon_platform;
	}
	public int getWebtoon_complete() {
		return webtoon_complete;
	}
	public void setWebtoon_complete(int webtoon_complete) {
		this.webtoon_complete = webtoon_complete;
	}
	public String getWebtoon_tag1() {
		return webtoon_tag1;
	}
	public void setWebtoon_tag1(String webtoon_tag1) {
		this.webtoon_tag1 = webtoon_tag1;
	}
	public String getWebtoon_tag2() {
		return webtoon_tag2;
	}
	public void setWebtoon_tag2(String webtoon_tag2) {
		this.webtoon_tag2 = webtoon_tag2;
	}
	public String getWebtoon_thumbnail() {
		return webtoon_thumbnail;
	}
	public void setWebtoon_thumbnail(String webtoon_thumbnail) {
		this.webtoon_thumbnail = webtoon_thumbnail;
	}
	public String getWebtoon_image1() {
		return webtoon_image1;
	}
	public void setWebtoon_image1(String webtoon_image1) {
		this.webtoon_image1 = webtoon_image1;
	}
	public String getWebtoon_image2() {
		return webtoon_image2;
	}
	public void setWebtoon_image2(String webtoon_image2) {
		this.webtoon_image2 = webtoon_image2;
	}
	public String getWebtoon_image3() {
		return webtoon_image3;
	}
	public void setWebtoon_image3(String webtoon_image3) {
		this.webtoon_image3 = webtoon_image3;
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
	
	

}
