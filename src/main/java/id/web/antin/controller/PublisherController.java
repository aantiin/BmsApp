package id.web.antin.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import id.web.antin.controller.common.SearchController;
import id.web.antin.helper.QueryHelper;
import id.web.antin.model.Publisher;
import id.web.antin.service.PublisherService;

@Controller
@RequestMapping(value = { "/publisher/*", "/publisher/*/*", "/publisher/*/*/*" })
public class PublisherController extends SearchController{
	private static Log log = LogFactory.getLog(PublisherController.class);

	@Autowired
	private PublisherService publisherService;
	
	@Override
	protected void buildCriteria() {
		fieldName.put("name", "Name");		
	}
	
	@RequestMapping(value = "/publisher/list", method = RequestMethod.GET)
	public String getList(@ModelAttribute("criteria") QueryHelper criteria,
			Model model) {

		initialize(criteria, model, publisherService, "publishers");
		return "publisher-list";
	}
	
	@RequestMapping( value = "/publisher/list", method = RequestMethod.POST )
	public String submit(@ModelAttribute("criteria") QueryHelper criteria,
			Model model) {
		
		log.info("Submit Criteria: fieldname:" +criteria.getFieldName() + ", value: "+criteria.getValue() + ", operator: "+criteria.getOperator().name());
		initialize(criteria, model, publisherService, "publishers");
		return "publisher-list";
	}
	
	@RequestMapping(value = "/publisher/add", method = RequestMethod.GET)
	public String add(Model model, HttpSession session) {
		Publisher publisher = new Publisher();
		model.addAttribute("publisher", publisher);
		return "publisher-add";
	}
	
	@RequestMapping( value = "/publisher/add", method = RequestMethod.POST )
	public String submit(@ModelAttribute("publisher") Publisher publisher,
			Model model) {
		
		log.info("Submit publisher: "+publisher.toString());
		publisherService.add(publisher);
		
		initialize(new QueryHelper(), model, publisherService, "publishers");
		return "publisher-list";
	}
}
