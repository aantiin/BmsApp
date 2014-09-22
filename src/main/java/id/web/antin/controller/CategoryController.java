package id.web.antin.controller;

import id.web.antin.controller.common.SearchController;
import id.web.antin.helper.QueryHelper;
import id.web.antin.model.Category;
import id.web.antin.service.CategoryService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "/category/*", "/category/*/*", "/category/*/*/*" })
public class CategoryController extends SearchController {
	private static Log log = LogFactory.getLog(CategoryController.class);

	@Autowired
	CategoryService categoryService;

	@Override
	protected void buildCriteria() {
		fieldName.put("name", "name");
		fieldName.put("description", "description");
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.GET)
	public String add(@ModelAttribute("category") Category category, Model model) {
		if (category == null) {
			category = new Category();
		}
		model.addAttribute("category", category);
		return "category-add";
	}

	/**
	 * when button save submit (add/edit)
	 * 
	 * @param author
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String submit(@ModelAttribute("category") Category category,
			Model model) {

		log.info("Submit category: " + category.toString());
		log.info("Submit categoryID: " + category.getId());

		if (category.getId() == null) {
			categoryService.add(category);
		} else {
			categoryService.update(category);
		}
		initialize(new QueryHelper(), model, categoryService, "categories");
		return "category-list";
	}

	@RequestMapping(value = "/category/list", method = RequestMethod.GET)
	public String getList(@ModelAttribute("criteria") QueryHelper criteria,
			Model model) {

		initialize(criteria, model, categoryService, "categories");
		return "category-list";
	}
	
	@RequestMapping( value = "/category/list", method = RequestMethod.POST )
	public String submit(@ModelAttribute("criteria") QueryHelper criteria,
			Model model) {
		
		log.info("Submit Criteria: fieldname:" +criteria.getFieldName() + ", value: "+criteria.getValue() + ", operator: "+criteria.getOperator().name());
		initialize(criteria, model, categoryService, "categories");
		return "category-list";
	}

}
