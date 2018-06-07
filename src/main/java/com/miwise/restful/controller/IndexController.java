package com.miwise.restful.controller;


import com.miwise.restful.dao.UserDao;
import com.miwise.restful.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/front/*")
public class IndexController {

	@Autowired
	private UserDao userDao;

	//index页面
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	//登录页面
	@RequestMapping("/register")
	public String register(){
		return "register";
	}

	//注册方法
	@RequestMapping("/add")
	public String register(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		System.out.println(username);
		System.out.println(password2);
		System.out.println(password);
		if(username == null||password==null ||password2==null)
			return "register";

		if (password.equals(password2)){
			UserEntity userEntity = new UserEntity();
			userEntity.setUsername(username);
			userEntity.setPassword(password);
			userDao.save(userEntity);
			return "index";
		}else {
			return "register";
		}
	}

	//登录方法
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserEntity userEntity = userDao.findByUsernameAndPassword(username,password);
		String str = "";
		if (userEntity !=null){
			str = "index";
		}else {
			str = "login";
		}
		return str;
	}

}
