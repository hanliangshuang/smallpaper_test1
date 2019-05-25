/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.lw.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.lw.entity.Smallpaper;
import com.thinkgem.jeesite.modules.lw.dao.SmallpaperDao;

/**
 * 小论文管理Service
 * @author hls
 * @version 2019-05-25
 */
@Service
@Transactional(readOnly = true)
public class SmallpaperService extends CrudService<SmallpaperDao, Smallpaper> {

	public Smallpaper get(String id) {
		return super.get(id);
	}
	
	public List<Smallpaper> findList(Smallpaper smallpaper) {
		return super.findList(smallpaper);
	}
	
	public Page<Smallpaper> findPage(Page<Smallpaper> page, Smallpaper smallpaper) {
		return super.findPage(page, smallpaper);
	}
	
	@Transactional(readOnly = false)
	public void save(Smallpaper smallpaper) {
		super.save(smallpaper);
	}
	
	@Transactional(readOnly = false)
	public void delete(Smallpaper smallpaper) {
		super.delete(smallpaper);
	}
	
}