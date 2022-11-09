package com.assemble.vo;


public class ThemaVO {

	private String thema_title;
	private String thema_cont;
	
	private WebtoonVO webtoonVo;
	
	public WebtoonVO getWebtoonVo() {
		return webtoonVo;
	}
	public void setWebtoonVo(WebtoonVO webtoonVo) {
		this.webtoonVo = webtoonVo;
	}
	
	public String getThema_title() {
		return thema_title;
	}
	public void setThema_title(String thema_title) {
		this.thema_title = thema_title;
	}
	public String getThema_cont() {
		return thema_cont;
	}
	public void setThema_cont(String thema_cont) {
		this.thema_cont = thema_cont;
	}
	
}
