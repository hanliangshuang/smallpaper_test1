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
 * 考试成绩Entity
 * @author lpb
 * @version 2017-11-27
 */
public class TblPxkshchj extends DataEntity<TblPxkshchj> {
	
	private static final long serialVersionUID = 1L;
	private String fkZhgh;		// 外键，关联对应职工表tbl_ZhG.ZhGH
	private String fkKshbh;		// 外键，关联培训考试表tbl_PXKSh.id
	private Date kshshj;		// 参加考试的具体时间，格式为&ldquo;年-月-日 时-分-秒&rdquo;
	private String ksysh;		// 在考试中使用的总时长，单位为分
	private String jl;		// 是否警铃提示
	private String pgcsh;		// 考试过程中，操作失误导致的碰杆的次数
	private String dgcsh;		// 考试过程中，操作失误导致倒杆的次数
	private String chny;		// 考试过程中出内圆（压到内圆的线）侧次数
	private String chzhy;		// 考试过程中出中圆（压到中圆的线）测次数
	private String chwy;		// 考试过程中出外圆（压到外圆的线）测次数
	private String shfdt;		// 是否多次停顿（超5次），默认0，超次数为 1
	private String kshchj;		// 最后成绩
	private String zhgxmxsh;
	private String zhgbmxsh;
	private String czgc;
	
	
	
	
	public String getZhgbmxsh() {
		return zhgbmxsh;
	}

	public void setZhgbmxsh(String zhgbmxsh) {
		this.zhgbmxsh = zhgbmxsh;
	}

	public String getCzgc() {
		return czgc;
	}

	public void setCzgc(String czgc) {
		this.czgc = czgc;
	}

	public String getZhgxmxsh() {
		return zhgxmxsh;
	}

	public void setZhgxmxsh(String zhgxmxsh) {
		this.zhgxmxsh = zhgxmxsh;
	}

	public TblPxkshchj() {
		super();
	}

	public TblPxkshchj(String id){
		super(id);
	}

	@Length(min=1, max=11, message="ZhGH长度必须介于 1 和 20 之间")
	public String getFkZhgh() {
		return fkZhgh;
	}

	public void setFkZhgh(String fkZhgh) {
		this.fkZhgh = fkZhgh;
	}
	
	@Length(min=1, max=11, message="id长度必须介于 1 和 16 之间")
	public String getFkKshbh() {
		return fkKshbh;
	}

	public void setFkKshbh(String fkKshbh) {
		this.fkKshbh = fkKshbh;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="参加考试的具体时间，格式为&ldquo;年-月-日 时-分-秒&rdquo;不能为空")
	public Date getKshshj() {
		return kshshj;
	}

	public void setKshshj(Date kshshj) {
		this.kshshj = kshshj;
	}
	
	@Length(min=1, max=11, message="在考试中使用的总时长，单位为分长度必须介于 1 和 11 之间")
	public String getKsysh() {
		return ksysh;
	}

	public void setKsysh(String ksysh) {
		this.ksysh = ksysh;
	}
	
	@Length(min=1, max=2, message="是否警铃提示长度必须介于 1 和 2 之间")
	public String getJl() {
		return jl;
	}

	public void setJl(String jl) {
		this.jl = jl;
	}
	
	@Length(min=1, max=11, message="考试过程中，操作失误导致的碰杆的次数长度必须介于 1 和 11 之间")
	public String getPgcsh() {
		return pgcsh;
	}

	public void setPgcsh(String pgcsh) {
		this.pgcsh = pgcsh;
	}
	
	@Length(min=1, max=11, message="考试过程中，操作失误导致倒杆的次数长度必须介于 1 和 11 之间")
	public String getDgcsh() {
		return dgcsh;
	}

	public void setDgcsh(String dgcsh) {
		this.dgcsh = dgcsh;
	}
	
	@Length(min=1, max=3, message="考试过程中出内圆（压到内圆的线）侧次数长度必须介于 1 和 3 之间")
	public String getChny() {
		return chny;
	}

	public void setChny(String chny) {
		this.chny = chny;
	}
	
	@Length(min=1, max=3, message="考试过程中出中圆（压到中圆的线）测次数长度必须介于 1 和 3 之间")
	public String getChzhy() {
		return chzhy;
	}

	public void setChzhy(String chzhy) {
		this.chzhy = chzhy;
	}
	
	@Length(min=1, max=3, message="考试过程中出外圆（压到外圆的线）测次数长度必须介于 1 和 3 之间")
	public String getChwy() {
		return chwy;
	}

	public void setChwy(String chwy) {
		this.chwy = chwy;
	}
	
	@Length(min=1, max=2, message="是否多次停顿（超5次），默认0，超次数为 1长度必须介于 1 和 2 之间")
	public String getShfdt() {
		return shfdt;
	}

	public void setShfdt(String shfdt) {
		this.shfdt = shfdt;
	}
	
	@Length(min=1, max=11, message="最后成绩长度必须介于 1 和 11 之间")
	public String getKshchj() {
		return kshchj;
	}

	public void setKshchj(String kshchj) {
		this.kshchj = kshchj;
	}
	
}