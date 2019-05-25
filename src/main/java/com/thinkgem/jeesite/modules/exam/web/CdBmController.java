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
import com.thinkgem.jeesite.modules.exam.entity.CdBm;
import com.thinkgem.jeesite.modules.exam.service.CdBmService;

/**
 * cd_编码Controller
 * @author lpb
 * @version 2017-12-21
 */
@Controller
@RequestMapping(value = "${adminPath}/exam/cdBm")
public class CdBmController extends BaseController {

	@Autowired
	private CdBmService cdBmService;
	
	@ModelAttribute
	public CdBm get(@RequestParam(required=false) String id) {
		CdBm entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cdBmService.get(id);
		}
		if (entity == null){
			entity = new CdBm();
		}
		return entity;
	}
	
	@RequiresPermissions("exam:cdBm:view")
	@RequestMapping(value = {"list"})
	public String list(CdBm cdBm, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CdBm> page = cdBmService.findPage(new Page<CdBm>(request, response), cdBm); 
		model.addAttribute("page", page);
		return "modules/exam/cdBmList";
	}

	@RequiresPermissions("exam:cdBm:view")
	@RequestMapping(value = "form")
	public String form(CdBm cdBm, Model model) {
		model.addAttribute("cdBm", cdBm);
		return "modules/exam/cdBmForm";
	}

	@RequiresPermissions("exam:cdBm:edit")
	@RequestMapping(value = "save")
	public String save(CdBm cdBm, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, cdBm)){
			return form(cdBm, model);
		}
		cdBmService.save(cdBm);
		addMessage(redirectAttributes, "保存cd_编码成功");
		return "redirect:"+Global.getAdminPath()+"/exam/cdBm/?repage";
	}
	
	@RequiresPermissions("exam:cdBm:edit")
	@RequestMapping(value = "delete")
	public String delete(CdBm cdBm, RedirectAttributes redirectAttributes) {
		cdBmService.delete(cdBm);
		addMessage(redirectAttributes, "删除cd_编码成功");
		return "redirect:"+Global.getAdminPath()+"/exam/cdBm/?repage";
	}

}