package id.web.antin.controller;

import id.web.antin.controller.common.SearchController;
import id.web.antin.helper.QueryHelper;
import id.web.antin.model.Author;
import id.web.antin.service.AuthorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "/author/*", "/author/*/*", "/author/*/*/*" })
public class AuthorController extends SearchController {
	private static Log log = LogFactory.getLog(AuthorController.class);

	@Autowired
	private ApplicationContext context;
	@Autowired
	private AuthorService authorService;

	@RequestMapping(value = "/author/add", method = RequestMethod.GET)
	public String add(Model model, HttpSession session) {

		Author author = new Author();

		model.addAttribute("author", author);

		return "author-add";
	}
	
	@RequestMapping( value = "/author/add", method = RequestMethod.POST )
	public String submit(@ModelAttribute("author") Author author,
			Model model) {
		
		log.info("Submit author: "+author.toString());
		authorService.add(author);
		initialize(new QueryHelper(), model, authorService, "authors");
		return "author-list";
	}

	@RequestMapping(value = "/author/list", method = RequestMethod.GET)
	public String getList(@ModelAttribute("criteria") QueryHelper criteria,
			Model model) {

		initialize(criteria, model, authorService, "authors");
		return "author-list";
	}

	@Override
	protected void buildCriteriaDictionary() {
		fieldName.put("name", "Name");
	}
	
	@RequestMapping( value = "/author/list", method = RequestMethod.POST )
	public String submit(@ModelAttribute("criteria") QueryHelper criteria,
			Model model) {
		
		log.info("Submit Criteria: fieldname:" +criteria.getFieldName() + ", value: "+criteria.getValue() + ", operator: "+criteria.getOperator().name());
		initialize(criteria, model, authorService, "authors");
		return "author-list";
	}
}
