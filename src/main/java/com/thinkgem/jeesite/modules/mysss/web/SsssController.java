/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mysss.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.impl.util.json.JSONObject;
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
import com.thinkgem.jeesite.modules.mysss.entity.Ssss;
import com.thinkgem.jeesite.modules.mysss.service.SsssService;

/**
 * lianxiController
 * @author lainxi
 * @version 2018-04-17
 */
@Controller
@RequestMapping(value = "${adminPath}/mysss/ssss")
public class SsssController extends BaseController {

	@Autowired
	private SsssService ssssService;
	
	@ModelAttribute
	public Ssss get(@RequestParam(required=false) String id) {
		Ssss entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ssssService.get(id);
		}
		if (entity == null){
			entity = new Ssss();
		}
		return entity;
	}
	
	@RequiresPermissions("mysss:ssss:view")
	@RequestMapping(value = {"list", ""})
	public String list(Ssss ssss, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Ssss> page = ssssService.findPage(new Page<Ssss>(request, response), ssss); 
		model.addAttribute("page", page);
		return "modules/mysss/ssssList";
	}

	@RequiresPermissions("mysss:ssss:view")
	@RequestMapping(value = "form")
	public String form(Ssss ssss, Model model) {
		model.addAttribute("ssss", ssss);
		return "modules/mysss/ssssForm";
	}

	@RequiresPermissions("mysss:ssss:edit")
	@RequestMapping(value = "save")
	public String save(Ssss ssss, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ssss)){
			return form(ssss, model);
		}
		int check = 0;
		List<Ssss> Slist = ssssService.findList(new Ssss());
		if(Slist.size() > 0) {
			for(int i=0;i<Slist.size();i++ ) {
				Ssss s = Slist.get(i);
				if(s.getName().equals(ssss.getName())) {
					addMessage(redirectAttributes, "错误：姓名重复不能保存！");
					check = 1;
					break; 
				}
			}
			
		}else {
			
			addMessage(redirectAttributes, "保存lianxi成功");
		}
		
		if(check == 0) {
			ssssService.save(ssss);
		}
		
		return "redirect:"+Global.getAdminPath()+"/mysss/ssss/?repage";
	}
	
	@RequiresPermissions("mysss:ssss:edit")
	@RequestMapping(value = "delete")
	public String delete(Ssss ssss, RedirectAttributes redirectAttributes) {
		ssssService.delete(ssss);
		addMessage(redirectAttributes, "删除lianxi成功");
		return "redirect:"+Global.getAdminPath()+"/mysss/ssss/?repage";
	}
	
	@RequestMapping(value = "validation")
	public void validation(String NAME,String ID, HttpServletResponse response) {
		JSONObject map=new JSONObject();
		Ssss checkssss = new Ssss();
		checkssss.setName(NAME);
		checkssss.setId(ID);
		
		List<Ssss> checkList = ssssService.findList(checkssss);
		if(checkList.size()>0){
			
				map.put("msg", "姓名重复");
				map.put("name", "name");
				map.put("flag", 1);
			}else{
				map.put("msg", "");
				map.put("name", "");
				map.put("flag", 0);
			}
		
		
		try {
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(map.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}