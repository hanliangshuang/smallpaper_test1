/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.lw.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 小论文管理Entity
 * @author hls
 * @version 2019-05-25
 */
public class Smallpaper extends DataEntity<Smallpaper> {
	
	private static final long serialVersionUID = 1L;
	private String xm;		// 姓名
	private String xh;		// 学号
	private String bt;		// 题标
	private String shllb;		// 收录类别
	private String sshdw;		// 所属单位
	private String kysh;		// 科研室
	private String yjxk;		// 一级学科
	private String fbfw;		// 发表范围
	private String fj;		// 附件
	private String zsh;		// 字数
	private String bm;		// 版面
	private String isbn;		// ISBN
	private String doi;		// doi
	private String hydzh;		// 会议地址
	private String shlh;		// 收录号
	private String shfyhylhfb;		// 是否与行业联合发表
	private String xkml;		// 学科门类
	private String xmly;		// 项目来源
	private String lwjchbdw;		// 论文集出版单位
	private String shftj;		// 是否统计
	private String xxshm;		// 学校署名
	private String shfwyw;		// 是否为译文
	private String jqy;		// 卷期页
	private String hymch;		// 会议名称
	private String hyrq;		// 会议日期
	private String lwfbyy;		// 论文发表语言
	private String shfydflhfb;		// 是否与地方联合发表
	private String c1;		// 预留1
	private String c2;		// 预留2
	private String c3;		// 预留3
	private String c4;		// 预留4
	private String c5;		// 预留5
	
	public Smallpaper() {
		super();
	}

	public Smallpaper(String id){
		super(id);
	}

