package com.roytuts.spring.security.data.jpa.preauthentication.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.spring.security.data.jpa.preauthentication.vo.BlogVo;

@RestController
public class BlogRestController {

	@GetMapping("/")
	public ResponseEntity<String> defaultPage(Model model) {
		return new ResponseEntity<String>("Welcome to Spring Security PreAuthentication", HttpStatus.OK);
	}

	@GetMapping("/blogs")
	public ResponseEntity<List<BlogVo>> getAllBlogs(Model model) {
		return new ResponseEntity<List<BlogVo>>(getBlogs(), HttpStatus.OK);
	}

	private List<BlogVo> getBlogs() {
		List<BlogVo> blogs = new ArrayList<>();
		BlogVo b1 = new BlogVo();
		b1.setTitle("Spring Security using XML");
		b1.setAuthor("https://roytuts.com");
		b1.setText("Spring Security. Autherntication. Authorization.");
		b1.setDate(new Date());
		BlogVo b2 = new BlogVo();
		b2.setTitle("Spring Security using Annotation");
		b2.setAuthor("https://roytuts.com");
		b2.setText("Spring Security. Autherntication. Authorization.");
		b2.setDate(new Date());
		BlogVo b3 = new BlogVo();
		b3.setTitle("Spring Security using UserDetailsService");
		b3.setAuthor("https://roytuts.com");
		b3.setText("Spring Security. Autherntication. Authorization.");
		b3.setDate(new Date());
		BlogVo b4 = new BlogVo();
		b4.setTitle("Spring MVC using XML");
		b4.setAuthor("https://roytuts.com");
		b4.setText("Spring Model-View-Controller.");
		b4.setDate(new Date());
		BlogVo b5 = new BlogVo();
		b5.setTitle("Spring MVC using Annotation");
		b5.setAuthor("https://roytuts.com");
		b5.setText("Spring Model-View-Controller.");
		b5.setDate(new Date());
		blogs.add(b1);
		blogs.add(b2);
		blogs.add(b3);
		blogs.add(b4);
		blogs.add(b5);
		return blogs;
	}

}
