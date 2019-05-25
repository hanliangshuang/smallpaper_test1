/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.qiye.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 企业Entity
 * @author tyk
 * @version 2019-05-09
 */
public class TestQy extends DataEntity<TestQy> {
	
	private static final long serialVersionUID = 1L;
	private String qymch;		// 企业名称
	private String zczb;		// 注册资本
	private Date zcshj;		// 注册时间
	private String zdqy;		// 重点企业
	private String gslx;		// 公司类型
	private String gsdzh;		// 公司地址
	private String beginZczb;		// 开始 注册资本
	private String endZczb;		// 结束 注册资本
	private Date beginZcshj;		// 开始 注册时间
	private Date endZcshj;		// 结束 注册时间
	
	public TestQy() {
		super();
	}

	public TestQy(String id){
		super(id);
	}

	@Length(min=1, max=64, message="企业名称长度必须介于 1 和 64 之间")
	public String getQymch() {
		return qymch;
	}

	public void setQymch(String qymch) {
		this.qymch = qymch;
	}
	
	public String getZczb() {
		return zczb;
	}

	public void setZczb(String zczb) {
		this.zczb = zczb;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="注册时间不能为空")
	public Date getZcshj() {
		return zcshj;
	}

	public void setZcshj(Date zcshj) {
		this.zcshj = zcshj;
	}
	
	@Length(min=1, max=1, message="重点企业长度必须介于 1 和 1 之间")
	public String getZdqy() {
		return zdqy;
	}

	public void setZdqy(String zdqy) {
		this.zdqy = zdqy;
	}
	
	@Length(min=1, max=1, message="公司类型长度必须介于 1 和 1 之间")
	public String getGslx() {
		return gslx;
	}

	public void setGslx(String gslx) {
		this.gslx = gslx;
	}
	
	@Length(min=1, max=64, message="公司地址长度必须介于 1 和 64 之间")
	public String getGsdzh() {
		return gsdzh;
	}

	public void setGsdzh(String gsdzh) {
		this.gsdzh = gsdzh;
	}
	
	public String getBeginZczb() {
		return beginZczb;
	}

	public void setBeginZczb(String beginZczb) {
		this.beginZczb = beginZczb;
	}
	
	public String getEndZczb() {
		return endZczb;
	}

	public void setEndZczb(String endZczb) {
		this.endZczb = endZczb;
	}
		
	public Date getBeginZcshj() {
		return beginZcshj;
	}

	public void setBeginZcshj(Date beginZcshj) {
		this.beginZcshj = beginZcshj;
	}
	
	public Date getEndZcshj() {
		return endZcshj;
	}

	public void setEndZcshj(Date endZcshj) {
		this.endZcshj = endZcshj;
	}
		
}