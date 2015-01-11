package in.nitron.jba.controller;


import java.security.Principal;

import in.nitron.jba.entities.Blog;
import in.nitron.jba.entities.User;
import in.nitron.jba.services.BlogService;
import in.nitron.jba.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

@Autowired
UserService userService;

@Autowired
BlogService blogService;

@ModelAttribute("user")
public User constructUser()
{
	return new User();
}
@ModelAttribute("blog")
public Blog constructBlog()
{
	return new Blog(); 
}

@RequestMapping("/users")
	public String users(Model model)
	{
		model.addAttribute("users",userService.findAll());
		return "users";
		
	}
	
/*	@RequestMapping("/users/{id}")
	public String userDetails(Model model, @PathVariable int id)
	{
		model.addAttribute("user",userService.findOne(id));
		return "userdetails";
		
	}*/
	
	@RequestMapping("/users/{id}")
	public String userDetails(Model model, @PathVariable int id)
	{
		User user = userService.findOneWithBlogs(id);
		model.addAttribute(user);
		System.out.println(user.getName());
		return "user_details";
	}
	
	@RequestMapping(value="/register_user")
	public String showRegistrationPage()
	{
		return "register_user";
	}
	
	@RequestMapping(value="/register_user", method=RequestMethod.POST)
	public String userRegistration( @ModelAttribute("user") User user)
	{
		userService.save(user);
		return "redirect:/register_user.htm?success=true";
	}
	
	@RequestMapping(value="/mypage")
	public String showUserAccount(Model model, Principal principal)
	{
		String name = principal.getName();
		User user = userService.findOneWithBlogs(name);
		model.addAttribute(user);
		return "mypage";
	}
	
	@RequestMapping(value="/mypage", method=RequestMethod.POST)
	public String addBlog(@ModelAttribute("blog") Blog blog, Principal principal)
	{
		
		blogService.save(blog,principal.getName()); 
		return "mypage";
	}
	
}
