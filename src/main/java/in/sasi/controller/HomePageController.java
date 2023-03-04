package in.sasi.controller;

import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("appServerTime", new Date());
		return "dashboard";
	}

}
