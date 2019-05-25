/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.exam.entity.TblPxksh;
import com.thinkgem.jeesite.modules.exam.dao.TblPxkshDao;

/**
 * pxkshService
 * @author lpb
 * @version 2017-11-27
 */
@Service
@Transactional(readOnly = true)
public class TblPxkshService extends CrudService<TblPxkshDao, TblPxksh> {

	public TblPxksh get(String id) {
		return super.get(id);
	}
	
	public List<TblPxksh> findList(TblPxksh tblPxksh) {
		return super.findList(tblPxksh);
	}
	
	public Page<TblPxksh> findPage(Page<TblPxksh> page, TblPxksh tblPxksh) {
		return super.findPage(page, tblPxksh);
	}
	
	@Transactional(readOnly = false)
	public void save(TblPxksh tblPxksh) {
		super.save(tblPxksh);
	}
	
	@Transactional(readOnly = false)
	public void delete(TblPxksh tblPxksh) {
		super.delete(tblPxksh);
	}
	
}