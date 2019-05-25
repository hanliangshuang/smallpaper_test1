/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.exam.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.exam.entity.TblCzlx;
import com.thinkgem.jeesite.modules.exam.service.TblCzlxService;

/**
 * czlxController
 * @author lpb
 * @version 2017-11-27
 */
@Controller
@RequestMapping(value = "${adminPath}/exam/tblCzlx")
public class TblCzlxController extends BaseController {

	@Autowired
	private TblCzlxService tblCzlxService;
	
	@ModelAttribute
	public TblCzlx get(@RequestParam(required=false) String id) {
		TblCzlx entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tblCzlxService.get(id);
		}
		if (entity == null){
			entity = new TblCzlx();
		}
		return entity;
	}
	
	@RequiresPermissions("exam:tblCzlx:view")
	@RequestMapping(value = {"list", ""})
	public String list(TblCzlx tblCzlx, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TblCzlx> page = tblCzlxService.findPage(new Page<TblCzlx>(request, response), tblCzlx); 
		model.addAttribute("page", page);
		return "modules/exam/tblCzlxList";
	}

	@RequiresPermissions("exam:tblCzlx:view")
	@RequestMapping(value = "form")
	public String form(TblCzlx tblCzlx, Model model) {
		model.addAttribute("tblCzlx", tblCzlx);
		return "modules/exam/tblCzlxForm";
	}

	@RequiresPermissions("exam:tblCzlx:edit")
	@RequestMapping(value = "save")
	public String save(TblCzlx tblCzlx, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tblCzlx)){
			return form(tblCzlx, model);
		}
		tblCzlxService.save(tblCzlx);
		addMessage(redirectAttributes, "保存czlx成功");
		return "redirect:"+Global.getAdminPath()+"/exam/tblCzlx/?repage";
	}
	
	@RequiresPermissions("exam:tblCzlx:edit")
	@RequestMapping(value = "delete")
	public String delete(TblCzlx tblCzlx, RedirectAttributes redirectAttributes) {
		tblCzlxService.delete(tblCzlx);
		addMessage(redirectAttributes, "删除czlx成功");
		return "redirect:"+Global.getAdminPath()+"/exam/tblCzlx/?repage";
	}

}