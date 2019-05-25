/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.exam.entity.TblZhg;
import com.thinkgem.jeesite.modules.exam.dao.TblZhgDao;

/**
 * zhgService
 * @author lpb
 * @version 2017-12-21
 */
@Service
@Transactional(readOnly = true)
public class TblZhgService extends CrudService<TblZhgDao, TblZhg> {

	public TblZhg get(String id) {
		return super.get(id);
	}
	
	public List<TblZhg> findList(TblZhg tblZhg) {
		return super.findList(tblZhg);
	}
	
	public Page<TblZhg> findPage(Page<TblZhg> page, TblZhg tblZhg) {
		return super.findPage(page, tblZhg);
	}
	
	@Transactional(readOnly = false)
	public void save(TblZhg tblZhg) {
		super.save(tblZhg);
	}
	
	@Transactional(readOnly = false)
	public void delete(TblZhg tblZhg) {
		super.delete(tblZhg);
	}
	
}