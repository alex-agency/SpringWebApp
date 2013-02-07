package app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import app.domain.Category;
import app.service.CategoryService;
import app.util.AjaxUtils;
import javax.validation.Valid;

@Controller
public class CategoryController {
	protected static Logger logger = Logger.getLogger(CategoryController.class);
	
	@Autowired
	CategoryService categoryService;
	
	// Invoked on every request
	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}
	
	@RequestMapping(value = "/add-category")
    public String createCategory(Model model) {
		logger.debug("Received request to show a page for create new category.");
		
		model.addAttribute("category", new Category());
		// show jsp page
        return "category-modify";
    }
	
	@RequestMapping(value = "/add-category", method = RequestMethod.POST)
    public String saveCategory(@Valid Category category, 
    							BindingResult result,
    							@ModelAttribute("ajaxRequest") boolean ajaxRequest) {
		logger.debug("Received request to save new category.");
		
		if (result.hasErrors()) {
			System.out.println("has errors");
			return "category-modify";
		}
		
		categoryService.save(category);
		
		// AJAX
		if (ajaxRequest) {
			System.out.println("AJAX request");
			return null;
		}
		
		// redirect to main page
        return "redirect:/";
    }
	
	@RequestMapping(value = "/category/{id}")
    public String showCategory(@PathVariable("id") String id, 
    							Model model) {
		logger.debug("Recived request to find recipe and to show it on the page.");
		
		Category category = categoryService.get(id);
		model.addAttribute(category);
		// show jsp page
		return "category";
    }
	
	@RequestMapping(value = "/category/{id}/edit")
	public String editCategory(@PathVariable("id") String id, 
								Model model) {
		logger.debug("Recived request to find category and to show page for modify.");
		
		Category category = categoryService.get(id);
		model.addAttribute(category);
		// show jsp page
		return "category-modify";
    }
	
	@RequestMapping(value = "/category/{id}/edit", method = RequestMethod.POST)
	public String updateCategory(@Valid Category category,
								BindingResult result) {
		logger.debug("Recived request to update existing category.");
		
		if (result.hasErrors()) {
			System.out.println("has errors");
			return "category-modify";
		}
		
		categoryService.save(category);
		// show jsp page
		return "category";
    }
	
	@RequestMapping(value = "/category/{id}/delete")
	public String deleteCategory(Category category) {
		logger.debug("Recived request to delete category.");
		
		categoryService.delete(category);
		// redirect to main page
		return "redirect:/";
    }
}
