package com.fei.app.controller;
import com.fei.app.model.MyException;
import com.fei.app.model.User;
import com.fei.app.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	
	@ResponseBody 
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		Integer userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.findUserById(userId);
		if (user==null){
			try {
				throw new MyException("用户不存在");
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return user.getUserName();
	}
	
	@ResponseBody 
	@RequestMapping("/test")
	public List<User> test(int id){
		List<User> user = new ArrayList<User>();
		user = this.userService.getUser(id); 
		return user;
	}
	
	@ResponseBody 
	@RequestMapping("/insert")
	public void insert( ){
		
		User user = null ;
		this.userService.insert(user);
	}
}
