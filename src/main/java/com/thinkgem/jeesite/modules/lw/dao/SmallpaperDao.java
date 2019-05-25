/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.lw.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.lw.entity.Smallpaper;

/**
 * 小论文管理DAO接口
 * @author hls
 * @version 2019-05-25
 */
@MyBatisDao
public interface SmallpaperDao extends CrudDao<Smallpaper> {
	
}