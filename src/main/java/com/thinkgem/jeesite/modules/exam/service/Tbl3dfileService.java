/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.exam.entity.Tbl3dfile;
import com.thinkgem.jeesite.modules.exam.dao.Tbl3dfileDao;

/**
 * 3DResourceService
 * @author xuhongtao
 * @version 2018-03-01
 */
@Service
@Transactional(readOnly = true)
public class Tbl3dfileService extends CrudService<Tbl3dfileDao, Tbl3dfile> {

	public Tbl3dfile get(String id) {
		return super.get(id);
	}
	
	public List<Tbl3dfile> findList(Tbl3dfile tbl3dfile) {
		return super.findList(tbl3dfile);
	}
	
	public Page<Tbl3dfile> findPage(Page<Tbl3dfile> page, Tbl3dfile tbl3dfile) {
		return super.findPage(page, tbl3dfile);
	}
	
	@Transactional(readOnly = false)
	public void save(Tbl3dfile tbl3dfile) {
		super.save(tbl3dfile);
	}
	
	@Transactional(readOnly = false)
	public void delete(Tbl3dfile tbl3dfile) {
		super.delete(tbl3dfile);
	}
	
}