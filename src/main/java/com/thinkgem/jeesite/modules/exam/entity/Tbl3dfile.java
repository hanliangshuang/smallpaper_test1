/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.exam.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 3DResourceEntity
 * @author xuhongtao
 * @version 2018-03-01
 */
public class Tbl3dfile extends DataEntity<Tbl3dfile> {
	
	private static final long serialVersionUID = 1L;
	private String mch;		// 资源名称
	private String lx;		// 类型
	private String shm;		// 说明
	private String pic;		// 图片链接地址
	private String zydzh;		// 资源地址
	
	public Tbl3dfile() {
		super();
	}

	public Tbl3dfile(String id){
		super(id);
	}

	@Length(min=1, max=80, message="资源名称长度必须介于 1 和 80 之间")
	public String getMch() {
		return mch;
	}

	public void setMch(String mch) {
		this.mch = mch;
	}
	
	@Length(min=1, max=20, message="类型长度必须介于 1 和 20 之间")
	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}
	
	@Length(min=1, max=500, message="说明长度必须介于 1 和 500 之间")
	public String getShm() {
		return shm;
	}

	public void setShm(String shm) {
		this.shm = shm;
	}
	
	@Length(min=1, max=500, message="图片链接地址长度必须介于 1 和 500 之间")
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	@Length(min=1, max=500, message="资源地址长度必须介于 1 和 500 之间")
	public String getZydzh() {
		return zydzh;
	}

	public void setZydzh(String zydzh) {
		this.zydzh = zydzh;
	}
	
}