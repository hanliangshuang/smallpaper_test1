/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.exam.web;

import java.util.List;
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
import com.thinkgem.jeesite.modules.exam.entity.TblPxksh;
import com.thinkgem.jeesite.modules.exam.service.TblPxkshService;

/**
 * pxkshController
 * @author lpb
 * @version 2017-11-27
 */
@Controller
@RequestMapping(value = "${adminPath}/exam/tblPxksh")
public class TblPxkshController extends BaseController {

	@Autowired
	private TblPxkshService tblPxkshService;
	
	@ModelAttribute
	public TblPxksh get(@RequestParam(required=false) String id) {
		TblPxksh entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tblPxkshService.get(id);
		}
		if (entity == null){
			entity = new TblPxksh();
		}
		return entity;
	}
	
	@RequiresPermissions("exam:tblPxksh:view")
	@RequestMapping(value = {"list", ""})
	public String list(TblPxksh tblPxksh, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TblPxksh> page = tblPxkshService.findPage(new Page<TblPxksh>(request, response), tblPxksh); 
		model.addAttribute("page", page);
		return "modules/exam/tblPxkshList";
	}

	@RequiresPermissions("exam:tblPxksh:view")
	@RequestMapping(value = "form")
	public String form(TblPxksh tblPxksh, Model model) {
		model.addAttribute("tblPxksh", tblPxksh);
		return "modules/exam/tblPxkshForm";
	}

	@RequiresPermissions("exam:tblPxksh:edit")
	@RequestMapping(value = "save")
	public String save(TblPxksh tblPxksh, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tblPxksh)){
			return form(tblPxksh, model);
		}
		//if(tblPxksh != null && StringUtils.isNoneEmpty(tblPxksh.getId())){
		tblPxkshService.save(tblPxksh);
		
		List<TblPxksh> LTPx = tblPxkshService.findList(new TblPxksh());
		for(int i=0;i<LTPx.size();i++){
			TblPxksh e = LTPx.get(i);
			if(e.getId().equals(tblPxksh.getId())){
				tblPxksh.setShfqy("1");
				tblPxkshService.save(tblPxksh);
			}else{
				e.setShfqy("0");
				tblPxkshService.save(e);
			}
		}
		
		addMessage(redirectAttributes, "保存pxksh成功");
		return "redirect:"+Global.getAdminPath()+"/exam/tblPxksh/?repage";
	}
	
	@RequiresPermissions("exam:tblPxksh:edit")
	@RequestMapping(value = "delete")
	public String delete(TblPxksh tblPxksh, RedirectAttributes redirectAttributes) {
		
		List<TblPxksh> LTPx = tblPxkshService.findList(new TblPxksh());
		for(int i=0;i<LTPx.size();i++){
			TblPxksh e = LTPx.get(i);
			if(e.getId().equals(tblPxksh.getId())){
				tblPxksh.setShfqy("1");
				tblPxkshService.save(tblPxksh);
			}else{
				e.setShfqy("0");
				tblPxkshService.save(e);
			}
		}
	
		addMessage(redirectAttributes, "更新成功");
		return "redirect:"+Global.getAdminPath()+"/exam/tblPxksh/?repage";
	}
	

}