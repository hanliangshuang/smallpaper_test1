/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.exam.entity.TblPxkshchj;
import com.thinkgem.jeesite.modules.exam.dao.TblPxkshchjDao;

/**
 * 考试成绩Service
 * @author lpb
 * @version 2017-11-27
 */
@Service
@Transactional(readOnly = true)
public class TblPxkshchjService extends CrudService<TblPxkshchjDao, TblPxkshchj> {

	public TblPxkshchj get(String id) {
		return super.get(id);
	}
	
	public List<TblPxkshchj> findList(TblPxkshchj tblPxkshchj) {
		return super.findList(tblPxkshchj);
	}
	
	public Page<TblPxkshchj> findPage(Page<TblPxkshchj> page, TblPxkshchj tblPxkshchj) {
		return super.findPage(page, tblPxkshchj);
	}
	
	@Transactional(readOnly = false)
	public void save(TblPxkshchj tblPxkshchj) {
		super.save(tblPxkshchj);
	}
	
	@Transactional(readOnly = false)
	public void delete(TblPxkshchj tblPxkshchj) {
		super.delete(tblPxkshchj);
	}
	
}