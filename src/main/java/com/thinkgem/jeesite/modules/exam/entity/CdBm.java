/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.exam.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * cd_编码Entity
 * @author lpb
 * @version 2017-12-21
 */
public class CdBm extends DataEntity<CdBm> {
	
	private static final long serialVersionUID = 1L;
	private Integer px;		// 排序
	private String bmmch;		// 编码名称
	private String bmzh;		// 编码值
	
	public CdBm() {
		super();
	}

	public CdBm(String id){
		super(id);
	}

	@NotNull(message="排序不能为空")
	public Integer getPx() {
		return px;
	}

	public void setPx(Integer px) {
		this.px = px;
	}
	
	@Length(min=1, max=255, message="编码名称长度必须介于 1 和 255 之间")
	public String getBmmch() {
		return bmmch;
	}

	public void setBmmch(String bmmch) {
		this.bmmch = bmmch;
	}
	
	@Length(min=1, max=255, message="编码值长度必须介于 1 和 255 之间")
	public String getBmzh() {
		return bmzh;
	}

	public void setBmzh(String bmzh) {
		this.bmzh = bmzh;
	}
	
}