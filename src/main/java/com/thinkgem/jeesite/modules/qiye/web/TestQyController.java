/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.qiye.web;

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
import com.thinkgem.jeesite.modules.qiye.entity.TestQy;
import com.thinkgem.jeesite.modules.qiye.service.TestQyService;

/**
 * 企业Controller
 * @author tyk
 * @version 2019-05-09
 */
@Controller
@RequestMapping(value = "${adminPath}/qiye/testQy")
public class TestQyController extends BaseController {

	@Autowired
	private TestQyService testQyService;
	
	@ModelAttribute
	public TestQy get(@RequestParam(required=false) String id) {
		TestQy entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = testQyService.get(id);
		}
		if (entity == null){
			entity = new TestQy();
		}
		return entity;
	}
	
	@RequiresPermissions("qiye:testQy:view")
	@RequestMapping(value = {"list", ""})
	public String list(TestQy testQy, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TestQy> page = testQyService.findPage(new Page<TestQy>(request, response), testQy); 
		model.addAttribute("page", page);
		return "modules/qiye/testQyList";
	}

	@RequiresPermissions("qiye:testQy:view")
	@RequestMapping(value = "form")
	public String form(TestQy testQy, Model model) {
		model.addAttribute("testQy", testQy);
		return "modules/qiye/testQyForm";
	}

	@RequiresPermissions("qiye:testQy:edit")
	@RequestMapping(value = "save")
	public String save(TestQy testQy, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, testQy)){
			return form(testQy, model);
		}
		testQyService.save(testQy);
		addMessage(redirectAttributes, "保存企业成功");
		return "redirect:"+Global.getAdminPath()+"/qiye/testQy/?repage";
	}
	
	@RequiresPermissions("qiye:testQy:edit")
	@RequestMapping(value = "delete")
	public String delete(TestQy testQy, RedirectAttributes redirectAttributes) {
		testQyService.delete(testQy);
		addMessage(redirectAttributes, "删除企业成功");
		System.out.println("111111111111111"+Global.getAdminPath());
		return "redirect:"+Global.getAdminPath()+"/qiye/testQy/?repage";
	}

}