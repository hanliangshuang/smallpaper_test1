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
import com.thinkgem.jeesite.modules.exam.entity.TblZhg;
import com.thinkgem.jeesite.modules.exam.service.TblZhgService;

/**
 * zhgController
 * @author lpb
 * @version 2017-12-21
 */
@Controller
@RequestMapping(value = "${adminPath}/exam/tblZhg")
public class TblZhgController extends BaseController {

	@Autowired
	private TblZhgService tblZhgService;
	
	@ModelAttribute
	public TblZhg get(@RequestParam(required=false) String id) {
		TblZhg entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tblZhgService.get(id);
		}
		if (entity == null){
			entity = new TblZhg();
		}
		return entity;
	}
	
	@RequiresPermissions("exam:tblZhg:view")
	@RequestMapping(value = {"list", ""})
	public String list(TblZhg tblZhg, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TblZhg> page = tblZhgService.findPage(new Page<TblZhg>(request, response), tblZhg); 
		model.addAttribute("page", page);
		return "modules/exam/tblZhgList";
	}

	@RequiresPermissions("exam:tblZhg:view")
	@RequestMapping(value = "form")
	public String form(TblZhg tblZhg, Model model) {
		model.addAttribute("tblZhg", tblZhg);
		return "modules/exam/tblZhgForm";
	}

	@RequiresPermissions("exam:tblZhg:edit")
	@RequestMapping(value = "save")
	public String save(TblZhg tblZhg, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tblZhg)){
			return form(tblZhg, model);
		}
		tblZhgService.save(tblZhg);
		addMessage(redirectAttributes, "保存zhg成功");
		return "redirect:"+Global.getAdminPath()+"/exam/tblZhg/?repage";
	}
	
	@RequiresPermissions("exam:tblZhg:edit")
	@RequestMapping(value = "delete")
	public String delete(TblZhg tblZhg, RedirectAttributes redirectAttributes) {
		tblZhgService.delete(tblZhg);
		addMessage(redirectAttributes, "删除zhg成功");
		return "redirect:"+Global.getAdminPath()+"/exam/tblZhg/?repage";
	}

}