/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.exam.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.supcan.annotation.treelist.cols.SupCol;

/**
 * pxkshEntity
 * @author lpb
 * @version 2017-11-27
 */
public class TblPxksh extends DataEntity<TblPxksh> {
	
	private static final long serialVersionUID = 1L;
	private String kshbh;		// 考试的自定义编号
	private String zfzh;		// 考试的成绩总分
	private String czshch;		// 在考试中允许的总时长，单位为分
	private String kfzh;		// 考试过程中，操作失误所对应的扣分分值
	private String shfqy;
	
	public TblPxksh() {
		super();
	}

	public TblPxksh(String id){
		super(id);
	}

	
	@NotNull
	@Length(min=1, max=16, message="考试的自定义编号长度必须介于 1 和 16 之间")
	public String getKshbh() {
		return kshbh;
	}

	public void setKshbh(String kshbh) {
		this.kshbh = kshbh;
	}
	
	@Length(min=1, max=11, message="考试的成绩总分长度必须介于 1 和 11 之间")
	public String getZfzh() {
		return zfzh;
	}

	public void setZfzh(String zfzh) {
		this.zfzh = zfzh;
	}
	
	@Length(min=1, max=11, message="在考试中允许的总时长，单位为分长度必须介于 1 和 11 之间")
	public String getCzshch() {
		return czshch;
	}

	public void setCzshch(String czshch) {
		this.czshch = czshch;
	}
	
	@Length(min=1, max=11, message="考试过程中，操作失误所对应的扣分分值长度必须介于 1 和 11 之间")
	public String getKfzh() {
		return kfzh;
	}

	public void setKfzh(String kfzh) {
		this.kfzh = kfzh;
	}
	@Length(min=1, max=11, message="是否启用")
	public String getShfqy() {
		return shfqy;
	}

	public void setShfqy(String shfqy) {
		this.shfqy = shfqy;
	}
	
	
}