/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.qiye.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.qiye.entity.TestQy;
import com.thinkgem.jeesite.modules.qiye.dao.TestQyDao;

/**
 * 企业Service
 * @author tyk
 * @version 2019-05-09
 */
@Service
@Transactional(readOnly = true)
public class TestQyService extends CrudService<TestQyDao, TestQy> {

	public TestQy get(String id) {
		return super.get(id);
	}
	
	public List<TestQy> findList(TestQy testQy) {
		return super.findList(testQy);
	}
	
	public Page<TestQy> findPage(Page<TestQy> page, TestQy testQy) {
		return super.findPage(page, testQy);
	}
	
	@Transactional(readOnly = false)
	public void save(TestQy testQy) {
		super.save(testQy);
	}
	
	@Transactional(readOnly = false)
	public void delete(TestQy testQy) {
		super.delete(testQy);
	}
	
}