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
import com.thinkgem.jeesite.modules.exam.entity.TblPxkshchj;
import com.thinkgem.jeesite.modules.exam.entity.TblZhg;
import com.thinkgem.jeesite.modules.exam.service.TblPxkshchjService;
import com.thinkgem.jeesite.modules.exam.service.TblZhgService;

/**
 * 考试成绩Controller
 * @author lpb
 * @version 2017-11-27
 */
@Controller
@RequestMapping(value = "${adminPath}/exam/tblPxkshchj")
public class TblPxkshchjController extends BaseController {

	@Autowired
	private TblPxkshchjService tblPxkshchjService;
	
	@Autowired
	private TblZhgService tblZhgService;
	
	@ModelAttribute
	public TblPxkshchj get(@RequestParam(required=false) String id) {
		TblPxkshchj entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tblPxkshchjService.get(id);
		}
		if (entity == null){
			entity = new TblPxkshchj();
		}
		return entity;
	}
	
	@RequiresPermissions("exam:tblPxkshchj:view")
	@RequestMapping(value = {"list", ""})
	public String list(TblPxkshchj tblPxkshchj, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TblPxkshchj> page = tblPxkshchjService.findPage(new Page<TblPxkshchj>(request, response), tblPxkshchj); 
		model.addAttribute("page", page);
		return "modules/exam/tblPxkshchjList";
	}

	@RequiresPermissions("exam:tblPxkshchj:view")
	@RequestMapping(value = "form")
	public String form(TblPxkshchj tblPxkshchj, Model model) {
		model.addAttribute("tblPxkshchj", tblPxkshchj);
		return "modules/exam/tblPxkshchjForm";
	}
	
	@RequiresPermissions("exam:tblPxkshchj:view")
	@RequestMapping(value = "chjxiangxi")
	public String chjxiangxi(TblPxkshchj tblPxkshchj,TblZhg zhg, Model model) {
		model.addAttribute("zhg", zhg);
		model.addAttribute("tblPxkshchj", tblPxkshchj);
		return "modules/exam/tblPxkshchjxiangxi";
	}
	

	@RequiresPermissions("exam:tblPxkshchj:edit")
	@RequestMapping(value = "save")
	public String save(TblPxkshchj tblPxkshchj, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tblPxkshchj)){
			return form(tblPxkshchj, model);
		}
		tblPxkshchjService.save(tblPxkshchj);
		addMessage(redirectAttributes, "保存考试成绩查询成功");
		return "redirect:"+Global.getAdminPath()+"/exam/tblPxkshchj/?repage";
	}
	
	@RequiresPermissions("exam:tblPxkshchj:edit")
	@RequestMapping(value = "delete")
	public String delete(TblPxkshchj tblPxkshchj, RedirectAttributes redirectAttributes) {
		tblPxkshchjService.delete(tblPxkshchj);
		addMessage(redirectAttributes, "删除考试成绩查询成功");
		return "redirect:"+Global.getAdminPath()+"/exam/tblPxkshchj/?repage";
	}

}