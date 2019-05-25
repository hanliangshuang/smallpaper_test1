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
 * czlxEntity
 * @author lpb
 * @version 2017-11-27
 */
public class TblCzlx extends DataEntity<TblCzlx> {
	
	private static final long serialVersionUID = 1L;
	private String fkZhgh;		// 外键，关联对应职工表tbl_ZhG.
	private String czlb;		// 操作类型 0-练习 1-考试
	private Date czshj;		// 进入操作练习的开始时间，格式为&ldquo;年-月-日 时-分-秒&rdquo;
	private String czshch;		// 在操作练习中停留的总时长，单位为分
	private String czgch;		// 在操作练习中进行的所有操作的记录；格式 &ldquo;时-分-秒 操作内容 / 时-分-秒 操作内容&rdquo;；
	private String fkkshbh;
	
	
	
	public String getFkkshbh() {
		return fkkshbh;
	}

	public void setFkkshbh(String fkkshbh) {
		this.fkkshbh = fkkshbh;
	}

	public TblCzlx() {
		super();
	}

	public TblCzlx(String id){
		super(id);
	}

	@Length(min=1, max=2, message="长度必须介于 1 和 20 之间")
	public String getFkZhgh() {
		return fkZhgh;
	}

	public void setFkZhgh(String fkZhgh) {
		this.fkZhgh = fkZhgh;
	}
	
	@Length(min=1, max=2, message="操作类型 0-练习 1-考试长度必须介于 1 和 2 之间")
	public String getCzlb() {
		return czlb;
	}

	public void setCzlb(String czlb) {
		this.czlb = czlb;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="进入操作练习的开始时间，格式为&ldquo;年-月-日 时-分-秒&rdquo;不能为空")
	public Date getCzshj() {
		return czshj;
	}

	public void setCzshj(Date czshj) {
		this.czshj = czshj;
	}
	
	@Length(min=1, max=11, message="在操作练习中停留的总时长，单位为分长度必须介于 1 和 11 之间")
	public String getCzshch() {
		return czshch;
	}

	public void setCzshch(String czshch) {
		this.czshch = czshch;
	}
	
	public String getCzgch() {
		return czgch;
	}

	public void setCzgch(String czgch) {
		this.czgch = czgch;
	}
	
}