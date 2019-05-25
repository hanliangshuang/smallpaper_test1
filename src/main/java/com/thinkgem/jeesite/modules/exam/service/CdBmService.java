/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.exam.entity.CdBm;
import com.thinkgem.jeesite.modules.exam.dao.CdBmDao;

/**
 * cd_编码Service
 * @author lpb
 * @version 2017-12-21
 */
@Service
@Transactional(readOnly = true)
public class CdBmService extends CrudService<CdBmDao, CdBm> {

	public CdBm get(String id) {
		return super.get(id);
	}
	
	public List<CdBm> findList(CdBm cdBm) {
		return super.findList(cdBm);
	}
	
	public Page<CdBm> findPage(Page<CdBm> page, CdBm cdBm) {
		return super.findPage(page, cdBm);
	}
	
	@Transactional(readOnly = false)
	public void save(CdBm cdBm) {
		super.save(cdBm);
	}
	
	@Transactional(readOnly = false)
	public void delete(CdBm cdBm) {
		super.delete(cdBm);
	}
	
}