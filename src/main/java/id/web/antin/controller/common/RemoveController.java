package id.web.antin.controller.common;

import id.web.antin.helper.QueryHelper;
import id.web.antin.model.Author;
import id.web.antin.service.AuthorService;
import id.web.antin.service.CategoryService;
import id.web.antin.service.PublisherService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = { "/author/*", "/publisher/*", "/category/*", "/book/*" })
public class RemoveController extends SearchController {
	private static Log log = LogFactory.getLog(RemoveController.class);
	@Autowired
	private AuthorService authorService;
	private PublisherService publisherService;
	private CategoryService categoryService;

	private String mode;

	@RequestMapping(value = "/author/remove", method = RequestMethod.POST)
	public String add(@ModelAttribute("value") Long value,
			@RequestParam(value = "actionButton") String action, Model model) {
		log.info("removed - action : "+action);
		if (value == null) {
			model.addAttribute("message", "object not found.");
			return "error";
		}

		if (action == null || action.equals("")) {
			model.addAttribute("message", "action not found.");
			return "error";
		}
		if (action.equals("remove")) {
			log.info("author to be deleted ID: " + value.toString());
			authorService.remove(authorService.findById(value));
			log.info("check : " + authorService.findAll().size());
		}
		initialize(new QueryHelper(), model, authorService, "authors");
		return "author-list";
	}

	@Override
	protected void buildCriteria() {
		fieldName.put("name", "Name");
	}
}
