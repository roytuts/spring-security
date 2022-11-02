package com.roytuts.spring.security.jdbc.authentication.persistent.rememberme.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SpringSecurityController implements MessageSourceAware {
	private MessageSource messageSource;

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@RequestMapping("/")
	public String defaultPage(Model model) {
		model.addAttribute("msg", "Welcome to Spring Security");
		return "index";
	}

	@RequestMapping("/login")
	public String loginPage(Model model, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		if (error != null) {
			model.addAttribute("error", messageSource.getMessage("login.failure.reason", null, Locale.US));
		}
		if (logout != null) {
			model.addAttribute("msg", messageSource.getMessage("logout.msg.success", null, Locale.US));
		}
		return "login";
	}

	@RequestMapping("/logout")
	public String logoutPage(Model model, HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login?logout";
	}

	@RequestMapping("/admin")
	public String adminPage(Model model) {
		model.addAttribute("title", messageSource.getMessage("page.admin.heading", null, Locale.US));
		model.addAttribute("message", messageSource.getMessage("page.admin.message", null, Locale.US));
		return "admin";
	}

}
