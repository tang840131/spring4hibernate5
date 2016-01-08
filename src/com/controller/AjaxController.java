package com.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bean.Constans;
import com.biz.UserBiz;
import com.entity.User;
import com.util.PwdUtil;

@RestController
@RequestMapping("/ajax")
public class AjaxController {

	@Resource
	private UserBiz userBiz;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public JSONObject add(@ModelAttribute("user") User user){
		JSONObject json=new JSONObject();
		try {
			user.setPassword(PwdUtil.md5(user.getUsername()+user.getPassword()));
			userBiz.save(user);
			json.put("err", 0);
			json.put("msg", "保存成功，成功后的ID为："+user.getId());
		} catch (Exception e) {
			json.put("err", 1);
			json.put("msg", "保存失败！");
			Constans.LOG.error(e);
		}
		return json;
	}
	
	@RequestMapping(value="/list/{page}",method=RequestMethod.POST)
	public String list(@PathVariable Integer page){
		page=page==null?1:page;
		return JSON.toJSONString(userBiz.getUserPage(10, page));
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	public JSONObject delete(@PathVariable Integer id){
		JSONObject json=new JSONObject();
		try {
			userBiz.delete(id);
			json.put("err", 0);
			json.put("msg","删除成功！");
		} catch (Exception e) {
			Constans.LOG.error(e);
			json.put("err", 1);
			json.put("msg","删除失败，错误原因："+e.getMessage());
		}
		return json;
	}
	
	@InitBinder("user")
	public void initUserBinder(WebDataBinder binder){
		binder.setFieldDefaultPrefix("u.");
	}
}
