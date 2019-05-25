/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.exam.entity.TblCzlx;
import com.thinkgem.jeesite.modules.exam.dao.TblCzlxDao;

/**
 * czlxService
 * @author lpb
 * @version 2017-11-27
 */
@Service
@Transactional(readOnly = true)
public class TblCzlxService extends CrudService<TblCzlxDao, TblCzlx> {

	public TblCzlx get(String id) {
		return super.get(id);
	}
	
	public List<TblCzlx> findList(TblCzlx tblCzlx) {
		return super.findList(tblCzlx);
	}
	
	public Page<TblCzlx> findPage(Page<TblCzlx> page, TblCzlx tblCzlx) {
		return super.findPage(page, tblCzlx);
	}
	
	@Transactional(readOnly = false)
	public void save(TblCzlx tblCzlx) {
		super.save(tblCzlx);
	}
	
	@Transactional(readOnly = false)
	public void delete(TblCzlx tblCzlx) {
		super.delete(tblCzlx);
	}
	
}