	@Length(min=0, max=64, message="姓名长度必须介于 0 和 64 之间")
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}
	
	@Length(min=0, max=10, message="学号长度必须介于 0 和 10 之间")
	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}
	
	@Length(min=0, max=255, message="题标长度必须介于 0 和 255 之间")
	public String getBt() {
		return bt;
	}

	public void setBt(String bt) {
		this.bt = bt;
	}
	
	@Length(min=0, max=64, message="收录类别长度必须介于 0 和 64 之间")
	public String getShllb() {
		return shllb;
	}

	public void setShllb(String shllb) {
		this.shllb = shllb;
	}
	
	@Length(min=0, max=64, message="所属单位长度必须介于 0 和 64 之间")
	public String getSshdw() {
		return sshdw;
	}

	public void setSshdw(String sshdw) {
		this.sshdw = sshdw;
	}
	
	@Length(min=0, max=64, message="科研室长度必须介于 0 和 64 之间")
	public String getKysh() {
		return kysh;
	}

	public void setKysh(String kysh) {
		this.kysh = kysh;
	}
	
	@Length(min=0, max=64, message="一级学科长度必须介于 0 和 64 之间")
	public String getYjxk() {
		return yjxk;
	}

	public void setYjxk(String yjxk) {
		this.yjxk = yjxk;
	}
	
	@Length(min=0, max=64, message="发表范围长度必须介于 0 和 64 之间")
	public String getFbfw() {
		return fbfw;
	}

	public void setFbfw(String fbfw) {
		this.fbfw = fbfw;
	}
	
	public String getFj() {
		return fj;
	}

	public void setFj(String fj) {
		this.fj = fj;
	}
	
	@Length(min=0, max=64, message="字数长度必须介于 0 和 64 之间")
	public String getZsh() {
		return zsh;
	}

	public void setZsh(String zsh) {
		this.zsh = zsh;
	}
	
	@Length(min=0, max=64, message="版面长度必须介于 0 和 64 之间")
	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}
	
	@Length(min=0, max=64, message="ISBN长度必须介于 0 和 64 之间")
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Length(min=0, max=64, message="doi长度必须介于 0 和 64 之间")
	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}
	
	@Length(min=0, max=255, message="会议地址长度必须介于 0 和 255 之间")
	public String getHydzh() {
		return hydzh;
	}

	public void setHydzh(String hydzh) {
		this.hydzh = hydzh;
	}
	
	@Length(min=0, max=64, message="收录号长度必须介于 0 和 64 之间")
	public String getShlh() {
		return shlh;
	}

	public void setShlh(String shlh) {
		this.shlh = shlh;
	}
	
	@Length(min=0, max=64, message="是否与行业联合发表长度必须介于 0 和 64 之间")
	public String getShfyhylhfb() {
		return shfyhylhfb;
	}

	public void setShfyhylhfb(String shfyhylhfb) {
		this.shfyhylhfb = shfyhylhfb;
	}
	
	@Length(min=0, max=64, message="学科门类长度必须介于 0 和 64 之间")
	public String getXkml() {
		return xkml;
	}

	public void setXkml(String xkml) {
		this.xkml = xkml;
	}
	
	@Length(min=0, max=64, message="项目来源长度必须介于 0 和 64 之间")
	public String getXmly() {
		return xmly;
	}

	public void setXmly(String xmly) {
		this.xmly = xmly;
	}
	
	@Length(min=0, max=64, message="论文集出版单位长度必须介于 0 和 64 之间")
	public String getLwjchbdw() {
		return lwjchbdw;
	}

	public void setLwjchbdw(String lwjchbdw) {
		this.lwjchbdw = lwjchbdw;
	}
	
	@Length(min=0, max=64, message="是否统计长度必须介于 0 和 64 之间")
	public String getShftj() {
		return shftj;
	}

	public void setShftj(String shftj) {
		this.shftj = shftj;
	}
	
	@Length(min=0, max=64, message="学校署名长度必须介于 0 和 64 之间")
	public String getXxshm() {
		return xxshm;
	}

	public void setXxshm(String xxshm) {
		this.xxshm = xxshm;
	}
	
	@Length(min=0, max=64, message="是否为译文长度必须介于 0 和 64 之间")
	public String getShfwyw() {
		return shfwyw;
	}

	public void setShfwyw(String shfwyw) {
		this.shfwyw = shfwyw;
	}
	
	@Length(min=0, max=64, message="卷期页长度必须介于 0 和 64 之间")
	public String getJqy() {
		return jqy;
	}

	public void setJqy(String jqy) {
		this.jqy = jqy;
	}
	
	@Length(min=0, max=255, message="会议名称长度必须介于 0 和 255 之间")
	public String getHymch() {
		return hymch;
	}

	public void setHymch(String hymch) {
		this.hymch = hymch;
	}
	
	@Length(min=0, max=64, message="会议日期长度必须介于 0 和 64 之间")
	public String getHyrq() {
		return hyrq;
	}

	public void setHyrq(String hyrq) {
		this.hyrq = hyrq;
	}
	
	@Length(min=0, max=64, message="论文发表语言长度必须介于 0 和 64 之间")
	public String getLwfbyy() {
		return lwfbyy;
	}

	public void setLwfbyy(String lwfbyy) {
		this.lwfbyy = lwfbyy;
	}
	
	@Length(min=0, max=64, message="是否与地方联合发表长度必须介于 0 和 64 之间")
	public String getShfydflhfb() {
		return shfydflhfb;
	}

	public void setShfydflhfb(String shfydflhfb) {
		this.shfydflhfb = shfydflhfb;
	}
	
	@Length(min=0, max=255, message="预留1长度必须介于 0 和 255 之间")
	public String getC1() {
		return c1;
	}

	public void setC1(String c1) {
		this.c1 = c1;
	}
	
	@Length(min=0, max=255, message="预留2长度必须介于 0 和 255 之间")
	public String getC2() {
		return c2;
	}

	public void setC2(String c2) {
		this.c2 = c2;
	}
	
	@Length(min=0, max=255, message="预留3长度必须介于 0 和 255 之间")
	public String getC3() {
		return c3;
	}

	public void setC3(String c3) {
		this.c3 = c3;
	}
	
	@Length(min=0, max=255, message="预留4长度必须介于 0 和 255 之间")
	public String getC4() {
		return c4;
	}

	public void setC4(String c4) {
		this.c4 = c4;
	}
	
	@Length(min=0, max=255, message="预留5长度必须介于 0 和 255 之间")
	public String getC5() {
		return c5;
	}

	public void setC5(String c5) {
		this.c5 = c5;
	}
	
}