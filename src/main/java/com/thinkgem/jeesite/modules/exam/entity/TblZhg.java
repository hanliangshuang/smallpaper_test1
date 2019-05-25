/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.exam.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * zhgEntity
 * @author lpb
 * @version 2017-12-21
 */
public class TblZhg extends DataEntity<TblZhg> {
	
	private static final long serialVersionUID = 1L;
	private String zhgh;		// 职工号
	private String zhgxm;		// 职工姓名
	private String xb;		// 性别
	private String bm;		// 所属部门
	private Date xtshj;		// 系统时间
	private Date beginXtshj;		// 开始 系统时间
	private Date endXtshj;		// 结束 系统时间
	
	public TblZhg() {
		super();
	}

	public TblZhg(String id){
		super(id);
	}

	@Length(min=1, max=20, message="职工号长度必须介于 1 和 20 之间")
	public String getZhgh() {
		return zhgh;
	}

	public void setZhgh(String zhgh) {
		this.zhgh = zhgh;
	}
	
	@Length(min=1, max=20, message="职工姓名长度必须介于 1 和 20 之间")
	public String getZhgxm() {
		return zhgxm;
	}

	public void setZhgxm(String zhgxm) {
		this.zhgxm = zhgxm;
	}
	
	@Length(min=1, max=1, message="性别长度必须介于 1 和 1 之间")
	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}
	
	@Length(min=1, max=20, message="所属部门长度必须介于 1 和 20 之间")
	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="系统时间不能为空")
	public Date getXtshj() {
		return xtshj;
	}

	public void setXtshj(Date xtshj) {
		this.xtshj = xtshj;
	}
	
	public Date getBeginXtshj() {
		return beginXtshj;
	}

	public void setBeginXtshj(Date beginXtshj) {
		this.beginXtshj = beginXtshj;
	}
	
	public Date getEndXtshj() {
		return endXtshj;
	}

	public void setEndXtshj(Date endXtshj) {
		this.endXtshj = endXtshj;
	}
		
}