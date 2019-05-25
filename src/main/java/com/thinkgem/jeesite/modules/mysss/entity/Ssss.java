/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mysss.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * lianxiEntity
 * @author lainxi
 * @version 2018-04-17
 */
public class Ssss extends DataEntity<Ssss> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String age;		// age
	private String xb;		// 0 - nan 1-nv  moren 0
	private String bm;		// bm
	
	
	public Ssss() {
		super();
	}

	public Ssss(String id){
		super(id);
	}

	@Length(min=1, max=64, message="name长度必须介于 1 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=3, message="age长度必须介于 1 和 3 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@Length(min=1, max=1, message="0 - nan 1-nv  moren 0长度必须介于 1 和 1 之间")
	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}
	
	@Length(min=1, max=64, message="bm长度必须介于 1 和 64 之间")
	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}
	
	
}