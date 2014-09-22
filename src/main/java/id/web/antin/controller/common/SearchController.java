package id.web.antin.controller.common;

import id.web.antin.helper.QueryHelper;
import id.web.antin.service.CommonService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;

public abstract class SearchController implements Constant{
	private static Log log = LogFactory.getLog(SearchController.class);
	
	protected Map<String, String> fieldName = new HashMap<String, String>();
	private static final int FIRST_PAGE = 1;
	private static final int MAX_ROWS = 10;

	public SearchController() {

		buildCriteria();
	}

	protected abstract void buildCriteria();

	public Map<String, String> getFieldNames() {
		return fieldName;
	}

	protected void initialize(QueryHelper criteria, Model model,
			CommonService service, String entity) {
		List result = null;
		if (criteria == null || criteria.empty()) {
			result = service.findAll();
		} else {				
			result = service.find(criteria, FIRST_PAGE, MAX_ROWS);			
		}		
		log.info("Result = "+result);
		model.addAttribute(entity, result);
		model.addAttribute("operators", getOperators());
		model.addAttribute("criterias", getFieldNames());
		model.addAttribute("criteria",  criteria);
		model.addAttribute("selectedObject",  "");
	}

	public Map<String, String> getOperators() {

		Map<String, String> operators = new HashMap<String, String>();
		operators.put("EQ", "Equal");
		operators.put("LIKE", "Like");

		return operators;
	}
}
