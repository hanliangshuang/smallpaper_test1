/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.exam.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.exam.entity.CdBm;

/**
 * cd_编码DAO接口
 * @author lpb
 * @version 2017-12-21
 */
@MyBatisDao
public interface CdBmDao extends CrudDao<CdBm> {
	
}