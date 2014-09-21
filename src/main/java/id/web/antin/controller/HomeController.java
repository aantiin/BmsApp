package id.web.antin.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
	private static final Log log = LogFactory.getLog(HomeController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String hello(Model model) {
		return "index";
	}
}
