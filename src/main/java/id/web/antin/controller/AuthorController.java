package id.web.antin.controller;

import id.web.antin.controller.common.SearchController;
import id.web.antin.helper.QueryHelper;
import id.web.antin.model.Author;
import id.web.antin.service.AuthorService;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = { "/author/*", "/author/*/*", "/author/*/*/*" })
public class AuthorController extends SearchController {
	private static Log log = LogFactory.getLog(AuthorController.class);

	@Autowired
	private ApplicationContext context;
	@Autowired
	private AuthorService authorService;

	/**
	 * add/edit page
	 * @param author
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/author/add", method = RequestMethod.GET)
	public String add(@ModelAttribute("author") Author author, Model model, HttpSession session) {
		if(author == null){
			author = new Author();
		}
		model.addAttribute("author", author);
		return "author-add";
	}
	
	/**
	 * when button save submit (add/edit)
	 * @param author
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/author/add", method = RequestMethod.POST )
	public String submit(@ModelAttribute("author") Author author, 
			Model model) {
		
		log.info("Submit author: "+author.toString());
		log.info("Submit authorID: "+author.getId());
		
		if(author.getId() == null){
			authorService.add(author);
		} else {
			authorService.update(author);
		}		
		initialize(new QueryHelper(), model, authorService, "authors");
		return "author-list";
	}
	
	/**
	 * when radio button selected and edit/remove button clicked
	 * @param selectedObject
	 * @param action
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/author/edit", method = RequestMethod.POST )
	public String edit(@ModelAttribute("selectedObject") Long selectedObject, @RequestParam(value = "actionButton") String action,
			Model model) {
		
		log.info("Submit selectedObject: "+selectedObject);
		Author author = authorService.findById(selectedObject);		
		if(author == null){
			model.addAttribute("data not found");
			return "alert-error";
		} 
		
		if(action == null || action.equals("")){
			model.addAttribute("action not found");
			return "alert-error";
		}
		if(action.equals("remove")){			
			model.addAttribute("message", author.toString());
			model.addAttribute("value", author.getId());
			return "author-remove";
			
		} else {
			log.info("author find by id - ID= "+author.getId());
			log.info("author find by id = "+author.toString());
			model.addAttribute("author", author);
			return "author-add";
		}
	}

	/**
	 * page list
	 * @param criteria
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/author/list", method = RequestMethod.GET)
	public String getList(@ModelAttribute("criteria") QueryHelper criteria,
			Model model) {

		initialize(criteria, model, authorService, "authors");
		return "author-list";
	}
	
	/**
	 * when search button clicked
	 * @param criteria
	 * @param model
	 * @return
	 */
	@RequestMapping( value = "/author/list", method = RequestMethod.POST )
	public String submit(@ModelAttribute("criteria") QueryHelper criteria,
			Model model) {
		
		log.info("Submit Criteria: fieldname:" +criteria.getFieldName() + ", value: "+criteria.getValue() + ", operator: "+criteria.getOperator().name());
		initialize(criteria, model, authorService, "authors");
		return "author-list";
	}

	@Override
	protected void buildCriteria() {
		fieldName.put("name", "Name");
	}	
}
