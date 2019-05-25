/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.lw.web;

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
import com.thinkgem.jeesite.modules.lw.entity.Smallpaper;
import com.thinkgem.jeesite.modules.lw.service.SmallpaperService;

/**
 * 小论文管理Controller
 * @author hls
 * @version 2019-05-25
 */
@Controller
@RequestMapping(value = "${adminPath}/lw/smallpaper")
public class SmallpaperController extends BaseController {

	@Autowired
	private SmallpaperService smallpaperService;
	
	@ModelAttribute
	public Smallpaper get(@RequestParam(required=false) String id) {
		Smallpaper entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = smallpaperService.get(id);
		}
		if (entity == null){
			entity = new Smallpaper();
		}
		return entity;
	}
	
	@RequiresPermissions("lw:smallpaper:view")
	@RequestMapping(value = {"list", ""})
	public String list(Smallpaper smallpaper, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Smallpaper> page = smallpaperService.findPage(new Page<Smallpaper>(request, response), smallpaper); 
		model.addAttribute("page", page);
		return "modules/lw/smallpaperList";
	}

	@RequiresPermissions("lw:smallpaper:view")
	@RequestMapping(value = "form")
	public String form(Smallpaper smallpaper, Model model) {
		model.addAttribute("smallpaper", smallpaper);
		return "modules/lw/smallpaperForm";
	}

	@RequiresPermissions("lw:smallpaper:edit")
	@RequestMapping(value = "save")
	public String save(Smallpaper smallpaper, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, smallpaper)){
			return form(smallpaper, model);
		}
		smallpaperService.save(smallpaper);
		addMessage(redirectAttributes, "保存小论文成功");
		return "redirect:"+Global.getAdminPath()+"/lw/smallpaper/?repage";
	}
	
	@RequiresPermissions("lw:smallpaper:edit")
	@RequestMapping(value = "delete")
	public String delete(Smallpaper smallpaper, RedirectAttributes redirectAttributes) {
		smallpaperService.delete(smallpaper);
		addMessage(redirectAttributes, "删除小论文成功");
		return "redirect:"+Global.getAdminPath()+"/lw/smallpaper/?repage";
	}

}