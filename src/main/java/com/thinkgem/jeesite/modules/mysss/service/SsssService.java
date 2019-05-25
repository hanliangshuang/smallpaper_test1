/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mysss.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.mysss.entity.Ssss;
import com.thinkgem.jeesite.modules.mysss.dao.SsssDao;

/**
 * lianxiService
 * @author lainxi
 * @version 2018-04-17
 */
@Service
@Transactional(readOnly = true)
public class SsssService extends CrudService<SsssDao, Ssss> {

	public Ssss get(String id) {
		return super.get(id);
	}
	
	public List<Ssss> findList(Ssss ssss) {
		return super.findList(ssss);
	}
	
	public Page<Ssss> findPage(Page<Ssss> page, Ssss ssss) {
		return super.findPage(page, ssss);
	}
	
	@Transactional(readOnly = false)
	public void save(Ssss ssss) {
		super.save(ssss);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ssss ssss) {
		super.delete(ssss);
	}
	
	public List<Ssss> findAllList() {
		return findAllList();
	}
	
	public List<Ssss> findexits(Ssss ssss) {
		return findexits(ssss);
	}
}