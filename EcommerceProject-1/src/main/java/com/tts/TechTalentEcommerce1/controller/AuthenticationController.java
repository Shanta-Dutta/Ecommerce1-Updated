				package com.tts.TechTalentEcommerce1.controller;
				
				import javax.servlet.ServletException;
				import javax.servlet.http.HttpServletRequest;
				import javax.validation.Valid;
				
				import org.springframework.beans.factory.annotation.Autowired;
				import org.springframework.stereotype.Controller;
				import org.springframework.ui.Model;
				import org.springframework.validation.BindingResult;
				import org.springframework.web.bind.annotation.GetMapping;
				import org.springframework.web.bind.annotation.PostMapping;
				import org.springframework.web.bind.annotation.RequestParam;
				
				import com.tts.TechTalentEcommerce1.model.User;
				import com.tts.TechTalentEcommerce1.service.UserService;
				
				@Controller
				class AuthenticationController {
					@Autowired
					private UserService userService;
				
					/*
					 * @GetMapping("/signin") public String signin() { return "signin"; }
					 */
					@GetMapping(value = "/signin")
					public String signin(Model model) {
						User user = new User();
						model.addAttribute("user", user);
						return "signin";
					}
				
					@GetMapping(value = "/signup")
					public String signup(Model model) {
						User user = new User();
						model.addAttribute("user", user);
						return "signup";
					}
				
					/*
					 * @PostMapping("/signin") public String singin(@Valid User user,
					 * 
					 * @RequestParam String submit, BindingResult bindingResult, HttpServletRequest
					 * request) throws ServletException { String password = user.getPassword();
					 * 
					 * if(submit.equals("up")) {
					 * 
					 * if(userService.findByUsername(user.getUsername())== null) { //
					 * userService.saveNewUser(user);
					 * 
					 * bindingResult.rejectValue("username", "error.user",
					 * "Username not Exist. Register First"); //return "signup"; } else {
					 * bindingResult.rejectValue("username", "error.user",
					 * "Username is already taken."); return "signin"; } //}
					 * request.login(user.getUsername(), password); return "redirect:/"; }
					 */
				
					@PostMapping("/signin")
					public String signin(@Valid User user, BindingResult bindingResult, Model model) {
						User userExists = userService.findByUsername(user.getUsername());
						if (userExists != null) {
							bindingResult.rejectValue("username", "error.user", "Username is already taken");
							// System.out.println("Invalid user id");
						}
						if (!bindingResult.hasErrors()) {
							userService.saveNewUser(user);
							model.addAttribute("success", "Sign up successful!");
							model.addAttribute("user", new User());
						}
						return "signin";
					}
				
					@PostMapping(value = "/signup")
					public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
						User userExists = userService.findByUsername(user.getUsername());
						if (userExists != null) {
							bindingResult.rejectValue("username", "error.user", "Username is already taken");
						}
						if (!bindingResult.hasErrors()) {
							userService.saveNewUser(user);
							model.addAttribute("success", "Sign up successful!");
							model.addAttribute("user", new User());
						}
						return "signup";
					}
				
				}
