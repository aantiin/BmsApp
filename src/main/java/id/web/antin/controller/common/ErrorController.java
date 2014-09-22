package id.web.antin.controller.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/error")
public class ErrorController {
	private static Log log = LogFactory.getLog(ErrorController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String add(@ModelAttribute("message") String message, Model model) {
		model.addAttribute("message", message);
		return "error";
	}
}
