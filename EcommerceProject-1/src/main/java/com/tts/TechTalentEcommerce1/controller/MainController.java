		package com.tts.TechTalentEcommerce1.controller;
		
		import java.util.List;
		
		import org.hibernate.usertype.UserType;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.stereotype.Controller;
		import org.springframework.ui.Model;
		import org.springframework.web.bind.annotation.ControllerAdvice;
		import org.springframework.web.bind.annotation.GetMapping;
		import org.springframework.web.bind.annotation.ModelAttribute;
		import org.springframework.web.bind.annotation.PathVariable;
		import org.springframework.web.bind.annotation.RequestParam;
		
		import com.tts.TechTalentEcommerce1.model.Product;
import com.tts.TechTalentEcommerce1.model.User;
import com.tts.TechTalentEcommerce1.service.ProductService;
		
		import lombok.Data;
		
		@Data
		@Controller
		@ControllerAdvice // This makes the `@ModelAttribute`s of this controller available to all controllers, for the navbar.
		public class MainController {
		    @Autowired
		   private ProductService productService;
		
		    @GetMapping("/")
		    public String main() {
		        return "main";
		    }
		
		    @ModelAttribute("products")
		    public List<Product> products() {
		        return productService.findAll();
		    }
		
		    @ModelAttribute("categories")
		    public List<String> categories() {
		        return productService.findDistinctCategories();
		    }
		
		    @ModelAttribute("brands")
		    public List<String> brands() {
		        return productService.findDistinctBrands();
		    }
		
		    @GetMapping("/filter")
		    public String filter(@RequestParam(required = false) String category,
		                         @RequestParam(required = false) String brand,
		                         Model model) {
		        List<Product> filtered = productService.findByBrandAndOrCategory(brand, category);
		        model.addAttribute("products", filtered); // Overrides the @ModelAttribute above.
		        return "main";
		    }
		
		    @GetMapping("/about")
		    public String about() {
		        return "about";
		    }
		    
		    @GetMapping("/bookstore")
		    public String bookstore() {
		        return "bookstore";
		    }
		    
		    
		    @GetMapping(value = "/users/{username}")
			public String getUser(@PathVariable(value = "username") String username, Model model) {
				return username;
				/*
				 * Object userService; User loggedInUser = ((Object)
				 * userService).getLoggedInUser(); User user = ((Object)
				 * userService).findByUsername(username);
				 */
				}
		    
		    
		}
		
		 