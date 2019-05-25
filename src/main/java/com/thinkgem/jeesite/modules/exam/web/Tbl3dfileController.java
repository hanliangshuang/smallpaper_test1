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
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.exam.entity.Tbl3dfile;
import com.thinkgem.jeesite.modules.exam.service.Tbl3dfileService;

/**
 * 3DResourceController
 * @author xuhongtao
 * @version 2018-03-01
 */
@Controller
@RequestMapping(value = "${adminPath}/exam/tbl3dfile")
public class Tbl3dfileController extends BaseController {

	@Autowired
	private Tbl3dfileService tbl3dfileService;
	
	@ModelAttribute
	public Tbl3dfile get(@RequestParam(required=false) String id) {
		Tbl3dfile entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbl3dfileService.get(id);
		}
		if (entity == null){
			entity = new Tbl3dfile();
		}
		return entity;
	}
	
	@RequiresPermissions("exam:tbl3dfile:view")
	@RequestMapping(value = {"list"})
	public String list(Tbl3dfile tbl3dfile, HttpServletRequest request, HttpServletResponse response, Model model) {
		int isAuth = 0;//默认不是管理员身份
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			tbl3dfile.setCreateBy(user);
			isAuth = 0;
		}else{
			isAuth = 1;
		}
		
		Page<Tbl3dfile> page = tbl3dfileService.findPage(new Page<Tbl3dfile>(request, response), tbl3dfile); 
		page.setPageSize(50);
		model.addAttribute("page", page);
		model.addAttribute("isAuth", isAuth);
		return "modules/exam/tbl3dfileList";
	}

	@RequiresPermissions("exam:tbl3dfile:view")
	@RequestMapping(value = "form")
	public String form(Tbl3dfile tbl3dfile, Model model) {
		model.addAttribute("tbl3dfile", tbl3dfile);
		return "modules/exam/tbl3dfileForm";
	}

	@RequiresPermissions("exam:tbl3dfile:edit")
	@RequestMapping(value = "save")
	public String save(Tbl3dfile tbl3dfile, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbl3dfile)){
			return form(tbl3dfile, model);
		}
		tbl3dfileService.save(tbl3dfile);
		addMessage(redirectAttributes, "保存3DResource成功");
		return "redirect:"+Global.getAdminPath()+"/exam/tbl3dfile/?repage";
	}
	
	@RequiresPermissions("exam:tbl3dfile:del")
	@RequestMapping(value = "delete")
	public String delete(Tbl3dfile tbl3dfile, RedirectAttributes redirectAttributes) {
		tbl3dfileService.delete(tbl3dfile);
		addMessage(redirectAttributes, "删除3DResource成功");
		return "redirect:"+Global.getAdminPath()+"/exam/tbl3dfile/?repage";
	}

}